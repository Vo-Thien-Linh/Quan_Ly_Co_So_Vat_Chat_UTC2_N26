package Model;
    
public class Manager extends User {
     private String userId;
 
     public Manager(String fullname, String username, String yearold, String email, String phoneNumber, String password, Status status, Role role,
 			String userId) {
 		super(fullname, username, yearold, email, phoneNumber, password, status, role);
 		this.userId = userId;
 	}
     
 	public String getUserId() {
 		return userId;
 	}
 
 	public void setUserId(String userId) {
 		this.userId = userId;
 	}
 
 	public void addInformation(Facilities facilities) {
         System.out.println("Quản lý " + getUsername() + " thêm vật chất: " + facilities.getId());
     }
 
     public void deleteInformation(Facilities facilities) {
         System.out.println("Quản lý " + getUsername() + " xóa vật chất: " + facilities.getId());
     }
 
     public void statusInformation() {
         System.out.println("Quản lý " + getUsername() + " xem thông tin trạng thái.");
     }
 
     public void findInformation() {
         System.out.println("Quản lý " + getUsername() + " tìm kiếm thông tin.");
     }
 
     public void updateStatus(Facilities facilities, String status) {
         facilities.setStatus(status);
         System.out.println("Quản lý " + getUsername() + " cập nhật trạng thái vật chất " + facilities.getId() + " thành " + status);
     }
 
 	@Override
 	public void displayInformationUser() {
 		 System.out.println("Quản lý: Tên=" + getUsername() + ", Quyền hạn=" + userId);
 	}
 }
