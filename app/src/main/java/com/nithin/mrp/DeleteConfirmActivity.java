package com.nithin.mrp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.nithin.mrp.database.DBHelper;
import com.nithin.mrp.database.OrderHistoryDBHelper;
import com.nithin.mrp.entities.OrderDetails;

public class DeleteConfirmActivity extends AppCompatActivity {

    OrderHistoryDBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_confirm);

        DB = new OrderHistoryDBHelper(this);

        Bundle bundle = getIntent().getExtras();
        final String name = bundle.getString("Pmodel");

        Boolean delete = DB.deleteOneRow(name);

        if(delete == true){
            Toast.makeText(DeleteConfirmActivity.this, "Order Successfully Cancelled", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(getApplicationContext(), OrderDetailsActivity.class);
            startActivity(intent);
        }
        else{
            Toast.makeText(DeleteConfirmActivity.this, "Order Cancel Failed", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(getApplicationContext(),OrderDetailsActivity.class);
            startActivity(intent);
        }
    }
}