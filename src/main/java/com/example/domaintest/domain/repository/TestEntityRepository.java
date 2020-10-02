package com.example.domaintest.domain.repository;

import com.example.domaintest.domain.dto.TestEntityDto;
import com.example.domaintest.domain.entity.TestEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TestEntityRepository extends JpaRepository<TestEntity, Long> {

    @Query("select new com.example.domaintest.domain.dto.TestEntityDto(t.id, t.text) " +
            "from TestEntity t " +
            "where t.member.memberSid = :memberSid ")
    List<TestEntityDto> findAllById(Long memberSid);

}
