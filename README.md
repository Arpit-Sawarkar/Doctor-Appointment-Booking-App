# ⚕️Doctor Appointment Booking - Android Application
This is an academic Android-based mobile application developed as part of a project. It allows users to find doctors, view their details, and book appointments easily. The app provides a simple and user-friendly interface for managing doctor consultations without the need to visit clinics physically.

## 📌 Problem Statement
Nowadays, there is a major problem in booking doctor appointments. Sometimes doctors are not available at suitable times, and patients have to visit hospitals physically to book appointments. This creates inconvenience and time consumption. Our application solves this problem by providing a digital appointment booking system.

## 📖 Project Description
This application enables patients to Register and log in, view doctor listings with details, book appointments online, receive SMS confirmation after booking, manage user profile and booking history and all data is managed efficiently using an SQLite database.

## 🎯 Key Features
- User Registration & Login  
- Doctor List with Details  
- Appointment Booking System  
- SMS Confirmation after Booking  
- View Booking History

## 🛠 Technologies Used
### 📱 Frontend:
- XML (UI Design)
### ⚙ Backend:
- Java (Logic & function)
### 🗄 Database:
- SQLite
### 🔧 Tools:
- Android Studio  
- Emulator / Real Device

## 💻 My Role in Project
I worked on both UI and database parts of the project i designed user-friendly interfaces using XML layouts for features like login, signup, and booking screens. i also implemented the database using SQLite, including table creation, data insertion, and data retrieval using SQLiteOpenHelper.

## 📂 Project Structure
```
DoctorAppointBooking
│
├─ Images
├─ README.md
├─ .gitignore
├─ gradle
└─ app
    └─ src
        └─ main
            ├── AndroidManifest.xml
            ├── java
            │    └─ com.example.mydoctor
            │       ├─ MainActivity.java
            │       ├─ database
            │       │   └─ DatabaseHelper.java
            │       ├─ model
            │       │   └─ Appointment.java
            │       ├─ adapter
            │       │   └─ DoctorAdapter.java
            │       ├─ ui
            │           ├─ doctor
            │           │   ├─ Doctor.java
            │           │   ├─ DoctorDetailActivity.java
            │           │   ├─ BookingFormActivtiy.java
            │           │   └─ BookingActivity.java
            │           ├── booking
            │           │    ├─ BookingFragment.java
            │           │    └─ BookingAdapter.java
            │           ├── profile
            │           │    └── ProfileFragment.java
            |           ├── home
            |           |    └── HomeFragment.java
            │           └── auth
            │                ├── LoginActivity.java
            │                └── SignupActivity.java
            └── res
                 │
                 ├── layout
                 │   ├─ activity_main.xml
                 │   ├─ activity_doctor_detail.xml
                 │   ├─ activity_booking_form.xml
                 │   ├─ activity_bookings.xml
                 │   ├─ fragment_booking.xml
                 |   ├─ fragment_home.xml
                 │   ├─ fragment_profile.xml
                 │   ├─ activity_login.xml
                 │   ├─ activity_sign_up.xml
                 │   ├─ item_doctor.xml
                 │   └─ item_booking.xml
                 ├── drawable
                 │   ├── user.png
                 │   ├── check.png
                 │   └── bg_searchcolour.xml
                 └── values
                     ├── colors.xml
                     ├── strings.xml
                     └── themes.xml
```

## ▶ How to Run
### Prerequisites
- Android Studio installed
- Android SDK setup
- Emulator or real device
### Steps to Run
1. Clone the repository
   ```
   git clone https://github.com/Arpit-Sawarkar/Doctor-Appointment-Booking-App.git
   ```
   
## 📸 Screenshots

![Home](images/home.png)

![Booking](images/booking.png)

![Profile](images/profile.png)



  
