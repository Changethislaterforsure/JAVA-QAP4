import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class FileManager {
    private static final String FILE_NAME = "drugs.txt";

    public static void saveDrugsToFile(List<Drug> drugs) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (Drug drug : drugs) {
                String line = drug.getDrugId() + "," + drug.getDrugName() + "," +
                              drug.getDrugCost() + "," + drug.getDosage();
                writer.write(line);
                writer.newLine();  // Move to next line for each drug
            }
            System.out.println("Drugs saved to file successfully.");
        } catch (IOException e) {
            System.out.println("Error saving drugs to file: " + e.getMessage());
        }
    }
}