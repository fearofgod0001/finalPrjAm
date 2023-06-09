package com.kh.finalPrjAm.entity;

import com.kh.finalPrjAm.repository.CartRepository;
import com.kh.finalPrjAm.repository.MemberRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest // 스프링 컨텍스트를 로드 하여 테스트 환경을 설정
@Transactional // 데이터베이스의 논리적인 작업 단위, 모두 성공하는 경우가 아니면 롤백
@Slf4j // 로깅 데이터를 처리하기 위해 사용
@TestPropertySource(locations = "classpath:application-test.properties")
class CartTest {
    @Autowired //스프링 컨테이너에서 해당 반에 해당하는 의존성을 주입 받음
    CartRepository cartRepository;
    @Autowired
    MemberRepository memberRepository;
    @PersistenceContext //EntityManager를 사용하기 위해서
    EntityManager em;




}