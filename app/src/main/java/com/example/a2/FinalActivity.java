package com.example.a2;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class FinalActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final);

        // Enable Back Button in Action Bar
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setTitle("CV Preview"); // Set title
        }

        CVData data = CVData.getInstance();

        // Set profile image
        ImageView profileImageView = findViewById(R.id.profileImageView);
        Bitmap profileImage = data.getProfileImageBitmap();
        if (profileImage != null) {
            profileImageView.setImageBitmap(profileImage);
        }

        // Set Text Fields
        ((TextView) findViewById(R.id.tvFullName)).setText(data.getFullName());
        ((TextView) findViewById(R.id.tvContact)).setText(
                "Email: " + data.getEmail() + " | Phone: " + data.getPhone());

        ((TextView) findViewById(R.id.tvSummary)).setText(data.getSummary());
        ((TextView) findViewById(R.id.tvEducation)).setText(data.getEducation());
        ((TextView) findViewById(R.id.tvExperience)).setText(data.getExperience());
        ((TextView) findViewById(R.id.tvCertifications)).setText(data.getCertifications());
        ((TextView) findViewById(R.id.tvReferences)).setText(data.getReferences());
    }

    // Handle Back Button Click
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish(); // Go back to MainActivity
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
