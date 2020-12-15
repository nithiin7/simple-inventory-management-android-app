package com.nithin.mrp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.nithin.mrp.database.DBHelper;

public class EditActivity extends AppCompatActivity {

    EditText username, phone, email, password, repassword;
    Button update;
    DBHelper DB;
    String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        update = (Button) findViewById(R.id.btnupdate);
        username = (EditText) findViewById(R.id.username);
        phone = (EditText) findViewById(R.id.phonenumber);
        email = (EditText) findViewById(R.id.email);
        password = (EditText) findViewById(R.id.password);
        repassword = (EditText) findViewById(R.id.repassword);
        DB = new DBHelper(this);

        Bundle bundle = getIntent().getExtras();
        final String name = bundle.getString("username");

        username.setText(name);

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String user = username.getText().toString();
                String ph = phone.getText().toString();
                String emai = email.getText().toString();
                String pass = password.getText().toString();
                String repass = repassword.getText().toString();

                if (user.equals("") || pass.equals("") || repass.equals("") || emai.equals("") || ph.equals(""))
                    Toast.makeText(EditActivity.this, "Please Enter All The Fields", Toast.LENGTH_SHORT).show();
                else {
                    if (emai.trim().matches(emailPattern)) {
                        if (pass.equals(repass)) {
                            Boolean insert = DB.updateProfile(user, ph, emai, pass);
                            if (insert == true) {
                                Toast.makeText(EditActivity.this, "Profile Updated Successfully", Toast.LENGTH_SHORT).show();

                            } else {
                                Toast.makeText(EditActivity.this, "Profile Update Unsuccessful", Toast.LENGTH_SHORT).show();
                            }
                        } else {
                            Toast.makeText(EditActivity.this, "Passwords Not Matching", Toast.LENGTH_SHORT).show();
                        }

                    } else {
                        Toast.makeText(EditActivity.this, "Enter Valid Email", Toast.LENGTH_SHORT).show();
                    }

                }
            }
        });
    }
}

