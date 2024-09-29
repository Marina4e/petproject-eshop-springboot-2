package com.example.petprojecteshopspringboot2.service;

import com.example.petprojecteshopspringboot2.domain.Item;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ItemService {
    private final List<Item> items = new ArrayList<>();

    public void addItem(Item item) {
        items.add(item);
    }

    public List<Item> getAll() {
        return items;
    }
}
