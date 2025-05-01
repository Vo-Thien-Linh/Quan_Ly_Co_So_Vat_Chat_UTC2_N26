package Controller;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import Model.Device;
import Model.Facilities;
import Model.Room;
import Model.User;
import Repository.ManagerDeviceRepository;
import Repository.ManagerUserRepository;
import utils.ScannerUtils;

public class ManagerDeviceController {
	private ManagerDeviceRepository managerDeviceRepository = new ManagerDeviceRepository();;
	
	public ArrayList<Room> getAllRooms() {
		return managerDeviceRepository.getAllRooms();
	}
	
	public boolean addDeviceAndReturnId(Device device) {
		return managerDeviceRepository.addDeviceAndReturnId(device);
	}
	
	public List<Device> getAllDevices() {
		return managerDeviceRepository.getAllDevices();
	}
	
	public boolean edit(Device device, JFrame currentFrame) {
		int choice = ScannerUtils.showConfirmMessage(currentFrame, "Bạn có chắc chắn muốn sửa không?");
		if(choice == JOptionPane.YES_NO_OPTION) {
			Boolean editSuccess = managerDeviceRepository.edit(device);
	    	return editSuccess;
		}
		
		return false;
	}
	
	public boolean delete(String deviceId, JFrame currentFrame) {
		int choice = ScannerUtils.showConfirmMessage(currentFrame, "Bạn có chắc chắn muốn xóa không?");
		if(choice == JOptionPane.YES_NO_OPTION) {
			Boolean deleteSuccess = managerDeviceRepository.delete(deviceId);
	    	return deleteSuccess;
		}
		
		return false;
	}
	
	public List<Device> searchDevices(String[] keyword) {
		return managerDeviceRepository.searchUsers(keyword);
	}
}
