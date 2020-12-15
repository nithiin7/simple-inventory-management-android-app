package com.nithin.mrp.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

public class InventoryDBHelper extends SQLiteOpenHelper {
    public static final String TABLE = "Inventory.db";

    public InventoryDBHelper(Context context) {
        super(context, "Inventory.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase MyDB) {
        MyDB.execSQL("create Table inventory(pname TEXT, pmodel TEXT, price INTEGER, qty INTEGER, manufacturer TEXT, warranty INTEGER)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase MyDB, int i, int i1) {
        MyDB.execSQL("drop Table if exists inventory");
        onCreate(MyDB);
    }

    public Boolean insertData(String pname, String pmodel, String price, String qty, String manufacturer, String warranty) {
        SQLiteDatabase MyDB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("pname", pname);
        contentValues.put("pmodel", pmodel);
        contentValues.put("price", price);
        contentValues.put("qty", qty);
        contentValues.put("manufacturer", manufacturer);
        contentValues.put("warranty", warranty);

        long result = MyDB.insert("inventory", null, contentValues);
        if (result == -1)
            return false;
        else
            return true;
    }

    public Cursor getdata() {
        SQLiteDatabase DB = this.getWritableDatabase();
        String qry = "select * from inventory";
        Cursor cursor = DB.rawQuery(qry, null);
        return cursor;

    }

    public boolean updateData(String pname, String pmodel, String price, String qty, String manufacturer,String warranty) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("pname", pname);
        contentValues.put("pmodel", pmodel);
        contentValues.put("price", price);
        contentValues.put("qty", qty);
        contentValues.put("manufacturer", manufacturer);
        contentValues.put("warranty", warranty);
        long result = db.update("inventory", contentValues, "pmodel = ?", new String[]{String.valueOf(pmodel)});
        if(result == 0){
            return false;
        }
        else{
            return true;
        }
    }

    public boolean deleteOneRow(String pmodel){
        SQLiteDatabase db = this.getWritableDatabase();
        long result;
        result = db.delete("inventory","pmodel = ?", new String[]{String.valueOf(pmodel)});
        if(result == 0){
            return false;
        }
        else{
            return true;
        }
    }
}

