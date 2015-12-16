package poc.springboot.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import poc.springboot.domain.User;

public interface UserRepository extends MongoRepository<User, String> {

	User findByName(String name);
}
