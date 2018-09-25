package com.example.hashu.hashcurrency;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private  RecyclerView.LayoutManager layoutManager;
    private RecyclerView.Adapter adapter;
    private static HashMap<String,Currency> currencies = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.rvCurrency);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(MainActivity.this);
        recyclerView.setLayoutManager(layoutManager);

        CurrencyFactory builder = new CurrencyFactory();

        adapter = new CurrencyAdapter(currencies = builder.getCurrencies());
        recyclerView.setAdapter(adapter);
        Converter converter  = new Converter();
        Double result = converter.convertCurrency("USD","PRK",10.000);
        Toast.makeText(this, "RS --> "+ result, Toast.LENGTH_SHORT).show();


    }
    class CurrencyAdapter extends RecyclerView.Adapter{
        HashMap<String ,Currency> currencies = new HashMap<>();
        public CurrencyAdapter (HashMap<String, Currency> currencies ){
            this.currencies = currencies;
        }

        @NonNull
        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            return null;
        }

        @Override
        public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {

        }

        @Override
        public int getItemCount() {
            return 0;
        }
    }
}
