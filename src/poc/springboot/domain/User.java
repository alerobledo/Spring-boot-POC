package poc.springboot.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="users")
public class User {

	@Id
	private String id;
	private String name;
	private int age;
	private String status;

	public User(String name, int age, String status) {
		this.name = name;
		this.age = age;
		this.status = status;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public String getStatus() {
		return status;
	}
}
