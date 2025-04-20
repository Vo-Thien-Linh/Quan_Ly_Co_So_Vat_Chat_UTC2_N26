package Model;

public class Device extends Facilities {
    private String deviceName;
    private int quantity;
    private String roomNumber;

    public Device() {
        super();
    }

    public Device(String deviceName, int quantity, String roomNumber) {
        super();
        this.deviceName = deviceName;
        this.quantity = quantity;
        this.roomNumber = roomNumber;
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

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    @Override
    public void informationDisplay() {
        System.out.println("Device ID: " + getId());
        System.out.println("Status: " + getStatus());
        System.out.println("Device Name: " + deviceName);
        System.out.println("Quantity: " + quantity);
        System.out.println("Room Number: " + roomNumber);
    }
}