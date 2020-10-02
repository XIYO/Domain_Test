package com.example.domaintest.domain.repository;

import com.example.domaintest.domain.dto.ReplyDto;
import com.example.domaintest.domain.entity.Reply;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ReplyRepository extends JpaRepository<Reply, Long> {

    @Query("select new com.example.domaintest.domain.dto.ReplyDto(r.replySid, r.text) " +
            "from Reply r " +
            "where r.member.memberSid = :memberSid")
    Page<ReplyDto> findAllDto(Long memberSid, Pageable pageable);
}
