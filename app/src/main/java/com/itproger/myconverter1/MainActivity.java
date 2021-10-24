package com.itproger.myconverter1;

import androidx.appcompat.app.AppCompatActivity;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private DataBase db;
    private ProgressBar spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = new DataBase(this);

        spinner = findViewById(R.id.progressBar);

        String url = "https://www.cbr-xml-daily.ru/daily_json.js";

        new GetURLData().execute(url);

    }

    @SuppressLint("StaticFieldLeak")
    private class GetURLData extends AsyncTask<String, String, String> {

        protected void onPreExecute(){
            super.onPreExecute();
            spinner.setVisibility(View.VISIBLE);

        }

        @Override
        protected String doInBackground(String... strings) {
            HttpURLConnection connection = null;
            BufferedReader reader = null;

            try {
                // Создаем URL подключение, а также HTTP подключение
                URL url = new URL(strings[0]);
                connection = (HttpURLConnection) url.openConnection();
                connection.connect();

                //открыли соединение и далее считываем данные
                InputStream stream = connection.getInputStream();
                reader = new BufferedReader(new InputStreamReader(stream));
                StringBuilder buffer = new StringBuilder();
                String line = "";

                //считываем построчно и записываем все в строку
                while((line = reader.readLine()) != null)
                    buffer.append(line).append("\n");
                return  buffer.toString();

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if(connection != null)
                    connection.disconnect();

                try {
                    if(reader != null)
                        reader.close();
                } catch(IOException e){
                    e.printStackTrace();
                }
            }
            return null;
        }

        @SuppressLint("SetTextI18n")
        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);
            spinner.setVisibility(View.INVISIBLE);
            // Конвертируем JSON формат и сохраняем в БД
            try {
                JSONObject jsonObject = new JSONObject(result);

                    db.insetData((jsonObject.getJSONObject("Valute").getJSONObject("AUD").getString("Name")),
                        (jsonObject.getJSONObject("Valute").getJSONObject("AUD").getString("CharCode")),
                        (jsonObject.getJSONObject("Valute").getJSONObject("AUD").getDouble("Value")));

                    db.insetData((jsonObject.getJSONObject("Valute").getJSONObject("EUR").getString("Name")),
                        (jsonObject.getJSONObject("Valute").getJSONObject("EUR").getString("CharCode")),
                        (jsonObject.getJSONObject("Valute").getJSONObject("EUR").getDouble("Value")));

                    db.insetData((jsonObject.getJSONObject("Valute").getJSONObject("BRL").getString("Name")),
                        (jsonObject.getJSONObject("Valute").getJSONObject("BRL").getString("CharCode")),
                        (jsonObject.getJSONObject("Valute").getJSONObject("BRL").getDouble("Value")));

                Intent intent = new Intent("com.itproger.myconverter1.ConvertActivity");
                startActivity(intent);

            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }
}

