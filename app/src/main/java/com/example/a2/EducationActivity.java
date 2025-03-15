package com.example.a2;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

public class EducationActivity extends AppCompatActivity {
    private EditText etEducation;
    private Button btnSave, btnDiscard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_education);

        // Initialize UI components
        etEducation = findViewById(R.id.etEducation);
        btnSave = findViewById(R.id.btnSave);
        btnDiscard = findViewById(R.id.btnDiscard);

        // Load existing education data if available
        etEducation.setText(CVData.getInstance().getEducation());

        // Save button functionality
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String educationText = etEducation.getText().toString().trim();
                CVData.getInstance().setEducation(educationText); // Save to Singleton
                finish(); // Go back to MainActivity
            }
        });

        // Discard button functionality
        btnDiscard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish(); // Just go back without saving
            }
        });
    }
}
