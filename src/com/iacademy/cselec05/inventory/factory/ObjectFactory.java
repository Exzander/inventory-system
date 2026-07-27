package com.iacademy.cselec05.inventory.factory;

import com.iacademy.cselec05.inventory.repo.ItemRepository;
import com.iacademy.cselec05.inventory.repo.RoomRepository;
import com.iacademy.cselec05.inventory.repo.UserRepository;
import com.iacademy.cselec05.inventory.repo.impl.ItemJdbcRepository;
import com.iacademy.cselec05.inventory.repo.impl.RoomJdbcRepository;
import com.iacademy.cselec05.inventory.repo.impl.UserJdbcRepository;

public class ObjectFactory {

    private static final UserRepository USER_REPOSITORY = new UserJdbcRepository();
    private static final RoomRepository ROOM_REPOSITORY = new RoomJdbcRepository();
    private static final ItemRepository ITEM_REPOSITORY = new ItemJdbcRepository();

    public static UserRepository getUserRepository() {
        return USER_REPOSITORY;
    }

    public static RoomRepository getRoomRepository() {
        return ROOM_REPOSITORY;
    }

    public static ItemRepository getItemRepository() {
        return ITEM_REPOSITORY;
    }
}
