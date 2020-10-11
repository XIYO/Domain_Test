package com.example.domaintest.domain.entity;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Entity
@NoArgsConstructor
@IdClass(FeedGoodPk.class)
public class FeedGood extends BaseEntity {
    @Id
    @ManyToOne
    @JoinColumn(name = "member_sid")
    private Member member;

    @Id
    @ManyToOne
    @JoinColumn(name = "feed_sid")
    private Feed feed;

    public FeedGood(Member member, Feed feed) {
        this.member = member;
        this.feed = feed;
    }

    public static FeedGood of(Member member, Feed feed) {
        return new FeedGood(member, feed);
    }
}
