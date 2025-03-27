package Model;

public class Manager extends User {
    private String right;

    public Manager(String username, int yearold, String email, String phoneNumber, String password, Role role,
			String right) {
		super(username, yearold, email, phoneNumber, password, role);
		this.right = right;
	}
    
	public String getRight() {
		return right;
	}

	public void setRight(String right) {
		this.right = right;
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

    public void approveBorrowingRequest(BorrowingRequest don) {
        don.setStatus("Được duyệt");
        System.out.println("Quản lý " + getUsername() + " duyệt đơn mượn phòng: " + don.getIdForm());
    }

	@Override
	public void displayInformationUser() {
		 System.out.println("Quản lý: Tên=" + getUsername() + ", Quyền hạn=" + right);
	}
}