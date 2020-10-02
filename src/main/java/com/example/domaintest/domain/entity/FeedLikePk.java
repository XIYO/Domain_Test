package com.example.domaintest.domain.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Data
public class FeedLikePk implements Serializable {
    private Feed feed;
    private Member member;
}
