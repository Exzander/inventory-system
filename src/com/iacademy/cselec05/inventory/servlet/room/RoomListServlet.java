package com.iacademy.cselec05.inventory.servlet.room;

import com.iacademy.cselec05.inventory.constant.Views;
import com.iacademy.cselec05.inventory.factory.ObjectFactory;
import com.iacademy.cselec05.inventory.model.Room;
import com.iacademy.cselec05.inventory.repo.RoomRepository;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class RoomListServlet extends HttpServlet {

    private final RoomRepository roomRepository = ObjectFactory.getRoomRepository();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // Retrieves all rooms
        List<Room> rooms = roomRepository.findAll();

        // Makes the list available to the JSP
        req.setAttribute("rooms", rooms);


        // Forward to the Room List view
        req.getRequestDispatcher(Views.ROOM_LIST).forward(req, resp);
    }
}
