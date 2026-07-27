package com.iacademy.cselec05.inventory.servlet;

import com.iacademy.cselec05.inventory.factory.ObjectFactory;
import com.iacademy.cselec05.inventory.model.Room;
import com.iacademy.cselec05.inventory.repo.RoomRepository;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CreateRoomServlet extends HttpServlet {

    private final RoomRepository roomRepository = ObjectFactory.getRoomRepository();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/views/create-room.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String roomName = req.getParameter("roomName");

        // Clean input up front
        if(roomName != null) {
            roomName = roomName.trim();
        }

        // Retains the entered roomName in the field
        req.setAttribute("roomName", roomName);

        if(roomName == null || roomName.isEmpty()) {
            req.setAttribute("roomError", "Room name is required");
            req.getRequestDispatcher("/WEB-INF/views/create-room.jsp").forward(req, resp);
            return;
        }

        Room room = new Room();
        room.setRoomName(roomName);

        boolean success = roomRepository.createRoom(room);

        if(success) {
            resp.sendRedirect(req.getContextPath() + "/room-list");
        } else {
            req.setAttribute("roomError", "Failed to create room");
            req.getRequestDispatcher("/WEB-INF/views/create-room.jsp").forward(req, resp);
        }
    }
}
