package com.example.domaintest.service;

import com.example.domaintest.domain.dto.FeedDto;
import com.example.domaintest.domain.entity.Feed;
import com.example.domaintest.domain.entity.FeedLike;
import com.example.domaintest.domain.entity.Member;
import com.example.domaintest.domain.repository.FeedRepository;
import com.example.domaintest.domain.repository.MemberRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FeedLikeService {
    @Autowired
    FeedRepository feedRepository;

    @Autowired
    MemberRepository memberRepository;

    @Autowired
    ModelMapper modelMapper;

    public FeedDto getFeed(Feed feed) {
        Feed findFeed = feedRepository.findById(feed.getFeedSid()).get();
        return modelMapper.map(
                findFeed, FeedDto.class);
    }

    public Boolean postFeedLike(Long feedSid, Long memberSid) {
        // todo need exception
        Feed findFeed = feedRepository.findById(feedSid).get();
        Member findMember = memberRepository.findById(memberSid).get();

        findFeed.getFeedLike().add(new FeedLike(findMember));
        feedRepository.save(findFeed);

        return true;
    }


}
