package com.example.domaintest.domain.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Feed {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "feed_sid")
    private Long feedSid;

    @ManyToOne
    @JoinColumn(name = "member_sid")
    private Member member;

    @OneToMany(mappedBy = "feed", cascade = CascadeType.ALL)
    private List<FeedLike> feedLike = new ArrayList<>();

    @OneToMany(mappedBy = "feed", cascade = CascadeType.ALL)
    private List<Reply> reply = new ArrayList<>();

    private String text;
}
