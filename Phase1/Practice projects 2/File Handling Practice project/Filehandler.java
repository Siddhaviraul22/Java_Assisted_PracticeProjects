package practice;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Filehandler {
    public static void main(String[] args) {
        // Specify the file path
        String filePath = "sample.txt";

        // Get user input for content to write
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter content to write to the file: ");
        String contentToWrite = scanner.nextLine();

        // Write to a file
        writeToFile(filePath, contentToWrite);

        // Read from a file
        String content = readFromFile(filePath);
        System.out.println("File content: " + content);

        // Get user input for content to append
        System.out.print("Enter content to append to the file: ");
        String contentToAppend = scanner.nextLine();

        // Append to a file
        appendToFile(filePath, contentToAppend);

        // Read the updated file content
        content = readFromFile(filePath);
        System.out.println("Updated file content: " + content);

        // Close the scanner
        scanner.close();
    }

    // Method to write to a file
    private static void writeToFile(String filePath, String content) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write(content);
            System.out.println("Content written to the file successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Method to read from a file
    private static String readFromFile(String filePath) {
        StringBuilder content = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return content.toString();
    }

    // Method to append to a file
    private static void appendToFile(String filePath, String content) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
            writer.write(content);
            System.out.println("Content appended to the file successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
