package Model;
 
 public class Device extends Facilities {
     private String nameOfDevice;
 
 	public Device(String status, String nameOfDevice) {
 		super(status);
 		this.nameOfDevice = nameOfDevice;
 	}
 
 	public String getNameOfDevice() {
 		return nameOfDevice;
 	}
 
 	public void setNameOfDevice(String nameOfDevice) {
 		this.nameOfDevice = nameOfDevice;
 	}
 
 	@Override
 	public void displayInformation() {
 		System.out.println("Thiết bị: ID=" + getId() + ", Tên=" + nameOfDevice + ", Trạng thái=" + getStatus());
 	}
 
     
 }
