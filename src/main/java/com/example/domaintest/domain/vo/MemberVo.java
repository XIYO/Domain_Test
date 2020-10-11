package com.example.domaintest.domain.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class MemberVo {
    private Long memberSid;
    private String memberNickname;
}
