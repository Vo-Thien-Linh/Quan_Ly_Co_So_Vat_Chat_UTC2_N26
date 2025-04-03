package Service;

import Model.User;
<<<<<<< HEAD
import Dao.UserDAO;
=======
import Repository.UserRepository;
>>>>>>> Tinh-nang-dang-nhap

public class UserService {
    private UserRepository userDAO = new UserRepository();

    public boolean login(String username, String password) {
        User user = userDAO.getUserByUsername(username);
        return user != null && user.getPassword().equals(password);
    }
    
    public boolean isUsernameExists(String username) {
        return userDAO.checkUsernameExists(username);
    }

    public boolean isEmailExists(String email) {
        return userDAO.checkEmailExists(email);
    }
    

    public boolean isNumberPhoneExists(String numberPhone) {
        return userDAO.checkNumberPhoneExists(numberPhone);
    }

    public boolean registerUser(User user) {
        return userDAO.registerUser(user);
    }
}
