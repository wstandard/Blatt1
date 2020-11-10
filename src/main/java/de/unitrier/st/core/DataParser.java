package de.unitrier.st.core;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DataParser {

    public Map<String, List<CountryDataPoint>> parseJsonData(String json) {
        Gson gson = new Gson();
        CountryDataPoint[] dataPoints = gson.fromJson(json, CountryDataPoint[].class);
        System.out.println("Json contains " + dataPoints.length + " data points");

        Map<String, List<CountryDataPoint>> countries = new HashMap<>();
        for (CountryDataPoint dataPoint : dataPoints) {
            if (countries.containsKey(dataPoint.Country)) {
                countries.get(dataPoint.Country).add(dataPoint);
            } else {
                ArrayList<CountryDataPoint> list = new ArrayList<>();
                list.add(dataPoint);
                countries.put(dataPoint.Country, list);
            }
        }
        return countries;
    }
}
