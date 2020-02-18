package com.example.myTest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

class UpdateManage implements Runnable {
	public void run() {
		int idx = 0;
		while (true) {
			try {
				if(idx++ > 5000)
					return;
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return;
			}
			System.out.print("Update!\n");
		}
	} 
}


@SpringBootApplication
public class MyTestApplication {



	public static void main(String[] args) {
		SpringApplication.run(MyTestApplication.class, args);
		Thread t = new Thread(new UpdateManage());
		t.start();
	}


}
