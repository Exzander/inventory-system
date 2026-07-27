package com.iacademy.cselec05.inventory.repo.impl;

import com.iacademy.cselec05.inventory.model.Room;
import com.iacademy.cselec05.inventory.repo.RoomRepository;
import com.iacademy.cselec05.inventory.util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RoomJdbcRepository implements RoomRepository {

    @Override
    public boolean createRoom(Room room) {
        String sql = "INSERT INTO room (room_name) VALUES (?)";

        try(Connection conn = DBConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, room.getRoomName());

            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean updateRoom(Room room) {
        String sql = "UPDATE room SET room_name = ? WHERE room_id = ?";

        try(Connection conn = DBConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, room.getRoomName());
            ps.setInt(2, room.getId());

            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public Room findById(int id) {
        String sql = "SELECT room_id, room_name FROM room WHERE room_id = ?";

        try(Connection conn = DBConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);

            try(ResultSet rs = ps.executeQuery()) {
                if(rs.next()) {
                    Room room = new Room();
                    room.setId(rs.getInt("room_id"));
                    room.setRoomName(rs.getString("room_name"));

                    return room;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public List<Room> findAll() {
        String sql = "SELECT room_id, room_name FROM room";

        List<Room> rooms = new ArrayList<>();

        try(Connection conn = DBConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery()) {

            while(rs.next()) {
                Room room = new Room();
                room.setId(rs.getInt("room_id"));
                room.setRoomName(rs.getString("room_name"));

                rooms.add(room);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return rooms;
    }
}
