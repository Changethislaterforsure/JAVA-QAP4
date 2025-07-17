import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileManager {
    private static final String FILE_NAME = "drugs.txt";

    // Save a list of Drug objects to the file
    public static void saveDrugsToFile(List<Drug> drugs) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (Drug drug : drugs) {
                String line = drug.getDrugId() + "," + drug.getDrugName() + "," +
                              drug.getDrugCost() + "," + drug.getDosage();
                writer.write(line);
                writer.newLine();
            }
            System.out.println("Drugs saved to file successfully.");
        } catch (IOException e) {
            System.out.println("Error saving drugs to file: " + e.getMessage());
        }
    }

    // Read Drug objects from the file and return them as a list
    public static List<Drug> readDrugsFromFile() {
        List<Drug> drugs = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;

            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                int id = Integer.parseInt(parts[0]);
                String name = parts[1];
                double cost = Double.parseDouble(parts[2]);
                String dosage = parts[3];

                Drug drug = new Drug(id, name, cost, dosage);
                drugs.add(drug);
            }
        } catch (IOException e) {
            System.out.println("Error reading from file: " + e.getMessage());
        }

        return drugs;
    }
}