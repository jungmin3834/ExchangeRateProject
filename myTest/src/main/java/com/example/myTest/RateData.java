package com.example.myTest;


public class RateData
{
    private String Name;
    private float Money;


    public RateData(String _name ,float _money){
        Money = _money;  
        Name = _name;      
    }

    public float getMoney(){
        return Money;
    }
    
};