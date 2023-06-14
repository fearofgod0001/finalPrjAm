package com.kh.finalPrjAm.repository;

import com.kh.finalPrjAm.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long>{

    Optional<Member> findByEmail(String email); //null포인트를 방지하기 위해서 Optional을 쓴다 Wrapper 클래스의 종류
    boolean existsByEmail(String email);

}
