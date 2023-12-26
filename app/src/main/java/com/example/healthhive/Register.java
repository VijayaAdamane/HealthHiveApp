package com.example.healthhive;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Register extends AppCompatActivity {

    EditText edUsername,edEmail, edPassword, edConfirmPassword;
    TextView tv ;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        edUsername = findViewById(R.id.editTextFullname);
        edEmail = findViewById(R.id.editTextAddress);
        edPassword = findViewById(R.id.editTextContact);
        edConfirmPassword = findViewById(R.id.editFees);
        btn = findViewById(R.id.btnBook);
        tv = findViewById(R.id.register);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Username = edUsername.getText().toString();
                String EMail = edEmail.getText().toString();
                String Password = edPassword.getText().toString();
                String ConfirmPassword = edConfirmPassword.getText().toString();
                Database db = new Database(getApplicationContext(), "HealthHive" , null , 1);

                if (Username.length() == 0 || EMail.length() == 0 || Password.length() == 0 || ConfirmPassword.length() == 0) {
                    Toast.makeText(Register.this, "Fill all the details !", Toast.LENGTH_SHORT).show();
                } else {
                    if(Password.compareTo(ConfirmPassword) == 0){
                        if(isValid(Password)){
                            db.register(Username , EMail , Password);
                            Toast.makeText(Register.this, "Registration successful", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(Register.this, LoginActivity.class));
                        }else{
                            Toast.makeText(Register.this, "Password must contain 8 characters having letter, digits and special symbols", Toast.LENGTH_SHORT).show();
                        }
                    }else{
                        Toast.makeText(Register.this, "Password and Confirm Password should be same", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });

        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Register.this, LoginActivity.class));
            }
        });
    }

        public static boolean isValid(String Enteredpassword){
            int f1=0, f2=0, f3=0;
            if(Enteredpassword.length() < 8 )
                return false;
            else{
                for(int i=0 ; i<Enteredpassword.length() ; i++){
                        if(Character.isLetter(Enteredpassword.charAt(i)))
                            f1 =1;
                }

                for(int j=0 ; j<Enteredpassword.length() ; j++){
                    if(Character.isDigit(Enteredpassword.charAt(j)))
                        f2 =1;
                }

                for(int k=0 ; k<Enteredpassword.length() ; k++){
                    char c = Enteredpassword.charAt(k);
                    if(c<=33 && c<=46 || c==64)
                        f3=1;
                }

                if(f1==1 && f2==1 && f3==1)
                    return true;
                return false;
            }
        }
    }