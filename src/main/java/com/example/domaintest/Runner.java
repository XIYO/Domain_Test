package com.example.domaintest;

import com.example.domaintest.domain.entity.*;
import com.example.domaintest.domain.repository.FeedRepository;
import com.example.domaintest.domain.repository.MemberRepository;
import com.example.domaintest.domain.repository.ReplyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class Runner implements ApplicationRunner {

    @Autowired
    ReplyRepository replyRepository;

    @Autowired
    MemberRepository memberRepository;

    @Autowired
    FeedRepository feedRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("==============================================");
        Member member = new Member();
        Feed feed = new Feed();
        Reply reply = new Reply();
        Reply reReply = new Reply();

        // text
        member.setMemberNickname("testNickname");
        Member saveMember = memberRepository.save(member);

        feed.setText("feed text");
        feed.setMember(saveMember);
        Feed saveFeed = feedRepository.save(feed);

        reply.setText("reply text");
        reply.setMember(saveMember);
        reply.setFeed(saveFeed);
        Reply saveReply = replyRepository.save(reply);

        reReply.setText("rereply texts");
        reReply.setMember(saveMember);
        reReply.setFeed(saveFeed);
        reReply.setParentReply(saveReply);
        Reply saveRereply = replyRepository.save(reReply);
    }
}
