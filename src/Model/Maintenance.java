package Model;
<<<<<<< HEAD

public class Maintenance extends User{
	private String department;

	public Maintenance(String username, int yearold, String email, String phoneNumber, String password, Role role, String department) {
		super(username, yearold, email, phoneNumber, password, role);
		this.department = department;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}
	
	public void createIncidentReport() {
        System.out.println("Nhân viên bảo trì " + getUsername() + " lập báo cáo bảo trì.");
    }
	
	//ccc
//    public void updateIncidentHandling() {
//        System.out.println("Nhân viên bảo trì " + getUsername() + " cập nhật xử lý sự cố.");
//    }

    public void incidentHandling() {
        System.out.println("Nhân viên bảo trì " + getUsername() + " xử lý sự cố.");
    }

    
	@Override
	public void displayInformationUser() {
		 System.out.println("Nhân viên bảo trì: Tên=" + getUsername() + ", Bộ phận=" + department);
	}
	
}
=======
 
 public class Maintenance extends User{
 	private String department;
 
 	public Maintenance(String username, String yearold, String email, String phoneNumber, String password, Role role, String department) {
 		super(username, yearold, email, phoneNumber, password, role);
 		this.department = department;
 	}
 
 	public String getDepartment() {
 		return department;
 	}
 
 	public void setDepartment(String department) {
 		this.department = department;
 	}
 	
 	public void createIncidentReport() {
         System.out.println("Nhân viên bảo trì " + getUsername() + " lập báo cáo bảo trì.");
     }
 	
 	//ccc
 //    public void updateIncidentHandling() {
 //        System.out.println("Nhân viên bảo trì " + getUsername() + " cập nhật xử lý sự cố.");
 //    }
 
     public void incidentHandling() {
         System.out.println("Nhân viên bảo trì " + getUsername() + " xử lý sự cố.");
     }
 
     
 	@Override
 	public void displayInformationUser() {
 		 System.out.println("Nhân viên bảo trì: Tên=" + getUsername() + ", Bộ phận=" + department);
 	}
 	
 }
>>>>>>> Tinh-nang-dang-nhap
