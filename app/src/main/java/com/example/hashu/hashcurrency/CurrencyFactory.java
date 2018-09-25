package com.example.hashu.hashcurrency;

import java.util.HashMap;
import java.util.Hashtable;

public class CurrencyFactory {

    private static HashMap<String,Currency> currencies = new HashMap<>();

    public static void addCurrency(){

        Hashtable<String, Double> usdRates = new Hashtable<>();
        usdRates.put("PRK",123.7298);
        usdRates.put("EUR",0.8505);
        usdRates.put("GBP",0.7623);
        usdRates.put("CAD",1.2943);
        Currency usd = new Currency("USD","United States Dollar ","$",usdRates);
        currencies.put("USD",usd);

        Hashtable<String, Double> prkRates = new Hashtable<>();
        prkRates.put("USD",0.0081);
        prkRates.put("EUR",0.0069);
        prkRates.put("GBP",0.0062);
        prkRates.put("CAD",0.0105);
        Currency prk = new Currency("PRK","Pakistani Rupees","Rs",prkRates);
        currencies.put("PRK",prk);

        Hashtable<String, Double> eurRates = new Hashtable<>();
        eurRates.put("USD",1.1757);
        eurRates.put("PRK",145.4708);
        eurRates.put("GBP",0.8962);
        eurRates.put("CAD",1.5217);
        Currency eur = new Currency("EUR","Euro","€",eurRates);
        currencies.put("EUR",eur);

        Hashtable<String, Double> cadRates = new Hashtable<>();
        cadRates.put("USD",0.7726);
        cadRates.put("PRK",95.5948);
        cadRates.put("GBP",0.5889);
        cadRates.put("EUR",0.6571);
        Currency cad = new Currency("CAD","Canadian Dollar","",cadRates);
        currencies.put("CAD", cad);
    }

    public static HashMap<String, Currency> getCurrencies() {
        addCurrency();
        return currencies;
    }
}
