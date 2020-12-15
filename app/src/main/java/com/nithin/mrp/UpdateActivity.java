package com.nithin.mrp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.nithin.mrp.database.InventoryDBHelper;

public class UpdateActivity extends AppCompatActivity {

    EditText ed1, ed2, ed3, ed4, ed5, ed6;
    Button b1;
    InventoryDBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        ed1 = findViewById(R.id.pdtname);
        ed2 = findViewById(R.id.pdtmodel);
        ed3 = findViewById(R.id.price);
        ed4 = findViewById(R.id.qty);
        ed5 = findViewById(R.id.manufacturer);
        ed6 = findViewById(R.id.warranty);
        b1 = findViewById(R.id.btnenter);
        DB = new InventoryDBHelper(this);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String productname = ed1.getText().toString();
                String productmodel = ed2.getText().toString();
                String pricepdt = ed3.getText().toString();
                String quantity = ed4.getText().toString();
                String manu = ed5.getText().toString();
                String war = ed6.getText().toString();

                Boolean updateData = DB.updateData(productname, productmodel, pricepdt, quantity, manu, war);
                if (updateData == true) {
                    Toast.makeText(UpdateActivity.this, "Product updated successfully", Toast.LENGTH_SHORT).show();
                }
                else{
                    if(updateData == false)
                    Toast.makeText(UpdateActivity.this, "No such existing product", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

}