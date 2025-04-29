package com.pluralsight;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

public class BankOfAmerica {
    public static void main(String[] args) {
        //get input
        Scanner scanner = new Scanner(System.in);
        // this keeps the program running
        boolean running = true;
        //this loop keeps showing the menu until the user chooses to exit
        while (true) {
            System.out.println("\n==Home Screen");
            System.out.println("D) Add Deposit");
            System.out.println("P) Make Payment (Debit)");
            System.out.println("L) Ledger");
            System.out.println("X Exit");
            System.out.println("Choose an option:");
            //read the user choice
            String input = scanner.nextLine().toUpperCase();
            //If user chooses to add money

            switch (input) {
                //User choice to make a payment
                case "D":
                    System.out.println("D) Add Deposits");
//transaction detail
                    System.out.print("Enter description: ");
                    String description = scanner.nextLine();
                    System.out.println("who is the vendor: ");
                    String vendor = scanner.nextLine();
                    System.out.println("Please enter amount");
                    System.out.println("Choose an option: ");
                    Double amount = Double.parseDouble(scanner.nextLine());

                    //
                    LocalDate date = LocalDate.now(); // get today's date
                    LocalTime time = LocalTime.now();  // get the current time

                    //to convert date and time type to String . we can use .toString
                    Transaction transaction = new Transaction(date.toString(), time.toString(), description, vendor, amount);
                    AccountingLedger.saveTransactionsToCSV(transaction);  // to save
                    System.out.println("Deposit saved!");
                    break;

// customer making a payment

                case "P":
                    System.out.println("\nYou chose to Make a Payment.");

                    System.out.print("Enter description: ");
                    String paymentDescription = scanner.nextLine();

                    System.out.print("Who is the vendor: ");
                    String paymentVendor = scanner.nextLine();

                    System.out.print("Please enter amount: ");
                    double paymentAmount = Double.parseDouble(scanner.nextLine());

                    LocalDate paymentDate = LocalDate.now();
                    LocalTime paymentTime = LocalTime.now();

// Make a new payment transaction (amount is negative) working on case p and has to be the same
                    Transaction paymentTransaction = new Transaction(paymentTime.toString(), paymentDate.toString(), paymentDescription, paymentVendor, -paymentAmount);

                    // (You would usually save this too)
                    System.out.println("Payment saved!");
                    break;
                //Customer chose to view the ledger
                case "L":
                    System.out.println("L) Ledger");
                    displayLedger();
                case "X":
                    System.out.println("Goodbye!");
                    running = false;  // Stop the loop
                    break;

                //error
                default:
                    System.out.println("invalid option. Try again");
            }
        }

    }
//create Ledger
    private static void displayLedger() {

        System.out.println("A) All");

        System.out.println("D) Deposit");

        System.out.println("P) Payment");

        System.out.println("R) Report");

        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine().toUpperCase();
        switch (input) {
            //User choice to make a payment .//                //create a method
            case "A":
                displayAllLedger();


        }

    }
    private static void displayAllLedger() {
    }
}



