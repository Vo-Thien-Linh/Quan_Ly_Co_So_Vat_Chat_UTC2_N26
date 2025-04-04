package Model;
 
 import java.time.LocalDateTime;
import java.util.Date;


public class IncidentHandling {
    private String idReport;
    private User reportedBy; // Người báo cáo (Lecturer)
    private String device;
    private String room;
    private String description;
    private LocalDateTime reportDate;
    private User handledBy; // Người xử lý (Maintenance)

    // Constructor
    public IncidentHandling() {}

    public IncidentHandling(String idReport, User reportedBy, String device, String room, String description, LocalDateTime reportDate, User handledBy) {
        this.idReport = idReport;
        this.reportedBy = reportedBy;
        this.device = device;
        this.room = room;
        this.description = description;
        this.reportDate = reportDate;
        this.handledBy = handledBy;
    }

    // Getters and Setters
    public String getIdReport() {
        return idReport;
    }

    public void setIdReport(String idReport) {
        this.idReport = idReport;
    }

    public User getReportedBy() {
        return reportedBy;
    }

    public void setReportedBy(User reportedBy) {
        this.reportedBy = reportedBy;
    }

    public String getDevice() {
        return device;
    }

    public void setDevice(String device) {
        this.device = device;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getReportDate() {
        return reportDate;
    }

    public void setReportDate(LocalDateTime reportDate) {
        this.reportDate = reportDate;
    }

    public User getHandledBy() {
        return handledBy;
    }

    public void setHandledBy(User handledBy) {
        this.handledBy = handledBy;
    }


    public void informationReportDisplay() {
        System.out.println("Incident Report ID: " + idReport + ", Reported By: " + reportedBy.getUsername() +
                ", Device: " + device + ", Room: " + room + ", Description: " + description +
                ", Report Date: " + reportDate + ", Handled By: " + (handledBy != null ? handledBy.getUsername() : "Not handled yet"));
    }
 }
