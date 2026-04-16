package com.example.mydoctor.ui.doctor;
import java.io.Serializable;
public class Doctor implements Serializable {
    public String name;
    public String specialty;
    public String qualification;
    public String experience;
    public String address;
    public String fees;
    public String description;
    public int photoResId;
    public String contactNumber;
    public Doctor(String name,
                  String specialty,
                  String qualification,
                  String experience,
                  String address,
                  String fees,
                  String description,
                  int photoResId,
                  String contactNumber) {
        this.name = name;
        this.specialty = specialty;
        this.qualification = qualification;
        this.experience = experience;
        this.address = address;
        this.fees = fees;
        this.description = description;
        this.photoResId = photoResId;
        this.contactNumber = contactNumber;
    }
}
