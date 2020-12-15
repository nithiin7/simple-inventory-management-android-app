package com.nithin.mrp.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class OrderHistoryDBHelper extends SQLiteOpenHelper {
    public static final String TABLE = "History.db";

    public OrderHistoryDBHelper(Context context) {
        super(context, "History.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase MyDB) {
        MyDB.execSQL("create Table history(pname TEXT, pmodel TEXT, price INTEGER, manufacturer TEXT, warranty TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase MyDB, int i, int i1) {
        MyDB.execSQL("drop Table if exists history");
        onCreate(MyDB);
    }

    public Boolean insertDataCart(String pname, String pmodel, String price, String manufacturer, String warranty) {
        SQLiteDatabase MyDB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("pname", pname);
        contentValues.put("pmodel", pmodel);
        contentValues.put("price", price);
        contentValues.put("manufacturer", manufacturer);
        contentValues.put("warranty", warranty);
        long result = MyDB.insert("history", null, contentValues);
        if (result == 0)
            return false;
        else
            return true;
    }

    public Cursor getdataCart() {
        SQLiteDatabase DB = this.getWritableDatabase();
        String qry = "select * from history";
        Cursor cursor = DB.rawQuery(qry, null);
        return cursor;

    }

    public boolean updateDataCart(String pname, String pmodel, String price,  String manufacturer, String warranty) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("pname", pname);
        contentValues.put("pmodel", pmodel);
        contentValues.put("price", price);
        contentValues.put("manufacturer", manufacturer);
        contentValues.put("warranty", warranty);
        long result = db.update("history", contentValues, "pmodel = ?", new String[]{String.valueOf(pmodel)});
        if (result == 0) {
            return false;
        } else {
            return true;
        }
    }

    public boolean deleteOneRow(String pmodel) {
        SQLiteDatabase db = this.getWritableDatabase();
        long result;
        result = db.delete("history", "pmodel = ?", new String[]{String.valueOf(pmodel)});
        if (result == 0) {
            return false;
        } else {
            return true;
        }
    }
}
