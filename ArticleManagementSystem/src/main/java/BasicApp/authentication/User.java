package BasicApp.authentication;

import org.springframework.beans.factory.annotation.Value;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer user_id;
	private String username;
	private String email;
	private String password;

	@Column(name = "role")
	private Integer role = 2;

	public User() {}

	private User(Integer user_id, String username, String email, String password, Integer role) {
		this.user_id = user_id;
		this.username = username;
		this.email = email;
		this.password = password;
		this.role = role;
	}

	public User(Integer user_id, String username, String email, String password) {
		this(user_id, username, email, password, UserConstants.USER_ROLE);
	}

	public Integer getUser_id() {
		return user_id;
	}

	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getRole() {
		return role;
	}

	public void setRole(Integer role) {
		this.role = role;
	}
}
