package DAO;

import DATABASE.DBConnection;
import FILES.FileHandler;
import MODEL.Patient;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class PatientDAO {
    public void addPatient(Patient patient) {

        try {

            Connection con = DBConnection.getConnection();

            String query = "INSERT INTO patients(name, age, gender, phone, disease) VALUES (?, ?, ?, ?, ?)";

            PreparedStatement pst = con.prepareStatement(query);

            pst.setString(1, patient.getName());
            pst.setInt(2, patient.getAge());
            pst.setString(3, patient.getGender());
            pst.setString(4, patient.getPhone());
            pst.setString(5, patient.getDisease());

            pst.executeUpdate();
            FileHandler.savePatient(
                    patient.getName() + "," +
                            patient.getAge() + "," +
                            patient.getGender() + "," +
                            patient.getPhone() + "," +
                            patient.getDisease()
            );

            System.out.println("MODEL.Patient Added Successfully");

        } catch (Exception e) {

            System.out.println(e);

        }
    }
    public void viewPatients() {

        try {

            Connection con = DBConnection.getConnection();

            String query = "SELECT * FROM patients";

            PreparedStatement pst = con.prepareStatement(query);

            ResultSet rs = pst.executeQuery();

            while (rs.next()) {

                System.out.println("MODEL.Patient ID: " + rs.getInt("patient_id"));
                System.out.println("Name: " + rs.getString("name"));
                System.out.println("Age: " + rs.getInt("age"));
                System.out.println("Gender: " + rs.getString("gender"));
                System.out.println("Phone: " + rs.getString("phone"));
                System.out.println("Disease: " + rs.getString("disease"));

                System.out.println("---------------------------");
            }

        } catch (Exception e) {

            System.out.println(e);

        }
    }
    public void updatePatient(Patient patient) {

        try {

            Connection con = DBConnection.getConnection();

            String query = "UPDATE patients SET name=?, age=?, gender=?, phone=?, disease=? WHERE patient_id=?";

            PreparedStatement pst = con.prepareStatement(query);

            pst.setString(1, patient.getName());
            pst.setInt(2, patient.getAge());
            pst.setString(3, patient.getGender());
            pst.setString(4, patient.getPhone());
            pst.setString(5, patient.getDisease());
            pst.setInt(6, patient.getPatientId());

            pst.executeUpdate();

            System.out.println("Patient Updated Successfully");

        } catch (Exception e) {

            System.out.println(e);
        }
    }
    public void deletePatient(int patientId) {

        try {

            Connection con = DBConnection.getConnection();

            String query = "DELETE FROM patients WHERE patient_id=?";

            PreparedStatement pst = con.prepareStatement(query);

            pst.setInt(1, patientId);

            pst.executeUpdate();

            System.out.println("Patient Deleted Successfully");

        } catch (Exception e) {

            System.out.println(e);
        }
    }
}
