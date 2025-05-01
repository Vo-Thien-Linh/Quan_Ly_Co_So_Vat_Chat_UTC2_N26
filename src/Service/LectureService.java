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

public class LectureService {
    private RoomRepository roomRepository;
    private DeviceRepository deviceRepository;
    private RoomBorrowRequestRepository roomBorrowRequestRepository;
    private DeviceBorrowRequestRepository deviceBorrowRequestRepository;

    /**
     * Khởi tạo LectureService và các repository cần thiết.
     * @throws SQLException nếu có lỗi khi khởi tạo kết nối database.
     */
    public LectureService() throws SQLException {
        this.roomRepository = new RoomRepository();
        this.deviceRepository = new DeviceRepository();
        this.roomBorrowRequestRepository = new RoomBorrowRequestRepository();
        this.deviceBorrowRequestRepository = new DeviceBorrowRequestRepository();
    }

    /**
     * Tạo yêu cầu mượn phòng cho giảng viên.
     * @param roomId ID của phòng cần mượn.
     * @param requestDate Ngày mượn phòng.
     * @param dueDate Ngày trả phòng.
     * @return true nếu tạo yêu cầu thành công, false nếu phòng không tồn tại hoặc không sẵn sàng.
     * @throws SQLException nếu có lỗi khi truy vấn cơ sở dữ liệu.
     * @throws IllegalArgumentException nếu thông tin đầu vào không hợp lệ.
     */
    public boolean borrowRoom(String roomId, Date requestDate, Date dueDate) throws SQLException {
        // Kiểm tra thông tin đầu vào
        if (roomId == null || requestDate == null || dueDate == null) {
            throw new IllegalArgumentException("Thông tin mượn phòng không đầy đủ.");
        }

        // Kiểm tra ngày trả có sau ngày mượn không
        if (!dueDate.after(requestDate)) {
            throw new IllegalArgumentException("Ngày trả phải sau ngày mượn.");
        }

        // Kiểm tra Session.getUserId() không null
        if (Session.getUserId() == null) {
            throw new IllegalArgumentException("Không thể xác định người dùng hiện tại. Vui lòng đăng nhập lại.");
        }

        // Kiểm tra phòng có tồn tại và trạng thái có sẵn không
        Room room = getRoomById(roomId);
        if (room == null || room.getStatus() != RoomStatus.AVAILABLE) {
            return false; // Phòng không tồn tại hoặc không sẵn sàng
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

    /**
     * Tạo yêu cầu mượn thiết bị cho giảng viên.
     * @param deviceId ID của thiết bị cần mượn.
     * @param requestDate Ngày mượn thiết bị.
     * @param dueDate Ngày trả thiết bị.
     * @return true nếu tạo yêu cầu thành công, false nếu thiết bị không tồn tại, không sẵn sàng hoặc hết số lượng.
     * @throws SQLException nếu có lỗi khi truy vấn cơ sở dữ liệu.
     * @throws IllegalArgumentException nếu thông tin đầu vào không hợp lệ.
     */
    public boolean borrowDevice(String deviceId, Date requestDate, Date dueDate) throws SQLException {
        // Kiểm tra thông tin đầu vào
        if (deviceId == null || requestDate == null || dueDate == null) {
            throw new IllegalArgumentException("Thông tin mượn thiết bị không đầy đủ.");
        }

        // Kiểm tra ngày trả có sau ngày mượn không
        if (!dueDate.after(requestDate)) {
            throw new IllegalArgumentException("Ngày trả phải sau ngày mượn.");
        }

        // Kiểm tra Session.getUserId() không null
        if (Session.getUserId() == null) {
            throw new IllegalArgumentException("Không thể xác định người dùng hiện tại. Vui lòng đăng nhập lại.");
        }

        // Kiểm tra thiết bị có tồn tại và trạng thái có sẵn không
        Device device = deviceRepository.getDeviceById(deviceId);
        if (device == null || device.getStatus() != DeviceStatus.AVAILABLE || device.getQuantity() <= 0) {
            return false; // Thiết bị không tồn tại, không sẵn sàng hoặc hết số lượng
        }

        // Tạo yêu cầu mượn thiết bị
        DeviceBorrowRequest request = new DeviceBorrowRequest();
        request.setLecturerUser(Session.getUserId());
        request.setDeviceId(deviceId);
        request.setRequestDate(requestDate);
        request.setDueDate(dueDate);
        request.setBorrowingRequest(BorrowingRequestStatus.PENDING);

        // Lưu yêu cầu vào cơ sở dữ liệu
        deviceBorrowRequestRepository.addRequest(request);
        return true;
    }

    /**
     * Tìm phòng theo ID từ danh sách phòng.
     * @param roomId ID của phòng cần tìm.
     * @return đối tượng Room nếu tìm thấy, null nếu không tìm thấy.
     * @throws SQLException nếu có lỗi khi truy vấn cơ sở dữ liệu.
     */
    private Room getRoomById(String roomId) throws SQLException {
        for (Room room : roomRepository.getAllRooms()) {
            if (room.getId().equals(roomId)) {
                return room;
            }
        }
        return null;
    }

    /**
     * Lấy danh sách tất cả các phòng.
     * @return danh sách các phòng.
     * @throws SQLException nếu có lỗi khi truy vấn cơ sở dữ liệu.
     */
    public List<Room> getAllRooms() throws SQLException {
        return roomRepository.getAllRooms();
    }
}