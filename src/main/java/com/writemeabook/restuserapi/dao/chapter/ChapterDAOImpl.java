package com.writemeabook.restuserapi.dao.chapter;

import com.writemeabook.restuserapi.model.Book;
import com.writemeabook.restuserapi.model.Chapter;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class ChapterDAOImpl implements ChapterDAO {

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Chapter> getAllChapters() {
        Session session = entityManager.unwrap(Session.class);
        Query<Chapter> query = session.createQuery("from Chapter",
                Chapter.class);
        return query.getResultList();
    }

    @Override
    public void saveChapter(Chapter chapter) {
        Session session = entityManager.unwrap(Session.class);
        session.saveOrUpdate(chapter);
    }

    @Override
    public Chapter getChapter(int id) {
        Session session = entityManager.unwrap(Session.class);
        return session.get(Chapter.class, id);
    }

    @Override
    public void deleteChapter(int id) {
        Session session = entityManager.unwrap(Session.class);
        Query<Book> query = session.createQuery("delete from Chapter " +
                "where id=:chapterId");
        query.setParameter("chapterId", id);
        query.executeUpdate();
    }
}
