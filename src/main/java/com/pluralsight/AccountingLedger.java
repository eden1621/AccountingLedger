package com.pluralsight;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class AccountingLedger {
//This is where the file save

    private static String fileName = "src/main/resources/trasaction.csv";
    //This method saves a transaction to the CSV file
// to save fileName path

    public static void saveTransactionsToCSV(Transaction transaction) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
            String csvLine = transaction.getDate() + " | " +
                    transaction.getTime() + " | " +
                    transaction.getDescription() + " | " +
                    transaction.getVendor() + " | " +
                    transaction.getAmount();

            writer.write(csvLine);
            writer.newLine();
            System.out.println("Entry saved!");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }



    public static List<Transaction> readTransactionsFromCSV() {
        List<Transaction> transactions = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) { // looping line by line,
                String[] parts = line.split("\\|"); // split the line and get transaction values

                if (parts.length >= 5) {
                    String date = parts[0].trim(); // trim is cutting out spaces, before or after
                    String time = parts[1].trim();
                    String description = parts[2].trim();
                    String vendor = parts[3].trim();
                    double amount = Double.parseDouble(parts[4].trim());

                    Transaction transaction = new Transaction(date, time, description, vendor, amount);
                    transactions.add(transaction);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("Failed to read transactions: " + e.getMessage(), e);
        }
        return transactions;


    }
}



