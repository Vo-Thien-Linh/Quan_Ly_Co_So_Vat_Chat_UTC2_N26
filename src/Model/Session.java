package Model;

public class Session {
    public static String userId;
    public static String role; 

    public static void setUserId(String id) {
        userId = id;
    }

    public static String getUserId() {
        return userId;
    }

    public static void setRole(String userRole) {
        role = userRole;
    }

    public static String getRole() {
        return role;
    }

    // Clear session
    public static void clear() {
        userId = null;
        role = null; 
    }
}
