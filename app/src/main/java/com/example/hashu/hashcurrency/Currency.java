package com.example.hashu.hashcurrency;

import java.util.HashSet;
import java.util.Hashtable;

public class Currency {
    //Data Members
    private String name;
    private String fullName;
    private String Symbol;
    private Hashtable<String, Double> Rates = new Hashtable<>();

    //Constructor
    public Currency(){

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
        return Symbol;
    }

    public void setSymbol(String symbol) {
        Symbol = symbol;
    }

    public Hashtable<String, Double> getRates() {
        return Rates;
    }

    public void setRates(Hashtable<String, Double> rates) {
        Rates = rates;
    }

}