package com.example.domaintest.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@AllArgsConstructor
public class TestEntityDto {
    private Long id;
    private String text;
}
