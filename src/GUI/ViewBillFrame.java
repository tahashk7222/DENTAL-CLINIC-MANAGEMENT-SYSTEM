package GUI;

import DATABASE.DBConnection;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ViewBillFrame extends JFrame {

    JTable table;
    DefaultTableModel model;

    public ViewBillFrame() {

        setTitle("View Bills");
        setSize(700, 400);
        setLocationRelativeTo(null);

        model = new DefaultTableModel();

        model.addColumn("Bill ID");
        model.addColumn("Patient ID");
        model.addColumn("Treatment");
        model.addColumn("Amount");

        table = new JTable(model);

        JScrollPane pane = new JScrollPane(table);

        add(pane);

        loadBills();

        setVisible(true);
    }

    public void loadBills() {

        try {

            Connection con = DBConnection.getConnection();

            String query = "SELECT * FROM bills";

            PreparedStatement pst = con.prepareStatement(query);

            ResultSet rs = pst.executeQuery();

            while (rs.next()) {

                model.addRow(new Object[]{

                        rs.getInt("bill_id"),
                        rs.getInt("patient_id"),
                        rs.getString("treatment"),
                        rs.getDouble("amount")
                });
            }

        } catch (Exception e) {

            System.out.println(e);
        }
    }
}