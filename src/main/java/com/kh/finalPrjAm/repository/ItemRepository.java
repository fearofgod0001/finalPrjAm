package com.kh.finalPrjAm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.kh.finalPrjAm.entity.Item;

import java.util.List;

//JpaRepository는 첫 번째에서 엔티티 타임 클래스를 넣어주고 , 두번째는 기본 키
//기본적인 CRUD 및 페이징 처리를 위한 메소드는 정의 되어 있음
public interface ItemRepository extends JpaRepository<Item, Long> {

    List<Item> findByItemNm(String itemNm); //조건절에 들어갈 이름을 설정한다.

    //OR 조건 처리
    List<Item> findByItemNmOrItemDetail(String itemNm, String itemDetail);

    //LessThan : 매개변수로 전달 받은 값보다 작은 상품 조회
    List<Item> findByPriceLessThan(Integer price);

    //OrderBy 로 정렬 : OrderBy + 속성명 + ASC or DESC(내림차순)
    List<Item> findByPriceLessThanOrderByPriceDesc(Integer price);


}
