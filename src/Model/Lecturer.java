package Model;
<<<<<<< HEAD

public class Lecturer extends User {
    private String Faculty;

    public Lecturer(String username, int yearold, String email, String phoneNumber, String password, Role role,
			String faculty) {
		super(username, yearold, email, phoneNumber, password, role);
		Faculty = faculty;
	}

	public void createBorrowingRequest(BorrowingRequest don) {
        System.out.println("Giảng viên " + getUsername() + " tạo đơn mượn phòng: " + don.getIdForm());
    }

    public void viewCheckRoom(BorrowingRequest don) {
        System.out.println("Giảng viên " + getUsername() + " xem nhận/trả phòng: " + don.getIdForm());
    }

    public void incidentReport(String phong, String thietBi, String noiDung) {
        System.out.println("Giảng viên " + getUsername() + " báo cáo sự cố: Phòng=" + phong + ", Thiết bị=" + thietBi + ", Nội dung=" + noiDung);
    }

    public void cancelRoomBorrowingRequest(BorrowingRequest don) {
        don.setStatus("Bị hủy");
        System.out.println("Giảng viên " + getUsername() + " hủy đơn mượn phòng: " + don.getIdForm());
    }

	@Override
	public void displayInformationUser() {
		System.out.println("Giảng viên: Tên=" + getUsername() + ", Khoa=" + Faculty);
	}

   
}
=======
 
 public class Lecturer extends User {
     private String Faculty;
 
     public Lecturer(String username, String yearold, String email, String phoneNumber, String password, Role role,
 			String faculty) {
 		super(username, yearold, email, phoneNumber, password, role);
 		Faculty = faculty;
 	}
 
 	public void createBorrowingRequest(BorrowingRequest don) {
         System.out.println("Giảng viên " + getUsername() + " tạo đơn mượn phòng: " + don.getIdForm());
     }
 
     public void viewCheckRoom(BorrowingRequest don) {
         System.out.println("Giảng viên " + getUsername() + " xem nhận/trả phòng: " + don.getIdForm());
     }
 
     public void incidentReport(String phong, String thietBi, String noiDung) {
         System.out.println("Giảng viên " + getUsername() + " báo cáo sự cố: Phòng=" + phong + ", Thiết bị=" + thietBi + ", Nội dung=" + noiDung);
     }
 
     public void cancelRoomBorrowingRequest(BorrowingRequest don) {
         don.setStatus("Bị hủy");
         System.out.println("Giảng viên " + getUsername() + " hủy đơn mượn phòng: " + don.getIdForm());
     }
 
 	@Override
 	public void displayInformationUser() {
 		System.out.println("Giảng viên: Tên=" + getUsername() + ", Khoa=" + Faculty);
 	}
 
    
 }
>>>>>>> Tinh-nang-dang-nhap
