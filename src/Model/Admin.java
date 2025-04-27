package Model;

public class Admin extends User {
	
    public Admin(String fullname, String username, String thumbnail, String yearold, String email, String phoneNumber, String password, Status status, Role role) {
        super(fullname, username, thumbnail, yearold, email, phoneNumber, password, status, role);
    }
    
    

	@Override
	public void displayInformationUser() {
		
	}
}