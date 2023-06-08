package com.kh.finalPrjAm.entity;
import javax.persistence.*;
import java.time.LocalDateTime;

//1. Entity로 선언
@Entity // JPA에 entity 클래스 임을 알려줌, DB Table로 만들어져야 할 클래스
//2. 테이블 이름 선언
@Table(name = "member_info") // 생성 될 DB 이름을 정해 줌(자바의 표기법은 대소문자를 구분하며 카멜 표기법을 따름)
public class Member {
    //3. 컬럼 생성 규칙
    @Id // 해당 필드가 primary key 임을 지정
    @Column(name = "member_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String userId;
    private String name;
    private String password;
    @Column(unique = true) //유일한 값이 되어야 함.
    private String email;
    private LocalDateTime joinTime;


}
