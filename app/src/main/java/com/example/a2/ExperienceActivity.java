package com.example.a2;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

public class ExperienceActivity extends AppCompatActivity {

    private EditText etJobTitle, etCompany;
    private Spinner spExperienceDuration;
    private RadioGroup rgEmploymentType;
    private Button btnSave, btnDiscard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_experience);

        etJobTitle = findViewById(R.id.etJobTitle);
        etCompany = findViewById(R.id.etCompany);
        spExperienceDuration = findViewById(R.id.spExperienceDuration);
        rgEmploymentType = findViewById(R.id.rgEmploymentType);
        btnSave = findViewById(R.id.btnSave);
        btnDiscard = findViewById(R.id.btnDiscard);

        // Populate Spinner with experience durations
        String[] durations = {"Less than 1 year", "1-3 years", "3-5 years", "More than 5 years"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, durations);
        spExperienceDuration.setAdapter(adapter);

        // Load existing data if available


        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String jobTitle = etJobTitle.getText().toString().trim();
                String company = etCompany.getText().toString().trim();
                String experienceDuration = spExperienceDuration.getSelectedItem().toString();

                // Get selected employment type
                int selectedId = rgEmploymentType.getCheckedRadioButtonId();
                RadioButton selectedRadioButton = findViewById(selectedId);
                String employmentType = (selectedRadioButton != null) ? selectedRadioButton.getText().toString() : "Not Selected";

                String experienceText = jobTitle + " - " + company + " (" + experienceDuration + ")";
                // Save experience data
                CVData.getInstance().setExperience(experienceText);

                finish();
            }
        });

        btnDiscard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
