import javax.swing.*;

public class DeletePatientScreen {

    private MedicalSystemGUI medicalSystem;

    public DeletePatientScreen(MedicalSystemGUI medicalSystem) {
        this.medicalSystem = medicalSystem;
    }


    public void display() {
        String patientName = JOptionPane.showInputDialog(medicalSystem.getMainFrame(), "Enter patient name to delete:");

        if (medicalSystem.getPatients().containsKey(patientName)) {
            medicalSystem.getPatients().remove(patientName); 
            JOptionPane.showMessageDialog(medicalSystem.getMainFrame(), "Patient removed successfully!");
        } else {
            JOptionPane.showMessageDialog(medicalSystem.getMainFrame(), "Patient not found!"); 
        }
    }
}
