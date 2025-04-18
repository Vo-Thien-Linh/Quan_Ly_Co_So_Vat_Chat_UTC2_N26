package Model;

import java.time.LocalDate;

public class Room extends Facilities {
	private String roomNumber;
    private int seatingCapacity;
    private RoomStatus status;
    
    public Room(String id, String roomNumber) {
    	super(id, null, null);
    	this.roomNumber = roomNumber;
    }
    
    public Room(String id, int seatingCapacity, RoomStatus status) {
    	super(id, null, null);
        this.seatingCapacity = seatingCapacity;
        this.status = status;
    }
    
    public String getRoomNumber() {
    	return roomNumber;
    }

    public int getSeatingCapacity() {
        return seatingCapacity;
    }

    public void setSeatingCapacity(int seatingCapacity) {
        this.seatingCapacity = seatingCapacity;
    }
    
    @Override
    public String toString() {
		return this.roomNumber;
	}

	@Override
    public void informationDisplay() {
        System.out.println("Room ID: " + getId());
        System.out.println("Status: " + status);
        System.out.println("Room Number: " + roomNumber);
        System.out.println("Seating Capacity: " + seatingCapacity);
    }
 
 }
