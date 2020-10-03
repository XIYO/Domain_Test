package com.example.domaintest.domain.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Collection;

@Getter
@Setter
public class MemberTestDto {
    private Long memberSid;
    private String memberNickname;

    private Integer feedCount;
    private Integer replyCount;

    private Collection<TestEntityDto> testEntityDtos;

    public MemberTestDto(
            Long memberSid
            , String memberNickname

            , Integer feedSize
            , Integer replyCount

            , Collection<TestEntityDto> testEntityDtos
    ) {
        this.memberSid = memberSid;
        this.memberNickname = memberNickname;

        this.feedCount = feedSize;
        this.replyCount = replyCount;

        this.testEntityDtos = testEntityDtos;
    }

}