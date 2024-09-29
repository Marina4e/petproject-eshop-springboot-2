package com.example.petprojecteshopspringboot2.controllers;

import com.example.petprojecteshopspringboot2.domain.Item;
import com.example.petprojecteshopspringboot2.service.ItemService;
import jakarta.validation.constraints.Max;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class MainItemController {
    private ItemService itemService;
    public MainItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @ModelAttribute("items")
    public List<Item> addAttributeItems(){
        return itemService.getAll();
    }

    @RequestMapping({"/index2","index2.html"})
    public String getIndex(){
        return "index2";
    }

    @MessageMapping("/item")
    @SendTo("/topic/items")
    public Item addItem(Item item){
        itemService.addItem(item);
        return item;
    }
}
