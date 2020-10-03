package com.example.domaintest.controller;

import com.example.domaintest.domain.dto.FeedDto;
import com.example.domaintest.domain.entity.Feed;
import com.example.domaintest.service.FeedLikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FeedController {

    @Autowired
    FeedLikeService feedLikeService;

}
