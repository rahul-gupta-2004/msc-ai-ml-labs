// movies_raw.txt - id, movie name, subscription price
// some records contain missing values or invalid prices, need to create a cleaned file with only valid records
// read each line from txt and skip records with a missing movie name or subscription price
// validate the subscription price field; if the price is not numeric, handle the error using NumberFormatException and continue processing the remaining records
// write all valid movie names and subscription price records into a new file named movies_cleaned.txt, use try-catch-finally blocks for the file handling

package ete;

import java.io.*;

public class prog2 {
    public static void main(String[] args) {
        BufferedReader reader = null;
        BufferedWriter writer = null;

        try {
            // Open the input and output files
            reader = new BufferedReader(new FileReader("movies_raw.txt"));
            writer = new BufferedWriter(new FileWriter("movies_cleaned.txt"));

            String line;
            // Read the file line by line
            while ((line = reader.readLine()) != null) {
                // Ignore empty lines
                if (line.trim().isEmpty()) {
                    continue;
                }

                // Split the line into parts by comma
                String[] parts = line.split(",");

                // Ignore incomplete records (we need id, movie name, and subscription price)
                if (parts.length < 3) {
                    continue;
                }

                String movieName = parts[1].trim();
                String priceStr = parts[2].trim();

                // Skip if movie name or price is missing (empty string)
                if (movieName.isEmpty() || priceStr.isEmpty()) {
                    continue;
                }

                try {
                    // Try to parse the price as a double
                    double price = Double.parseDouble(priceStr);

                    // If valid, write the movie name and price to the new file
                    writer.write(movieName + " - " + price);
                    writer.newLine();
                } catch (NumberFormatException e) {
                    // Handle invalid numeric values and continue
                    System.out.println("Invalid price format for movie: " + movieName);
                }
            }
            System.out.println("Processing completed. Check movies_cleaned.txt");
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
