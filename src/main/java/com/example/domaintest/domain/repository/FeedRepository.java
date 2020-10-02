package com.example.domaintest.domain.repository;

import com.example.domaintest.domain.dto.FeedDto;
import com.example.domaintest.domain.entity.Feed;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface FeedRepository extends JpaRepository<Feed, Long> {

    @Query(value = "select new com.example.domaintest.domain.dto.FeedDto(f.feedSid, f.text, f.feedLike.size, f.reply.size) " +
            "from Feed f " +
            "where f.member.memberSid = :memberSid")
    Page<FeedDto> findByMemberSidDto(Long memberSid, Pageable pageable);
}
