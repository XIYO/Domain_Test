package com.example.domaintest.domain.entity;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class FeedLike {
    @Id
    private Long memberSid;

    public FeedLike(Member member) {
        this.memberSid = member.getMemberSid();
    }
}
