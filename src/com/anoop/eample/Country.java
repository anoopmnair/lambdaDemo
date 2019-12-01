package com.anoop.eample;

public class Country {
    private String name;
    private long population;

    public Country (String name,long popul)
    {
        this.name=name;
        this.population=popul;
    };

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getPopulation() {
        return population;
    }

    public void setPopulation(long population) {
        this.population = population;
    }
}
