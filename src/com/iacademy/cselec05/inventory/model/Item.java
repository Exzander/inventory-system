package com.iacademy.cselec05.inventory.model;

public class Item {
    private int id;
    private String name;
    private int quantity;
    private Integer roomId;
    private String roomName;

    // Used for setting fields
    public Item() {}

    // Used when creating an item before it's inserted into the database
    public Item(String name, int quantity, Integer roomId) {
        this.name = name;
        this.quantity = quantity;
        this.roomId = roomId;
    }

    // Used when retrieving an item from the database.
    public Item(int id, String name, int quantity, Integer roomId) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.roomId = roomId;
    }

    // Used when retrieving items with JOIN for display
    public Item(int id, String name, int quantity, Integer roomId, String roomName) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.roomId = roomId;
        this.roomName = roomName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Integer getRoomId() {
        return roomId;
    }

    public void setRoomId(Integer roomId) {
        this.roomId = roomId;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }
}
