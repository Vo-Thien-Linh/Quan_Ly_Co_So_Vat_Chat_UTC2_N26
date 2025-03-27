package Model;

import java.sql.Date;

public class BorrowingRequest {
	private String idForm;
    private String idRoom;
    private String borrower;
    private Date borrowingDate;
    private Date returnDate;
    private String Status;
    private static int idCounter = 0;

    public BorrowingRequest(String idForm, String idRoom, String borrower, Date borrowingDate, Date returnDate,
			String status) {
		super();
		this.idForm = idForm;
		this.idRoom = idRoom;
		this.borrower = borrower;
		this.borrowingDate = borrowingDate;
		this.returnDate = returnDate;
		Status = status;
	}

    public String getIdForm() {
		return idForm;
	}

	public void setIdForm(String idForm) {
		this.idForm = idForm;
	}

	public String getIdRoom() {
		return idRoom;
	}

	public void setIdRoom(String idRoom) {
		this.idRoom = idRoom;
	}

	public String getBorrower() {
		return borrower;
	}

	public void setBorrower(String borrower) {
		this.borrower = borrower;
	}

	public Date getBorrowingDate() {
		return borrowingDate;
	}

	public void setBorrowingDate(Date borrowingDate) {
		this.borrowingDate = borrowingDate;
	}

	public Date getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}

	public String getStatus() {
		return Status;
	}

	public void setStatus(String status) {
		Status = status;
	}

	public static int getIdCounter() {
		return idCounter;
	}

	public static void setIdCounter(int idCounter) {
		BorrowingRequest.idCounter = idCounter;
	}

	public void taoDon() {
        System.out.println("Đơn mượn phòng được tạo: ID=" + idForm + ", Phòng=" + idRoom + ", Người mượn=" + borrower);
    }
}
