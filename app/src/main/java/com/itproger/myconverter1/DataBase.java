package com.itproger.myconverter1;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class DataBase extends SQLiteOpenHelper {

    private static final String db_name = "currency_converter";
    private static final int db_version = 1;

    private static final String db_table = "converter";
    private static final String db_column1 = "currency_name";
    private static final String db_column2 = "abbrev_name";
    private static final String db_column3 = "meaning_currency";


    public DataBase(@Nullable Context context) {
        super(context, db_name, null, db_version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = String.format("CREATE TABLE %s (ID INTEGER PRIMARY KEY AUTOINCREMENT, %s TEXT NOT NULL, %s TEXT NOT NULL, %s REAL NOT NULL);", db_table, db_column1, db_column2, db_column3);
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + db_table);
        onCreate(db);
    }

    public void insetData(String currency, String abbrev, double meaning) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(db_column1, currency);
        values.put(db_column2, abbrev);
        values.put(db_column3, meaning);
        db.insertWithOnConflict(db_table, null, values, SQLiteDatabase.CONFLICT_REPLACE);
    }



    public ArrayList<String> getAllCurr() {
        ArrayList<String> allCurr = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(db_table, new String[]{db_column1, db_column2, db_column3}, null, null, null, null, null);
        while (cursor.moveToNext()) {
            int index = cursor.getColumnIndex(db_column1);
        }
        cursor.close();
        db.close();
        return  allCurr;
    }
}

