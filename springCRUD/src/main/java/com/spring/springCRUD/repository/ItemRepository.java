package com.spring.springCRUD.repository;

import com.spring.springCRUD.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ItemRepository extends JpaRepository<Item, String> {

    List<Item> findByNameContaining(String text);
}
