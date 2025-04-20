package Model;

import java.time.LocalDateTime;

public class IncidentHandling {
    private String idReport;
    private Lecturer reportedBy;
    private Device device;
    private Room room;
    private String description;
    private LocalDateTime reportDate;
    private Maintenance handledBy;
    private IncidentStatus status;

    public IncidentHandling() {
        this.status = IncidentStatus.PENDING;
    }

    public IncidentHandling(String idReport, Lecturer reportedBy, Device device, Room room, String description,
                    LocalDateTime reportDate, Maintenance handledBy, IncidentStatus status) {
        this.idReport = idReport;
        this.reportedBy = reportedBy;
        this.device = device;
        this.room = room;
        this.description = description;
        this.reportDate = reportDate;
        this.handledBy = handledBy;
        this.status = (status != null) ? status : IncidentStatus.PENDING;
    }

    public String getIdReport() {
        return idReport;
    }

    public void setIdReport(String idReport) {
        this.idReport = idReport;
    }

    public Lecturer getReportedBy() {
        return reportedBy;
    }

    public void setReportedBy(Lecturer reportedBy) {
        this.reportedBy = reportedBy;
    }

    public Device getDevice() {
        return device;
    }

    public void setDevice(Device device) {
        this.device = device;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
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

    public Maintenance getHandledBy() {
        return handledBy;
    }

    public void setHandledBy(Maintenance handledBy) {
        this.handledBy = handledBy;
    }

    public IncidentStatus getStatus() {
        return status;
    }

    public void setStatus(IncidentStatus status) {
        this.status = status;
    }
}
