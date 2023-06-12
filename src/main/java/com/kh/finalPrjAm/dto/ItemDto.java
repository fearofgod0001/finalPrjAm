package com.kh.finalPrjAm.dto;

//뷰로 전달하려면 DTO가 필요하다
//Data Transfer Object
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ItemDto {
    String itemNm;
    int price;
    String itemDetail;
}
