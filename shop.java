import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class shop {
    public static void main(String[] args) {
        String filename = "sales.txt";
        double totalSales = 0;

        try (Scanner fileScanner = new Scanner(new File(filename))) {
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine().trim();
                if (!line.isEmpty()) {
                    try {
                        double amount = Double.parseDouble(line);
                        totalSales += amount;
                    } catch (NumberFormatException nfe) {
                        System.err.println("Skipping invalid entry: " + line);
                    }
                }
            }
            System.out.printf("Total sales for the day: %.2f%n", totalSales);
        } catch (FileNotFoundException e) {
            System.err.println("Sales file not found: " + filename);
        }
    }
}
