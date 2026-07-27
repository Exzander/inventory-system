package com.iacademy.cselec05.inventory.repo;

import com.iacademy.cselec05.inventory.model.Room;

import java.util.List;

public interface RoomRepository {
    boolean createRoom(Room room);

    boolean updateRoom(Room room);

    Room findById(int id);

    List<Room> findAll();
}