package com.example.domaintest.domain.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Reply {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reply_sid")
    private Long replySid;
    private String text;

    @ManyToOne
    @JoinColumn(name = "member_sid")
    private Member member;

    @ManyToOne
    @JoinColumn(name = "parent_reply_sid")
    private Reply parentReply;

    @OneToMany(mappedBy = "parentReply", cascade = CascadeType.ALL)
    private List<Reply> replyList;


    @ManyToOne
    @JoinColumn(name = "feed_sid")
    private Feed feed;
}
