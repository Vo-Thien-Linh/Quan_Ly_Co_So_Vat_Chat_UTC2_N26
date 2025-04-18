package Controller;

import java.util.ArrayList;
import java.util.List;

import Model.Device;
import Model.Facilities;
import Model.Room;
import Repository.ManagerDeviceRepository;
import Repository.ManagerUserRepository;

public class ManagerDeviceController {
	private ManagerDeviceRepository managerDeviceRepository;
	
	public ArrayList<Room> getAllRooms() {
		managerDeviceRepository = new ManagerDeviceRepository();
		return managerDeviceRepository.getAllRooms();
	}
	
	public boolean addDeviceAndReturnId(Device device) {
		managerDeviceRepository = new ManagerDeviceRepository();
		return managerDeviceRepository.addDeviceAndReturnId(device);
	}
	
	public List<Device> getAllDevices() {
		managerDeviceRepository = new ManagerDeviceRepository();
		return managerDeviceRepository.getAllDevices();
	}
	
	public boolean edit(Device device) {
		managerDeviceRepository = new ManagerDeviceRepository();
		return managerDeviceRepository.edit(device);
	}
	
	public boolean delete(String deviceId) {
		managerDeviceRepository = new ManagerDeviceRepository();
		return managerDeviceRepository.delete(deviceId);
	}
}
