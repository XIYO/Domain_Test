package com.example.domaintest.controller;

import com.example.domaintest.domain.dto.MemberDto;
import com.example.domaintest.domain.repository.MemberRepository;
import com.example.domaintest.domain.vo.MemberFeedReplyVo;
import com.example.domaintest.domain.vo.MemberVo;
import com.example.domaintest.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MemberController {

    @Autowired
    MemberRepository memberRepository;

    @Autowired
    MemberService memberService;

//    @GetMapping("memberTest001")
//    public List<MemberDto> getMemberTest001() {
//        return memberService.getMember();
//    }

    @GetMapping("memberTest002")
    public Page<MemberDto> getMemberTest002(Pageable pageable) {
        return memberRepository.findAllMemberDto(pageable);
    }

    @GetMapping("memberTest004")
    public Page<MemberFeedReplyVo> getMemberTest004(@Qualifier("member") Pageable pageableMember,
                                                    @Qualifier("feed") Pageable pageableFeed,
                                                    @Qualifier("reply") Pageable pageableReply) {
        return memberService.getMemberVo(pageableMember, pageableFeed, pageableReply);
    }

    @GetMapping("memberTest005")
    public Page<MemberVo> getMemberTest005(Pageable pageable) {
        return memberService.memberVoPages(pageable);
    }
}
