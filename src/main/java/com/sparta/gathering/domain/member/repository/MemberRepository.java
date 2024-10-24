package com.sparta.gathering.domain.member.repository;

import com.sparta.gathering.domain.member.entity.Member;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
    List<Member> findByGatherIdAndDeletedAtIsNull(Pageable pageable, long gatherId);

    @Query("SELECT m.user.id, m.permission FROM Member m WHERE m.gather.id = :gatherId and m.permission = com.sparta.gathering.domain.member.enums.Permission.MANAGER")
    Optional<UUID> findManagerIdByGatherId(@Param("gatherId") Long gatherId);


    Optional<Member> findByUserId(UUID id);
}
