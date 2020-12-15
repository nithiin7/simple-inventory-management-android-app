package com.nithin.mrp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.nithin.mrp.database.InventoryDBHelper;

public class RemoveActivity extends AppCompatActivity {

    EditText ed1;
    Button b1;
    InventoryDBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_remove);

        ed1 = findViewById(R.id.pdtname3);
        b1 = findViewById(R.id.btndelete);
        DB = new InventoryDBHelper(this);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String productmodel = ed1.getText().toString();

                Boolean deleteData = DB.deleteOneRow(productmodel);

                if (deleteData == false) {
                    Toast.makeText(RemoveActivity.this, "No such product to delete", Toast.LENGTH_SHORT).show();
                } else  {
                    Toast.makeText(RemoveActivity.this, "Product deleted successfully", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
