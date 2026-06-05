package GUI;

import DATABASE.DBConnection;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import DAO.AppointmentDAO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ViewAppointmentFrame extends JFrame implements ActionListener{
    JButton deleteButton;
    JTable table;
    DefaultTableModel model;

    public ViewAppointmentFrame() {

        deleteButton = new JButton("Delete Appointment");

        setTitle("View Appointments");
        setSize(700, 400);
        setLayout(null);
        setLocationRelativeTo(null);

        model = new DefaultTableModel();

        model.addColumn("ID");
        model.addColumn("Patient Name");
        model.addColumn("Doctor Name");
        model.addColumn("Date");
        model.addColumn("Treatment");

        table = new JTable(model);

        JScrollPane pane = new JScrollPane(table);

        add(pane);
        deleteButton = new JButton("Delete Appointment");
        deleteButton.setBounds(250, 320, 180, 30);
        deleteButton.addActionListener(this);

        add(deleteButton);
        pane.setBounds(20, 20, 650, 270);

        loadAppointments();

        setVisible(true);
    }

    public void loadAppointments() {

        try {

            Connection con = DBConnection.getConnection();

            String query = "SELECT * FROM appointments";

            PreparedStatement pst = con.prepareStatement(query);

            ResultSet rs = pst.executeQuery();

            while (rs.next()) {

                model.addRow(new Object[]{

                        rs.getInt("appointment_id"),
                        rs.getString("patient_name"),
                        rs.getString("doctor_name"),
                        rs.getString("appointment_date"),
                        rs.getString("treatment")
                });
            }

        } catch (Exception e) {

            System.out.println(e);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == deleteButton) {

            int row = table.getSelectedRow();

            if (row == -1) {

                JOptionPane.showMessageDialog(
                        this,
                        "Please select an appointment"
                );

                return;
            }

            int appointmentId =
                    (Integer) model.getValueAt(row, 0);

            AppointmentDAO dao =
                    new AppointmentDAO();

            dao.deleteAppointment(appointmentId);

            model.removeRow(row);

            JOptionPane.showMessageDialog(
                    this,
                    "Appointment Deleted Successfully"
            );
        }


    }
}