package com.example.domaintest.domain.repository;

import com.example.domaintest.domain.entity.FeedLike;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FeedLikeRepository extends JpaRepository<FeedLike, Long> {
}
