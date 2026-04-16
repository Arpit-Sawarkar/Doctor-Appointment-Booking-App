package com.example.mydoctor.ui.auth;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import com.example.mydoctor.MainActivity;
import com.example.mydoctor.R;
import com.example.mydoctor.database.DatabaseHelper;
public class SignupActivity extends AppCompatActivity {
    private EditText etName, etMobile, etEmail, etPassword, etAge, etCity;
    private RadioGroup rgGender;
    private Button btnSignup;
    private DatabaseHelper dbHelper;
    private String gender = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            getWindow().clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            getWindow().setStatusBarColor(Color.WHITE);
        }if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            getWindow().getDecorView().setSystemUiVisibility(
                    View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        }
        etName = findViewById(R.id.etName);
        etMobile = findViewById(R.id.etMobile);
        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);
        etAge = findViewById(R.id.etAge);
        etCity = findViewById(R.id.etCity);
        rgGender = findViewById(R.id.rgGender);
        btnSignup = findViewById(R.id.btnSignup);
        dbHelper = new DatabaseHelper(this);
        rgGender.setOnCheckedChangeListener((group, checkedId) -> {
            if (checkedId == R.id.rbMale) gender = "Male";
            else if (checkedId == R.id.rbFemale) gender = "Female";
        });
        btnSignup.setOnClickListener(v -> signupUser());
    }private void signupUser() {
        String name = etName.getText().toString().trim();
        String mobile = etMobile.getText().toString().trim().replaceAll("\\s+", "");
        String email = etEmail.getText().toString().trim().toLowerCase();
        String password = etPassword.getText().toString().trim();
        String ageStr = etAge.getText().toString().trim();
        String city = etCity.getText().toString().trim();
        if (name.isEmpty() || mobile.length() != 10 || email.isEmpty() ||
                password.isEmpty() || ageStr.isEmpty() || city.isEmpty() || gender.isEmpty()) {
            Toast.makeText(this, "Fill all fields correctly", Toast.LENGTH_SHORT).show();
            return;
        }if (dbHelper.isUserExists(mobile)) {
            Toast.makeText(this, "User already exists", Toast.LENGTH_SHORT).show();
            return;
        }boolean inserted = dbHelper.insertUser(
                name,
                email,
                mobile,
                password,
                Integer.parseInt(ageStr),
                gender,
                city);
        if (inserted) {
            SharedPreferences sp = getSharedPreferences("auth", MODE_PRIVATE);
            sp.edit()
                    .putBoolean("logged_in", true)
                    .putString("mobile", mobile)
                    .apply();
            Intent intent = new Intent(SignupActivity.this, MainActivity.class);
            intent.putExtra("openProfile", true);
            startActivity(intent);
            finish();
        } else {
            Toast.makeText(this, "Signup failed, try again", Toast.LENGTH_SHORT).show();
        }
    }
}
