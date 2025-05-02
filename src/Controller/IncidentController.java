package Controller;

import Model.Incident;
import Service.IncidentService;

import java.sql.SQLException;
import java.util.List;

public class IncidentController {
    private IncidentService incidentService;

    public IncidentController() {
        this.incidentService = new IncidentService();
    }

    public void reportIncident(String reportedBy, String deviceId, String roomId, String description) throws SQLException {
        incidentService.reportIncident(reportedBy, deviceId, roomId, description);
    }

    public List<Incident> searchByDeviceId(String deviceId) throws SQLException {
        return incidentService.searchByDeviceId(deviceId);
    }

    public List<Incident> searchByRoomId(String roomId) throws SQLException {
        return incidentService.searchByRoomId(roomId);
    }

    public List<Incident> getAllIncidents() throws SQLException {
        return incidentService.getAllIncidents();
    }

    public void handleIncident(String deviceId, String roomId, String handlingNote, String handledBy, String status) throws SQLException {
        incidentService.handleIncident(deviceId, roomId, handlingNote, handledBy, status);
    }
}