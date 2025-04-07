package Model;

public class Room extends Facilities {
    private String roomNumber;
    private int seatingCapacity;

    public Room() {}

    public Room(String id, String status, String roomNumber, int seatingCapacity) {
        super(id, status);
        this.roomNumber = roomNumber;
        this.seatingCapacity = seatingCapacity;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public int getSeatingCapacity() {
        return seatingCapacity;
    }

    public void setSeatingCapacity(int seatingCapacity) {
        this.seatingCapacity = seatingCapacity;
    }

	@Override
    public void informationDisplay() {
        System.out.println("Room ID: " + getId());
        System.out.println("Status: " + getStatus());
        System.out.println("Room Number: " + roomNumber);
        System.out.println("Seating Capacity: " + seatingCapacity);
    }
 
 }
