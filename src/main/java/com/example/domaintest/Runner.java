package com.example.domaintest;

import com.example.domaintest.common.RandomNickname;
import com.example.domaintest.domain.entity.Feed;
import com.example.domaintest.domain.entity.Member;
import com.example.domaintest.domain.entity.Reply;
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


    private final int memberNum = 1;
    private final int feedNum = 1;
    private final int replyNum = 2;
    private final int reReplyNum = 2;

    @Override
    public void run(ApplicationArguments args) {
//        System.out.println("test==============================================");
//        testEntityRepository.test();
//        System.out.println("==============================================");

        // member
        for (int memberI = 0; memberI < memberNum; memberI++) {
            Member member = new Member(RandomNickname.randomHangulName());

            // feed
            addFeeds(member);

            memberRepository.save(member);
        }

    }

    private void addFeeds(Member member) {
        for (int feedI = 0; feedI < feedNum; feedI++) {
            Feed feed = new Feed(member);
            member.getFeedList().add(feed);

            // reply
            addReplies(member, feed);
        }
    }

    private void addReplies(Member member, Feed feed) {
        for (int replyI = 0; replyI < replyNum; replyI++) {
            Reply reply = new Reply(member, feed);
            feed.getReply().add(reply);

            // reReply
            addReReply(member, feed, reply);
        }
    }

    private void addReReply(Member member, Feed feed, Reply reply) {
        for (int reReplyI = 0; reReplyI < reReplyNum; reReplyI++) {
            Reply reReply = new Reply(member, feed, reply);
            reply.getReplyList().add(reReply);
        }
    }
}
