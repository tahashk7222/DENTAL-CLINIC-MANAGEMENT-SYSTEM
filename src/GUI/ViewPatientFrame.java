package GUI;

import DAO.PatientDAO;
import DATABASE.DBConnection;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ViewPatientFrame extends JFrame implements ActionListener {

    JTable table;
    DefaultTableModel model;
    JButton editButton;
    JButton deleteButton;

    public ViewPatientFrame() {

        setTitle("View Patients");
        setSize(700, 500);
        setLayout(null);
        setLocationRelativeTo(null);

        model = new DefaultTableModel();

        model.addColumn("ID");
        model.addColumn("Name");
        model.addColumn("Age");
        model.addColumn("Gender");
        model.addColumn("Phone");
        model.addColumn("Disease");

        table = new JTable(model);

        JScrollPane pane = new JScrollPane(table);
        pane.setBounds(20, 20, 650, 270);
        add(pane);

        loadPatients();
        editButton = new JButton("Edit Patient");
        editButton.setBounds(150, 320, 150, 30);
        editButton.addActionListener(this);

        deleteButton = new JButton("Delete Patient");
        deleteButton.setBounds(320, 320, 150, 30);
        deleteButton.addActionListener(this);

        add(editButton);
        add(deleteButton);

        setVisible(true);
    }

    public void loadPatients() {

        try {

            Connection con = DBConnection.getConnection();

            String query = "SELECT * FROM patients";

            PreparedStatement pst = con.prepareStatement(query);

            ResultSet rs = pst.executeQuery();

            while (rs.next()) {

                model.addRow(new Object[]{

                        rs.getInt("patient_id"),
                        rs.getString("name"),
                        rs.getInt("age"),
                        rs.getString("gender"),
                        rs.getString("phone"),
                        rs.getString("disease")
                });
            }

        } catch (Exception e) {

            System.out.println(e);
        }
    }

//    @Override
//    public void actionPerformed(ActionEvent actionEvent) {
//
//    }
    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == deleteButton) {

            int row = table.getSelectedRow();

            if (row == -1) {

                JOptionPane.showMessageDialog(
                        this,
                        "Please select a patient first"
                );

                return;
            }

            int patientId =
                    (Integer) model.getValueAt(row, 0);

            PatientDAO dao = new PatientDAO();

            dao.deletePatient(patientId);

            model.removeRow(row);

            JOptionPane.showMessageDialog(
                    this,
                    "Patient Deleted Successfully"
            );
        }
        if (e.getSource() == editButton) {

            int row = table.getSelectedRow();

            if (row == -1) {

                JOptionPane.showMessageDialog(
                        this,
                        "Please select a patient first"
                );

                return;
            }
            int id = (Integer) model.getValueAt(row, 0);
            String name = (String) model.getValueAt(row, 1);
            int age = (Integer) model.getValueAt(row, 2);
            String gender = (String) model.getValueAt(row, 3);
            String phone = (String) model.getValueAt(row, 4);
            String disease = (String) model.getValueAt(row, 5);

            new EditPatientFrame(
                    id,
                    name,
                    age,
                    gender,
                    phone,
                    disease
            );

        }
    }
}