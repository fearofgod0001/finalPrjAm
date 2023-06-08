package com.kh.finalPrjAm.repository;

import com.kh.finalPrjAm.constant.ItemSellStatus;
import com.kh.finalPrjAm.entity.Item;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j //디버깅하거나 로그 파일을 만들 때 사용
@SpringBootTest //단위 테스트 및 통합 테스트를 위해 스프링부트에서 제공하는 어노테이션
@TestPropertySource(locations = "classpath:application-test.properties")
//테스트코드 실행 시 해당 설정 파일을 우선적으로 불러옴
class ItemRepositoryTest {
    @Autowired // 의존성을 주입 받음
    ItemRepository itemRepository;

    @Test
    @DisplayName("상품 저장 테스트")
    public void createItemTest(){
        Item item = new Item(); //엔티티를 객체화
        item.setItemNm("테스트 상품");
        item.setPrice(10000);
        item.setItemDetail("테스트 상품의 상세 설명");
        item.setItemSellStatus(ItemSellStatus.SELL);
        item.setStockNumber(100);
        item.setRegTime(LocalDateTime.now());
        item.setUpdateTime(LocalDateTime.now());
        Item saveItem = itemRepository.save(item);
        System.out.println(saveItem); //수 많은 실행 메시지 중 출력을 하는 것
//        대신 @Slf4j 를 사용하여 log를 찍어본다.
//        log.info(String.valueOf(saveItem));
    }

}