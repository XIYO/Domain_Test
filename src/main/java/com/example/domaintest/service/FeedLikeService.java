package com.example.domaintest.service;

import com.example.domaintest.domain.entity.FeedGood;
import com.example.domaintest.domain.entity.FeedGoodPk;
import com.example.domaintest.domain.repository.FeedGoodRepository;
import com.example.domaintest.domain.repository.FeedRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FeedLikeService {
    @Autowired
    FeedRepository feedRepository;

    @Autowired
    FeedGoodRepository feedGoodRepository;

    public FeedGood postFeedLike(FeedGoodPk feedGoodPk) {
        // todo need exception
        return feedGoodRepository.save(FeedGood.of(feedGoodPk.getMember(), feedGoodPk.getFeed()));

    }

}