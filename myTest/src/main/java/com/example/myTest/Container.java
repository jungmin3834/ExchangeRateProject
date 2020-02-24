package com.example.myTest;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Container {

    HashMap<String,RateData> CountryRateContrainer = new HashMap<String,RateData>();
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

    public void printAllContainerData(){
        Iterator<String> mapIter = CountryRateContrainer.keySet().iterator();
 
        while(mapIter.hasNext()){
            String key = mapIter.next();
            RateData value = CountryRateContrainer.get(key);
            System.out.println(value.getName()+" : " + value.getRate() + "  : "+value.getMoney());
        }
    }
};