package com.example.hashu.hashcurrency;

import java.util.HashMap;
import java.util.Hashtable;

public class CurrencyBuilder {
    private Integer numberOfCurrency;
    private HashMap<String,Currency> Currencies = new HashMap<>();

    public CurrencyBuilder (){

    }

    public void addCurrency(){

        Hashtable<String, Double> USD_Rates = new Hashtable<>();
        USD_Rates.put("PRK",123.7298);
        USD_Rates.put("EUR",0.8505);
        USD_Rates.put("GBP",0.7623);
        USD_Rates.put("CAD",1.2943);
        Currency USD = new Currency("USD","United States Dollar ", "$",USD_Rates);
        Currencies.put("USD",USD);

        Hashtable<String, Double> PRK_Rates = new Hashtable<>();
        PRK_Rates.put("USD",0.0081);
        PRK_Rates.put("EUR",0.0069);
        PRK_Rates.put("GBP",0.0062);
        PRK_Rates.put("CAD",0.0105);
        Currency PRK = new Currency("PRK","Pakistani Rupees", "Rs",PRK_Rates);
        Currencies.put("PRK",PRK);

        Hashtable<String, Double> EUR_Rates = new Hashtable<>();
        EUR_Rates.put("USD",1.1757);
        EUR_Rates.put("PRK",145.4708);
        EUR_Rates.put("GBP",0.8962);
        EUR_Rates.put("CAD",1.5217);
        Currency EUR = new Currency("EUR","Euro", "€",EUR_Rates);
        Currencies.put("EUR",EUR);

        Hashtable<String, Double> CAD_Rates = new Hashtable<>();
        CAD_Rates.put("USD",0.7726);
        CAD_Rates.put("PRK",95.5948);
        CAD_Rates.put("GBP",0.5889);
        CAD_Rates.put("EUR",0.6571);
        Currency CAD = new Currency("CAD","Canadian Dollar", "$",CAD_Rates);
        Currencies.put("CAD", CAD);
    }

    public HashMap<String, Currency> getCurrencies() {
        return Currencies;
    }
}
