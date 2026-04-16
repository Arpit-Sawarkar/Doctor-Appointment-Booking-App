package com.example.mydoctor.model;
public class Appointment {
    private int id;
    private String doctorName;
    private String patientName;
    private String phone;
    private String date;
    private String time;
    private String disease;
    public Appointment(String doctorName, String patientName, String phone,
                       String date, String time, String disease) {
        this.doctorName = doctorName;
        this.patientName = patientName;
        this.phone = phone;
        this.date = date;
        this.time = time;
        this.disease = disease;
    }public Appointment(int id, String doctorName, String patientName, String phone,
                       String date, String time, String disease) {
        this.id = id;
        this.doctorName = doctorName;
        this.patientName = patientName;
        this.phone = phone;
        this.date = date;
        this.time = time;
        this.disease = disease;
    }public int getId() { return id; }
    public String getDoctorName() { return doctorName; }
    public String getPatientName() { return patientName; }
    public String getPhone() { return phone; }
    public String getDate() { return date; }
    public String getTime() { return time; }
    public String getDisease() { return disease; }
    public void setId(int id) { this.id = id; }
    public void setDoctorName(String doctorName) { this.doctorName = doctorName; }
    public void setPatientName(String patientName) { this.patientName = patientName; }
    public void setPhone(String phone) { this.phone = phone; }
    public void setDate(String date) { this.date = date; }
    public void setTime(String time) { this.time = time; }
    public void setDisease(String disease) { this.disease = disease; }
}
