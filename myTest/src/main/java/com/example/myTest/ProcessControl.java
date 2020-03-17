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

  public ProcessControl() {
  }

  public void executePost(String targetURL , String rate, Container container){
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
          
				JSONArray ary = new JSONArray(inputLine);
				JSONObject jObject = ary.getJSONObject(0);
			
       
        //null = TZS 탄자니아 실링.
        System.out.println(jObject.get("basePrice").toString());
				RateData rateData = new RateData(jObject.get("name").toString(), Float.parseFloat(jObject.get("basePrice").toString()),rate);
        container.addData(rateData);
        
				in.close();

			} catch (MalformedURLException e) {
				e.printStackTrace();
			} 

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

   public String getMoneyRateJson(){
      Scanner myReader;
      try {
        myReader = new Scanner(new File("C:\\Users\\MSI\\Desktop\\exchangelistjson.txt"), "UTF-8");
    

      String res = String.format("");
      while (myReader.hasNext()) {
        String data = myReader.nextLine();
        res += data;
      }
      return res = res.replace("﻿", "");
    } catch (FileNotFoundException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
      return "";
    }
  }

  void init(Container container) {
      //System.out.println(res);
      JSONArray js = new JSONArray(getMoneyRateJson());
      for(int i =0;i<js.length();i++){
        JSONObject jObject = js.getJSONObject(i);
        executePost(path + jObject.get("code"), jObject.get("rate").toString(),container);
      }
    }
};