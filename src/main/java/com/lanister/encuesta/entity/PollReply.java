package com.lanister.encuesta.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@EntityListeners(AuditingEntityListener.class)
@Entity(name = "poll_replies")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PollReply {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column
    private String user;
    @CreatedDate
    private Date createdAt;

    @ManyToOne
    @JoinColumn(name = "poll_id")
    private Poll poll;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "pollReply")
    private List<PollReplyDetail> pollReplies = new ArrayList<>();


}
