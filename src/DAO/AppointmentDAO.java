package DAO;
import DATABASE.DBConnection;
import FILES.FileHandler;
import MODEL.Appointment;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AppointmentDAO {

    // Add Appointment
    public void addAppointment(Appointment appointment) {

        try {

            Connection con = DBConnection.getConnection();

            String query = "INSERT INTO appointments(patient_name, doctor_name, appointment_date, treatment) VALUES (?, ?, ?, ?)";

            PreparedStatement pst = con.prepareStatement(query);

            pst.setString(1, appointment.getPatientName());
            pst.setString(2, appointment.getDoctorName());
            pst.setString(3, appointment.getAppointmentDate());
            pst.setString(4, appointment.getTreatment());

            pst.executeUpdate();
            FileHandler.saveAppointment(
                    appointment.getPatientName() + "," +
                            appointment.getDoctorName() + "," +
                            appointment.getAppointmentDate() + "," +
                            appointment.getTreatment()
            );

            System.out.println("Appointment Added Successfully");

        } catch (Exception e) {

            System.out.println(e);

        }
    }

    // View Appointments
    public void viewAppointments() {

        try {

            Connection con = DBConnection.getConnection();

            String query = "SELECT * FROM appointments";

            PreparedStatement pst = con.prepareStatement(query);

            ResultSet rs = pst.executeQuery();

            while (rs.next()) {

                System.out.println("Appointment ID: " + rs.getInt("appointment_id"));
                System.out.println("Patient Name: " + rs.getString("patient_name"));
                System.out.println("Doctor Name: " + rs.getString("doctor_name"));
                System.out.println("Appointment Date: " + rs.getString("appointment_date"));
                System.out.println("Treatment: " + rs.getString("treatment"));

                System.out.println("-----------------------------");
            }

        } catch (Exception e) {

            System.out.println(e);

        }
    }
//    Delete Appointment
public void deleteAppointment(int appointmentId) {

    try {

        Connection con = DBConnection.getConnection();

        String query =
                "DELETE FROM appointments WHERE appointment_id=?";

        PreparedStatement pst =
                con.prepareStatement(query);

        pst.setInt(1, appointmentId);

        pst.executeUpdate();

        System.out.println(
                "Appointment Deleted Successfully"
        );

        }
    catch (Exception e)
        {

            System.out.println(e);
        }
    }
}
