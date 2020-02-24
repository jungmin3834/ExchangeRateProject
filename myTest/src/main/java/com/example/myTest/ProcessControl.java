package com.example.myTest;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

import org.json.JSONArray;
import org.json.JSONObject;

public class ProcessControl {

  Container container;
  public ProcessControl(Container _container) {
    container = _container;
    init();
    
  }

  public void executePost(String targetURL , String rate){
    URL url;
		try {
			url = new URL(targetURL);

			URLConnection yc;
			try {
       // System.out.println(targetURL);
				yc = url.openConnection();

				BufferedReader in = new BufferedReader(new InputStreamReader(yc.getInputStream()));
				String inputLine = "";
				while (in.ready() == true) {
					inputLine += in.readLine();
        }
        
        String compare = "[]";
        if(inputLine.compareTo(compare) == 0)
        {
           System.out.println(rate);
           return;
        }
          
				
        System.out.println(inputLine);
				JSONArray ary = new JSONArray(inputLine);
				JSONObject jObject = ary.getJSONObject(0);
			
       
				
				RateData rateData = new RateData(jObject.get("name").toString(), Float.parseFloat(jObject.get("basePrice").toString()),rate);
				container.addData(rateData);
				//System.out.print(rateData.getName() + "  :   " +rateData.getMoney());
				
			
				//System.out.println(inputLine);
				in.close();

			} catch (MalformedURLException e) {
				e.printStackTrace();
			} 

		} catch (IOException e) {
			e.printStackTrace();
		}

	}


  void init() {
    try {
      Scanner myReader;
      String path = "https://quotation-api-cdn.dunamu.com/v1/forex/recent?codes=FRX.KRW";

      myReader = new Scanner(new File("C:\\Users\\MSI\\Desktop\\test.txt"), "UTF-8");

      String res = String.format("");
      while (myReader.hasNext()) {
        String data = myReader.nextLine();
        res += data;
      }
      res = res.replace("﻿", "");
      //System.out.println(res);
      JSONArray js = new JSONArray(res);
      for(int i =0;i<js.length();i++){
        JSONObject jObject = js.getJSONObject(i);
        executePost(path + jObject.get("code"), jObject.get("rate").toString());
      }
      



      } catch (FileNotFoundException e) {
           e.printStackTrace();
      }
         
        
    }



};