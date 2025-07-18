import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseManager {
    // Update these with your actual DB info
    private static final String URL = "jdbc:postgresql://localhost:5432/javadata";
    private static final String USER = "keyin";  // <- Replace this
    private static final String PASSWORD = "";               // leave blank if no password

    public static void savePatientToDatabase(Patient p) {
        String sql = "INSERT INTO patients (patient_id, first_name, last_name, dob) VALUES (?, ?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, p.getPatientId());
            stmt.setString(2, p.getPatientFirstName());
            stmt.setString(3, p.getPatientLastName());
            stmt.setString(4, p.getPatientDOB());

            stmt.executeUpdate();
            System.out.println(" Patient saved to database.");
        } catch (SQLException e) {
            System.out.println(" Error saving patient: " + e.getMessage());
        }
    }

    public static List<Patient> readPatientsFromDatabase() {
        List<Patient> patients = new ArrayList<>();
        String sql = "SELECT * FROM patients";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                int id = rs.getInt("patient_id");
                String firstName = rs.getString("first_name");
                String lastName = rs.getString("last_name");
                String dob = rs.getString("dob");

                Patient patient = new Patient(id, firstName, lastName, dob);
                patients.add(patient);
            }
        } catch (SQLException e) {
            System.out.println(" Error reading patients: " + e.getMessage());
        }

        return patients;
    }
}