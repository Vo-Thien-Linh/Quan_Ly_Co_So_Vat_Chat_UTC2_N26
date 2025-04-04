package Model;

public class Manager extends User {
	private String right; 
	
    public Manager() {}

    public Manager(String right) {
		super();
		this.right = right;
	}

	public void approveBorrowingRoomRequest(BorrowingRoomRequest request) {
        if (request.getRequestStatus().equals("Đã tạo")) {
            request.setRequestStatus("Chấp nhận");
            System.out.println("Đơn mượn phòng " + request.getIdRequest() + " đã được duyệt bởi " + getUsername());
        } else {
            System.out.println("Không thể duyệt yêu cầu " + request.getIdRequest() + " đã tồn tại " + request.getRequestStatus());
        }
    }

    public String getRight() {
		return right;
	}

	public void setRight(String right) {
		this.right = right;
	}

	public void rejectBorrowingRoomRequest(BorrowingRoomRequest request) {
        if (request.getRequestStatus().equals("Đã tạo")) {
            request.setRequestStatus("Từ chối");
            System.out.println("Đơn mượn phòng " + request.getIdRequest() + " đã bị từ chối bởi " + getUsername());
        } else {
            System.out.println("Không thể duyệt yêu cầu " + request.getIdRequest() + " đã tồn tại " + request.getRequestStatus());
        }
    }

    public void approveBorrowingDeviceRequest(BorrowingDeviceRequest request) {
        if (request.getRequestStatus().equals("Đã tạo")) {
            request.setRequestStatus("Chấp nhận");
            System.out.println("Đơn mượn phòng " + request.getIdRequest() + " đã được duyệt bởi " + getUsername());
        } else {
            System.out.println("Không thể duyệt yêu cầu " + request.getIdRequest() + " is already " + request.getRequestStatus());
        }
    }

    public void rejectBorrowingDeviceRequest(BorrowingDeviceRequest request) {
        if (request.getRequestStatus().equals("PENDING")) {
            request.setRequestStatus("REJECTED");
            System.out.println("Đơn mượn phòng " + request.getIdRequest() + " đã bị từ chối bởi " + getUsername());
        } else {
            System.out.println("Không thể duyệt yêu cầu " + request.getIdRequest() + " đã tồn tại " + request.getRequestStatus());
        }
    }

    public void addRoom(Room room) {
        System.out.println("Phòng " + room.getRoomNumber() + " đã được thêm bởi quản lí " + getUsername());
    }

    public void updateRoom(Room room) {
        System.out.println("Phòng " + room.getRoomNumber() + " đã được sửa bởi quản lí " + getUsername());
    }

    public void deleteRoom(Room room) {
        System.out.println("Phòng " + room.getRoomNumber() + " đã được xóa bởi quản lí " + getUsername());
    }

    public void addDevice(Device device) {
        System.out.println("Thiết bị " + device.getDeviceName() + " đã được thêm bởi quản lí " + getUsername());
    }

    public void updateDevice(Device device) {
        System.out.println("Thiết bị " + device.getDeviceName() + " đã được sửa bởi quản lí " + getUsername());
    }

    public void deleteDevice(Device device) {
        System.out.println("Thiết bị " + device.getDeviceName() + " đã được xóa bởi quản lí " + getUsername());
    }

    public void addUser(User user) {
        System.out.println("Người dùng " + user.getUsername() + " đã được thêm bởi quản lí " + getUsername());
    }

    public void updateUser(User user) {
        System.out.println("Người dùng " + user.getUsername() + " đã được sửa bởi quản lí " + getUsername());
    }

    public void deleteUser(User user) {
        System.out.println("Người dùng " + user.getUsername() + " đã được xóa bởi quản lí " + getUsername());
    }

	@Override
	public void displayInformationUser() {
		System.out.println("Maintenance Username: " + getUsername());
        System.out.println("Year Old: " + getYearold());
        System.out.println("Email: " + getEmail());
        System.out.println("Phone Number: " + getPhoneNumber());
        System.out.println("Role: " + getRole());
        System.out.println("Password: " + getPassword());
        System.out.println("Quyền: " + right);
	}
}
 
