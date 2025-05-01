package Controller;

import Model.Room;
import Model.BorrowingRequestStatus;
import Repository.RoomRepository;
import Repository.RoomBorrowRequestRepository;
import View.Panel_ManagerRoom;
import java.sql.SQLException;
import java.util.List;

public class RoomController {
    private RoomRepository roomRepository;
    private RoomBorrowRequestRepository requestRepository;
    private Panel_ManagerRoom view;

    public RoomController(Panel_ManagerRoom view) throws SQLException {
        this.roomRepository = new RoomRepository();
        this.requestRepository = new RoomBorrowRequestRepository();
        this.view = view;
    }

    public void addRoom(Room room) throws SQLException {
        roomRepository.addRoom(room);
    }

    public void updateRoom(Room room) throws SQLException {
        roomRepository.updateRoom(room);
    }

    public void deleteRoom(String roomId) throws SQLException {
        roomRepository.deleteRoom(roomId);
    }

    public List<Room> getAllRooms() throws SQLException {
        return roomRepository.getAllRooms();
    }

    public boolean updateRequestStatus(String idRequest, BorrowingRequestStatus status) throws SQLException {
        return requestRepository.updateRequestStatus(idRequest, status);
    }

    public String getRoomIdByRequest(String idRequest) throws SQLException {
        return requestRepository.getRoomIdByRequest(idRequest);
    }
}