package Model;

import java.time.LocalDateTime;

public class BorrowingRoomRequest {
    private String idRequest;
    private Lecturer lecturer;
    private Room room;
    private LocalDateTime requestDate;
    private LocalDateTime dueDate;
    private String RequestStatus; 

    public BorrowingRoomRequest() {
        this.RequestStatus = "Đã tạo";
    }

    public BorrowingRoomRequest(String idRequest, Lecturer lecturer, Room room, LocalDateTime requestDate, LocalDateTime dueDate, String status) {
        this.idRequest = idRequest;
        this.lecturer = lecturer;
        this.room = room;
        this.requestDate = requestDate;
        this.dueDate = dueDate;
        this.RequestStatus = status != null ? status : "Đã tạo";
    }

    public String getIdRequest() {
        return idRequest;
    }

    public void setIdRequest(String idRequest) {
        this.idRequest = idRequest;
    }

    public Lecturer getLecturer() {
        return lecturer;
    }

    public void setLecturer(Lecturer lecturer) {
        this.lecturer = lecturer;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public LocalDateTime getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(LocalDateTime requestDate) {
        this.requestDate = requestDate;
    }

    public LocalDateTime getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDateTime dueDate) {
        this.dueDate = dueDate;
    }

	public String getRequestStatus() {
		return RequestStatus;
	}

	public void setRequestStatus(String requestStatus) {
		RequestStatus = requestStatus;
	}
}