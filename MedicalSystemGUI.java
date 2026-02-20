import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class MedicalSystemGUI {

    private JFrame mainFrame; 
    private Map<String, Patient> patients; 

    public MedicalSystemGUI() {
        mainFrame = new JFrame("Medical System");
        mainFrame.setSize(1080, 720);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        mainFrame.setLayout(new BorderLayout());

        ImageIcon backgroundImage = new ImageIcon("Untitled design.png");
        Image img = backgroundImage.getImage();
        Image scaledImg = img.getScaledInstance(mainFrame.getWidth(), mainFrame.getHeight(), Image.SCALE_SMOOTH);
        backgroundImage = new ImageIcon(scaledImg);

        JLabel backgroundLabel = new JLabel(backgroundImage);
        backgroundLabel.setLayout(new BorderLayout());

        mainFrame.setContentPane(backgroundLabel);

        patients = new HashMap<>();

        createMainScreen();
    }

    public void createMainScreen() {
        MainScreen mainScreen = new MainScreen(this);
        mainScreen.display();
    }

    public JButton createButton(String text, Dimension size) {
        JButton button = new JButton(text);
        button.setPreferredSize(size);
        button.setMaximumSize(size);
        return button;
    }

    public void switchToReceptionistScreen() {
        mainFrame.getContentPane().removeAll();
        ReceptionistScreen receptionistScreen = new ReceptionistScreen(this);
        receptionistScreen.display();
        mainFrame.revalidate();
        mainFrame.repaint();
    }

    public void switchToDoctorScreen() {
        mainFrame.getContentPane().removeAll();
        DoctorScreen doctorScreen = new DoctorScreen(this);
        doctorScreen.display();
        mainFrame.revalidate();
        mainFrame.repaint();
    }

    public void searchForPatient() {
        SearchPatientScreen searchPatientScreen = new SearchPatientScreen(this);
        searchPatientScreen.display();
    }

    public void displayAllPatients() {
        ListPatientsScreen listPatientsScreen = new ListPatientsScreen(this);
        listPatientsScreen.display();
    }

    public void deletePatient() {
        DeletePatientScreen deletePatientScreen = new DeletePatientScreen(this);
        deletePatientScreen.display();
    }

    public void viewMedicalCertificate() {
        ViewMedicalCertificateScreen viewCertificateScreen = new ViewMedicalCertificateScreen(this);
        viewCertificateScreen.display();
    }

    public void displayPatientInfo(Patient patient) {
        JOptionPane.showMessageDialog(mainFrame, "Patient Information:\n" +
                "Name: " + patient.getName() +
                "\nAge: " + patient.getAge() +
                "\nAddress: " + patient.getAddress() +
                "\nSick Information: " + patient.getSickInfo() +
                "\nPrescription: " + patient.getPrescription() +
                "\nMedical Certificate: " + (patient.hasMedicalCertificate() ? "Yes" : "No"));
    }

    public Map<String, Patient> getPatients() {
        return patients;
    }

    public JFrame getMainFrame() {
        return mainFrame;
    }

    public class Patient {
        private String name;
        private int age;
        private String address;
        private String sickInfo;
        private String prescription;
        private String findings;
        private String diagnosis;
        private String treatment;
        private String medication;
        private String nric;
        private boolean medicalCertificate;
        private int mcDays;

        public Patient(String name, int age, String address, String sickInfo, String nric) {
            this.name = name;
            this.nric = nric;
            this.mcDays = 0;
            this.age = age;
            this.address = address;
            this.sickInfo = sickInfo;
            this.prescription = "";
            this.medicalCertificate = false;
        }

        public String getName() {
            return name;
        }

        public int getMcDays() {
            return mcDays;
        }

        public void setMcDays(int mcDays) {
            this.mcDays = mcDays;
        }

        public String getNric() {
            return nric;
        }

        public int getAge() {
            return age;
        }

        public String getAddress() {
            return address;
        }

        public String getSickInfo() {
            return sickInfo;
        }

        public String getPrescription() {
            return prescription;
        }

        public void setPrescription(String prescription) {
            this.prescription = prescription;
        }

        public String getFindings() {
            return findings;
        }

        public void setFindings(String findings) {
            this.findings = findings;
        }

        public String getDiagnosis() {
            return diagnosis;
        }

        public void setDiagnosis(String diagnosis) {
            this.diagnosis = diagnosis;
        }

        public String getTreatment() {
            return treatment;
        }

        public void setTreatment(String treatment) {
            this.treatment = treatment;
        }

        public String getMedication() {
            return medication;
        }

        public void setMedication(String medication) {
            this.medication = medication;
        }

        public boolean hasMedicalCertificate() {
            return medicalCertificate;
        }

        public void setMedicalCertificate(boolean medicalCertificate) {
            this.medicalCertificate = medicalCertificate;
        }

        public void setNric(String nric) {
            this.nric = nric;
        }

        public String getNric(String nric) {
            return nric;
        }
    }
}
