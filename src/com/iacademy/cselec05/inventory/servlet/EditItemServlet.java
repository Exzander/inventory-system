package com.iacademy.cselec05.inventory.servlet;

import com.iacademy.cselec05.inventory.factory.ObjectFactory;
import com.iacademy.cselec05.inventory.model.Item;
import com.iacademy.cselec05.inventory.model.Room;
import com.iacademy.cselec05.inventory.repo.ItemRepository;
import com.iacademy.cselec05.inventory.repo.RoomRepository;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

public class EditItemServlet extends HttpServlet {

    private final ItemRepository itemRepository = ObjectFactory.getItemRepository();
    private final RoomRepository roomRepository = ObjectFactory.getRoomRepository();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String idStr = req.getParameter("id");

        if (idStr == null || idStr.trim().isEmpty()) {
            resp.sendRedirect(req.getContextPath() + "/item-list");
            return;
        }

        try {
            int id = Integer.parseInt(idStr);

            Item item = itemRepository.findById(id);
            List<Room> rooms = roomRepository.findAll();

            req.setAttribute("rooms", rooms);

            if (item == null) {
                req.setAttribute("itemError", "Item not found.");
            } else {
                req.setAttribute("item", item);
            }

        } catch (NumberFormatException e) {
            req.setAttribute("itemError", "Invalid Item ID.");
        }

        req.getRequestDispatcher("/WEB-INF/views/edit-item.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String idStr = req.getParameter("id");
        String name = req.getParameter("name");
        String quantityStr = req.getParameter("quantity");
        String roomIdStr = req.getParameter("roomId");

        if (name != null) {
            name = name.trim();
        }

        List<Room> rooms = roomRepository.findAll();
        req.setAttribute("rooms", rooms);

        try {

            if (idStr == null || idStr.trim().isEmpty()) {
                req.setAttribute("itemError", "Invalid Item ID.");
                req.getRequestDispatcher("/WEB-INF/views/edit-item.jsp").forward(req, resp);
                return;
            }

            int id = Integer.parseInt(idStr);

            if (name == null || name.isEmpty()) {

                Item item = new Item();
                item.setId(id);
                item.setName(name);

                req.setAttribute("item", item);
                req.setAttribute("itemError", "Item name is required.");
                req.getRequestDispatcher("/WEB-INF/views/edit-item.jsp").forward(req, resp);
                return;
            }

            int quantity;

            try {
                quantity = Integer.parseInt(quantityStr);

                if (quantity < 0) {
                    throw new NumberFormatException();
                }

            } catch (NumberFormatException e) {

                Item item = new Item();
                item.setId(id);
                item.setName(name);

                req.setAttribute("item", item);
                req.setAttribute("itemError", "Invalid quantity.");
                req.getRequestDispatcher("/WEB-INF/views/edit-item.jsp").forward(req, resp);
                return;
            }

            Integer roomId = null;

            if (roomIdStr != null && !roomIdStr.trim().isEmpty()) {
                roomId = Integer.parseInt(roomIdStr);
            }

            Item item = new Item(id, name, quantity, roomId);

            boolean success = itemRepository.updateItem(item);

            if (success) {
                resp.sendRedirect(req.getContextPath() + "/item-list");
            } else {
                req.setAttribute("item", item);
                req.setAttribute("itemError", "Failed to update item.");
                req.getRequestDispatcher("/WEB-INF/views/edit-item.jsp").forward(req, resp);
            }

        } catch (NumberFormatException e) {
            req.setAttribute("itemError", "Invalid Item ID.");
            req.getRequestDispatcher("/WEB-INF/views/edit-item.jsp").forward(req, resp);
        }
    }
}