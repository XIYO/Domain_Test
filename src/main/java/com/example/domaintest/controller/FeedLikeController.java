package com.example.domaintest.controller;

import com.example.domaintest.service.FeedLikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FeedLikeController {

    @Autowired
    FeedLikeService feedLikeService;

    @PostMapping("feed")
    public Boolean feedLikePost(@RequestBody Long feedSid, @RequestBody Long memberSid) {
        return feedLikeService.postFeedLike(feedSid, memberSid);
    }

}
