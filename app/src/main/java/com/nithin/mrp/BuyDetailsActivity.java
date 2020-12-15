package com.nithin.mrp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.nithin.mrp.database.OrderHistoryDBHelper;


public class BuyDetailsActivity extends AppCompatActivity {

    TextView pname, pmodel, manufacturer, warranty, total;
    Button confirm, cancel;
    OrderHistoryDBHelper DB;
    String pdtname, pdtmodel, pdtprice, pdtman, pdtwar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy_details);

        pname = (TextView) findViewById(R.id.p_name);
        pmodel = (TextView) findViewById(R.id.p_model);
        manufacturer = (TextView) findViewById(R.id.p_manu);
        warranty = (TextView) findViewById(R.id.p_war);
        total = (TextView) findViewById(R.id.p_totalprice);
        confirm = (Button) findViewById(R.id.btnConfirm);
        cancel = (Button) findViewById(R.id.btnCancel);
        DB = new OrderHistoryDBHelper(this);

        Bundle bundle = getIntent().getExtras();
        final String name = bundle.getString("Pname");
        final String model = bundle.getString("Pmodel");
        final String price = bundle.getString("Pprice");
        final String manu = bundle.getString("Pmanu");
        final String war = bundle.getString("Pwar");

        pname.setText(name);
        pmodel.setText(model);
        total.setText(price);
        manufacturer.setText(manu);
        warranty.setText(war);

        pdtname = name;
        pdtmodel = model;
        pdtprice = price;
        pdtman = manu;
        pdtwar = war;

        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Boolean insert = DB.insertDataCart(pdtname, pdtmodel, pdtprice, pdtman, pdtwar);
                if (insert == true) {
                    Toast.makeText(BuyDetailsActivity.this, "Purchase Successful", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(BuyDetailsActivity.this, "Purchase not Successful. Try Again Later", Toast.LENGTH_SHORT).show();
                }
            }
        });

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), BuyActivity.class);
                startActivity(intent);
            }
        });

    }
}