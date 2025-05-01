package Model;

import java.util.Date;

public class DeviceBorrowRequest {
    private String idRequest;
    private String lecturerUser;
    private String deviceId;
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

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
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