package com.kh.finalPrjAm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.kh.finalPrjAm.entity.Item;

//JpaRepository는 첫 번째에서 엔티티 타임 클래스를 넣어주고 , 두번째는 기본 키
//기본적인 CRUD 및 페이징 처리를 위한 메소드는 정의 되어 있음
public interface ItemRepository extends JpaRepository<Item, Long> {

}
