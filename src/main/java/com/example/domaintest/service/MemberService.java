package com.example.domaintest.service;

import com.example.domaintest.domain.dto.FeedDto;
import com.example.domaintest.domain.dto.MemberDto;
import com.example.domaintest.domain.dto.ReplyDto;
import com.example.domaintest.domain.repository.FeedRepository;
import com.example.domaintest.domain.repository.MemberRepository;
import com.example.domaintest.domain.repository.ReplyRepository;
import com.example.domaintest.domain.vo.MemberFeedReplyVo;
import com.example.domaintest.domain.vo.MemberVo;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class MemberService {
    final MemberRepository memberRepository;
    final FeedRepository feedRepository;
    final ReplyRepository replyRepository;

//    @AllArgsConstructor 가 생성
//    public MemberService(MemberRepository memberRepository, FeedRepository feedRepository, ReplyRepository replyRepository) {
//        this.memberRepository = memberRepository;
//        this.feedRepository = feedRepository;
//        this.replyRepository = replyRepository;
//    }

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

    public Page<MemberVo> memberVoPages(Pageable pageable) {
        return memberRepository.findAllByMemberSidNotNull(pageable);
    }
}