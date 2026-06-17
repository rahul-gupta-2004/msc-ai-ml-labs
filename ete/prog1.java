// books.txt - id, title, copies
// handle empty lines, missing information, invalid values
// 1. read each lines from books.txt and ignore any empty or incomplete records
// 2. check whether the number of copies is a valid numeric value; if it not numeric, handle the error using NumberFormatException and continue processing the remaining records
// 3. Save only the valid book records (title-copies pairs) into a new file named clean_books.txt, use try-catch-finally blocks for file handling operations

package ete;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class prog1 {
    public static void main(String[] args) {
        BufferedReader reader = null;
        BufferedWriter writer = null;

        try {
            // Open the input and output files
            reader = new BufferedReader(new FileReader("books.txt"));
            writer = new BufferedWriter(new FileWriter("clean_books.txt"));

            String line;
            // Read the file line by line
            while ((line = reader.readLine()) != null) {
                // Ignore empty lines
                if (line.trim().isEmpty()) {
                    continue;
                }

                // Split the line into parts by comma
                String[] parts = line.split(",");

                // Ignore incomplete records (we need id, title, and copies)
                if (parts.length < 3) {
                    continue;
                }

                String title = parts[1].trim();
                String copiesStr = parts[2].trim();

                try {
                    // Try to parse the copies as an integer
                    int copies = Integer.parseInt(copiesStr);

                    // If valid, write the title and copies to the new file
                    writer.write(title + " - " + copies);
                    writer.newLine();
                } catch (NumberFormatException e) {
                    // Handle invalid numeric values and continue
                    System.out.println("Invalid copies format for book: " + title);
                }
            }
            System.out.println("Processing completed. Check clean_books.txt");
        } catch (IOException e) {
            // Handle any file IO errors
            System.out.println("A file error occurred: " + e.getMessage());
        } finally {
            // Use finally block to safely close the files
            try {
                if (reader != null) {
                    reader.close(); // Close the reader
                }
                if (writer != null) {
                    writer.close(); // Close the writer
                }
            } catch (IOException e) {
                System.out.println("Error closing the files.");
            }
        }
    }
}
