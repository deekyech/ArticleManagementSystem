package BasicApp.authentication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

	@Autowired
	UserRepository userRepository;

	public boolean userExists(String username, String email) {
		return !(userRepository.findByUsernameOrEmail(username, email).size() == 0);
	}

	public void addUser(User user) {
		userRepository.save(user);
	}

	public User getUserByEmail(String email) {
		return userRepository.findByEmail(email).get(0);
	}
}
