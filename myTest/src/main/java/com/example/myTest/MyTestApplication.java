package com.example.myTest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;




@SpringBootApplication
public class MyTestApplication {

	public static Container container;
	public static ProcessControl process;
	public static class UpdateManage implements Runnable {
		public void run() {
			while (true) {
				try {
					Thread.sleep(10000000);
					container.clearContainer();
					process.init(container);

				} catch (InterruptedException e) {
					e.printStackTrace();
					return;
				}
				System.out.print("Update!\n");
			}
		}
	}

	public static void init(){
		container = new Container();
		process = new ProcessControl();
		process.init(container);
	}

	public static void main(String[] args) {
		init();
		SpringApplication.run(MyTestApplication.class, args);
		Thread t = new Thread(new UpdateManage());
		t.start();
	}

	
}
