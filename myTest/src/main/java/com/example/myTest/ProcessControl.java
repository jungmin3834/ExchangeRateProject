package com.example.myTest;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import org.apache.tomcat.util.json.JSONParser;
import org.apache.tomcat.util.json.ParseException;
import org.json.JSONArray;
import org.json.JSONObject;

import java.awt.Desktop;

public class ProcessControl {

  public ProcessControl() {
    init();
  }

  void init() {
    try {
      Scanner myReader;

      myReader = new Scanner(new File("C:\\Users\\MSI\\Desktop\\test.txt"), "UTF-8");

      String res = String.format("");
      while (myReader.hasNext()) {
        String data = myReader.nextLine();
        res += data;
      }

      JSONParser parser = new JSONParser(res);
   
      
      JSONArray js = new JSONArray(res);
      for(int i =0;i<js.length();i++){
        JSONObject jObject = js.getJSONObject(i);
        System.out.println(jObject.get("name") + "\n" + jObject.get("rate")+"\n");
      }
      

        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
         
        
    }



};