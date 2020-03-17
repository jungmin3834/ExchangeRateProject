package com.example.myTest;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class DataController {

	@RequestMapping("/getMoneyRate")
	public String getMoneyList() {
		return MyTestApplication.container.printAllContainerData();
	}
}