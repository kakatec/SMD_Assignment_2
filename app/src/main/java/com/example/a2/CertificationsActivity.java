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

public class CertificationsActivity extends AppCompatActivity {

    private EditText etCertifications;
    private Spinner spCertificationType;
    private RadioGroup rgLevel;
    private Button btnSave, btnDiscard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_certifications);

        etCertifications = findViewById(R.id.etCertifications);
        spCertificationType = findViewById(R.id.spCertificationType);
        rgLevel = findViewById(R.id.rgLevel);
        btnSave = findViewById(R.id.btnSave);
        btnDiscard = findViewById(R.id.btnDiscard);

        // Populate the Spinner
        String[] certificationTypes = {"Technical", "Management", "Language", "Other"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, certificationTypes);
        spCertificationType.setAdapter(adapter);

        // Load previous data if available
        etCertifications.setText(CVData.getInstance().getCertifications());

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String certificationsText = etCertifications.getText().toString().trim();
                String selectedType = spCertificationType.getSelectedItem().toString();

                // Get selected RadioButton value
                int selectedId = rgLevel.getCheckedRadioButtonId();
                RadioButton selectedRadioButton = findViewById(selectedId);
                String selectedLevel = (selectedRadioButton != null) ? selectedRadioButton.getText().toString() : "Not Selected";

                // Save data
                String fullCertificationDetails = certificationsText + " - " + selectedType + " (" + selectedLevel + ")";
                CVData.getInstance().setCertifications(fullCertificationDetails);

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
