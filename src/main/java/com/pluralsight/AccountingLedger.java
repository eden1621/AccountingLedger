package com.pluralsight;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;


public class AccountingLedger {
    static Scanner scanner = new Scanner(System.in);
    static final String fileName = "transactions.csv";

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n=== Home Screen ===");
            System.out.println("D) Add Deposit");
            System.out.println("P) Make Payment (Debit)");
            System.out.println("L) Ledger");
            System.out.println("X Exit");
            System.out.println("Choose an option:");
            String choice = scanner.nextLine();

            if (choice.equals("D")) {
                addAccountingLedger(true);
            } else if (choice.equals("P")) ;
            addAccountingLedger(false);
        } else if (choice.equals("L")) {
            showTransactions();
        } else if (choice.equals("X")) {
            System.out.println("Exit");

            break;
        } else {
            System.out.println("Try again");

        }
    }

}

static void addTransactions(boolean isDeposit) {
    try (FileWriter fw = new FileWriter(filename, true);
         BufferedWriter bw = new BufferedWriter(fw)) {

        LocalDate today = LocalDate.now();
        LocalTime now = LocalTime.now();

        System.out.print("What is it for?");
        System.out.print("Who is the vendor");
        String vendor = AccountingLedger.scanner.nextLine();
        System.out.print("How much money?");
        double amount = Double.parseDouble(AccountingLedger.scanner.nextLine());

        if (!isDeposit) {
            //if we spend money, it is negative

            amount = -amount;
        }
        Object description;
        String line = today + "|" + now.withNano(0) + "|" + description + "|" + vendor + "|" + amount;
        bw.write(line);
        bw.newLine();

        System.out.println("Saved your transaction");
    } catch (IOException e) {
        System.out.println("Something wrong");

    }

}

static void showTransactions() {

    try (BufferedReader br = new BufferedReader(new File))
    System.out.println("\n=== your Transactions ===");
    String line;
    while ((line = br.readLine()) != null) {
        Systme.out.print(line);

    }
}catch(IOException ){
        System.out.

println("You don't have transction yet");

}
