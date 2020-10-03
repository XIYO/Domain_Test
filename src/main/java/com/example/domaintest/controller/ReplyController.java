package com.example.domaintest.controller;

import com.example.domaintest.domain.dto.ReplyDto;
import com.example.domaintest.domain.entity.Reply;
import com.example.domaintest.domain.repository.ReplyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReplyController {

    @Autowired
    ReplyRepository replyRepository;

}
