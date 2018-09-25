package com.example.hashu.hashcurrency;

import java.util.HashMap;

public class Converter {
    //Data Members
    private Double convertedAmount;
    private String symbol;
    private HashMap<String,Currency> currencies = new HashMap<>();

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
    public Double convertCurrency(String convertFrom , String convertTo , Double amount){

        CurrencyBuilder builder = new CurrencyBuilder();
        currencies = builder.getCurrencies();
        Currency fromCurrency = new Currency();
        fromCurrency =currencies.get(convertFrom);
        Double rate = fromCurrency.getRates().get(convertTo);
        convertedAmount = amount*rate ;
        return convertedAmount;
    }
}
