package com.writemeabook.restuserapi.hierarchicalmodel;

import com.writemeabook.restuserapi.VO.TextStory;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "subsections")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Subsection implements TreeTextEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "title")
    private String title;

    @Column(name = "num_order")
    private int numOrder;

/*    @ManyToOne(cascade = CascadeType.ALL,
            fetch = FetchType.EAGER)
    @JoinColumn(name = "section_id")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Section parentSection;*/

    /*    @OneToOne(fetch = FetchType.LAZY,
                cascade = CascadeType.ALL)
        @JoinColumn(name = "text_id")
        @EqualsAndHashCode.Exclude
        @ToString.Exclude*/
    @Column(name = "text_id")
    private Integer text;

    public Subsection(String title, int numOrder, TextStory text, Section parentSection) {
        this.title = title;
        this.numOrder = numOrder;
        //this.text = text;
        parentSection.addSubsectionToSection(this);
    }
}

