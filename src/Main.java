import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\n==== DRUG FILE MENU ====");
            System.out.println("1. Save Drugs to File");
            System.out.println("2. Read Drugs from File");
            System.out.println("3. Exit");
            System.out.print("Enter your choice (1-3): ");

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
                    System.out.println("Exiting program.");
                    running = false;
                    break;

                default:
                    System.out.println("Invalid choice. Please enter 1, 2 or 3.");
                    break;
            }
        }

        scanner.close();
    }
}