package com.example.mydoctor.ui.doctor;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.example.mydoctor.MainActivity;
import com.example.mydoctor.R;
import com.example.mydoctor.database.DatabaseHelper;
public class BookingActivity extends AppCompatActivity {
    LinearLayout bookingsContainer;
    Button btnGoHome;
    DatabaseHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bookings);
        bookingsContainer = findViewById(R.id.bookingsContainer);
        btnGoHome = findViewById(R.id.btnGoHome);
        Window window = getWindow();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.setStatusBarColor(Color.WHITE);
        }if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        }db = new DatabaseHelper(this);
        showLatestBooking();
        btnGoHome.setOnClickListener(v -> {
            Intent i = new Intent(BookingActivity.this, MainActivity.class);
            i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(i);
            finish();
        });
    }private void showLatestBooking() {
        bookingsContainer.removeAllViews();
        Cursor c = db.getLatestAppointment();
        if (c == null || !c.moveToFirst()) {
            TextView tv = new TextView(this);
            tv.setText("No booking found.\nPlease book an appointment first.");
            tv.setTextSize(18);
            tv.setPadding(32, 32, 32, 32);
            bookingsContainer.addView(tv);
            return;
        }String doctor = c.getString(0);
        String patient = c.getString(1);
        String mobile = c.getString(2);
        String dateTime = c.getString(3);
        String disease = c.getString(4);
        String date = "";
        String time = "";
        if (dateTime != null && dateTime.contains(" ")) {
            String[] parts = dateTime.split(" ");
            date = parts[0];
            time = parts[1];
        }TextView tv = new TextView(this);
        tv.setText(
                "✅ Appointment Confirmed\n\n" +
                        " Doctor : " + doctor + "\n" +
                        " Patient : " + patient + "\n" +
                        " Mobile : " + mobile + "\n" +
                        " Date : " + date + "\n" +
                        " Time : " + time + "\n" +
                        " Problem : " + disease);
        tv.setTextSize(17);
        tv.setPadding(32, 32, 32, 32);
        tv.setBackgroundColor(Color.WHITE);
        bookingsContainer.addView(tv);
        c.close();
    }
}
