package com.iacademy.cselec05.inventory.servlet.item;

import com.iacademy.cselec05.inventory.constant.Urls;
import com.iacademy.cselec05.inventory.constant.Views;
import com.iacademy.cselec05.inventory.factory.ObjectFactory;
import com.iacademy.cselec05.inventory.model.Item;
import com.iacademy.cselec05.inventory.model.Room;
import com.iacademy.cselec05.inventory.repo.ItemRepository;
import com.iacademy.cselec05.inventory.repo.RoomRepository;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

public class CreateItemServlet extends HttpServlet {

    private final ItemRepository itemRepository = ObjectFactory.getItemRepository();
    private final RoomRepository roomRepository = ObjectFactory.getRoomRepository();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        // Retrieves all available rooms for the dropdown
        List<Room> rooms = roomRepository.findAll();
        req.setAttribute("rooms", rooms);

        req.getRequestDispatcher(Views.CREATE_ITEM).forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String name = req.getParameter("name");
        String quantityStr = req.getParameter("quantity");
        String roomIdStr = req.getParameter("roomId");

        if (name != null) {
            name = name.trim();
        }

        // Retains entered values after validation fails
        req.setAttribute("name", name);
        req.setAttribute("quantity", quantityStr);
        req.setAttribute("roomId", roomIdStr);

        // Reload rooms for the dropdown
        List<Room> rooms = roomRepository.findAll();
        req.setAttribute("rooms", rooms);

        if (name == null || name.isEmpty()) {
            req.setAttribute("itemError", "Item name is required.");
            req.getRequestDispatcher(Views.CREATE_ITEM).forward(req, resp);
            return;
        }

        int quantity;

        try {
            quantity = Integer.parseInt(quantityStr);

            if (quantity < 0) {
                req.setAttribute("itemError", "Quantity cannot be negative.");
                req.getRequestDispatcher(Views.CREATE_ITEM).forward(req, resp);
                return;
            }

        } catch (NumberFormatException e) {
            req.setAttribute("itemError", "Invalid quantity.");
            req.getRequestDispatcher(Views.CREATE_ITEM).forward(req, resp);
            return;
        }

        Integer roomId = null;

        if (roomIdStr != null && !roomIdStr.trim().isEmpty()) {
            try {
                roomId = Integer.parseInt(roomIdStr);
            } catch (NumberFormatException ignored) {
            }
        }

        Item item = new Item(name, quantity, roomId);

        boolean success = itemRepository.createItem(item);

        if (success) {
            resp.sendRedirect(req.getContextPath() + Urls.ITEM_LIST);
        } else {
            req.setAttribute("itemError", "Failed to create item.");
            req.getRequestDispatcher(Views.CREATE_ITEM).forward(req, resp);
        }
    }
}