package com.example.a2;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class PersonalDetailsActivity extends AppCompatActivity {
    private EditText etFullName, etEmail, etPhone;
    private CVData cvData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal_details);

        cvData = CVData.getInstance();

        etFullName = findViewById(R.id.etFullName);
        etEmail = findViewById(R.id.etEmail);
        etPhone = findViewById(R.id.etPhone);
        Button btnSave = findViewById(R.id.btnSave);
        Button btnDiscard = findViewById(R.id.btnDiscard);

        // Load existing data if available
        etFullName.setText(cvData.getFullName());
        etEmail.setText(cvData.getEmail());
        etPhone.setText(cvData.getPhone());

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validateInput()) {
                    cvData.setFullName(etFullName.getText().toString().trim());
                    cvData.setEmail(etEmail.getText().toString().trim());
                    cvData.setPhone(etPhone.getText().toString().trim());
                    Toast.makeText(PersonalDetailsActivity.this, "Data Saved Successfully", Toast.LENGTH_SHORT).show();
                    finish(); // Go back to MainActivity
                }
            }
        });

        btnDiscard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish(); // Go back without saving
            }
        });
    }

    private boolean validateInput() {
        String fullName = etFullName.getText().toString().trim();
        String email = etEmail.getText().toString().trim();
        String phone = etPhone.getText().toString().trim();

        if (TextUtils.isEmpty(fullName)) {
            etFullName.setError("Full Name is required!");
            return false;
        }

        if (TextUtils.isEmpty(email)) {
            etEmail.setError("Email is required!");
            return false;
        } else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            etEmail.setError("Invalid email format!");
            return false;
        }

        if (TextUtils.isEmpty(phone)) {
            etPhone.setError("Phone number is required!");
            return false;
        } else if (!Patterns.PHONE.matcher(phone).matches() || phone.length() < 10 || phone.length() > 15) {
            etPhone.setError("Invalid phone number!");
            return false;
        }

        return true;
    }
}
