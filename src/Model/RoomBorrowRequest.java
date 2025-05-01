package Model;

import java.util.Date;

public class RoomBorrowRequest {
    private String idRequest;
    private String lecturerUser;
    private String fullname;
    private String roomId;
    private Date requestDate;
    private Date dueDate;
    private BorrowingRequestStatus borrowingRequest;

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
    
    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

    public Date getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(Date requestDate) {
        this.requestDate = requestDate;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public BorrowingRequestStatus getBorrowingRequest() {
        return borrowingRequest;
    }

    public void setBorrowingRequest(BorrowingRequestStatus borrowingRequest) {
        this.borrowingRequest = borrowingRequest;
    }
}