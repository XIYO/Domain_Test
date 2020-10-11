package com.example.domaintest.domain.entity;


import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class FeedGoodPk implements Serializable {
    private Member member;
    private Feed feed;
}
