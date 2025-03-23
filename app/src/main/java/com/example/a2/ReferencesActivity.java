package com.example.a2;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.ArrayAdapter;
import androidx.appcompat.app.AppCompatActivity;

public class ReferencesActivity extends AppCompatActivity {

    private EditText etReferences, etRefereeName, etRefereeContact;
    private Spinner spReferenceType;
    private RadioGroup rgAvailability;
    private Button btnSave, btnDiscard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_references);

        etReferences = findViewById(R.id.etReferences);
        etRefereeName = findViewById(R.id.etRefssereeName);
        etRefereeContact = findViewById(R.id.etRefereeContact);
        spReferenceType = findViewById(R.id.spReferenceType);
        rgAvailability = findViewById(R.id.rgAvailability);
        btnSave = findViewById(R.id.btnSave);
        btnDiscard = findViewById(R.id.btnDiscard);

        // Populate Spinner with Reference Types
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this, R.array.reference_types, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spReferenceType.setAdapter(adapter);

        // Load saved reference details
        etReferences.setText(CVData.getInstance().getReferences());

        btnSave.setOnClickListener(v -> {
            String referenceText = etReferences.getText().toString().trim();
            String refereeName = etRefereeName.getText().toString().trim();
            String refereeContact = etRefereeContact.getText().toString().trim();
            String referenceType = spReferenceType.getSelectedItem().toString();

            int selectedAvailabilityId = rgAvailability.getCheckedRadioButtonId();
            String availability = (selectedAvailabilityId != -1) ?
                    ((RadioButton) findViewById(selectedAvailabilityId)).getText().toString() : "Unknown";

            // Combine all reference details into a single string
            String fullReference = refereeName + " | " + refereeContact + " | " + referenceType + " | " + availability + "\n" + referenceText;
            CVData.getInstance().setReferences(fullReference);

            finish();
        });

        btnDiscard.setOnClickListener(v -> finish());
    }
}
