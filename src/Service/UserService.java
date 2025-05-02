package Service;

import Model.User;
import Repository.UserRepository;
import utils.PasswordEncryptionUtils;
import utils.PasswordGeneratorUtils;
import utils.ScannerUtils;

public class UserService {
	private UserRepository userRepository = new UserRepository();

	public String login(String username, String password) {
		String[] user = userRepository.getUserByUsername(username);
		if (user == null) {
			return "NOTEXIST";
		}

		if (user[1].equals("INACTIVE")) {
			return "INACTIVE";
		} else if (user[1].equals("MAINTENANCE")) {
			return "MAINTENANCE";
		}

		if (!user[0].equals(PasswordEncryptionUtils.hashPassword(password))) {
			return "UNSUCCESS";
		}

		return "SUCCESS";
	}

}
