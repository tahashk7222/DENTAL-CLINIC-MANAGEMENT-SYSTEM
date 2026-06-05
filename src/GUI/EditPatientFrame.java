package GUI;

import DAO.PatientDAO;
import MODEL.Patient;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EditPatientFrame extends JFrame implements ActionListener {

    JLabel idLabel;
    JLabel nameLabel;
    JLabel ageLabel;
    JLabel genderLabel;
    JLabel phoneLabel;
    JLabel diseaseLabel;

    JTextField idField;
    JTextField nameField;
    JTextField ageField;
    JTextField genderField;
    JTextField phoneField;
    JTextField diseaseField;

    JButton updateButton;

    public EditPatientFrame() {

        setTitle("Edit Patient");
        setSize(400, 450);
        setLayout(null);
        setLocationRelativeTo(null);

        idLabel = new JLabel("Patient ID:");
        idLabel.setBounds(50, 30, 100, 25);
        add(idLabel);

        idField = new JTextField();
        idField.setBounds(150, 30, 150, 25);
        add(idField);

        nameLabel = new JLabel("Name:");
        nameLabel.setBounds(50, 80, 100, 25);
        add(nameLabel);

        nameField = new JTextField();
        nameField.setBounds(150, 80, 150, 25);
        add(nameField);

        ageLabel = new JLabel("Age:");
        ageLabel.setBounds(50, 120, 100, 25);
        add(ageLabel);

        ageField = new JTextField();
        ageField.setBounds(150, 120, 150, 25);
        add(ageField);

        genderLabel = new JLabel("Gender:");
        genderLabel.setBounds(50, 160, 100, 25);
        add(genderLabel);

        genderField = new JTextField();
        genderField.setBounds(150, 160, 150, 25);
        add(genderField);

        phoneLabel = new JLabel("Phone:");
        phoneLabel.setBounds(50, 200, 100, 25);
        add(phoneLabel);

        phoneField = new JTextField();
        phoneField.setBounds(150, 200, 150, 25);
        add(phoneField);

        diseaseLabel = new JLabel("Disease:");
        diseaseLabel.setBounds(50, 240, 100, 25);
        add(diseaseLabel);

        diseaseField = new JTextField();
        diseaseField.setBounds(150, 240, 150, 25);
        add(diseaseField);

        updateButton = new JButton("Update Patient");
        updateButton.setBounds(120, 320, 150, 30);
        updateButton.addActionListener(this);
        add(updateButton);

        setVisible(true);
    }
    public EditPatientFrame(
            int id,
            String name,
            int age,
            String gender,
            String phone,
            String disease
    ) {

        this();

        idField.setText(String.valueOf(id));
        nameField.setText(name);
        ageField.setText(String.valueOf(age));
        genderField.setText(gender);
        phoneField.setText(phone);
        diseaseField.setText(disease);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        int id = Integer.parseInt(idField.getText());

        Patient patient = new Patient();

        patient.setPatientId(id);
        patient.setName(nameField.getText());
        patient.setAge(Integer.parseInt(ageField.getText()));
        patient.setGender(genderField.getText());
        patient.setPhone(phoneField.getText());
        patient.setDisease(diseaseField.getText());

        PatientDAO dao = new PatientDAO();

        dao.updatePatient(patient);

        JOptionPane.showMessageDialog(
                this,
                "Patient Updated Successfully"
        );

        dispose();
        dispose();

        for (Frame frame : Frame.getFrames()) {

            if (frame instanceof ViewPatientFrame) {

                frame.dispose();
            }
        }

        new ViewPatientFrame();

//        new DashboardFrame();
    }
}