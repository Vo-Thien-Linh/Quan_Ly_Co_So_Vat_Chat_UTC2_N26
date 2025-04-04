package Model;

public class Device extends Facilities {
    private String deviceName;
    private int quantity;

    public Device() {}

    public Device(String id, String status, String deviceName, int quantity) {
        super(id, status);
        this.deviceName = deviceName;
        this.quantity = quantity;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

	@Override
	public void informationDisplay() {
		System.out.println("Device ID: " + getId());
        System.out.println("Status: " + getStatus());
        System.out.println("Device Name: " + deviceName);
        System.out.println("Quantity: " + quantity);
        System.out.println("Room Number: " + deviceName);
	}
     
 }
