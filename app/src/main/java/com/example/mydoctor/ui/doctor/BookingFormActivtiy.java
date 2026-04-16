package com.example.mydoctor.ui.doctor;
import android.Manifest;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.*;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import com.example.mydoctor.R;
import com.example.mydoctor.database.DatabaseHelper;
import java.util.ArrayList;
import java.util.Calendar;
public class BookingFormActivtiy extends AppCompatActivity {
    EditText etName, etMobile, etEmail, etAge, etCity, etDisease, etDate, etTime;
    RadioGroup rgGender;
    Button btnBook;
    DatabaseHelper db;
    int selYear, selMonth, selDay, selHour, selMinute;
    String doctorName;
    String doctorMobile;
    String doctoraddress;;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking_form);
        Window window = getWindow();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.setStatusBarColor(getResources().getColor(R.color.white));
        }if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        }if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.SEND_SMS)
                != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(
                    this,
                    new String[]{Manifest.permission.SEND_SMS},
                    100);
        }db = new DatabaseHelper(this);
        doctorName = getIntent().getStringExtra("doctorName");
        doctorMobile = getIntent().getStringExtra("doctorContact");
        doctoraddress = getIntent().getStringExtra("doctoraddress");
        if (doctorName == null) doctorName = "Doctor";
        if (doctorMobile == null) doctorMobile = "";
        if (doctoraddress == null) doctoraddress ="Not Avaailable";
        etName = findViewById(R.id.etPatientName);
        etMobile = findViewById(R.id.etMobile);
        etEmail = findViewById(R.id.etEmail);
        etAge = findViewById(R.id.etAge);
        etCity = findViewById(R.id.etCity);
        etDisease = findViewById(R.id.etDisease);
        etDate = findViewById(R.id.etDate);
        etTime = findViewById(R.id.etTime);
        rgGender = findViewById(R.id.rgGender);
        btnBook = findViewById(R.id.btnBook);
        etDate.setOnClickListener(v -> openDatePicker());
        etTime.setOnClickListener(v -> openTimePicker());
        btnBook.setOnClickListener(v -> bookAppointment());
    }private void openDatePicker() {
        Calendar c = Calendar.getInstance();
        DatePickerDialog dp = new DatePickerDialog(
                this,
                (view, year, month, day) -> {
                    selYear = year;
                    selMonth = month;
                    selDay = day;
                    etDate.setText(day + "/" + (month + 1) + "/" + year);},
                c.get(Calendar.YEAR),
                c.get(Calendar.MONTH),
                c.get(Calendar.DAY_OF_MONTH));
        dp.getDatePicker().setMinDate(System.currentTimeMillis());
        dp.show();
    }private void openTimePicker() {
        Calendar c = Calendar.getInstance();
        TimePickerDialog tp = new TimePickerDialog(
                this,
                (view, hour, minute) -> {
                    selHour = hour;
                    selMinute = minute;
                    etTime.setText(String.format("%02d:%02d", hour, minute));},
                c.get(Calendar.HOUR_OF_DAY),
                c.get(Calendar.MINUTE),
                true);
        tp.show();
    }private void bookAppointment() {
        String name = etName.getText().toString().trim();
        String mobile = etMobile.getText().toString().trim();
        String email = etEmail.getText().toString().trim();
        String ageStr = etAge.getText().toString().trim();
        String city = etCity.getText().toString().trim();
        String disease = etDisease.getText().toString().trim();
        String date = etDate.getText().toString().trim();
        String time = etTime.getText().toString().trim();
        if (name.isEmpty() || mobile.isEmpty() || email.isEmpty()
                || ageStr.isEmpty() || city.isEmpty()
                || date.isEmpty() || time.isEmpty()) {
            Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show();
            return;
        }if (mobile.length() != 10) {
            Toast.makeText(this, "Enter valid 10 digit mobile", Toast.LENGTH_SHORT).show();
            return;}
        int age;
        try {
            age = Integer.parseInt(ageStr);
        } catch (Exception e) {
            Toast.makeText(this, "Invalid age", Toast.LENGTH_SHORT).show();
            return;
        }if (rgGender.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "Select gender", Toast.LENGTH_SHORT).show();
            return;
        }RadioButton rb = findViewById(rgGender.getCheckedRadioButtonId());
        String gender = rb.getText().toString();
        Calendar selected = Calendar.getInstance();
        selected.set(selYear, selMonth, selDay, selHour, selMinute);
        if (selected.before(Calendar.getInstance())) {
            Toast.makeText(this, "Select future date & time", Toast.LENGTH_SHORT).show();
            return;
        }String[] dp = date.split("/");
        String dateTime =
                dp[2] + "-" + dp[1] + "-" + dp[0] + " " + time + ":00";
        boolean inserted = db.insertAppointment(
                doctorName,
                name,
                email,
                mobile,
                age,
                gender,
                city,
                dateTime,
                disease);
        if (inserted) {
            sendSmsToDoctor(
                    doctorMobile,
                    doctorName,
                    doctoraddress,
                    name,
                    age,
                    gender,
                    city,
                    disease,
                    date,
                    time,
                    mobile);
            new AlertDialog.Builder(this)
                    .setTitle("Booking Confirmed")
                    .setMessage(
                            "Doctor: " + doctorName + "\n" +
                                    "Date: " + date + "\n" +
                                    "Time: " + time)
                    .setCancelable(false)
                    .setPositiveButton("OK", (d, w) -> {
                        startActivity(new Intent(this, BookingActivity.class));
                        finish();})
                    .show();} else {
            Toast.makeText(this, "Booking Failed", Toast.LENGTH_SHORT).show();}
    }private void sendSmsToDoctor(
            String doctorMobile,
            String doctorName,
            String doctoraddress,
            String patient,
            int age,
            String gender,
            String city,
            String disease,
            String date,
            String time,
            String userMobile
    ) { try {
            if (doctorMobile == null || doctorMobile.trim().isEmpty()) {
                Toast.makeText(this, "Doctor mobile missing", Toast.LENGTH_SHORT).show();
                return;
            }
            if (userMobile == null || userMobile.trim().isEmpty()) {
                Toast.makeText(this, "User mobile missing", Toast.LENGTH_SHORT).show();
                return;
            }
            if (!doctorMobile.startsWith("+91")) {
                doctorMobile = "+91" + doctorMobile;
            }
            if (!userMobile.startsWith("+91")) {
                userMobile = "+91" + userMobile;
            }
            SmsManager smsManager = SmsManager.getDefault();
        String doctorMsg =
                "New appointment booked on " + date + " at " + time + ".\n" +
                        "Patient : " + patient + ", " +  city + ".\n" +
                        "Complaint : " + disease + ".\n" +
                        "Contact : " + userMobile + ".";
            ArrayList<String> doctorParts =
                    smsManager.divideMessage(doctorMsg);
            smsManager.sendMultipartTextMessage(
                    doctorMobile,
                    null,
                    doctorParts,
                    null,
                    null);
        String userMsg =
                "Hello " + patient + ",\n\n" +
                        "This is a confirmation for your appointment with "
                        + doctorName + " on " + date + " at " + time + ".\n\n" +
                        "Clinic Address : " + doctoraddress + "\n\n" +
                        "Please arrive a few minutes early.\n" +
                        "Thank you.";
            ArrayList<String> userParts =
                    smsManager.divideMessage(userMsg);
            smsManager.sendMultipartTextMessage(
                    userMobile,
                    null,
                    userParts,
                    null,
                    null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    }