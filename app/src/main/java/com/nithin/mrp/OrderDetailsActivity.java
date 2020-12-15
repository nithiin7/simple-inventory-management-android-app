package com.nithin.mrp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.nithin.mrp.adapter.CustomAdapter;
import com.nithin.mrp.adapter.CustomAdapterDetails;
import com.nithin.mrp.database.InventoryDBHelper;
import com.nithin.mrp.database.OrderHistoryDBHelper;
import com.nithin.mrp.entities.Model;
import com.nithin.mrp.entities.OrderDetails;

import java.util.ArrayList;
import java.util.Collections;

public class OrderDetailsActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerView.Adapter mAdapter;
    RecyclerView.LayoutManager layoutManager;

    ArrayList<OrderDetails> dataholder;
    ActionBar actionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_details);

        actionBar = getSupportActionBar();
        actionBar.setTitle("Order History");

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        Cursor cursor= new OrderHistoryDBHelper(this).getdataCart();
        dataholder = new ArrayList<>();

        while (cursor.moveToNext()) {
            OrderDetails obj = new OrderDetails(cursor.getString(0), cursor.getString(1), cursor.getString(2), cursor.getString(3));
            dataholder.add(obj);

        }
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        mAdapter = new CustomAdapterDetails(dataholder);
        recyclerView.setAdapter(mAdapter);
    }
}