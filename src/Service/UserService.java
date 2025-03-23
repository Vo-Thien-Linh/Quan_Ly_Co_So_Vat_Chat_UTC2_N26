package Service;

import Dao.UserDAO;
import Model.User;

public class UserService {
    private UserDAO userDAO = new UserDAO();

    public boolean login(String username, String password) {
        User user = userDAO.getUserByUsername(username);
        return user != null && user.getPassword().equals(password);
    }
}
