package com.example.hashu.hashcurrency;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Converter converter  = new Converter();

        Double result = converter.convertCurrency("USD","PRK",10.000);

        Toast.makeText(this, "RS --> "+ result, Toast.LENGTH_SHORT).show();

    }
}
