package com.example.domaintest.domain.dto;

import com.example.domaintest.domain.entity.Reply;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.domain.Page;

@Data
@AllArgsConstructor
public class ReplyDto {
    private Long replySid;
    private String text;
}
