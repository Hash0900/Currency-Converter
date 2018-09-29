package com.example.hashu.hashcurrency;

import java.util.Hashtable;

public class Currency {
    private String name;
    private String fullName;
    private String symbol;
    private Hashtable<String, Double> rates = new Hashtable<>();

    public Currency(String name , String fullName , String symbol , Hashtable<String, Double> rates){
       this.name = name;
       this.fullName = fullName;
       this.symbol = symbol;
       this.rates = rates;
    }

    public String getName() {
        return name;
    }

    public String getFullName() {
        return fullName;
    }

    public String getSymbol() {
        return symbol;
    }

    public Hashtable<String, Double> getRates() {
        return rates;
    }

    public void setRates(Hashtable<String, Double> rates) {
        this.rates = rates;
    }

    public Double convertTo(Currency convertTo, Double amount){
        Double rate = rates.get(convertTo.getName());
        return amount*rate ;
    }

    public Double convertTo(String convertTo, Double amount){

        Double rate = rates.get(convertTo);
        return amount*rate ;
    }

}