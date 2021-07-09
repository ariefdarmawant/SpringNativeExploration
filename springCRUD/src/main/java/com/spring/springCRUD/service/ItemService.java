package com.spring.springCRUD.service;

import com.spring.springCRUD.entity.Balance;
import com.spring.springCRUD.entity.Item;
import com.spring.springCRUD.exception.DataNotFoundException;
import com.spring.springCRUD.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ItemService {

    private final ItemRepository itemRepository;

    public List<Item> getAllItems(String name) {
        if (name == null) {
            return itemRepository.findAll();
        } else {
            return itemRepository.findByNameContaining(name);
        }
    }

    public Item getItemWithId(String uid) {
        Optional<Item> item = itemRepository.findById(uid);
        return item.orElseThrow(() -> new DataNotFoundException(Balance.class, "Item with uid : " + uid + " not found."));
    }

    public Item createItem(Item item) {
        Item itemSaved = itemRepository.save(item);
        return itemSaved;
    }

    public Item updateItem(String uid, Item item) {
        Optional<Item> itemData = itemRepository.findById(uid);
        Item saveItem = itemData.orElseThrow(() -> new DataNotFoundException(Balance.class, "Item with uid : " + uid + " not found."));;
        saveItem.setName(item.getName());
        saveItem.setDescription(item.getDescription());
        return itemRepository.save(saveItem);
    }

    public Item deleteItem(String uid) {
        Optional<Item> item = itemRepository.findById(uid);
        itemRepository.deleteById(uid);
        return item.orElseThrow(() -> new DataNotFoundException(Balance.class, "Item with uid : " + uid + " not found."));
    }
}
