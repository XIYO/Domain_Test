package com.example.domaintest.domain.vo;

import com.example.domaintest.domain.dto.FeedDto;
import com.example.domaintest.domain.dto.MemberDto;
import com.example.domaintest.domain.dto.ReplyDto;
import lombok.Data;
import org.springframework.data.domain.Page;

@Data
public class MemberFeedReplyVo {
    private MemberDto memberDto;
    private Page<FeedDto> feedDto;
    private Page<ReplyDto> replyDto;

    public MemberFeedReplyVo(MemberDto memberDto, Page<FeedDto> feedDto, Page<ReplyDto> replyDto) {
        this.memberDto = memberDto;
        this.feedDto = feedDto;
        this.replyDto = replyDto;
    }
}
