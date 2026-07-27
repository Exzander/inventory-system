package com.iacademy.cselec05.inventory.repo.impl;

import com.iacademy.cselec05.inventory.model.Item;
import com.iacademy.cselec05.inventory.repo.ItemRepository;
import com.iacademy.cselec05.inventory.util.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ItemJdbcRepository implements ItemRepository {

    @Override
    public boolean createItem(Item item) {

        String sql = "INSERT INTO item (item_name, quantity, room_id) VALUES (?, ?, ?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, item.getName());
            ps.setInt(2, item.getQuantity());

            if (item.getRoomId() != null) {
                ps.setInt(3, item.getRoomId());
            } else {
                ps.setNull(3, Types.INTEGER);
            }

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }


    @Override
    public boolean updateItem(Item item) {

        String sql = "UPDATE item SET item_name = ?, quantity = ?, room_id = ? WHERE item_id = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, item.getName());
            ps.setInt(2, item.getQuantity());

            if (item.getRoomId() != null) {
                ps.setInt(3, item.getRoomId());
            } else {
                ps.setNull(3, Types.INTEGER);
            }

            ps.setInt(4, item.getId());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public boolean updateQuantity(int itemId, int quantity) {

        String sql = "UPDATE item SET quantity = ? WHERE item_id = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, quantity);
            ps.setInt(2, itemId);

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public Item findById(int id) {

        String sql = "SELECT i.item_id, i.item_name, i.quantity, i.room_id, r.room_name FROM item i LEFT JOIN room r ON i.room_id = r.room_id WHERE i.item_id = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);

            try (ResultSet rs = ps.executeQuery()) {

                if (rs.next()) {

                    Item item = new Item();

                    item.setId(rs.getInt("item_id"));
                    item.setName(rs.getString("item_name"));
                    item.setQuantity(rs.getInt("quantity"));

                    int roomId = rs.getInt("room_id");

                    if (!rs.wasNull()) {
                        item.setRoomId(roomId);
                        item.setRoomName(rs.getString("room_name"));
                    } else {
                        item.setRoomId(null);
                        item.setRoomName("Unassigned");
                    }

                    return item;
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public List<Item> findAll() {

        List<Item> items = new ArrayList<>();

        String sql = "SELECT i.item_id, i.item_name, i.quantity, i.room_id, r.room_name FROM item i LEFT JOIN room r ON i.room_id = r.room_id";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {

                Item item = new Item();

                item.setId(rs.getInt("item_id"));
                item.setName(rs.getString("item_name"));
                item.setQuantity(rs.getInt("quantity"));

                int roomId = rs.getInt("room_id");

                if (!rs.wasNull()) {
                    item.setRoomId(roomId);
                    item.setRoomName(rs.getString("room_name"));
                } else {
                    item.setRoomId(null);
                    item.setRoomName("Unassigned");
                }

                items.add(item);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return items;
    }
}
