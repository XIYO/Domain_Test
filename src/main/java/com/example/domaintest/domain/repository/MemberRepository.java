package com.example.domaintest.domain.repository;

import com.example.domaintest.domain.dto.MemberDto;
import com.example.domaintest.domain.entity.Member;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface MemberRepository extends JpaRepository<Member, Long> {

    @Query(value = "select new com.example.domaintest.domain.dto.MemberDto( " +
            "m.memberSid " +
            ", m.memberNickname " +
            ", m.feedList.size " +
            ", m.replyList.size " +
//            ", m.feedList " +
//            ", m.testEntityList " +
            ") " +
            "from Member m ",
            countQuery = "select count(m) " +
                    "from Member m ")
    Page<MemberDto> findAllMemberDto(Pageable pageable);

}
