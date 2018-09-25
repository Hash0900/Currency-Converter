package com.example.hashu.hashcurrency;

import java.util.HashMap;

public class Converter {
    //Data Members
    private static Double convertedAmount;
    private String symbol;
    private static HashMap<String,Currency> currencies = new HashMap<>();

    //Constructor
    public Converter(){

    }
    //getter and setters

    public Double getConvertedAmount() {
        return convertedAmount;
    }
    public void setConvertedAmount(Double convertedAmount) {
        this.convertedAmount = convertedAmount;
    }
    public String getSymbol() {
        return symbol;
    }
    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    //Functions

    public static Double convertCurrency(String convertFrom, String convertTo, Double amount){
        CurrencyFactory builder = new CurrencyFactory();
        currencies = builder.getCurrencies();
        Currency fromCurrency = currencies.get(convertFrom);
        Double rate = fromCurrency.getRates().get(convertTo);
        convertedAmount = amount*rate ;
        return convertedAmount;
    }
}
