package BasicApp.authentication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticationController {

	@Autowired
	AuthenticationService authenticationService;

	@RequestMapping("/userDataExists/{username}/{email}")
	public boolean userExists(@PathVariable String username, @PathVariable String email) {
		return authenticationService.userExists(username, email);
	}

	@RequestMapping("/getUserByEmail/{email}")
	public User getUserByEmail(@PathVariable String email) {
		return authenticationService.getUserByEmail(email);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/addUser")
	public void addUser(User user) {
		authenticationService.addUser(user);
	}
}
