package com.anoop.eample;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StreamTester {

    private String continent;

    /**
     *
     * @param continentNme
     * @param countrycount
     * @return
     */
    public Map<String, List<Country>> dataFiller(String continentNme,int countrycount)
    {
        Map<String, List<Country>>continentCountryMap=new HashMap<>();
        List<Country>countryList=new ArrayList<>();
        String countr;
        for (int i=1;i<=countrycount;i++) {

            countryList.add(new Country("countr"+i,i*10));
        }
        continentCountryMap.put(continentNme,countryList);
        return continentCountryMap;
    }

    public Map<String,Long>populationCalculator(Map<String, List<Country>> continentCountryMap)
    {
        long count=0;
        Map<String,Long> resultMap=new HashMap<>();
        continentCountryMap.forEach((k,v)->{resultMap.put(k,findPopulation(v));

        });
        return resultMap;
    }

    private Long findPopulation(List<Country> v) {
        Long count=0l;
        long totalPopulation=0l;
        totalPopulation =v.stream().map(country -> country.getPopulation()).reduce(0l,Long::sum);
        return totalPopulation;
    }

    public static void main(String arg[])
    {
        StreamTester streamTester=new StreamTester();
        Map<String, List<Country>>continentCountryMap=  streamTester.dataFiller("Asia",1);
        Map<String,Long> resultMap= streamTester.populationCalculator(continentCountryMap);
        resultMap.forEach((k,v)->{
            System.out.print("Continent= "+k+" ");
            System.out.print("& Population "+v);
            System.out.println();
        });
    }
}
