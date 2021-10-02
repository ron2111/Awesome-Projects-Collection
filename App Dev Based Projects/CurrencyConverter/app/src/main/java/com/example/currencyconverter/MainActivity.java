package com.example.currencyconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public void convert(View view)
    {
        EditText amountInInr = (EditText) findViewById(R.id.amountInInr);
        double inUSD = Double.parseDouble(amountInInr.getText().toString());
        inUSD = inUSD*72.51;
        String ans = String.format("%.2f",inUSD);
        Toast.makeText(this, amountInInr.getText().toString()+" in USD is "+ans, Toast.LENGTH_SHORT).show();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}