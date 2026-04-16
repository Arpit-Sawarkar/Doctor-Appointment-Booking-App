package com.example.mydoctor.ui.auth;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.example.mydoctor.MainActivity;
import com.example.mydoctor.R;
import com.example.mydoctor.database.DatabaseHelper;
public class LoginActivity extends AppCompatActivity {
    private EditText etMobile, etEmail, etPassword;
    private Button btnLogin;
    private DatabaseHelper dbHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            getWindow().clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            getWindow().setStatusBarColor(Color.WHITE);
        }if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            getWindow().getDecorView().setSystemUiVisibility(
                    View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        }
        etMobile = findViewById(R.id.etMobile);
        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);
        btnLogin = findViewById(R.id.btnLogin);
        dbHelper = new DatabaseHelper(this);
        btnLogin.setOnClickListener(v -> loginUser());
    }private void loginUser() {
        String mobile = etMobile.getText().toString().trim();
        String email = etEmail.getText().toString().trim();
        String password = etPassword.getText().toString().trim();
        if (mobile.isEmpty() || mobile.length() != 10) {
            etMobile.setError("Enter valid 10-digit mobile");
            etMobile.requestFocus();
            return;
        }if (email.isEmpty()) {
            etEmail.setError("Enter email");
            etEmail.requestFocus();
            return;
        }if (password.isEmpty()) {
            etPassword.setError("Enter password");
            etPassword.requestFocus();
            return;
        }boolean success = dbHelper.loginUser(mobile, email, password);
        if (success) {
            SharedPreferences sp = getSharedPreferences("auth", MODE_PRIVATE);
            sp.edit()
                    .putBoolean("logged_in", true)
                    .putString("mobile", mobile)
                    .apply();
            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
            intent.putExtra("openProfile", true);
            startActivity(intent);
            finish();
        } else {
            Toast.makeText(this, "Invalid mobile / email / password", Toast.LENGTH_SHORT).show();
        }
      }
    }
