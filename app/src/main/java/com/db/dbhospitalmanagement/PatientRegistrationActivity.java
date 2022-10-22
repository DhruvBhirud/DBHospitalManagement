package com.db.dbhospitalmanagement;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

import de.hdodenhof.circleimageview.CircleImageView;

public class PatientRegistrationActivity extends AppCompatActivity {

    private TextView regPageQuestion;
    private TextInputEditText registrationFullName,registrationIdNumber,registrationPhoneNumber,
                              loginEmail,loginPassword;
    private Button regButton;
    private CircleImageView profileImage;
    private Uri resultUri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_registration);

        regPageQuestion = findViewById(R.id.regPageQuestion);
        regPageQuestion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PatientRegistrationActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });

        registrationFullName = findViewById(R.id.registrationFullName);
        registrationIdNumber = findViewById(R.id.registrationIdNumber);
        registrationPhoneNumber = findViewById(R.id.registrationPhoneNumber);
        loginEmail = findViewById(R.id.loginEmail);
        loginPassword = findViewById(R.id.loginPassword);
        regButton = findViewById(R.id.regButton);
        profileImage = findViewById(R.id.profileImage);

        profileImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_PICK);
                intent.setType("image/*");
                startActivityForResult(intent,1);
            }
        });

        regButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String email = loginEmail.getText().toString().trim();
                final String password = loginPassword.getText().toString().trim();
                final String fullName = registrationFullName.getText().toString().trim();
                final String idNumber = registrationIdNumber.getText().toString().trim();
                final String phoneNumber = registrationPhoneNumber.getText().toString().trim();

                if (TextUtils.isEmpty(email)) {
                    loginEmail.setError("Email is required!");
                    return;
                }
                if (TextUtils.isEmpty(email)) {
                    loginPassword.setError("Password is required!");
                    return;
                }
                if (TextUtils.isEmpty(email)) {
                    registrationFullName.setError("Name is required!");
                    return;
                }
                if (TextUtils.isEmpty(email)) {
                    registrationIdNumber.setError("ID Number is required!");
                    return;
                }
                if (TextUtils.isEmpty(email)) {
                    registrationPhoneNumber.setError("Phone Number is required!");
                    return;
                }
                if (resultUri==null){
                    Toast.makeText(PatientRegistrationActivity.this,"Profile Photo is Needed",
                            Toast.LENGTH_SHORT).show();
                }
                else{

                }
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode==1 && resultCode== Activity.RESULT_OK && data!=null){
            resultUri=data.getData();
            profileImage.setImageURI(resultUri);
        }
    }
}