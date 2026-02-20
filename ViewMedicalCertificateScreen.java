import javax.swing.*;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.util.Map;

class ViewMedicalCertificateScreen {

    private MedicalSystemGUI medicalSystem;

    public ViewMedicalCertificateScreen(MedicalSystemGUI medicalSystem) {
        this.medicalSystem = medicalSystem;
    }

    public void display() {
        Map<String, MedicalSystemGUI.Patient> patients = medicalSystem.getPatients();

        Object[][] data = new Object[patients.size()][3];
        int row = 0;

        for (MedicalSystemGUI.Patient patient : patients.values()) {
            data[row][0] = patient.getName();
            data[row][1] = (patient.hasMedicalCertificate() ? "Yes" : "No");
            data[row][2] = patient.getMcDays();
            row++;
        }
        String[] columnNames = {"Name", "Medical Certificate", "MC Days"};

        JTable table = new JTable(data, columnNames);
        JTableHeader header = table.getTableHeader();
        header.setBackground(Color.LIGHT_GRAY); 

        JScrollPane scrollPane = new JScrollPane(table);

        JPanel panel = new JPanel(new BorderLayout());
        panel.add(scrollPane, BorderLayout.CENTER);

        JFrame mainFrame = medicalSystem.getMainFrame();

        Dimension mainScreenSize = mainFrame.getSize();

        JOptionPane.showMessageDialog(
                mainFrame,
                panel,
                "Medical Certificates",
                JOptionPane.PLAIN_MESSAGE,
                null
        );

        mainFrame.setSize(mainScreenSize);
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setVisible(true);
    }
}
