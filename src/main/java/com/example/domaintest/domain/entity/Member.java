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
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long memberSid;

    private String memberNickname;

    private String password;

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<Feed> feedList = new ArrayList<>();

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<Reply> replyList = new ArrayList<>();

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<FeedGood> feedGoods = new ArrayList<>();

    public Member(String memberNickname) {
        this.memberNickname = memberNickname;
    }
}
