package com.example.a2;

import android.graphics.Bitmap;
import android.util.Base64;

import java.io.ByteArrayOutputStream;

public class CVData {
    private static final CVData instance = new CVData();

    private String fullName, email, phone, summary;
    private String education, experience, certifications, references;
    private String profileImageBase64; // Stores the profile image as Base64

    private CVData() {} // Private constructor

    public static CVData getInstance() {
        return instance;
    }

    // Setters and Getters
    public void setFullName(String fullName) { this.fullName = fullName; }
    public String getFullName() { return fullName; }

    public void setEmail(String email) { this.email = email; }
    public String getEmail() { return email; }

    public void setPhone(String phone) { this.phone = phone; }
    public String getPhone() { return phone; }

    public void setSummary(String summary) { this.summary = summary; }
    public String getSummary() { return summary; }

    public void setEducation(String education) { this.education = education; }
    public String getEducation() { return education; }

    public void setExperience(String experience) { this.experience = experience; }
    public String getExperience() { return experience; }

    public void setCertifications(String certifications) { this.certifications = certifications; }
    public String getCertifications() { return certifications; }

    public void setReferences(String references) { this.references = references; }
    public String getReferences() { return references; }

    // Convert Bitmap to Base64 String
    public void setProfileImage(Bitmap bitmap) {
        if (bitmap != null) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            profileImageBase64 = Base64.encodeToString(byteArray, Base64.DEFAULT);
        }
    }

    // Retrieve Profile Image as Base64 String
    public String getProfileImageBase64() {
        return profileImageBase64;
    }

    // Convert Base64 String back to Bitmap
    public Bitmap getProfileImageBitmap() {
        if (profileImageBase64 != null) {
            byte[] decodedBytes = Base64.decode(profileImageBase64, Base64.DEFAULT);
            return android.graphics.BitmapFactory.decodeByteArray(decodedBytes, 0, decodedBytes.length);
        }
        return null;
    }
}