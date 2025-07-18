import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\n===== MAIN MENU =====");
            System.out.println("1. Save Drugs to File");
            System.out.println("2. Read Drugs from File");
            System.out.println("3. Save Patient to Database");
            System.out.println("4. Read Patients from Database");
            System.out.println("5. Exit");
            System.out.print("Enter your choice (1-5): ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    List<Drug> drugsToSave = new ArrayList<>();

                    System.out.print("Enter number of drugs to add: ");
                    int count = Integer.parseInt(scanner.nextLine());

                    for (int i = 0; i < count; i++) {
                        System.out.println("\nDrug #" + (i + 1));
                        System.out.print("ID: ");
                        int id = Integer.parseInt(scanner.nextLine());

                        System.out.print("Name: ");
                        String name = scanner.nextLine();

                        System.out.print("Cost: ");
                        double cost = Double.parseDouble(scanner.nextLine());

                        System.out.print("Dosage: ");
                        String dosage = scanner.nextLine();

                        drugsToSave.add(new Drug(id, name, cost, dosage));
                    }

                    FileManager.saveDrugsToFile(drugsToSave);
                    break;

                case "2":
                    List<Drug> loadedDrugs = FileManager.readDrugsFromFile();
                    System.out.println("\n=== Drugs from File ===");
                    for (Drug d : loadedDrugs) {
                        System.out.println(d);
                    }
                    break;

                case "3":
                    System.out.println("\nEnter new patient details:");
                    System.out.print("ID: ");
                    int pid = Integer.parseInt(scanner.nextLine());

                    System.out.print("First Name: ");
                    String firstName = scanner.nextLine();

                    System.out.print("Last Name: ");
                    String lastName = scanner.nextLine();

                    System.out.print("Date of Birth (e.g., 1990-05-12): ");
                    String dob = scanner.nextLine();

                    Patient newPatient = new Patient(pid, firstName, lastName, dob);
                    DatabaseManager.savePatientToDatabase(newPatient);
                    break;

                case "4":
                    List<Patient> patients = DatabaseManager.readPatientsFromDatabase();
                    System.out.println("\n=== Patients from Database ===");
                    for (Patient p : patients) {
                        System.out.println(p);
                    }
                    break;

                case "5":
                    System.out.println("Exiting program.");
                    running = false;
                    break;

                default:
                    System.out.println("Invalid choice. Please enter 1-5.");
                    break;
            }
        }

        scanner.close();
    }
}