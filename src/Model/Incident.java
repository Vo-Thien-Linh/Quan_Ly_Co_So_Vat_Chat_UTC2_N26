package Model;

import java.util.Date;

public class Incident {
	private String idReport;
	private String reportedBy;
	private String deviceId;
	private String roomId;
	private String description;
	private Date reportDate;
	private String handledBy;
	private String status;

	public Incident(String idReport, String reportedBy, String deviceId, String roomId, String description,
			Date reportDate, String handledBy, String status) {
		super();
		this.idReport = idReport;
		this.reportedBy = reportedBy;
		this.deviceId = deviceId;
		this.roomId = roomId;
		this.description = description;
		this.reportDate = reportDate;
		this.handledBy = handledBy;
		this.status = status;
	}

	public String getIdReport() {
		return idReport;
	}

	public void setIdReport(String idReport) {
		this.idReport = idReport;
	}

	public String getReportedBy() {
		return reportedBy;
	}

	public void setReportedBy(String reportedBy) {
		this.reportedBy = reportedBy;
	}

	public String getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}

	public String getRoomId() {
		return roomId;
	}

	public void setRoomId(String roomId) {
		this.roomId = roomId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getReportDate() {
		return reportDate;
	}

	public void setReportDate(Date reportDate) {
		this.reportDate = reportDate;
	}

	public String getHandledBy() {
		return handledBy;
	}

	public void setHandledBy(String handledBy) {
		this.handledBy = handledBy;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
