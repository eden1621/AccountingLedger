package com.pluralsight;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class AccountingLedger {
//This is where the file save

    private static String fileName = "main/resource/trasaction.csv";
    //This method saves a transaction to the CSV file
// to save fileName path

    public static void saveTransactionsToCSV(Transaction transaction) {
        try {

            //this helps the writer to the file and true means we keep adding to it
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
            //make one line of text with all the transaction info, separeted by split |

            String csvLine = transaction.getDate() + " | " +
                    transaction.getTime() + "|" +
                    transaction.getDescription() + "|" +
                    transaction.getVendor() + "|" +
                    transaction.getAmount() + "|" ;

                    writer.write(csvLine); //write the line to the file
            writer.newLine(); //adds a new line after each entry
            writer.close();  //close the writer when done

        } catch (IOException e) { //if there is a problem writing the file
            throw new RuntimeException(e); //show the error

        }

    }
}
