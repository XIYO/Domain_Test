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
public class Feed extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "feed_sid")
    private Long feedSid;

    @ManyToOne
    @JoinColumn(name = "member_sid")
    private Member member;

    // not duplex, simplex
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = " feed_sid")
    private List<FeedGood> feedGood = new ArrayList<>();

    @OneToMany(mappedBy = "feed", cascade = CascadeType.ALL)
    private List<Reply> reply = new ArrayList<>();

    @OneToMany(mappedBy = "feed", cascade = CascadeType.ALL)
    private List<FeedGood> feedGoods = new ArrayList<>();

    private String text;

    public Feed(Member member) {
        this.member = member;
        this.text = "feed write by " + member.getMemberNickname();
    }

    public Feed(String s) {
        this.text = s;
    }
}
