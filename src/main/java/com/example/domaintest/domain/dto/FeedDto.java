package com.example.domaintest.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@AllArgsConstructor
public class FeedDto {
    private Long feedSid;
    private String text;

    private Integer feedLikeCount;
    private Integer replyCount;

    public FeedDto(Long feedSid, String text) {
        this.feedSid = feedSid;
        this.text = text;
    }
}
