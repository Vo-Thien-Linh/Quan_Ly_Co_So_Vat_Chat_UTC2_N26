package Model;

public class Maintenance extends User {
    private String department;

    public Maintenance(String fullname, String username, String yearold, String email, String phoneNumber, String password, Status status, Role role, String department) {
        super(fullname, username, yearold, email, phoneNumber, password, status, role);
        this.department = department;
    }

    public void createIncidentReport(IncidentHandling incident) {
        System.out.println("Maintenance " + getUsername() + " created incident report " + incident.getIdReport());
    }

    public void incidentHandling(IncidentHandling incident) {
        System.out.println("Incident has been handled by Maintenance " + getUsername());
        incident.setHandledBy(this);
    }

 	@Override
 	public void displayInformationUser() {
 		System.out.println("Maintenance Username: " + getUsername());
        System.out.println("Year Old: " + getYearold());
        System.out.println("Email: " + getEmail());
        System.out.println("Phone Number: " + getPhoneNumber());
        System.out.println("Role: " + getRole());
        System.out.println("Password: " + getPassword());
        System.out.println("BoPHAN: " + department);
 	}
 }
