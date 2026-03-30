import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ResultsReader {
    public static void main(String[] args) {
        String filename = "results.dat";

        try (DataInputStream input = new DataInputStream(
                new BufferedInputStream(new FileInputStream(filename)))) {
            System.out.println("Student results:");
            while (true) {
                StudentRecord record = readStudentRecord(input);
                System.out.printf("Name: %s, Marks: %d%n", record.getName(), record.getTotalMarks());
            }
        } catch (EOFException eof) {
            // End of file reached; normal termination.
        } catch (FileNotFoundException e) {
            System.err.println("Binary file not found: " + filename);
        } catch (IOException e) {
            System.err.println("Error reading from file: " + e.getMessage());
        }
    }

    private static StudentRecord readStudentRecord(DataInputStream input) throws IOException {
        String name = input.readUTF();
        String registrationNumber = input.readUTF();
        int totalMarks = input.readInt();
        return new StudentRecord(name, registrationNumber, totalMarks);
    }

    private static class StudentRecord {
        private final String name;
        private final String registrationNumber;
        private final int totalMarks;

        public StudentRecord(String name, String registrationNumber, int totalMarks) {
            this.name = name;
            this.registrationNumber = registrationNumber;
            this.totalMarks = totalMarks;
        }

        public String getName() {
            return name;
        }

        public String getRegistrationNumber() {
            return registrationNumber;
        }

        public int getTotalMarks() {
            return totalMarks;
        }
    }
}
