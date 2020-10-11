package com.example.domaintest.domain.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@NoArgsConstructor
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
    private List<Reply> replyList = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "feed_sid")
    private Feed feed;

    public Reply(Member member, Feed memberFeed) {
        this.member = member;
        this.feed = memberFeed;
        this.text = "reply write by " + member.getMemberNickname();
    }

    public Reply(Member member, Feed memberFeed, Reply memberReply) {
        this.member = member;
        this.feed = memberFeed;
        this.parentReply = memberReply;
        this.text = "it is reReply, reply write by " + member.getMemberNickname();
    }
}
