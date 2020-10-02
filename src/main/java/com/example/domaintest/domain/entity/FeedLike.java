package com.example.domaintest.domain.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Data
@Entity
@IdClass(FeedLikePk.class)
public class FeedLike {
    @Id
    @ManyToOne
    @JoinColumn(name = "feed_sid")
    private Feed feed;

    @Id
    @ManyToOne
    @JoinColumn(name = "member_sid")
    private Member member;

}
