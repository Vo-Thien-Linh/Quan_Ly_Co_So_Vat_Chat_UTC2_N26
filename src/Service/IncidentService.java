package Service;

import Model.Incident;
import Repository.IncidentRepository;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public class IncidentService {
    private IncidentRepository incidentRepository;

    public IncidentService() {
        this.incidentRepository = new IncidentRepository();
    }

    public void reportIncident(String reportedBy, String deviceId, String roomId, String description) throws SQLException {
        if ((deviceId == null || deviceId.isEmpty()) && (roomId == null || roomId.isEmpty())) {
            throw new IllegalArgumentException("Phải cung cấp ít nhất ID phòng hoặc ID thiết bị.");
        }
        if (description == null || description.isEmpty()) {
            throw new IllegalArgumentException("Ghi chú không được để trống.");
        }

        Incident incident = new Incident(null, reportedBy, deviceId, roomId, description, new Date(), null, "PENDING");
        incidentRepository.createIncident(incident);
    }

    public List<Incident> searchByDeviceId(String deviceId) throws SQLException {
        return incidentRepository.findByDeviceId(deviceId);
    }

    public List<Incident> searchByRoomId(String roomId) throws SQLException {
        return incidentRepository.findByRoomId(roomId);
    }

    public List<Incident> getAllIncidents() throws SQLException {
        return incidentRepository.getAllIncidents();
    }

    public void handleIncident(String deviceId, String roomId, String handlingNote, String handledBy, String status) throws SQLException {
        if ((deviceId == null || deviceId.isEmpty()) && (roomId == null || roomId.isEmpty())) {
            throw new IllegalArgumentException("Phải cung cấp ít nhất ID phòng hoặc ID thiết bị.");
        }
        if (handlingNote == null || handlingNote.isEmpty()) {
            throw new IllegalArgumentException("Ghi chú xử lý không được để trống.");
        }

        List<Incident> incidents;
        if (deviceId != null && !deviceId.isEmpty()) {
            incidents = incidentRepository.findByDeviceId(deviceId);
        } else {
            incidents = incidentRepository.findByRoomId(roomId);
        }

        if (incidents.isEmpty()) {
            throw new SQLException("Không tìm thấy sự cố với ID phòng/thiết bị: " + (deviceId != null ? deviceId : roomId));
        }

        // Cập nhật sự cố đầu tiên tìm thấy, thay thế ghi chú cũ bằng ghi chú mới
        Incident incident = incidents.get(0);
        String newDescription = handlingNote; // Thay thế hoàn toàn ghi chú cũ
        incidentRepository.updateIncidentHandling(incident.getIdReport(), newDescription, handledBy, status);
    }
}