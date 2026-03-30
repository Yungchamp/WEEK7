import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class BorrowedBooks {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the title of the borrowed book: ");
        String bookTitle = scanner.nextLine().trim();

        if (bookTitle.isEmpty()) {
            System.out.println("No title entered. Exiting without saving.");
            scanner.close();
            return;
        }

        String filename = "borrowed_books.txt";

        try (FileWriter fileWriter = new FileWriter(filename, true);
             PrintWriter printWriter = new PrintWriter(fileWriter)) {
            printWriter.println(bookTitle);
            System.out.println("Title stored successfully in " + filename + ".");
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }

        scanner.close();
    }
}
