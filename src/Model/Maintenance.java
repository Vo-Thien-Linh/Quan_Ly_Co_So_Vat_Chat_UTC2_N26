package Model;
 
 public class Maintenance extends User{
 	private String department;
 
 	public Maintenance(String fullname, String username, String yearold, String email, String phoneNumber, String password, Status status, Role role, String department) {
 		super(fullname, username, yearold, email, phoneNumber, password, status, role);
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
