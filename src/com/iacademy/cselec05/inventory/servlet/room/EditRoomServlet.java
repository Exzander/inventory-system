package com.iacademy.cselec05.inventory.servlet.room;

import com.iacademy.cselec05.inventory.constant.Urls;
import com.iacademy.cselec05.inventory.constant.Views;
import com.iacademy.cselec05.inventory.factory.ObjectFactory;
import com.iacademy.cselec05.inventory.model.Room;
import com.iacademy.cselec05.inventory.repo.RoomRepository;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class EditRoomServlet extends HttpServlet {
    private final RoomRepository roomRepository = ObjectFactory.getRoomRepository();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idStr = req.getParameter("id");

        if(idStr == null || idStr.trim().isEmpty()) {
            resp.sendRedirect(req.getContextPath() + Urls.ROOM_LIST);
            return;
        }

        try {
            int id = Integer.parseInt(idStr);

            Room room = roomRepository.findById(id);

            if(room == null) {
                req.setAttribute("roomError", "Room not found");
            } else {
                req.setAttribute("room", room);
            }
        } catch (NumberFormatException e) {
            req.setAttribute("roomError", "Invalid room ID");
        }

        req.getRequestDispatcher(Views.EDIT_ROOM).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idParam = req.getParameter("id");
        String roomName = req.getParameter("roomName");

        if (roomName != null) {
            roomName = roomName.trim();
        }

        try {
            if(idParam == null || idParam.trim().isEmpty()) {
                req.setAttribute("roomError", "Invalid room ID");
                req.getRequestDispatcher(Views.EDIT_ROOM).forward(req, resp);
                return;
            }

            int id = Integer.parseInt(idParam);

            if (roomName == null || roomName.isEmpty()) {
                Room room = new Room();
                room.setId(id);
                room.setRoomName(roomName);

                req.setAttribute("roomError", "Room name is required");
                req.setAttribute("room", room);
                req.getRequestDispatcher(Views.EDIT_ROOM).forward(req, resp);
                return;
            }

            Room room = new Room();
            room.setId(id);
            room.setRoomName(roomName);

            boolean success = roomRepository.updateRoom(room);

            if (success) {
                resp.sendRedirect(req.getContextPath() + Urls.ROOM_LIST);
            } else {
                req.setAttribute("roomError", "Failed to update room");
                req.setAttribute("room", room);
                req.getRequestDispatcher(Views.EDIT_ROOM).forward(req, resp);
            }
        } catch (NumberFormatException e) {
            req.setAttribute("roomError", "Invalid Room ID.");
            req.getRequestDispatcher(Views.EDIT_ROOM).forward(req, resp);
        }
    }
}
