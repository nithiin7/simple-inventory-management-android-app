package com.nithin.mrp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.nithin.mrp.database.DBHelper;

public class AdminLoginActivity extends AppCompatActivity {

    EditText username, password;
    Button btnlogin;

    private String usernameAdm = "Admin";
    private String passwordAdm = "1234";
    boolean isValid = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_login);

        username = (EditText) findViewById(R.id.usernameAdmin);
        password = (EditText) findViewById(R.id.passwordAdmin);
        btnlogin = (Button) findViewById(R.id.btnsigninAdmin);

        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String user = username.getText().toString();
                String pass = password.getText().toString();

                if(user.isEmpty()||pass.isEmpty())
                    Toast.makeText(AdminLoginActivity.this, "Please Enter All The Fields", Toast.LENGTH_SHORT).show();
                else{
                    isValid = validate(user,pass);
                    if(isValid == true){
                        Toast.makeText(AdminLoginActivity.this, "Sign In Successful", Toast.LENGTH_LONG).show();
                        Intent intent  = new Intent(getApplicationContext(), HomeActivity.class);
                        intent.putExtra("username",usernameAdm);
                        startActivity(intent);
                    }else{
                        Toast.makeText(AdminLoginActivity.this, "Invalid Credentials", Toast.LENGTH_LONG).show();
                    }
                }
            }
        });
    }

    private boolean validate(String name, String password){
        if(name.equals(usernameAdm) && password.equals(passwordAdm)){
            return true;
        }
        else {
            return false;
        }
    }
}