package Model;

import java.sql.Timestamp;

public class DeviceBorrowRequest {
    private String idRequest;
    private String lecturerUser;
    private String fullname;
    private String deviceId;
    private Timestamp requestDate;
    private Timestamp dueDate;
    private BorrowingRequestStatus borrowingRequest;

    // Getters and setters
    public String getIdRequest() { return idRequest; }
    public void setIdRequest(String idRequest) { this.idRequest = idRequest; }
    public String getLecturerUser() { return lecturerUser; }
    public void setLecturerUser(String lecturerUser) { this.lecturerUser = lecturerUser; }
    public String getFullname() { return fullname; }
    public void setFullname(String fullname) { this.fullname = fullname; }
    public String getDeviceId() { return deviceId; }
    public void setDeviceId(String deviceId) { this.deviceId = deviceId; }
    public Timestamp getRequestDate() { return requestDate; }
    public void setRequestDate(Timestamp requestDate) { this.requestDate = requestDate; }
    public Timestamp getDueDate() { return dueDate; }
    public void setDueDate(Timestamp dueDate) { this.dueDate = dueDate; }
    public BorrowingRequestStatus getBorrowingRequest() { return borrowingRequest; }
    public void setBorrowingRequest(BorrowingRequestStatus borrowingRequest) { this.borrowingRequest = borrowingRequest; }
}