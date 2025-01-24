package com.lanister.encuesta.entity;


import com.lanister.encuesta.enums.QuestionType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "questions")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false, length = 255)
    private String content;
    @Column
    private  int questionOrder;
    @Column
    private QuestionType type;

    @ManyToOne
    @JoinColumn(name = "poll_id")
    private Poll poll;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "question")
    private List<Answer> answers = new ArrayList<>();

}
