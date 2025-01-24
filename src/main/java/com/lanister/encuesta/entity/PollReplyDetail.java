package com.lanister.encuesta.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity(name = "poll_reply_details")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PollReplyDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column
    private long questionId;
    @Column
    private long answerId;
    @ManyToOne
    @JoinColumn(name = "poll_reply_id")
    private PollReply pollReply;
}
