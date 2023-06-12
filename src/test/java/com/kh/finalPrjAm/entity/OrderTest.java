package com.kh.finalPrjAm.entity;

import com.kh.finalPrjAm.constant.ItemSellStatus;
import com.kh.finalPrjAm.repository.ItemRepository;
import com.kh.finalPrjAm.repository.MemberRepository;
import com.kh.finalPrjAm.repository.OrderRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class OrderTest {
    @Autowired
    OrderRepository orderRepository;
    @Autowired
    ItemRepository itemRepository;
    @Autowired
    MemberRepository memberRepository;

    @PersistenceContext //영속성에 대한 정보를 저장하고 관리
    EntityManager em;

    public Item createItem(){
        Item item = new Item();
        item.setItemNm("테스트 상품");
        item.setPrice(10000);
        item.setItemDetail("상세설명");
        item.setItemSellStatus(ItemSellStatus.SELL);
        item.setStockNumber(100);
        return item;
    }
    @Test@DisplayName("영속성 전이 테스트")
    public void cascadeTest(){
        Order order = new Order();
        for(int i =0; i <3; i++){
            Item item = this.createItem();
            itemRepository.save(item);
            OrderItem orderItem = new OrderItem();
            orderItem.setItem(item);
            orderItem.setCount(10);
            orderItem.setOrderPrice(1000);
            orderItem.setOrder(order);
            //아직 영속성 컨텍스트에 지장되지 않은 orderItem 엔티티를 order 엔티티를 담아 둠
            order.getOrderItemList().add(orderItem);
        }
        // 엔티티에 저장하면서 강제로 flush하여 영속성 컨텍스트에 반영
        orderRepository.saveAndFlush(order);
        em.clear();
        // 주문 엔티티 조회
        Order saveOrder = orderRepository.findById(order.getId()).orElseThrow(EntityNotFoundException::new);
        assertEquals(3,saveOrder.getOrderItemList().size()); //참과 거짓을 판별 하는 코드
    }

    public Order createOrder(){
        Order order = new Order();
        for(int i = 0; i<3; i++){
            Item item = createItem();
            itemRepository.save(item);
            OrderItem orderItem = new OrderItem();
            orderItem.setItem(item);
            orderItem.setCount(10);
            orderItem.setOrderPrice(10000);
            orderItem.setOrder(order);
            order.getOrderItemList().add(orderItem);
        }
        Member member = new Member();
        memberRepository.save(member);
        order.setMember(member);
        orderRepository.save(order);
        return order;
    }

    @Test
    @DisplayName("고아객체 제거 테스트")
    public void orphanRemovalTest(){
        Order order = this.createOrder();
        order.getOrderItemList().remove(0); // order 엔티티에서 관리하고 있는 orderItem 리스트의 0번째 인덱스 요소를 제거
        em.flush();
    }
}