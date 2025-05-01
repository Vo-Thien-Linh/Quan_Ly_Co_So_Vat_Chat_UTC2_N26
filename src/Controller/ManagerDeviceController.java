package Controller;

import Repository.DeviceBorrowRequestRepository;
import Repository.DeviceRepository;
import Repository.RoomRepository;
import Model.Device;
import Model.Room;
import Model.DeviceBorrowRequest;
import Model.BorrowingRequestStatus;

import java.sql.SQLException;
import java.util.List;

public class ManagerDeviceController {
    private DeviceRepository deviceRepository;
    private RoomRepository roomRepository;
    private DeviceBorrowRequestRepository deviceRequestRepository;

    public ManagerDeviceController() {
        this.deviceRepository = new DeviceRepository();
        this.roomRepository = new RoomRepository();
        this.deviceRequestRepository = new DeviceBorrowRequestRepository();
    }

    public List<Room> getAllRooms() throws SQLException {
        return roomRepository.getAllRooms();
    }

    public List<Device> getAllDevices() {
        return deviceRepository.getAllDevices();
    }

    public Boolean addDeviceAndReturnId(Device device) {
        return deviceRepository.addDeviceAndReturnId(device);
    }

    public Boolean edit(Device device) {
        return deviceRepository.edit(device);
    }

    public Boolean delete(String deviceId) {
        return deviceRepository.delete(deviceId);
    }

    public List<DeviceBorrowRequest> getPendingDeviceRequests() throws SQLException {
        return deviceRequestRepository.getPendingRequests();
    }

    public List<DeviceBorrowRequest> getAllDeviceRequests() throws SQLException {
        return deviceRequestRepository.getAllRequests();
    }

    public boolean updateDeviceRequestStatus(String idRequest, BorrowingRequestStatus status) throws SQLException {
        return deviceRequestRepository.updateRequestStatus(idRequest, status);
    }

    public String getDeviceNameById(String deviceId) {
        Device device = deviceRepository.getDeviceById(deviceId);
        return device != null ? device.getDeviceName() : deviceId;
    }
}