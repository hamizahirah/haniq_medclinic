import javax.swing.*;
import java.awt.*;

public class MainScreen {

    private MedicalSystemGUI medicalSystem;

    public MainScreen(MedicalSystemGUI medicalSystem) {
        this.medicalSystem = medicalSystem;
    }

    public void display() {
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));
        buttonPanel.setOpaque(false);

        Dimension buttonSize = new Dimension(200, 50);

        JButton receptionistButton = createButton("Receptionist", buttonSize);
        receptionistButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                medicalSystem.switchToReceptionistScreen();
            }
        });

        JButton doctorButton = createButton("Doctor", buttonSize);
        doctorButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                medicalSystem.switchToDoctorScreen();
            }
        });

        JButton searchButton = createButton("Search", buttonSize);
        searchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                medicalSystem.searchForPatient();
            }
        });

        JButton listPatientsButton = createButton("List All Patients", buttonSize);
        listPatientsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                medicalSystem.displayAllPatients();
            }
        });

        JButton deletePatientButton = createButton("Delete Patient", buttonSize);
        deletePatientButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                medicalSystem.deletePatient();
            }
        });

        JButton viewCertificateButton = createButton("View Medical Certificate", buttonSize);
        viewCertificateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                medicalSystem.viewMedicalCertificate();
            }
        });


        buttonPanel.add(Box.createRigidArea(new Dimension(0, 90)));
        buttonPanel.add(receptionistButton);
        buttonPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        buttonPanel.add(doctorButton);
        buttonPanel.add(Box.createRigidArea(new Dimension(0, 5)));
        buttonPanel.add(searchButton);
        buttonPanel.add(Box.createRigidArea(new Dimension(0, 5)));
        buttonPanel.add(listPatientsButton);
        buttonPanel.add(Box.createRigidArea(new Dimension(0, 5)));
        buttonPanel.add(deletePatientButton);
        buttonPanel.add(Box.createRigidArea(new Dimension(0, 5)));
        buttonPanel.add(viewCertificateButton);

        medicalSystem.getMainFrame().add(buttonPanel, BorderLayout.EAST);

        medicalSystem.getMainFrame().setVisible(true);
    }

    private JButton createButton(String text, Dimension size) {
        JButton button = new JButton(text);
        button.setPreferredSize(size);
        button.setMaximumSize(size);
        return button;
    }
}
