package com.cts.springboot.web.springbootfirstwebapplication.controller;




import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWordController {

	//http://localhost:9080/login?name=Gayathri
		
	public void sendNotification() {
		User user = new User();
		user.setName("Gayathri");
		
	}
	
	
	
	
	

}
