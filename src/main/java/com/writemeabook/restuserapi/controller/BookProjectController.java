package com.writemeabook.restuserapi.controller;

import com.writemeabook.restuserapi.hierarchicalmodel.BookProject;
import com.writemeabook.restuserapi.service.project.ProjectService;
import com.writemeabook.restuserapi.textmodel.BookProject_txt;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;

import java.util.Arrays;
import java.util.concurrent.ForkJoinPool;

@Slf4j
@RestController
@RequestMapping("/api/bookprojects")
public class BookProjectController {

    @Autowired
    private ProjectService bookProjectService;

/*    @GetMapping("/{id}")
    public DeferredResult<BookProject_txt> getProject(@PathVariable Integer id) {
        log.info("Start of getProject method of BookProjectController");
        final DeferredResult<BookProject_txt> deferredResult = new DeferredResult<>();
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        forkJoinPool.submit(() -> {
           log.info("Processing of getProject method");
           BookProject project = null;
           try {
               project = bookProjectService.getProject(id);
           } catch (Exception exc) {
               log.error("Exception occured in getProject method: /n Message: " + exc.getMessage() +
                       "/n Stack trace: + " + Arrays.toString(exc.getStackTrace()));
           }
           deferredResult.setResult(project);
        });
    }*/


}
