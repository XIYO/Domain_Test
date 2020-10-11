package com.example.domaintest.domain.repository;

import com.example.domaintest.domain.entity.FeedGood;
import com.example.domaintest.domain.entity.FeedGoodPk;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FeedGoodRepository extends JpaRepository<FeedGood, FeedGoodPk> {
}
