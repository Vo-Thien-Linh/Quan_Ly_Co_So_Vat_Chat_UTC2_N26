package Model;
<<<<<<< HEAD

public class Room extends Facilities {
    private int numberOfRoom;

    public Room(String status, int numberOfRoom) {
		super(status);
		this.numberOfRoom = numberOfRoom;
	}

	public int getNumberOfRoom() {
		return numberOfRoom;
	}

	public void setNumberOfRoom(int numberOfRoom) {
		this.numberOfRoom = numberOfRoom;
	}

	@Override
	public void displayInformation() {
		System.out.println("Phòng: ID=" + getId() + ", Số phòng=" + numberOfRoom + ", Trạng thái=" + getStatus());
	}

}
=======
 
 public class Room extends Facilities {
     private int numberOfRoom;
 
     public Room(String status, int numberOfRoom) {
 		super(status);
 		this.numberOfRoom = numberOfRoom;
 	}
 
 	public int getNumberOfRoom() {
 		return numberOfRoom;
 	}
 
 	public void setNumberOfRoom(int numberOfRoom) {
 		this.numberOfRoom = numberOfRoom;
 	}
 
 	@Override
 	public void displayInformation() {
 		System.out.println("Phòng: ID=" + getId() + ", Số phòng=" + numberOfRoom + ", Trạng thái=" + getStatus());
 	}
 
 }
>>>>>>> Tinh-nang-dang-nhap
