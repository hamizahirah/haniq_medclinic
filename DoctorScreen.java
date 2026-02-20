import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

public class DoctorScreen {

    private MedicalSystemGUI medicalSystem; 

    private JComboBox<String> patientComboBox;
    private JTextField findingsField;
    private JTextField diagnosisField;
    private JTextField medicationField;
    private JTextField mcDaysField; 
    private JCheckBox medicalCertificateCheckBox;
    private JLabel mcDaysLabel;


    public DoctorScreen(MedicalSystemGUI medicalSystem) {
        this.medicalSystem = medicalSystem;
    }

    public void display() {
        Map<String, MedicalSystemGUI.Patient> patients = medicalSystem.getPatients();
        String[] patientNames = patients.keySet().toArray(new String[0]);

        JPanel panel = new JPanel(null);

        Font smallFont = new Font("Bahnschrift SemiBold", Font.PLAIN, 12);

        JLabel patientLabel = new JLabel("Select Patient:");
        patientComboBox = new JComboBox<>(patientNames);

        JLabel findingsLabel = new JLabel("Findings:");
        findingsField = new JTextField();
        findingsField.setFont(smallFont);

        JLabel diagnosisLabel = new JLabel("Diagnosis:");
        diagnosisField = new JTextField();
        diagnosisField.setFont(smallFont);

        JLabel medicationLabel = new JLabel("Medication:");
        medicationField = new JTextField();
        medicationField.setFont(smallFont);

        mcDaysLabel = new JLabel("MC Days:");
        mcDaysField = new JTextField();
        mcDaysField.setFont(smallFont);

        medicalCertificateCheckBox = new JCheckBox("Medical Certificate");

        JButton submitButton = new JButton("Submit");
        submitButton.setFont(smallFont);
        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String selectedPatient = (String) patientComboBox.getSelectedItem();
                MedicalSystemGUI.Patient patient = patients.get(selectedPatient);

                String findings = findingsField.getText();
                String diagnosis = diagnosisField.getText();
                String medication = medicationField.getText();
                int mcDays = Integer.parseInt(mcDaysField.getText()); 

                patient.setFindings(findings);
                patient.setDiagnosis(diagnosis);
                patient.setMedication(medication);
                patient.setMedicalCertificate(medicalCertificateCheckBox.isSelected());
                patient.setMcDays(mcDays);

                JOptionPane.showMessageDialog(medicalSystem.getMainFrame(), "Doctor's information saved successfully!");

                clearFields();
            }
        });

        JButton backButton = createButton("Back");
        backButton.setFont(smallFont);
        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                clearFields();
                medicalSystem.getMainFrame().getContentPane().removeAll();
                medicalSystem.createMainScreen();
                medicalSystem.getMainFrame().revalidate();
                medicalSystem.getMainFrame().repaint();
            }
        });

        patientLabel.setBounds(350, 220, 150, 30);
        patientComboBox.setBounds(470, 220, 350, 30);
        findingsLabel.setBounds(350, 270, 150, 30);
        findingsField.setBounds(470, 270, 350, 30);
        diagnosisLabel.setBounds(350, 310, 150, 30);
        diagnosisField.setBounds(470, 310, 350, 30);
        medicationLabel.setBounds(350, 350, 150, 30);
        medicationField.setBounds(470, 350, 350, 30);
        mcDaysLabel.setBounds(600, 390, 160, 30);
        mcDaysField.setBounds(700, 390, 120, 30);
        medicalCertificateCheckBox.setBounds(350, 390, 200, 30);
        submitButton.setBounds(420, 460, 150, 30);
        backButton.setBounds(595, 460, 150, 30);

        panel.add(patientLabel);
        panel.add(patientComboBox);
        panel.add(findingsLabel);
        panel.add(findingsField);
        panel.add(diagnosisLabel);
        panel.add(diagnosisField);
        panel.add(medicationLabel);
        panel.add(medicationField);
        panel.add(mcDaysLabel);
        panel.add(mcDaysField);
        panel.add(medicalCertificateCheckBox);
        panel.add(submitButton);
        panel.add(backButton);

        medicalSystem.getMainFrame().add(panel);
        medicalSystem.getMainFrame().setSize(1080, 720);
        medicalSystem.getMainFrame().setLocationRelativeTo(null);
        medicalSystem.getMainFrame().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        medicalSystem.getMainFrame().setVisible(true);
    }

    private JButton createButton(String text) {
        JButton button = new JButton(text);
        return button;
    }

    private void clearFields() {
        patientComboBox.setSelectedIndex(0);
        findingsField.setText("");
        diagnosisField.setText("");
        medicationField.setText("");
        mcDaysField.setText("");
        medicalCertificateCheckBox.setSelected(false);
    }
}
