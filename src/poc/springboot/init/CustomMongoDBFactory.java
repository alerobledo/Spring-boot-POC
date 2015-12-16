package poc.springboot.init;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.stereotype.Component;

@Component
public class CustomMongoDBFactory {

	@Autowired
	private final MongoDbFactory mongo;

	public CustomMongoDBFactory(MongoDbFactory mongo) {
		this.mongo = mongo;
	}
	
	
}
