import javax.swing.*;

public class SearchPatientScreen {

    private MedicalSystemGUI medicalSystem;

    public SearchPatientScreen(MedicalSystemGUI medicalSystem) {
        this.medicalSystem = medicalSystem;
    }

    public void display() {
        String patientName = JOptionPane.showInputDialog(medicalSystem.getMainFrame(), "Enter patient name:");
        MedicalSystemGUI.Patient foundPatient = getPatientByName(patientName);

        if (foundPatient != null) {
            printPatientInfo(foundPatient); 
        } else {
            JOptionPane.showMessageDialog(medicalSystem.getMainFrame(), "Patient not found!");
        }
    }

    private MedicalSystemGUI.Patient getPatientByName(String name) {
        for (MedicalSystemGUI.Patient patient : medicalSystem.getPatients().values()) {
            if (patient.getName().equalsIgnoreCase(name)) {
                return patient;
            }
        }
        return null;
    }

    private void printPatientInfo(MedicalSystemGUI.Patient patient) {
        StringBuilder patientInfo = new StringBuilder("Patient Information:\n");
        patientInfo.append("Name: ").append(patient.getName()).append("\n");
        patientInfo.append("Age: ").append(patient.getAge()).append("\n");
        patientInfo.append("Address: ").append(patient.getAddress()).append("\n");
        patientInfo.append("Complaint: ").append(patient.getSickInfo()).append("\n");
        patientInfo.append("Medication: ").append(patient.getMedication()).append("\n");
        patientInfo.append("Medical Certificate: ").append(patient.hasMedicalCertificate() ? "Yes" : "No");

        JOptionPane.showMessageDialog(medicalSystem.getMainFrame(), patientInfo.toString());
    }
}
