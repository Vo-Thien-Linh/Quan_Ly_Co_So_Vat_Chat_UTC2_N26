package Model;
<<<<<<< HEAD

import java.util.Date;

public class IncidentHandling {
    private String idReport;
    private String  handler;
    private Date incidentHandlingDate;
    private String contentToBeHandled;
    private static int idCounter = 0;

    public IncidentHandling(String idReport, String handler, Date incidentHandlingDate, String contentToBeHandled) {
		super();
		this.idReport = idReport;
		this.handler = handler;
		this.incidentHandlingDate = incidentHandlingDate;
		this.contentToBeHandled = contentToBeHandled;
	}

	public String getIdReport() {
		return idReport;
	}

	public void setIdReport(String idReport) {
		this.idReport = idReport;
	}

	public String getHandler() {
		return handler;
	}

	public void setHandler(String handler) {
		this.handler = handler;
	}

	public Date getIncidentHandlingDate() {
		return incidentHandlingDate;
	}

	public void setIncidentHandlingDate(Date incidentHandlingDate) {
		this.incidentHandlingDate = incidentHandlingDate;
	}

	public String getContentToBeHandled() {
		return contentToBeHandled;
	}

	public void setContentToBeHandled(String contentToBeHandled) {
		this.contentToBeHandled = contentToBeHandled;
	}

	public static int getIdCounter() {
		return idCounter;
	}

	public static void setIdCounter(int idCounter) {
		IncidentHandling.idCounter = idCounter;
	}

	public void displayHandlingInformation() {
        System.out.println("Sự cố: ID=" + idReport + ", Người xử lý=" + handler + ", Ngày xử lý=" + incidentHandlingDate + ", Nội dung=" + contentToBeHandled);
    }
}
=======
 
 import java.util.Date;
 
 public class IncidentHandling {
     private String idReport;
     private String  handler;
     private Date incidentHandlingDate;
     private String contentToBeHandled;
     private static int idCounter = 0;
 
     public IncidentHandling(String idReport, String handler, Date incidentHandlingDate, String contentToBeHandled) {
 		super();
 		this.idReport = idReport;
 		this.handler = handler;
 		this.incidentHandlingDate = incidentHandlingDate;
 		this.contentToBeHandled = contentToBeHandled;
 	}
 
 	public String getIdReport() {
 		return idReport;
 	}
 
 	public void setIdReport(String idReport) {
 		this.idReport = idReport;
 	}
 
 	public String getHandler() {
 		return handler;
 	}
 
 	public void setHandler(String handler) {
 		this.handler = handler;
 	}
 
 	public Date getIncidentHandlingDate() {
 		return incidentHandlingDate;
 	}
 
 	public void setIncidentHandlingDate(Date incidentHandlingDate) {
 		this.incidentHandlingDate = incidentHandlingDate;
 	}
 
 	public String getContentToBeHandled() {
 		return contentToBeHandled;
 	}
 
 	public void setContentToBeHandled(String contentToBeHandled) {
 		this.contentToBeHandled = contentToBeHandled;
 	}
 
 	public static int getIdCounter() {
 		return idCounter;
 	}
 
 	public static void setIdCounter(int idCounter) {
 		IncidentHandling.idCounter = idCounter;
 	}
 
 	public void displayHandlingInformation() {
         System.out.println("Sự cố: ID=" + idReport + ", Người xử lý=" + handler + ", Ngày xử lý=" + incidentHandlingDate + ", Nội dung=" + contentToBeHandled);
     }
 }
>>>>>>> Tinh-nang-dang-nhap
