package com.example.domaintest.controller;

import com.example.domaintest.domain.dto.FeedDto;
import com.example.domaintest.domain.entity.Feed;
import com.example.domaintest.domain.repository.FeedRepository;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FeedController {

    @Autowired
    FeedRepository feedRepository;

//    @GetMapping("feed")
//    public Page<FeedDto> getFeedPage(Pageable pageable) {
//        return feedRepository.findAll(pageable);
//    }
}
