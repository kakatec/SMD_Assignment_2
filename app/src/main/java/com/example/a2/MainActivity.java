package com.example.a2;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btnProfile).setOnClickListener(view -> openActivity(ProfileActivity.class));
        findViewById(R.id.btnPersonal).setOnClickListener(view -> openActivity(PersonalDetailsActivity.class));
        findViewById(R.id.btnSummary).setOnClickListener(view -> openActivity(SummaryActivity.class));
        findViewById(R.id.btnEducation).setOnClickListener(view -> openActivity(EducationActivity.class));
        findViewById(R.id.btnExperience).setOnClickListener(view -> openActivity(ExperienceActivity.class));
        findViewById(R.id.btnCertifications).setOnClickListener(view -> openActivity(CertificationsActivity.class));
        findViewById(R.id.btnReferences).setOnClickListener(view -> openActivity(ReferencesActivity.class));
        findViewById(R.id.btnPreview).setOnClickListener(view -> openActivity(FinalActivity.class)); // New Preview Button
    }

    private void openActivity(Class<?> activityClass) {
        Intent intent = new Intent(MainActivity.this, activityClass);
        startActivity(intent);
    }
}
