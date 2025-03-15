package com.example.a2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

public class PersonalDetailsActivity extends AppCompatActivity {
    private EditText etFullName, etEmail;
    private CVData cvData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal_details);

        cvData = CVData.getInstance();

        etFullName = findViewById(R.id.etFullName);
        etEmail = findViewById(R.id.etEmail);
        Button btnSave = findViewById(R.id.btnSave);
        Button btnDiscard = findViewById(R.id.btnDiscard);

        // Load existing data if available
        etFullName.setText(cvData.getFullName());
        etEmail.setText(cvData.getEmail());

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cvData.setFullName(etFullName.getText().toString());
                cvData.setEmail(etEmail.getText().toString());
                finish(); // Go back to MainActivity
            }
        });

        btnDiscard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish(); // Go back without saving
            }
        });
    }
}
