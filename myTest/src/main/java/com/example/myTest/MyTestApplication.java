package com.example.myTest;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

class UpdateManage implements Runnable {
	public void run() {
		int idx = 0;
		while (true) {
			try {
				if (idx++ > 5000)
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

	public static void executePost(String targetURL) throws IOException {
		URL yahoo;
		try {
			yahoo = new URL(targetURL);

			URLConnection yc;
			try {
				yc = yahoo.openConnection();

				BufferedReader in = new BufferedReader(new InputStreamReader(yc.getInputStream()));
				String inputLine;

				while ((inputLine = in.readLine()) != null)
					System.out.println(inputLine);
				in.close();

			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {

		try {
			executePost("https://quotation-api-cdn.dunamu.com/v1/forex/recent?codes=FRX.KRWAud");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		//SpringApplication.run(MyTestApplication.class, args);
		//Thread t = new Thread(new UpdateManage());
		//t.start();
	}


}
