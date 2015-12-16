package poc.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import poc.springboot.domain.User;
import poc.springboot.repository.UserRepository;

@RestController
public class PocController {

	@Autowired
	private UserRepository userRepository;
	
	@RequestMapping("/")
    String home() {
        return "Welcome to POC: Spring-boot / REST / Hibernate / MongoDB";
    }

	@Transactional(readOnly = true)
	@RequestMapping(value="/mongo", method = RequestMethod.GET)
    String mongo() {
		
		StringBuilder result = new StringBuilder("from mongo using spring-data-mongo findAll:<br/>");
		for(User user :userRepository.findAll()){
			result.append(user.getName())
			.append(" - ").append(user.getAge())
			.append(" - ").append(user.getStatus())
			.append("<br/>");
		}
		return result.toString();
    }
	
	@Transactional(readOnly = true)
	@RequestMapping(value = "/mongo/{name}", method= RequestMethod.GET)
	public String findUser(@PathVariable("name") String name){
		User user = userRepository.findByName(name.replaceAll("%20", " "));
		if(user!=null){
			return "user found:<br/>"+user.getName()+" - "+user.getAge()+" - "+user.getStatus(); 
		}
		return "User not found.";
	}
	
	@Transactional(readOnly=false)
	@RequestMapping(value="/mongo/new/{name}/{age}/{status}", method = RequestMethod.GET)
	public String insertUser(@PathVariable("name") String name, @PathVariable("age") int age, @PathVariable("status") String status){
		userRepository.save(new User(name, age, status));
		return "<br/>Inserted OK";
	}
	
}
