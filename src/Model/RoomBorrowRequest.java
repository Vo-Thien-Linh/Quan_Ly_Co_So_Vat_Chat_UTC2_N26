package Model;

import java.sql.Timestamp;

public class RoomBorrowRequest {
    private String idRequest;
    private String lecturerUser;
    private String roomId;
    private Timestamp requestDate;
    private Timestamp dueDate;
    private BorrowingRequestStatus borrowingRequest;

    public RoomBorrowRequest() {}

    public String getIdRequest() {
        return idRequest;
    }

    public void setIdRequest(String idRequest) {
        this.idRequest = idRequest;
    }

    public String getLecturerUser() {
        return lecturerUser;
    }

    public void setLecturerUser(String lecturerUser) {
        this.lecturerUser = lecturerUser;
    }

    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

    public Timestamp getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(Timestamp requestDate) {
        this.requestDate = requestDate;
    }

    public Timestamp getDueDate() {
        return dueDate;
    }

    public void setDueDate(Timestamp dueDate) {
        this.dueDate = dueDate;
    }

    public BorrowingRequestStatus getBorrowingRequest() {
        return borrowingRequest;
    }

    public void setBorrowingRequest(BorrowingRequestStatus borrowingRequest) {
        this.borrowingRequest = borrowingRequest;
    }
}