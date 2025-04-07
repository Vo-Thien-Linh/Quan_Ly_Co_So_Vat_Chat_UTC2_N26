package Model;

public class Admin extends User {
	private String userId;
	
    public Admin(String fullname, String username, String yearold, String email, String phoneNumber, String password, Status status, Role role) {
        super(fullname, username, yearold, email, phoneNumber, password, status, role);
    }
    
    

	@Override
	public void displayInformationUser() {
		
	}
}