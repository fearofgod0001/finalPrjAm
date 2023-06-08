package com.kh.finalPrjAm.entity;

import com.kh.finalPrjAm.constant.ItemSellStatus;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter @Setter @ToString
public class Item {
    private Long id; //Primary Key
    private String itemNm; //상품 코드
    private int price; //가격
    private int stockNumber; // 재고 수량
    private String itemDetail; // 상품 상세 설명
    private ItemSellStatus itemSellStatus; // 상품 판매 상태 enum으로 설정함
    private LocalDateTime regTime; // 등록 시간
    private LocalDateTime updateTime; //
}
