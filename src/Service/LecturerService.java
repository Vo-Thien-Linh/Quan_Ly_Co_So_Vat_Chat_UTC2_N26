package Service;

import Model.Room;
import Model.Device;
import Model.RoomBorrowRequest;
import Model.DeviceBorrowRequest;
import Model.BorrowingRequestStatus;
import Model.RoomStatus;
import Model.DeviceStatus;
import Model.Session;
import Repository.RoomRepository;
import Repository.DeviceRepository;
import Repository.RoomBorrowRequestRepository;
import Repository.DeviceBorrowRequestRepository;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public class LecturerService {
	private RoomRepository roomRepository;
	private DeviceRepository deviceRepository;
	private RoomBorrowRequestRepository roomBorrowRequestRepository;
	private DeviceBorrowRequestRepository deviceBorrowRequestRepository;

	public LecturerService() throws SQLException {
		this.roomRepository = new RoomRepository();
		this.deviceRepository = new DeviceRepository();
		this.roomBorrowRequestRepository = new RoomBorrowRequestRepository();
		this.deviceBorrowRequestRepository = new DeviceBorrowRequestRepository();
	}

	public boolean borrowRoom(String roomId, Date requestDate, Date dueDate) throws SQLException {
		if (roomId == null || requestDate == null || dueDate == null) {
			throw new IllegalArgumentException("Thông tin mượn phòng không đầy đủ.");
		}
		if (!dueDate.after(requestDate)) {
			throw new IllegalArgumentException("Ngày trả phải sau ngày mượn.");
		}
		if (Session.getUserId() == null) {
			throw new IllegalArgumentException("Không thể xác định người dùng hiện tại. Vui lòng đăng nhập lại.");
		}
		Room room = getRoomById(roomId);
		if (room == null || room.getStatus() != RoomStatus.AVAILABLE) {
			return false;
		}
		// Tạo yêu cầu mượn phòng
		RoomBorrowRequest request = new RoomBorrowRequest();
		request.setLecturerUser(Session.getUserId());
		request.setRoomId(roomId);
		request.setRequestDate(requestDate);
		request.setDueDate(dueDate);
		request.setBorrowingRequest(BorrowingRequestStatus.PENDING);

		// Lưu yêu cầu vào cơ sở dữ liệu bằng phương thức mới với kiểm tra hợp lệ
		roomBorrowRequestRepository.addRequestWithValidation(request);
		return true;
	}

	public boolean borrowDevice(String deviceId, Date requestDate, Date dueDate) throws SQLException {
		if (deviceId == null || requestDate == null || dueDate == null) {
			throw new IllegalArgumentException("Thông tin mượn thiết bị không đầy đủ.");
		}
		if (!dueDate.after(requestDate)) {
			throw new IllegalArgumentException("Ngày trả phải sau ngày mượn.");
		}
		if (Session.getUserId() == null) {
			throw new IllegalArgumentException("Không thể xác định người dùng hiện tại. Vui lòng đăng nhập lại.");
		}
		Device device = deviceRepository.getDeviceById(deviceId);
		if (device == null || device.getStatus() != DeviceStatus.AVAILABLE || device.getQuantity() <= 0) {
			return false;
		}
		DeviceBorrowRequest request = new DeviceBorrowRequest();
		request.setLecturerUser(Session.getUserId());
		request.setDeviceId(deviceId);
		request.setRequestDate(requestDate);
		request.setDueDate(dueDate);
		request.setBorrowingRequest(BorrowingRequestStatus.PENDING);

		deviceBorrowRequestRepository.addRequest(request);
		return true;
	}

	private Room getRoomById(String roomId) throws SQLException {
		for (Room room : roomRepository.getAllRooms()) {
			if (room.getId().equals(roomId)) {
				return room;
			}
		}
		return null;
	}

	public List<Room> getAllRooms() throws SQLException {
		return roomRepository.getAllRooms();
	}
}