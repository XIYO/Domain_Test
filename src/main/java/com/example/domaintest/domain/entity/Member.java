package com.example.domaintest.domain.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long memberSid;

    private String memberNickname;

    private String password;

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<Feed> feedList;

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<Reply> replyList;

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
//    @JoinColumn(name = "member_sid")
    private List<TestEntity> testEntityList;
}
