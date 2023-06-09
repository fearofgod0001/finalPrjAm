package com.kh.finalPrjAm.repository;

import com.kh.finalPrjAm.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
public interface MemberRepository extends JpaRepository<Member, Long>{
}
