package example.sia5.tacos.respository.jpa;

import org.springframework.data.repository.CrudRepository;

import example.sia5.tacos.model.User;

public interface UserRepository extends CrudRepository<User, Long> {
	User findByUsername(String username);
}
