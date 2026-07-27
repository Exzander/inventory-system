package com.iacademy.cselec05.inventory.servlet.item;

import com.iacademy.cselec05.inventory.constant.Views;
import com.iacademy.cselec05.inventory.factory.ObjectFactory;
import com.iacademy.cselec05.inventory.model.Item;
import com.iacademy.cselec05.inventory.repo.ItemRepository;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ItemListServlet extends HttpServlet {

    private final ItemRepository itemRepository = ObjectFactory.getItemRepository();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        // Retrieves all items
        List<Item> items = itemRepository.findAll();

        // Makes the list available to the JSP
        req.setAttribute("items", items);

        // Forward to the Item List view
        req.getRequestDispatcher(Views.ITEM_LIST).forward(req, resp);
    }
}