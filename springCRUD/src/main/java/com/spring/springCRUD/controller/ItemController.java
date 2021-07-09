package com.spring.springCRUD.controller;

import com.spring.springCRUD.entity.Item;
import com.spring.springCRUD.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/items")
@RequiredArgsConstructor
public class ItemController {

    private final ItemService service;

    @GetMapping
    public ResponseEntity<List<Item>> getAllItems(@RequestParam(required = false) String name) {
        List<Item> items = service.getAllItems(name);
        return new ResponseEntity<>(items, HttpStatus.OK);
    }

    @GetMapping("/{uid}")
    public ResponseEntity<Item> getItemWithId(@PathVariable("uid") String uid) {
        Item item = service.getItemWithId(uid);
        return new ResponseEntity<>(item, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity createItem(@Valid @RequestBody Item item) {
        service.createItem(item);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/{uid}")
    public ResponseEntity<Item> updateItem(@PathVariable("uid") String uid, @Valid @RequestBody Item item) {
        Item itemData = service.updateItem(uid, item);
        return new ResponseEntity<>(itemData, HttpStatus.OK);
    }

    @DeleteMapping("/{uid}")
    public ResponseEntity<Item> deleteItem(@PathVariable("uid") String uid) {
        Item item = service.deleteItem(uid);
        return new ResponseEntity<>(item, HttpStatus.OK);
    }
}
