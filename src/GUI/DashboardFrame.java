package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DashboardFrame extends JFrame implements ActionListener {
    JButton viewAppointmentButton;
    JButton addPatientButton;
    JButton viewPatientButton;
    JButton appointmentButton;
    JButton exitButton;
    JButton billingButton;
    JButton viewBillButton;

    public DashboardFrame() {

        setTitle("Dashboard");
        setSize(500, 550);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.WHITE);

        // Add Patient Button
        addPatientButton = new JButton("Add Patient");
        addPatientButton.setBounds(150, 40, 180, 40);addPatientButton.addActionListener(this);
        add(addPatientButton);

        // View Patients Button
        viewPatientButton = new JButton("View Patients");
        viewPatientButton.setBounds(150,100, 180, 40);
        viewPatientButton.addActionListener(this);
        add(viewPatientButton);

        // Appointment Button
        appointmentButton = new JButton("Appointments");
        appointmentButton.setBounds(150, 160, 180, 40);
        appointmentButton.addActionListener(this);
        add(appointmentButton);

        // View Appointment button
        viewAppointmentButton = new JButton("View Appointments");
        viewAppointmentButton.setBounds(150, 220, 180, 40);
        viewAppointmentButton.addActionListener(this);
        add(viewAppointmentButton);
//        Billing Button
        billingButton = new JButton("Generate Bill");
        billingButton.setBounds(150, 280, 180, 40);
        billingButton.addActionListener(this);
        add(billingButton);
//        View Bills Button
        viewBillButton = new JButton("View Bills");
        viewBillButton.setBounds(150, 340, 180, 40);
        viewBillButton.addActionListener(this);
        add(viewBillButton);
        // Exit Button
        exitButton = new JButton("Exit");
        exitButton.setBounds(150, 400, 180, 40);exitButton.addActionListener(this);
        add(exitButton);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == addPatientButton) {

            new AddPatientFrame();
        }

        if (e.getSource() == viewPatientButton) {

            new ViewPatientFrame();
        }
        if (e.getSource() == viewAppointmentButton) {

            new ViewAppointmentFrame();
        }
        if (e.getSource() == appointmentButton) {

            new AppointmentFrame();
        }
        if (e.getSource() == billingButton) {

            new BillingFrame();
        }
        if (e.getSource() == viewBillButton) {

            new ViewBillFrame();
        }
        if (e.getSource() == exitButton) {

            System.exit(0);
        }
    }
}