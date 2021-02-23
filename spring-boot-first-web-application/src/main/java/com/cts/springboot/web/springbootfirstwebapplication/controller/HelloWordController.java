package com.cts.springboot.web.springbootfirstwebapplication.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloWordController {

	//http://localhost:9080/login?name=Gayathri
		@RequestMapping("/login")
		//@ResponseBody
		public String HelloMessage() {
			
			return "hello";
		}
	
	
	
	

}
