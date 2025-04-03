package Model;

public class Admin extends User {
    public Admin(String username, String yearold, String email, String phoneNumber, String password, Role role) {
        super(username, yearold, email, phoneNumber, password, role);
    }

	@Override
	public void displayInformationUser() {
		
	}
}