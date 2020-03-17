package com.example.myTest;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Container {

    HashMap<String,RateData> CountryRateContrainer = new HashMap<String,RateData>();
    public Container(){
    }

    public void clearContainer(){
        CountryRateContrainer.clear();
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

    public String printAllContainerData(){
        Iterator<String> mapIter = CountryRateContrainer.keySet().iterator();
        StringBuffer res = new StringBuffer("");
        while(mapIter.hasNext()){
            String key = mapIter.next();
            RateData value = CountryRateContrainer.get(key);
            res.append("{\"name\":\""+value.getRate()+"\",\"rate\":\""+ value.getRate() + "\",\"money\":\""+ value.getMoney()+"\"},");
        }

        res.delete(res.length()-1,res.length());
        return "[" + res + "]";
    }
};