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

import org.apache.tomcat.util.json.JSONParser;
import org.apache.tomcat.util.json.ParseException;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.FileWriter;

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

	static Container container;

	public static void executePost(String targetURL) throws IOException {
		URL url;
		try {
			url = new URL(targetURL);

			URLConnection yc;
			try {
				yc = url.openConnection();

				BufferedReader in = new BufferedReader(new InputStreamReader(yc.getInputStream()));
				String inputLine = "";
				while (in.ready() == true) {
					inputLine += in.readLine();
				}
				
				
				JSONArray ary = new JSONArray(inputLine);
				JSONObject jObject = ary.getJSONObject(0);
				
				System.out.println(inputLine);
				
				RateData rateData = new RateData(jObject.get("name").toString(), Float.parseFloat(jObject.get("basePrice").toString()));
				container.addData(rateData);
				

				System.out.print(rateData.getMoney());
				
			
				//System.out.println(inputLine);
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



	public static void init(){
		container = new Container();
	}

	public static void main(String[] args) {

		ProcessControl test = new ProcessControl();
		/*
		System.out.print("Start");
		init();
		try {
			executePost("https://quotation-api-cdn.dunamu.com/v1/forex/recent?codes=FRX.KRWAud");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.print("Finish");*/
		//SpringApplication.run(MyTestApplication.class, args);
		//Thread t = new Thread(new UpdateManage());
		//t.start();
	}


}
