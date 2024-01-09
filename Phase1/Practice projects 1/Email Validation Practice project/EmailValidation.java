package practice;

import java.util.Arrays;

import java.util.Scanner;

public class EmailValidation {
    public static void main(String[] args) {
        // Array of email IDs
        String[] emailArray = {
            "john.doe@example.com",
            "jane.smith@example.com",
            "bob.jones@example.com",
            "peter.jonson@example.com",
            "tom.12@example.com",
            "alex.r@example.com"
            // Add more email IDs as needed
        };

        // Scanner to get user input
        Scanner scanner = new Scanner(System.in);

        // Prompt user for email ID input
        System.out.print("Enter the email ID to search: ");
        String searchEmail = scanner.nextLine();

        // Close the scanner
        scanner.close();

        // Call the search method and print the result
        boolean isEmailFound = searchEmail(emailArray, searchEmail);
        if (isEmailFound) {
            System.out.println("Email ID found in the array.");
        } else {
            System.out.println("Email ID not found in the array.");
        }
    }

    // Method to search for an email ID in the array
    private static boolean searchEmail(String[] emailArray, String searchEmail) {
        // Use Arrays.asList to convert the array to a list for easy searching
        return Arrays.asList(emailArray).contains(searchEmail);
    }
}

