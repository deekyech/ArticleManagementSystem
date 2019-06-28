package BasicApp.authentication;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
	List<User> findByUsernameOrEmail(String username, String email);
	List<User> findByEmail(String email);
}
