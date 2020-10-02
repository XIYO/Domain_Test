package com.example.domaintest.domain.vo;

import lombok.Data;
import org.springframework.data.domain.Pageable;

@Data
public class PageMemberTestEntityVo {
    private MemberTestEntityVo contents;
    private Pageable pageable;
}
