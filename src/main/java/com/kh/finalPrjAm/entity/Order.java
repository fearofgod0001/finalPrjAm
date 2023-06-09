package com.kh.finalPrjAm.entity;

import com.kh.finalPrjAm.constant.OrderStatus;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "orders")
@Getter @Setter @ToString
public class Order {
    @Id
    @GeneratedValue
    @Column(name ="order_id")//주문정보
    private Long id;
    @ManyToOne
    @JoinColumn(name = "member_id") //회원정보
    private Member member;

    private LocalDateTime orderDate; // 주문일
    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;
    private LocalDateTime regTime;
    private LocalDateTime updateTime;



}
