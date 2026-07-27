package com.iacademy.cselec05.inventory.repo;

import com.iacademy.cselec05.inventory.model.Item;

import java.util.List;

public interface ItemRepository {
    boolean createItem(Item item);

    boolean updateItem(Item item);

    boolean updateQuantity(int itemId, int quantity);

    Item findById(int id);

    List<Item> findAll();
}
