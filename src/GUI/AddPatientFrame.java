package GUI;

import DAO.PatientDAO;
import MODEL.Patient;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddPatientFrame extends JFrame implements ActionListener {

    JLabel nameLabel, ageLabel, genderLabel, phoneLabel, diseaseLabel;

    JTextField nameField, ageField, genderField, phoneField, diseaseField;

    JButton addButton;

    public AddPatientFrame() {

        setTitle("Add Patient");
        setSize(400, 400);
        setLayout(null);
        setLocationRelativeTo(null);

        // Name
        nameLabel = new JLabel("Name:");
        nameLabel.setBounds(50, 50, 100, 25);
        add(nameLabel);

        nameField = new JTextField();
        nameField.setBounds(150, 50, 150, 25);
        add(nameField);

        // Age
        ageLabel = new JLabel("Age:");
        ageLabel.setBounds(50, 90, 100, 25);
        add(ageLabel);

        ageField = new JTextField();
        ageField.setBounds(150, 90, 150, 25);
        add(ageField);

        // Gender
        genderLabel = new JLabel("Gender:");
        genderLabel.setBounds(50, 130, 100, 25);
        add(genderLabel);

        genderField = new JTextField();
        genderField.setBounds(150, 130, 150, 25);
        add(genderField);

        // Phone
        phoneLabel = new JLabel("Phone:");
        phoneLabel.setBounds(50, 170, 100, 25);
        add(phoneLabel);

        phoneField = new JTextField();
        phoneField.setBounds(150, 170, 150, 25);
        add(phoneField);

        // Disease
        diseaseLabel = new JLabel("Disease:");
        diseaseLabel.setBounds(50, 210, 100, 25);
        add(diseaseLabel);

        diseaseField = new JTextField();
        diseaseField.setBounds(150, 210, 150, 25);
        add(diseaseField);

        // Button
        addButton = new JButton("Add Patient");
        addButton.setBounds(120, 280, 150, 30);
        addButton.addActionListener(this);
        add(addButton);
        getRootPane().setDefaultButton(addButton);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String name = nameField.getText();
        int age = Integer.parseInt(ageField.getText());
        String gender = genderField.getText();
        String phone = phoneField.getText();
        String disease = diseaseField.getText();

        Patient patient = new Patient(
                name,
                age,
                gender,
                phone,
                disease
        );

        PatientDAO dao = new PatientDAO();

        dao.addPatient(patient);

        JOptionPane.showMessageDialog(this,
                "Patient Added Successfully");

        dispose();

        new DashboardFrame();
    }
}