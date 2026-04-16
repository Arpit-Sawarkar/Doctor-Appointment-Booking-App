package com.example.mydoctor.database;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "mydoctor.db";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_USERS = "users";
    private static final String TABLE_APPOINTMENTS = "appointments";
    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }@Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(
                "CREATE TABLE " + TABLE_USERS + " (" +
                        "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                        "name TEXT," +
                        "email TEXT," +
                        "mobile TEXT UNIQUE," +
                        "password TEXT," +
                        "age INTEGER," +
                        "gender TEXT," +
                        "city TEXT)");
        db.execSQL("CREATE TABLE " + TABLE_APPOINTMENTS + " (" +
                        "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                        "doctor_name TEXT," +
                        "patient_name TEXT," +
                        "patient_email TEXT," +
                        "patient_mobile TEXT," +
                        "age INTEGER," +
                        "gender TEXT," +
                        "city TEXT," +
                        "appointment_datetime TEXT," +
                        "disease TEXT," +
                        "status TEXT)");
    }@Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USERS);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_APPOINTMENTS);
        onCreate(db);
    }public boolean insertUser(
            String name,
            String email,
            String mobile,
            String password,
            int age,
            String gender,
            String city) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("name", name);
        cv.put("email", email);
        cv.put("mobile", mobile);
        cv.put("password", password);
        cv.put("age", age);
        cv.put("gender", gender);
        cv.put("city", city);
        long res = db.insert(TABLE_USERS, null, cv);
        return res != -1;
    }public boolean isUserExists(String mobile) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery(
                "SELECT id FROM " + TABLE_USERS + " WHERE mobile=?",
                new String[]{mobile});
        boolean exists = c.moveToFirst();
        c.close();
        return exists;
    }public boolean loginUser(String mobile, String email, String password) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery(
                "SELECT id FROM users WHERE mobile=? AND email=? AND password=?",
                new String[]{mobile, email, password});
        boolean success = c.moveToFirst();
        c.close();
        return success;
    }public Cursor getUserByMobile(String mobile) {
        SQLiteDatabase db = this.getReadableDatabase();
        return db.rawQuery(
                "SELECT name, email, mobile, age, gender, city FROM " +
                        TABLE_USERS + " WHERE mobile=?",
                new String[]{mobile});
    }public boolean insertAppointment(
            String doctor,
            String patient,
            String email,
            String mobile,
            int age,
            String gender,
            String city,
            String datetime,
            String disease) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("doctor_name", doctor);
        cv.put("patient_name", patient);
        cv.put("patient_email", email);
        cv.put("patient_mobile", mobile);
        cv.put("age", age);
        cv.put("gender", gender);
        cv.put("city", city);
        cv.put("appointment_datetime", datetime);
        cv.put("disease", disease);
        cv.put("status", "Booked");
        long res = db.insert(TABLE_APPOINTMENTS, null, cv);
        return res != -1;
    }
    public Cursor getAllAppointments() {
        SQLiteDatabase db = this.getReadableDatabase();
        return db.rawQuery(
                "SELECT id, doctor_name, patient_name, patient_mobile, appointment_datetime, disease " +
                        "FROM " + TABLE_APPOINTMENTS +
                        " ORDER BY id DESC",
                null);
    }public Cursor getLatestAppointment() {
        SQLiteDatabase db = this.getReadableDatabase();
        return db.rawQuery(
                "SELECT doctor_name, patient_name, patient_mobile, appointment_datetime, disease " +
                        "FROM " + TABLE_APPOINTMENTS +
                        " ORDER BY id DESC LIMIT 1",
                null);
    }
}