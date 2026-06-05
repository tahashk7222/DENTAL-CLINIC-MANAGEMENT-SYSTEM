package GUI;

import DAO.BillDAO;
import MODEL.Bill;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BillingFrame extends JFrame implements ActionListener {

    JLabel patientIdLabel;
    JLabel treatmentLabel;
    JLabel amountLabel;

    JTextField patientIdField;
    JTextField treatmentField;
    JTextField amountField;

    JButton generateButton;

    public BillingFrame() {

        setTitle("Billing System");
        setSize(400, 300);
        setLayout(null);
        setLocationRelativeTo(null);

        // Patient ID
        patientIdLabel = new JLabel("Patient ID:");
        patientIdLabel.setBounds(50, 50, 100, 25);
        add(patientIdLabel);

        patientIdField = new JTextField();
        patientIdField.setBounds(150, 50, 150, 25);
        add(patientIdField);

        // Treatment
        treatmentLabel = new JLabel("Treatment:");
        treatmentLabel.setBounds(50, 100, 100, 25);
        add(treatmentLabel);

        treatmentField = new JTextField();
        treatmentField.setBounds(150, 100, 150, 25);
        add(treatmentField);

        // Amount
        amountLabel = new JLabel("Amount:");
        amountLabel.setBounds(50, 150, 100, 25);
        add(amountLabel);

        amountField = new JTextField();
        amountField.setBounds(150, 150, 150, 25);
        add(amountField);

        // Button
        generateButton = new JButton("Generate Bill");
        generateButton.setBounds(120, 210, 150, 30);
        generateButton.addActionListener(this);
        add(generateButton);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        int patientId = Integer.parseInt(patientIdField.getText());
        String treatment = treatmentField.getText();
        double amount = Double.parseDouble(amountField.getText());

        Bill bill = new Bill(
                0,
                patientId,
                treatment,
                amount
        );

        BillDAO dao = new BillDAO();

        dao.addBill(bill);

        JOptionPane.showMessageDialog(
                this,
                "Bill Generated Successfully"
        );

        dispose();

        new DashboardFrame();
    }
}