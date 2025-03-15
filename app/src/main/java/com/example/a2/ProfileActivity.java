package com.example.a2;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import java.io.IOException;

public class ProfileActivity extends AppCompatActivity {
    private static final int PICK_IMAGE = 1;
    private ImageView profileImageView;
    private Button selectImageButton, saveButton, cancelButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        profileImageView = findViewById(R.id.profileImageView);
        selectImageButton = findViewById(R.id.selectImageButton);
        saveButton = findViewById(R.id.saveButton);
        cancelButton = findViewById(R.id.cancelButton);

        // Load saved profile image if available
        Bitmap savedImage = CVData.getInstance().getProfileImageBitmap();
        if (savedImage != null) {
            profileImageView.setImageBitmap(savedImage);
        }

        selectImageButton.setOnClickListener(v -> pickImageFromGallery());
        saveButton.setOnClickListener(v -> saveProfileImage());
        cancelButton.setOnClickListener(v -> finish());
    }

    private void pickImageFromGallery() {
        Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(intent, PICK_IMAGE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == PICK_IMAGE && resultCode == RESULT_OK && data != null) {
            Uri imageUri = data.getData();
            try {
                Bitmap bitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), imageUri);
                profileImageView.setImageBitmap(bitmap);
                CVData.getInstance().setProfileImage(bitmap); // Store image in Singleton
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void saveProfileImage() {
        finish(); // Go back to MainActivity after saving
    }
}
