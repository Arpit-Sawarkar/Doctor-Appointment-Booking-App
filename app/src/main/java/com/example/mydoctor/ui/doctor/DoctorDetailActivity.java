package com.example.mydoctor.ui.doctor;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.RelativeSizeSpan;
import android.text.style.StyleSpan;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.example.mydoctor.MainActivity;
import com.example.mydoctor.R;
public class DoctorDetailActivity extends AppCompatActivity {
    ImageView imgDoctor, imgVerified;
    TextView tvDoctorName, tvSpecialization, tvQualification,
            tvAddress, tvExperience, tvFees,
            tvContactNumber, tvServiceTitle, tvServiceDesc, tvVerified;
    Button btnBookConsultancy;
    Doctor doctor;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_detail);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            getWindow().setStatusBarColor(Color.WHITE);
            getWindow().getDecorView().setSystemUiVisibility(
                    View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        }imgDoctor = findViewById(R.id.imgDoctor);
        imgVerified = findViewById(R.id.imgVerified);
        tvDoctorName = findViewById(R.id.tvDoctorName);
        tvSpecialization = findViewById(R.id.tvSpecialization);
        tvQualification = findViewById(R.id.tvQualification);
        tvAddress = findViewById(R.id.tvAddress);
        tvExperience = findViewById(R.id.tvExperience);
        tvFees = findViewById(R.id.tvFees);
        tvContactNumber = findViewById(R.id.tvContactNumber);
        tvServiceTitle = findViewById(R.id.tvService);
        tvServiceDesc = findViewById(R.id.tvServiceDesc);
        tvVerified = findViewById(R.id.tvVerified);
        btnBookConsultancy = findViewById(R.id.btnBookConsultancy);
        imgVerified.setVisibility(View.VISIBLE);
        tvVerified.setVisibility(View.VISIBLE);
        doctor = (Doctor) getIntent().getSerializableExtra("doctor");
        if (doctor == null) {
            Toast.makeText(this, "Doctor data not found", Toast.LENGTH_SHORT).show();
            finish();
            return;
        }tvDoctorName.setText(doctor.name);
        tvSpecialization.setText(doctor.specialty + " Doctor");
        imgDoctor.setImageResource(doctor.photoResId);
        tvQualification.setText(getFormattedLabel("Education", doctor.qualification));
        tvAddress.setText(getFormattedLabel("Address", doctor.address));
        tvExperience.setText(getFormattedLabel("Experience", doctor.experience));
        tvFees.setText(getFormattedLabel("Consultancy Fees", doctor.fees));
        tvContactNumber.setText(getFormattedLabel("Contact", doctor.contactNumber));
        tvServiceTitle.setText("About Doctor");
        tvServiceDesc.setText(doctor.description);
        btnBookConsultancy.setOnClickListener(v -> {
            SharedPreferences sp = getSharedPreferences("auth", MODE_PRIVATE);
            boolean isLoggedIn = sp.getBoolean("logged_in", false);
            if (!isLoggedIn) {
                Toast.makeText(
                        DoctorDetailActivity.this,
                        "Please login to book appointment",
                        Toast.LENGTH_SHORT).show();
                Intent i = new Intent(
                        DoctorDetailActivity.this,
                        MainActivity.class);
                i.putExtra("openProfile", true);
                startActivity(i);
                return;
            }Intent i = new Intent(
                    DoctorDetailActivity.this,
                    BookingFormActivtiy.class);
            i.putExtra("doctorName", doctor.name);
            i.putExtra("doctorSpecialty", doctor.specialty);
            i.putExtra("doctorContact", doctor.contactNumber);
            i.putExtra("doctoraddress", doctor.address);
            startActivity(i);});
    }private SpannableString getFormattedLabel(String label, String value) {
        String text = label + " : " + value;
        SpannableString ss = new SpannableString(text);
        ss.setSpan(
                new StyleSpan(Typeface.BOLD),
                0,
                label.length() + 1,
                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        ss.setSpan(
                new RelativeSizeSpan(1.05f),
                0,
                label.length() + 1,
                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        return ss;
    }
}