package com.example.domaintest.service;

import com.example.domaintest.domain.dto.FeedDto;
import com.example.domaintest.domain.dto.MemberDto;
import com.example.domaintest.domain.dto.ReplyDto;
import com.example.domaintest.domain.dto.TestEntityDto;
import com.example.domaintest.domain.entity.Member;
import com.example.domaintest.domain.repository.FeedRepository;
import com.example.domaintest.domain.repository.MemberRepository;
import com.example.domaintest.domain.repository.ReplyRepository;
import com.example.domaintest.domain.repository.TestEntityRepository;
import com.example.domaintest.domain.vo.MemberFeedReplyVo;
import com.example.domaintest.domain.vo.MemberTestEntityVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

@Service
public class MemberService {

    @Autowired
    EntityManager entityManager;

    @Autowired
    MemberRepository memberRepository;

    @Autowired
    FeedRepository feedRepository;

    @Autowired
    ReplyRepository replyRepository;

    @Autowired
    TestEntityRepository testEntityRepository;

    public Page<MemberFeedReplyVo> getMemberVo(Pageable pageableMember, Pageable pageableFeed, Pageable pageableReply) {
        Page<MemberDto> memberDtoPage;
        Page<FeedDto> feedDtoPage;
        Page<ReplyDto> replyDtoPage;

        List<MemberFeedReplyVo> memberFeedReplyVoList = new ArrayList<>();

        memberDtoPage = memberRepository.findAllMemberDto(pageableMember);

        for (MemberDto memberDto : memberDtoPage) {
            feedDtoPage = feedRepository.findByMemberSidDto(memberDto.getMemberSid(), pageableFeed);
            replyDtoPage = replyRepository.findAllDto(memberDto.getMemberSid(), pageableMember);
            memberFeedReplyVoList.add(new MemberFeedReplyVo(memberDto, feedDtoPage, replyDtoPage));
        }
        return new PageImpl<>(memberFeedReplyVoList, memberDtoPage.getPageable(), memberDtoPage.getTotalElements());
    }

    public Page<MemberTestEntityVo> getMemberVoTest(Pageable pageable) {
        Page<MemberDto> memberDtoPage;
        List<TestEntityDto> testEntityDtoList;

        List<MemberTestEntityVo> memberTestEntityVoList = new ArrayList<>();
        Page<MemberTestEntityVo> memberTestEntityVoPage;

        // find
        memberDtoPage = memberRepository.findAllMemberDto(pageable);

        for (MemberDto memberDto : memberDtoPage) {
            testEntityDtoList = testEntityRepository.findAllById(memberDto.getMemberSid());
            memberTestEntityVoList.add(new MemberTestEntityVo(memberDto, testEntityDtoList));
        }

        // List to Page
        memberTestEntityVoPage = new PageImpl<>(memberTestEntityVoList, memberDtoPage.getPageable(), memberDtoPage.getTotalElements());
        return memberTestEntityVoPage;
    }

//    public Page<MemberTestEntityVo> getMemberVo()

    public List<MemberDto> getMember() {
//        String query = "select new com.example.domaintest.domain.dto.MemberDto( " +
//                "m.memberSid " +
//                ", m.memberNickname " +
//                ", size(m.feedList) " +
//                ", size(m.replyList)) " +
//                ", m.testEntityList " +
//                "from Member m";
//
//        return entityManager.createQuery(query, MemberDto.class)
//                .getResultList();
        return null;
    }
}
