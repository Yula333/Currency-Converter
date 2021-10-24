package com.itproger.myconverter1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ToggleButton;

public class ChoiceActivity extends AppCompatActivity {

    private DataBase dataBase;
    private ToggleButton btn_RUB;
    private ToggleButton btn_AUD;
    private ToggleButton btn_BRL;
    private ToggleButton btn_EUR;
    private Button btn_back;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choice);

        dataBase = new DataBase(this);
        btn_back = findViewById(R.id.btn_back);
        btn_RUB = findViewById(R.id.btn_RUB);
        btn_AUD = findViewById(R.id.btn_AUD);
        btn_BRL = findViewById(R.id.btn_BRL);
        btn_EUR = findViewById(R.id.btn_EUR);

        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("com.itproger.myconverter1.ConvertActivity");
                startActivity(intent);
            }
        });

        btn_RUB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("com.itproger.myconverter1.ConvertActivity");
                startActivity(intent);
            }
        });

        btn_AUD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("com.itproger.myconverter1.ConvertActivity");
                startActivity(intent);
            }
        });

        btn_BRL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("com.itproger.myconverter1.ConvertActivity");
                startActivity(intent);
            }
        });

        btn_EUR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("com.itproger.myconverter1.ConvertActivity");
                startActivity(intent);
            }
        });
    }

}