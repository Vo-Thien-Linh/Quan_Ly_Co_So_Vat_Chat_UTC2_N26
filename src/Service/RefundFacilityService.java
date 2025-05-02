package Service;

import Model.BorrowingRequestStatus;
import Model.DeviceBorrowRequest;
import Model.RoomBorrowRequest;
import Repository.DeviceBorrowRequestRepository;
import Repository.RoomBorrowRequestRepository;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RefundFacilityService {
    private DeviceBorrowRequestRepository deviceRequestRepository;
    private RoomBorrowRequestRepository roomRequestRepository;

    public RefundFacilityService() {
        this.deviceRequestRepository = new DeviceBorrowRequestRepository();
        this.roomRequestRepository = new RoomBorrowRequestRepository();
    }

    public void refundFacility(String idRequest, String userId) throws SQLException {
        // Kiểm tra xem đơn mượn có tồn tại và thuộc về user không
        List<DeviceBorrowRequest> deviceRequests = deviceRequestRepository.getRequestsByUser(userId);
        List<RoomBorrowRequest> roomRequests = roomRequestRepository.getRequestsByUser(userId);
        
        // Kiểm tra đơn mượn thiết bị
        DeviceBorrowRequest targetDeviceRequest = null;
        for (DeviceBorrowRequest request : deviceRequests) {
            if (request.getIdRequest().equals(idRequest)) {
                targetDeviceRequest = request;
                break;
            }
        }

        // Kiểm tra đơn mượn phòng
        RoomBorrowRequest targetRoomRequest = null;
        for (RoomBorrowRequest request : roomRequests) {
            if (request.getIdRequest().equals(idRequest)) {
                targetRoomRequest = request;
                break;
            }
        }

        if (targetDeviceRequest == null && targetRoomRequest == null) {
            throw new SQLException("Không tìm thấy đơn mượn với ID: " + idRequest);
        }

        if (targetDeviceRequest != null) {
            if (targetDeviceRequest.getBorrowingRequest() != BorrowingRequestStatus.APPROVED) {
                throw new SQLException("Đơn mượn thiết bị không ở trạng thái APPROVED để có thể trả.");
            }
            deviceRequestRepository.updateRequestStatus(idRequest, BorrowingRequestStatus.COMPLETED);
        } else {
            if (targetRoomRequest.getBorrowingRequest() != BorrowingRequestStatus.APPROVED) {
                throw new SQLException("Đơn mượn phòng không ở trạng thái APPROVED để có thể trả.");
            }
            roomRequestRepository.updateRequestStatus(idRequest, BorrowingRequestStatus.RETURNED);
        }
    }

    public List<DeviceBorrowRequest> searchDeviceByRequestId(String idRequest) throws SQLException {
        return deviceRequestRepository.findByRequestId(idRequest);
    }

    public List<RoomBorrowRequest> searchRoomByRequestId(String idRequest) throws SQLException {
        return roomRequestRepository.findByRequestId(idRequest);
    }

    public List<Object> getAllRequestsByUser(String userId) throws SQLException {
        List<Object> allRequests = new ArrayList<>();
        // Lấy đơn mượn thiết bị
        List<DeviceBorrowRequest> deviceRequests = deviceRequestRepository.getRequestsByUser(userId);
        allRequests.addAll(deviceRequests);
        // Lấy đơn mượn phòng
        List<RoomBorrowRequest> roomRequests = roomRequestRepository.getRequestsByUser(userId);
        allRequests.addAll(roomRequests);
        return allRequests;
    }
}