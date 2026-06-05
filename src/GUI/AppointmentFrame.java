package GUI;

import DAO.AppointmentDAO;
import MODEL.Appointment;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AppointmentFrame extends JFrame implements ActionListener {

    JLabel patientLabel;
    JLabel doctorLabel;
    JLabel dateLabel;
    JLabel treatmentLabel;

    JTextField patientField;
    JTextField doctorField;
    JTextField dateField;
    JTextField treatmentField;

    JButton addButton;

    public AppointmentFrame() {

        setTitle("Appointment Management");
        setSize(400, 350);
        setLayout(null);
        setLocationRelativeTo(null);

        // Patient Name
        patientLabel = new JLabel("Patient Name:");
        patientLabel.setBounds(40, 40, 120, 25);
        add(patientLabel);

        patientField = new JTextField();
        patientField.setBounds(170, 40, 150, 25);
        add(patientField);

        // Doctor Name
        doctorLabel = new JLabel("Doctor Name:");
        doctorLabel.setBounds(40, 80, 120, 25);
        add(doctorLabel);

        doctorField = new JTextField();
        doctorField.setBounds(170, 80, 150, 25);
        add(doctorField);

        // Appointment Date
        dateLabel = new JLabel("Appointment Date:");
        dateLabel.setBounds(40, 120, 120, 25);
        add(dateLabel);

        dateField = new JTextField();
        dateField.setBounds(170, 120, 150, 25);
        add(dateField);

        // Treatment
        treatmentLabel = new JLabel("Treatment:");
        treatmentLabel.setBounds(40, 160, 120, 25);
        add(treatmentLabel);

        treatmentField = new JTextField();
        treatmentField.setBounds(170, 160, 150, 25);
        add(treatmentField);

        // Button
        addButton = new JButton("Book Appointment");
        addButton.setBounds(110, 230, 170, 35);
        addButton.addActionListener(this);
        add(addButton);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String patientName = patientField.getText();
        String doctorName = doctorField.getText();
        String appointmentDate = dateField.getText();
        String treatment = treatmentField.getText();

        Appointment appointment = new Appointment(
                patientName,
                doctorName,
                appointmentDate,
                treatment
        );

        AppointmentDAO dao = new AppointmentDAO();

        dao.addAppointment(appointment);

        JOptionPane.showMessageDialog(this,
                "Appointment Booked Successfully");

        dispose();

        new DashboardFrame();

        // Clear Fields
        patientField.setText("");
        doctorField.setText("");
        dateField.setText("");
        treatmentField.setText("");
    }
}