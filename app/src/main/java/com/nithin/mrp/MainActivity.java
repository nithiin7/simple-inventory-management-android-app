package com.nithin.mrp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.nithin.mrp.database.DBHelper;

public class MainActivity extends AppCompatActivity {

    EditText username, phone, email, password, repassword;
    Button signup, signin;
    DBHelper DB;
    String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = (EditText) findViewById(R.id.username);
        phone = (EditText) findViewById(R.id.phonenumber);
        email = (EditText) findViewById(R.id.email);
        password = (EditText) findViewById(R.id.password);
        repassword = (EditText) findViewById(R.id.repassword);
        signup = (Button) findViewById(R.id.btnsignup);
        signin = (Button) findViewById(R.id.btnsignin);
        DB = new DBHelper(this);


        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = username.getText().toString();
                String ph = phone.getText().toString();
                String emai = email.getText().toString();
                String pass = password.getText().toString();
                String repass = repassword.getText().toString();

                if(user.equals("")||pass.equals("")||repass.equals("")||emai.equals(""))
                    Toast.makeText(MainActivity.this, "Please Enter All The Fields", Toast.LENGTH_SHORT).show();
                else{
                    if(emai.trim().matches(emailPattern)){
                        if(pass.equals(repass)){
                            Boolean checkuser = DB.checkusername(user, emai);
                            if(checkuser==false){
                                Boolean insert = DB.insertData(user,ph, emai, pass);
                                if(insert==true){
                                    Toast.makeText(MainActivity.this, "Registered Successfully", Toast.LENGTH_SHORT).show();
                                    Intent intent = new Intent(getApplicationContext(),UserHomeActivity.class);
                                    intent.putExtra("username",user);
                                    startActivity(intent);
                                }else{
                                    Toast.makeText(MainActivity.this, "Registration Failed", Toast.LENGTH_SHORT).show();
                                }
                            }
                            else{
                                Toast.makeText(MainActivity.this, "User Already Exists! Please Sign In", Toast.LENGTH_SHORT).show();
                            }
                        }else{
                            Toast.makeText(MainActivity.this, "Passwords Not Matching", Toast.LENGTH_SHORT).show();
                        }

                    }
                    else{
                        Toast.makeText(MainActivity.this, "Enter Valid Email", Toast.LENGTH_SHORT).show();
                    }

                } }
        });

        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(intent);
            }
        });
    }
}