package com.lanister.encuesta.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "polls")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(indexes = @Index(columnList = "pollId", name = "index_poll_id", unique = true))
public class Poll {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String pollId;
    @Column(nullable = false, length = 255)
    private String content;
    @Column
    private  boolean opened;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "poll")
    private List<Question> questions = new ArrayList<>();

}
