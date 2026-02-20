import javax.swing.*;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.util.Map;

class ListPatientsScreen {

    private MedicalSystemGUI medicalSystem;

    public ListPatientsScreen(MedicalSystemGUI medicalSystem) {
        this.medicalSystem = medicalSystem;
    }

    public void display() {
        Map<String, MedicalSystemGUI.Patient> patients = medicalSystem.getPatients();

        Object[][] data = new Object[patients.size()][7]; 
        int row = 0;

        for (MedicalSystemGUI.Patient patient : patients.values()) {
            data[row][0] = patient.getName();
            data[row][1] = patient.getAge();
            data[row][2] = patient.getFindings();
            data[row][3] = patient.getDiagnosis();
            data[row][4] = patient.getMedication();
            data[row][5] = (patient.hasMedicalCertificate() ? "Yes" : "No");
            data[row][6] = patient.getMcDays();
            row++;
        }

        String[] columnNames = {"Name", "Age", "Findings", "Diagnosis", "Medication", "Medical Certificate", "MC Days"};

        JTable table = new JTable(data, columnNames);

        JTableHeader header = table.getTableHeader();
        header.setBackground(Color.LIGHT_GRAY);

        JScrollPane scrollPane = new JScrollPane(table);

        JPanel panel = new JPanel(new GridLayout(1, 1));
        panel.add(scrollPane);

        JFrame listPatientsFrame = new JFrame("All Patients");
        listPatientsFrame.getContentPane().add(panel);

        listPatientsFrame.setSize(1080, 720);
        listPatientsFrame.setLocationRelativeTo(null);
        listPatientsFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 
        listPatientsFrame.setVisible(true);
    }
}
