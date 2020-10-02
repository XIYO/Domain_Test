package com.example.domaintest.domain.vo;

import com.example.domaintest.domain.dto.MemberDto;
import com.example.domaintest.domain.dto.TestEntityDto;
import lombok.Data;

import java.util.List;

@Data
public class MemberTestEntityVo {

    private Long memberSid;
    private String memberNickname;

    private Integer feedCount;
    private Integer replyCount;
    private Integer scrapCount;

    private List<TestEntityDto> testEntityList;

    public MemberTestEntityVo(MemberDto memberDto, List<TestEntityDto> testEntityDto) {
        this.memberSid = memberDto.getMemberSid();
        this.memberNickname = memberDto.getMemberNickname();
        this.feedCount = memberDto.getFeedCount();
        this.replyCount = memberDto.getReplyCount();
        this.scrapCount = 0;
        this.testEntityList = testEntityDto;
    }
}
