package com.example.hashu.hashcurrency;

import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Hashtable;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private RecyclerView.Adapter adapter;
    private Double amount;
    private static HashMap<String,Currency> currencies = new HashMap<>();
    private ArrayList<Currency> currenciesList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CurrencyFactory builder = new CurrencyFactory();
        currencies = builder.getCurrencies();
        currenciesList.addAll(currencies.values());

        recyclerView = findViewById(R.id.rvCurrency);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(MainActivity.this);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new CurrencyAdapter(currenciesList);
        recyclerView.setAdapter(adapter);

        //currencies.get("usd").convertTo("eur",1200.0);


        //Double result = Converter.convertCurrency("USD","PRK",10.000);
        //Toast.makeText(this, "RS --> "+ result, Toast.LENGTH_SHORT).show();


    }

    class CurrencyAdapter extends RecyclerView.Adapter<CurrencyAdapter.CurrencyViewHolder>{
        private ArrayList<Currency> currenciesList = new ArrayList<>();
        Double va =1.0 ;
        public CurrencyAdapter (ArrayList<Currency> currencies){
            this.currenciesList = currencies;

        }

        public class CurrencyViewHolder extends RecyclerView.ViewHolder{
            RelativeLayout rlBackgroung;
            ImageView ivCurrencyImage ;
            ImageView ivInputIcon;
            TextView tvCurrencyName;
            TextView tvCurrencyFullName;
            EditText etAmountEntered;
            TextView tvAmount;
            TextView tvRate;


            public CurrencyViewHolder(@NonNull View itemView) {
                super(itemView);
                rlBackgroung = itemView.findViewById(R.id.rlBackground);
                tvCurrencyName = itemView.findViewById(R.id.tvCurrencyName);
                tvCurrencyFullName = itemView.findViewById(R.id.tvCurrencyFullName);
                tvAmount= itemView.findViewById(R.id.tvAmount);
                tvRate= itemView.findViewById(R.id.tvRate);
                ivInputIcon =itemView.findViewById(R.id.ivInputIcon);
                ivCurrencyImage =itemView.findViewById(R.id.ivCurrencyImage);
                etAmountEntered= itemView.findViewById(R.id.etAmount);
            }

        }

        @NonNull
        @Override
        public CurrencyAdapter.CurrencyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            View view = LayoutInflater.from(viewGroup.getContext())
                    .inflate(R.layout.layout_currency,viewGroup,false);
            return new CurrencyViewHolder(view);
        }
        @Override
        public void onBindViewHolder(@NonNull final CurrencyAdapter.CurrencyViewHolder currencyViewHolder, final int i) {
            Currency currency = currenciesList.get(i);
            if(i == 0){
                currencyViewHolder.rlBackgroung.setBackgroundColor(Color.BLUE);
                currencyViewHolder.tvAmount.setVisibility(View.GONE);
                currencyViewHolder.tvRate.setVisibility(View.GONE);
                currencyViewHolder.etAmountEntered.setVisibility(View.VISIBLE);
                currencyViewHolder.ivInputIcon.setVisibility(View.VISIBLE);
                currencyViewHolder.tvCurrencyName.setText(currency.getName());
                currencyViewHolder.tvCurrencyName.setTextColor(Color.WHITE);
                currencyViewHolder.tvCurrencyFullName.setTextColor(Color.WHITE);
                currencyViewHolder.etAmountEntered.setTextColor(Color.WHITE);
                currencyViewHolder.etAmountEntered.addTextChangedListener(new TextWatcher() {
                    @Override
                    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                    }

                    @Override
                    public void onTextChanged(CharSequence s, int start, int before, int count) {

                    }

                    @Override
                    public void afterTextChanged(Editable s) {
                        if(s.toString().equals("")){
                            va= 0.0;
                            notifyDataSetChanged();
                        }
                        else {
                            va = Double.parseDouble(String.valueOf(s));
                            notifyDataSetChanged();

                        }
                    }
                });
            }
            else {
                Double rate = currenciesList.get(0).getRates().get(currency.getName());
                Double amount = rate* va ;
                currencyViewHolder.tvAmount.setVisibility(View.VISIBLE);
                currencyViewHolder.tvRate.setVisibility(View.VISIBLE);
                currencyViewHolder.etAmountEntered.setVisibility(View.GONE);
                currencyViewHolder.ivInputIcon.setVisibility(View.GONE);
                currencyViewHolder.tvCurrencyName.setText(currency.getName());
                currencyViewHolder.tvCurrencyFullName.setText(currency.getFullName());
                currencyViewHolder.tvRate.setText("1 "+currency.getSymbol()+ "= " + rate + currenciesList.get(0).getName());
                currencyViewHolder.tvAmount.setText(String.format("%.4f",amount));

            }

            currencyViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Collections.swap(currenciesList,0,i);
                    notifyDataSetChanged();
                }
            });

        }


        @Override
        public int getItemCount() {

            return currencies.size();
        }
    }
}
