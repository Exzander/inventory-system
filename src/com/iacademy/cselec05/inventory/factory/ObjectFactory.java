package com.iacademy.cselec05.inventory.factory;

import com.iacademy.cselec05.inventory.repo.RoomRepository;
import com.iacademy.cselec05.inventory.repo.UserRepository;
import com.iacademy.cselec05.inventory.repo.impl.RoomJdbcRepository;
import com.iacademy.cselec05.inventory.repo.impl.UserJdbcRepository;

public class ObjectFactory {

    private static final UserRepository USER_REPOSITORY = new UserJdbcRepository();
    private static final RoomRepository ROOM_REPOSITORY = new RoomJdbcRepository();

    public static UserRepository getUserRepository() {
        return USER_REPOSITORY;
    }

    public static RoomRepository getRoomRepository() {
        return ROOM_REPOSITORY;
    }
}
