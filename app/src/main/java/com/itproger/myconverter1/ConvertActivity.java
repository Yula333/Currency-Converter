package com.itproger.myconverter1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

public class ConvertActivity extends AppCompatActivity {

    private EditText user_sum;
    private TextView convert_sum;
    private ImageButton swap_btn;
    private TextView currency_first;
    private TextView currency_second;
    private Button change1;
    private Button change2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_convert);

        user_sum = findViewById(R.id.user_sum);
        convert_sum = findViewById(R.id.convert_sum);
        swap_btn = findViewById(R.id.swap_btn);
        currency_first = findViewById(R.id.currency_first);
        currency_second = findViewById(R.id.currency_second);
        change1 = findViewById(R.id.change1);
        change2 = findViewById(R.id.change2);


        change1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("com.itproger.myconverter1.ChoiceActivity");
                startActivity(intent);
            }
        });

        change2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("com.itproger.myconverter1.ChoiceActivity");
                startActivity(intent);
            }
        });

        swap_btn.setOnClickListener(new View.OnClickListener() {        //ДОПИСАТЬ!  меняем валюту между собой
            @Override
            public void onClick(View v) {

            }
        });
    }

}
