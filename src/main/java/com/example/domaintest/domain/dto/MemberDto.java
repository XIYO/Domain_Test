package com.example.domaintest.domain.dto;

import com.example.domaintest.domain.entity.Member;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberDto {

    private Long memberSid;
    private String memberNickname;

    private Integer feedCount;
    private Integer replyCount;
//    private Integer scrapCount;

    public MemberDto(
            Long memberSid
            , String memberNickname
            , Integer feedSize
            , Integer replyCount
    ) {
        this.memberSid = memberSid;
        this.memberNickname = memberNickname;

        this.feedCount = feedSize;
        this.replyCount = replyCount;
//        this.scrapCount = scrapCount;

    }

}
