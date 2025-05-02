package Controller;

import Model.DeviceBorrowRequest;
import Model.RoomBorrowRequest;
import Service.RefundFacilityService;

import java.sql.SQLException;
import java.util.List;

public class RefundFacilityController {
    private RefundFacilityService refundService;

    public RefundFacilityController() {
        this.refundService = new RefundFacilityService();
    }

    public void refundFacility(String idRequest, String userId) throws SQLException {
        refundService.refundFacility(idRequest, userId);
    }

    public List<DeviceBorrowRequest> searchDeviceByRequestId(String idRequest) throws SQLException {
        return refundService.searchDeviceByRequestId(idRequest);
    }

    public List<RoomBorrowRequest> searchRoomByRequestId(String idRequest) throws SQLException {
        return refundService.searchRoomByRequestId(idRequest);
    }

    public List<Object> getRequestsByUser(String userId) throws SQLException {
        return refundService.getAllRequestsByUser(userId);
    }
}