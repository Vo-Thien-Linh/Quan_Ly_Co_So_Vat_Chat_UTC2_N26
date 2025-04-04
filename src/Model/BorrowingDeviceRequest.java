package Model;

import java.time.LocalDateTime;

public class BorrowingDeviceRequest {
    private String idRequest;
    private Lecturer lecturer;
    private Device device;
    private LocalDateTime requestDate;
    private LocalDateTime dueDate;
    private String requestStatus;

    public BorrowingDeviceRequest() {
        this.requestStatus = "Được tạo"; 
    }

    public BorrowingDeviceRequest(String idRequest, Lecturer lecturer, Device device, LocalDateTime requestDate, LocalDateTime dueDate, String status) {
        this.idRequest = idRequest;
        this.lecturer = lecturer;
        this.device = device;
        this.requestDate = requestDate;
        this.dueDate = dueDate;
        this.requestStatus = status != null ? status : "Được tạo";
    }

    // Getters and Setters
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

    public Device getDevice() {
        return device;
    }

    public void setDevice(Device device) {
        this.device = device;
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
		return requestStatus;
	}

	public void setRequestStatus(String requestStatus) {
		this.requestStatus = requestStatus;
	}

    
}