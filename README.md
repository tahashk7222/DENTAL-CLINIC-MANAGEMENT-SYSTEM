# Dental Clinic Management System

A Java-based desktop application developed for managing the day-to-day operations of a dental clinic. This project was created as part of an Object-Oriented Programming (OOP) course and demonstrates the practical implementation of OOP concepts, database connectivity, file handling, and GUI development.

---

## Project Overview

Managing patient records, appointments, and billing manually can be time-consuming and error-prone. The Dental Clinic Management System provides a simple and efficient solution by allowing clinic staff to manage patients, appointments, and bills through an easy-to-use graphical interface.

The application is developed using **Java Swing** for the GUI and **MySQL** for database management.

---

## Features

### Patient Management

* Add new patients
* View patient records
* Edit patient information
* Delete patient records

### Appointment Management

* Book appointments
* View scheduled appointments
* Delete appointments

### Billing Management

* Generate bills
* View billing records

### Additional Features

* Login system
* MySQL database integration
* File handling for record backup
* GitHub version control

---

## Technologies Used

* Java
* Java Swing
* MySQL
* JDBC
* IntelliJ IDEA
* Git & GitHub

---

## OOP Concepts Implemented

### Encapsulation

Data members are kept private and accessed using getters and setters.

### Inheritance

Common attributes are inherited from the `Person` class.

```text
Person
 ├── Patient
 └── Dentist
```

### Polymorphism

Method overriding is used where appropriate to provide specialized behavior.

### Abstraction

Users interact with the GUI without needing to understand the underlying database implementation.

---

## Project Structure

```text
src
│
├── DAO
│   ├── PatientDAO.java
│   ├── AppointmentDAO.java
│   └── BillDAO.java
│
├── DATABASE
│   └── DBConnection.java
│
├── FILES
│   └── FileHandler.java
│
├── GUI
│   ├── LoginFrame.java
│   ├── DashboardFrame.java
│   ├── AddPatientFrame.java
│   ├── ViewPatientFrame.java
│   ├── EditPatientFrame.java
│   ├── AppointmentFrame.java
│   ├── ViewAppointmentFrame.java
│   ├── BillingFrame.java
│   └── ViewBillFrame.java
│
└── MODEL
    ├── Person.java
    ├── Patient.java
    ├── Dentist.java
    ├── Appointment.java
    └── Bill.java
```

---

## Database

The project uses MySQL for storing application data.

### Main Tables

* patients
* appointments
* bills

Each table uses a primary key with AUTO_INCREMENT to uniquely identify records.

---

## File Handling

To satisfy file handling requirements and provide basic backup functionality, records are also stored in text files:

* patients.txt
* appointments.txt
* bills.txt

---

## How to Run the Project

1. Clone the repository.
2. Open the project in IntelliJ IDEA.
3. Create the required MySQL database and tables.
4. Update database credentials in `DBConnection.java`.
5. Run `Main.java`.

---

## Screenshots

Add screenshots of:

* Login Screen
* Dashboard
* Add Patient
* View Patients
* Appointment Management
* Billing Management

---

## Challenges Faced

During development, the main challenges included:

* Connecting Java with MySQL using JDBC
* Implementing CRUD operations
* Synchronizing GUI components with database records
* Managing file handling alongside database storage

These challenges were resolved using the DAO pattern, JDBC, and structured project organization.

---

## Future Improvements

Possible future enhancements include:

* Search functionality
* Online appointment booking
* Email notifications
* Advanced reporting system
* Multi-user authentication
* Export reports to PDF

---

## Learning Outcomes

Through this project, I gained practical experience in:

* Object-Oriented Programming
* Java Swing GUI Development
* JDBC Database Connectivity
* MySQL Database Management
* File Handling
* GitHub Version Control
* Software Design using DAO Pattern

---

## Author

Developed as an academic OOP project for learning and demonstrating Object-Oriented Programming concepts using Java.
