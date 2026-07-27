package com.iacademy.cselec05.inventory.constant;

public class Views {
    // Common Views
    public static final String LOGIN = "/login.jsp";

    // Home Views
    public static final String HOME = "/WEB-INF/views/home.jsp";

    // Admin Views
    public static final String REGISTER_USER = "/WEB-INF/views/user/register-user.jsp";

    // Item Views
    public static final String ITEM_LIST = "/WEB-INF/views/item/item-list.jsp";
    public static final String CREATE_ITEM = "/WEB-INF/views/item/create-item.jsp";
    public static final String EDIT_ITEM = "/WEB-INF/views/item/edit-item.jsp";
    public static final String MANAGE_STOCK = "/WEB-INF/views/item/manage-stock.jsp";

    // Room Views
    public static final String ROOM_LIST = "/WEB-INF/views/room/room-list.jsp";
    public static final String CREATE_ROOM = "/WEB-INF/views/room/create-room.jsp";
    public static final String EDIT_ROOM = "WEB/INF/views/room/edit-room.jsp";

    private Views() {
        // Prevent object creation
    }
}
