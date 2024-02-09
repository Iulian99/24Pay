package com.example.a24pay.LoginRegister;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.a24pay.databinding.ActivityRegisterBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class RegisterActivity extends AppCompatActivity {
    ActivityRegisterBinding activityRegisterBinding;
    String email,password;
    FirebaseDatabase db;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_register);
        activityRegisterBinding = ActivityRegisterBinding.inflate(getLayoutInflater());
        setContentView(activityRegisterBinding.getRoot());
        Button buttonLogin = activityRegisterBinding.loginBtn;
        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RegisterActivity.this,LoginActivity.class));
            }
        });
        activityRegisterBinding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                email = activityRegisterBinding.editTextTextEmailAddress.getText().toString();
                password = activityRegisterBinding.editTextTextPassword.getText().toString();

                if(!email.isEmpty() && !password.isEmpty()){
                    Users users = new Users(email,password);
                    db = FirebaseDatabase.getInstance();
                    reference = db.getReference("Users");
                    reference.child(users.email).setValue(users).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            activityRegisterBinding.editTextTextEmailAddress.setText("");
                            activityRegisterBinding.editTextTextPassword.setText("");
                            Toast.makeText(RegisterActivity.this, "Successfuly Updated", Toast.LENGTH_SHORT).show();
                        }
                    });
                }

//                email = activityRegisterBinding.editTextTextEmailAddress.getText().toString();
//                password = activityRegisterBinding.editTextTextPassword.getText().toString();
//
//                if(!email.isEmpty() && !password.isEmpty()){
//                    // Add more validations here as necessary
//                    Users users = new Users(email, password);
//                    db = FirebaseDatabase.getInstance();
//                    reference = db.getReference("Users");
//                    reference.child(users.email).setValue(users).addOnCompleteListener(new OnCompleteListener<Void>() {
//                        @Override
//                        public void onComplete(@NonNull Task<Void> task) {
//                            if(task.isSuccessful()) {
//                                activityRegisterBinding.editTextTextEmailAddress.setText("");
//                                activityRegisterBinding.editTextTextPassword.setText("");
//                                Toast.makeText(RegisterActivity.this, "Successfully Updated", Toast.LENGTH_SHORT).show();
//                            } else {
//                                Toast.makeText(RegisterActivity.this, "Failed to Update: " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
//                            }
//                        }
//                    });
//                } else {
//                    Toast.makeText(RegisterActivity.this, "Email and Password cannot be empty", Toast.LENGTH_SHORT).show();
//                }
            }
        });
    }
}