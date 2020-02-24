package com.example.myTest;

import java.util.HashMap;
import java.util.Map;

public class Container {

    Map<String,RateData> CountryRateContrainer = new HashMap<String,RateData>();
    public Container(){
    }
    
    public void DeContainer(){
        CountryRateContrainer.clear();
        CountryRateContrainer = null;
    }

    public void addData(RateData _RateData){
        CountryRateContrainer.put(_RateData.getName(), _RateData);
    }

    public RateData getDataByName(String _Name) {
        if(CountryRateContrainer.containsKey(_Name) != true)
            return null;
        else
            return CountryRateContrainer.get(_Name);
    }



};