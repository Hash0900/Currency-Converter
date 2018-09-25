package com.example.hashu.hashcurrency;

import java.util.Hashtable;

public class Currency {
    //Data Members
    private String name;
    private String fullName;
    private String symbol;
    private Hashtable<String, Double> rates = new Hashtable<>();

    //Constructor
    public Currency(String name , String fullName , String symbol , Hashtable<String, Double> rates){
        setName(name);
        setFullName(fullName);
        setSymbol(symbol);
        setRates(rates);
    }

    // Getter and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public Hashtable<String, Double> getRates() {
        return rates;
    }

    public void setRates(Hashtable<String, Double> rates) {
        this.rates = rates;
    }

}