package com.example.domaintest.domain.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
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
