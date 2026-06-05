package DAO;

import DATABASE.DBConnection;
import FILES.FileHandler;
import MODEL.Bill;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class BillDAO {

    // Add Bill
    public void addBill(Bill bill) {

        try {

            Connection con = DBConnection.getConnection();

            String query = "INSERT INTO bills(patient_id, treatment, amount) VALUES (?, ?, ?)";

            PreparedStatement pst = con.prepareStatement(query);

            pst.setInt(1, bill.getPatientId());
            pst.setString(2, bill.getTreatment());
            pst.setDouble(3, bill.getAmount());

            pst.executeUpdate();
            FileHandler.saveBill(
                    bill.getPatientId() + "," +
                            bill.getTreatment() + "," +
                            bill.getAmount()
            );
            System.out.println("Bill Generated Successfully");

        } catch (Exception e) {

            System.out.println(e);

        }
    }

    // View Bills
    public void viewBills() {

        try {

            Connection con = DBConnection.getConnection();

            String query = "SELECT * FROM bills";

            PreparedStatement pst = con.prepareStatement(query);

            ResultSet rs = pst.executeQuery();

            while (rs.next()) {

                System.out.println("Bill ID: " + rs.getInt("bill_id"));
                System.out.println("Patient ID: " + rs.getInt("patient_id"));
                System.out.println("Treatment: " + rs.getString("treatment"));
                System.out.println("Amount: " + rs.getDouble("amount"));

                System.out.println("---------------------------");
            }

        } catch (Exception e) {

            System.out.println(e);

        }
    }
}