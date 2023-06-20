package com.kh.finalPrjAm.controller;

import com.kh.finalPrjAm.dto.ItemDto;
import com.kh.finalPrjAm.entity.Item;
import com.kh.finalPrjAm.service.ItemService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Slf4j //logging data 출력 혹은 저장
// log.error 등 가독성이 좋아짐 컬러를 설정 가능
// logging data를 따로 저장하여 문제가 발생한 시점을 파악 할 수 있다.
@Controller //view로 바로 던질 때 사용
@RequiredArgsConstructor//JSON이나  XML로 던질 때 사용
@RequestMapping("/thymeleaf")
public class ThymeleafItemController {
    private final ItemService itemService;
    @GetMapping("/items")
    public String getItemList(Model model){
        List<ItemDto> itemDtoList = itemService.getItemList();
        model.addAttribute("itemDtoList",itemDtoList);
        return "thymeleaf/thymeleafItemList";
    }
    @GetMapping("/new")
    public String showItemForm(Model model){
        model.addAttribute("item",new Item());
        return "thymeleaf/item-form";
    }
    @PostMapping("/items")
    public String saveItem(Item item){
        itemService.saveItem(item);
        return "thymeleaf/item-save";
    }


}
