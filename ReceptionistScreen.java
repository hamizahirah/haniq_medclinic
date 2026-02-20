import javax.swing.*;
import java.awt.*;


public class ReceptionistScreen {

    private MedicalSystemGUI medicalSystem;

    private JTextField nameField;
    private JTextField ageField;
    private JTextField addressField;
    private JTextField sickInfoField;
    private JTextField nricField;

    public ReceptionistScreen(MedicalSystemGUI medicalSystem) {
        this.medicalSystem = medicalSystem;
    }

    public void display() {

        JPanel panel = new JPanel(null);

        Font smallFont = new Font("Bahnschrift SemiBold", Font.PLAIN, 12);

        JLabel nameLabel = new JLabel("Patient Name:");
        nameField = new JTextField();
        nameField.setFont(smallFont);

        JLabel ageLabel = new JLabel("Age:");
        ageField = new JTextField();
        ageField.setFont(smallFont);

        JLabel addressLabel = new JLabel("Address:");
        addressField = new JTextField();
        addressField.setFont(smallFont);

        JLabel sickInfoLabel = new JLabel("Complaint:");
        sickInfoField = new JTextField();
        sickInfoField.setFont(smallFont);

        JLabel nricLabel = new JLabel("NRIC:");
        nricField = new JTextField();
        nricField.setFont(smallFont);

        JButton saveButton = new JButton("Save");
        saveButton.setFont(smallFont);
        saveButton.addActionListener(e -> {
            String name = nameField.getText();
            int age = Integer.parseInt(ageField.getText());
            String address = addressField.getText();
            String sickInfo = sickInfoField.getText();
            String nric = nricField.getText(); 

            MedicalSystemGUI.Patient patient = medicalSystem.new Patient(name, age, address, sickInfo, nric);
            medicalSystem.getPatients().put(name, patient);

            JOptionPane.showMessageDialog(medicalSystem.getMainFrame(), "Patient information saved successfully!");

            clearFields();
        });

        JButton backButton = createButton("Back");
        backButton.setFont(smallFont);
        backButton.addActionListener(e -> {
            clearFields(); 
            medicalSystem.getMainFrame().getContentPane().removeAll();
            medicalSystem.createMainScreen();
            medicalSystem.getMainFrame().revalidate();
            medicalSystem.getMainFrame().repaint();
        });

        nameLabel.setBounds(350, 220, 200, 30);
        nameField.setBounds(470, 220, 350, 30);
        ageLabel.setBounds(350, 260, 80, 30);
        ageField.setBounds(470, 260, 350, 30);
        addressLabel.setBounds(350, 300, 80, 30);
        addressField.setBounds(470, 300, 350, 30);
        sickInfoLabel.setBounds(350, 340, 150, 30);
        sickInfoField.setBounds(470, 340, 350, 30);
        nricLabel.setBounds(350, 380, 80, 30); 
        nricField.setBounds(470, 380, 350, 30); 
        saveButton.setBounds(420, 440, 150, 30);
        backButton.setBounds(595, 440, 150, 30);

        panel.add(nameLabel);
        panel.add(nameField);
        panel.add(ageLabel);
        panel.add(ageField);
        panel.add(addressLabel);
        panel.add(addressField);
        panel.add(sickInfoLabel);
        panel.add(sickInfoField);
        panel.add(nricLabel);
        panel.add(nricField);
        panel.add(saveButton);
        panel.add(backButton);

        medicalSystem.getMainFrame().add(panel);
        medicalSystem.getMainFrame().setSize(1080, 720);
        medicalSystem.getMainFrame().setLocationRelativeTo(null);
        medicalSystem.getMainFrame().setVisible(true);
    }

    private JButton createButton(String text) {
        JButton button = new JButton(text);
        return button;
    }

    private void clearFields() {
        nameField.setText("");
        ageField.setText("");
        addressField.setText("");
        sickInfoField.setText("");
        nricField.setText("");
    }
}
