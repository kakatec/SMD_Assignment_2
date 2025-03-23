package com.example.a2;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

public class EducationActivity extends AppCompatActivity {

    private EditText etInstitution, etGraduationYear;
    private Spinner spDegree;
    private RadioGroup rgEducationType;
    private Button btnSave, btnDiscard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_education);

        etInstitution = findViewById(R.id.etInstitution);
        etGraduationYear = findViewById(R.id.etGraduationYear);
        spDegree = findViewById(R.id.spDegree);
        rgEducationType = findViewById(R.id.rgEducationType);
        btnSave = findViewById(R.id.btnSave);
        btnDiscard = findViewById(R.id.btnDiscard);

        // Populate Spinner with degrees
        String[] degrees = {"High School", "Bachelor's", "Master's", "PhD"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, degrees);
        spDegree.setAdapter(adapter);

        // Load existing data if available


        // Date picker for Graduation Year
        etGraduationYear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar calendar = Calendar.getInstance();
                int year = calendar.get(Calendar.YEAR);

                DatePickerDialog datePicker = new DatePickerDialog(EducationActivity.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int selectedYear, int month, int dayOfMonth) {
                                etGraduationYear.setText(String.valueOf(selectedYear));
                            }
                        }, year, 0, 1);
                datePicker.show();
            }
        });

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String institution = etInstitution.getText().toString().trim();
                String degree = spDegree.getSelectedItem().toString();
                String graduationYear = etGraduationYear.getText().toString().trim();

                // Get selected education type
                int selectedId = rgEducationType.getCheckedRadioButtonId();
                RadioButton selectedRadioButton = findViewById(selectedId);
                String educationType = (selectedRadioButton != null) ? selectedRadioButton.getText().toString() : "Not Selected";

                // Save education data
                String educationText = institution + " - " + degree + " (" + graduationYear + ")";
                CVData.getInstance().setEducation(educationText);
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
