package com.nithin.mrp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.nithin.mrp.adapter.CustomAdapterBuy;
import com.nithin.mrp.database.InventoryDBHelper;
import com.nithin.mrp.entities.Model;

import java.util.ArrayList;
import java.util.Collections;

public class BuyActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerView.Adapter mAdapter;
    RecyclerView.LayoutManager layoutManager;

    ArrayList<Model> dataholder;
    Menu menu;
    ActionBar actionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inventory);

        actionBar = getSupportActionBar();
        actionBar.setTitle("Inventory");

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.hasFixedSize();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        Cursor cursor= new InventoryDBHelper(this).getdata();
        dataholder = new ArrayList<>();

        while (cursor.moveToNext()) {
            Model obj = new Model(cursor.getString(0), cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getString(4), cursor.getString(5));
            dataholder.add(obj);

        }

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        mAdapter = new CustomAdapterBuy(dataholder);
        recyclerView.setAdapter(mAdapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_filter, menu);
        return true;
    }

    public boolean onOptionsItemSelected(@NonNull MenuItem item){

        switch (item.getItemId()){
            case R.id.action_ascending:
                Collections.sort(dataholder, Model.ascPname);
                mAdapter.notifyDataSetChanged();
                Toast.makeText(BuyActivity.this, "Name In Ascending Order", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.action_descending:
                Collections.sort(dataholder, Model.descPname);
                mAdapter.notifyDataSetChanged();
                Toast.makeText(BuyActivity.this, "Name In Descending Order", Toast.LENGTH_SHORT).show();
                return true;

            case R.id.action_ascprice:
                Collections.sort(dataholder, Model.ascPrice);
                mAdapter.notifyDataSetChanged();
                Toast.makeText(BuyActivity.this, "Price In Ascending Order", Toast.LENGTH_SHORT).show();
                return true;

            case R.id.action_descprice:
                Collections.sort(dataholder, Model.descPrice);
                mAdapter.notifyDataSetChanged();
                Toast.makeText(BuyActivity.this, "Price In Descending Order", Toast.LENGTH_SHORT).show();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }


}