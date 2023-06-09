package com.kh.finalPrjAm.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Getter @Setter @ToString
public class CartItem {
    @Id
    @GeneratedValue
    @Column(name = "cart_item_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name="cart_id")
    private Cart cart;

    @ManyToOne//하나의 상품은 여러 장바구니의 상품으로 포함될 수 있으므로 다대링 관계 매핑
    @JoinColumn(name="item_id")
    private Item item;

    private int count;
}
