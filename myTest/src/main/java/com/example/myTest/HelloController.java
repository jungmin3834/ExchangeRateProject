package com.example.myTest;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class HelloController {

	@RequestMapping("/")
	public String index() {
		return "Greetings from Spring Boot!";
	}

	

	@RequestMapping("/getMoneyRate")
	public String getMoneyList() {
		return MyTestApplication.container.printAllContainerData();
	}



}