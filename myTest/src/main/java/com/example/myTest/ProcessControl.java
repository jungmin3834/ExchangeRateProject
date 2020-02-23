package com.example.myTest;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.awt.Desktop;

public class ProcessControl {

    public ProcessControl() {
        init();
    }

    void init() {

      String t = "나는증말";
      System.out.print(t);
        try {
            Scanner myReader =new Scanner(new File("C:\\Users\\MSI\\Desktop\\jsn.txt"),"UTF-8");
            String res = String.format("");
            while (myReader.hasNext()) {
              String data = myReader.nextLine();
             // System.out.println(data);
            }

            

            myReader.close();
          } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
          }
        
    }



};