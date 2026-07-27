package com.iacademy.cselec05.inventory.servlet.item;

import com.iacademy.cselec05.inventory.constant.Urls;
import com.iacademy.cselec05.inventory.constant.Views;
import com.iacademy.cselec05.inventory.factory.ObjectFactory;
import com.iacademy.cselec05.inventory.model.Item;
import com.iacademy.cselec05.inventory.repo.ItemRepository;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;

public class ManageStockServlet extends HttpServlet {
    private final ItemRepository itemRepository = ObjectFactory.getItemRepository();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idStr = req.getParameter("id");

        if (idStr == null || idStr.trim().isEmpty()) {
            resp.sendRedirect(req.getContextPath() + Urls.ITEM_LIST);
            return;
        }

        try {
            int id = Integer.parseInt(idStr);

            Item item = itemRepository.findById(id);

            if (item == null) {
                resp.sendRedirect(req.getContextPath() + Urls.ITEM_LIST);
                return;
            }

            req.setAttribute("item", item);
        } catch (NumberFormatException e) {
            resp.sendRedirect(req.getContextPath() + Urls.ITEM_LIST);
            return;
        }

        req.getRequestDispatcher(Views.MANAGE_STOCK).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idStr= req.getParameter("id");
        String operation = req.getParameter("operation");
        String quantityStr= req.getParameter("quantity");

        // Retains entered values after validation fails
        req.setAttribute("operation", operation);
        req.setAttribute("quantity", quantityStr);

        if (quantityStr == null || quantityStr.trim().isEmpty()) {
            int itemId = Integer.parseInt(idStr);
            Item item = itemRepository.findById(itemId);

            req.setAttribute("item", item);
            req.setAttribute("quantityError", "Quantity is required");

            req.getRequestDispatcher(Views.MANAGE_STOCK).forward(req, resp);
            return;
        }

        try {
            int itemId = Integer.parseInt(idStr);
            int quantity = Integer.parseInt(quantityStr);

            Item item = itemRepository.findById(itemId);

            if (item == null) {
                resp.sendRedirect(req.getContextPath() + Urls.ITEM_LIST);
                return;
            }

            req.setAttribute("item", item);

            if (quantity <= 0) {
                req.setAttribute("quantityError", "Quantity must be greater than zero");
                req.getRequestDispatcher(Views.MANAGE_STOCK).forward(req, resp);
                return;
            }

            int currentQuantity = item.getQuantity();
            int newQuantity;

            if ("ADD".equalsIgnoreCase(operation)) {
                newQuantity = currentQuantity + quantity;
            } else if ("SUBTRACT".equalsIgnoreCase(operation)) {
                if (quantity > currentQuantity) {
                    req.setAttribute("itemError", "Cannot subtract more than the current stock");
                    req.getRequestDispatcher(Views.MANAGE_STOCK).forward(req, resp);
                    return;
                }
                newQuantity = currentQuantity - quantity;
            } else {
                req.setAttribute("itemError", "Invalid operation");
                req.getRequestDispatcher(Views.MANAGE_STOCK).forward(req, resp);
                return;
            }

            boolean success = itemRepository.updateQuantity(itemId, newQuantity);

            if (success) {
                resp.sendRedirect(req.getContextPath() + Urls.ITEM_LIST);
            } else {
                req.setAttribute("itemError", "Failed to update quantity");
                req.getRequestDispatcher(Views.MANAGE_STOCK).forward(req, resp);
            }

        } catch (NumberFormatException e) {
            resp.sendRedirect(req.getContextPath() + Urls.ITEM_LIST);
        }
    }
}