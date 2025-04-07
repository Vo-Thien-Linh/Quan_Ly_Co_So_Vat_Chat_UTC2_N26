package Model;

 
public class Lecturer extends User {
    private String faculty;
    
    public Lecturer(String fullname, String username, String yearold, String email, String phoneNumber, String password, Status status, Role role, String faculty) {
        super(fullname, username, yearold, email, phoneNumber, password, status, role);
        this.faculty = faculty;
    }

    public String getFaculty() {
		return faculty;
	}
 
 
    
	public void setFaculty(String faculty) {
		this.faculty = faculty;
	}

	public void createBorrowingRoomRequest(BorrowingRoomRequest request) {
        System.out.println("Đơn mượn phòng " + request.getIdRequest() + " đã được tạo bởi giảng viên " + getUsername());
    }

    public void createBorrowingDeviceRequest(BorrowingDeviceRequest request) {
        System.out.println("Đơn mượn thiết bị " + request.getIdRequest() + " đã được tạo bởi giảng viên " + getUsername());
    }

    public void createIncidentReport(IncidentHandling report) {
        System.out.println("Đơn báo cáo sự cố " + report.getIdReport() + " đã được tạo bởi giảng viên " + getUsername());
    }

    public void viewReportSent() {
        System.out.println("Giảng viên " + getUsername() + " đang xem các yêu cầu đã gửi");
    }

	@Override
	public void displayInformationUser() {
		// TODO Auto-generated method stub
		System.out.println("Maintenance Username: " + getUsername());
        System.out.println("Year Old: " + getYearold());
        System.out.println("Email: " + getEmail());
        System.out.println("Phone Number: " + getPhoneNumber());
        System.out.println("Role: " + getRole());
        System.out.println("Password: " + getPassword());
        System.out.println("Khoa: " + faculty);
	}
}