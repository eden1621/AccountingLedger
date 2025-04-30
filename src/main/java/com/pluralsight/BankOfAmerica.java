package com.pluralsight;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.YearMonth;
import java.util.List;
import java.util.Scanner;

import static com.pluralsight.AccountingLedger.readTransactionsFromCSV;
import static com.pluralsight.AccountingLedger.saveTransactionsToCSV;

public class BankOfAmerica {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        //get input
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
                    saveTransactionsToCSV(transaction);  // to save
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

                    saveTransactionsToCSV(paymentTransaction); // create the report

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
/// /////////////////////////////////////
    //create Ledger
    private static void displayLedger() {
        System.out.println("\n=== Ledger Menu ===");
        System.out.println("A) All");

        System.out.println("D) Deposit");

        System.out.println("P) Payment");

        System.out.println("R) Report");
        System.out.println("H) Home");
        System.out.print("Enter your Choice: ");

        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine().toUpperCase();

        //User choice to make a payment .//                //create a method
        // Check the user's choice and take the appropriate action
        // Check the user's choice and take the appropriate action
        switch (input) {
            case "A":
                // Let the user know what's happening
                System.out.println("You selected: Show All Entries");
                displayAllLedger();
                break;

            case "D":
                System.out.println("You selected: Show Deposit Entries");
                //create method
                displayDeposit();

                break;

            case "P":
                System.out.println("You selected: Show Payment Entries");
                displayPayment();
                break;

            case "R":
                System.out.println("You selected: Report Menu");
                reportMenu();
                break;

            case "H":
                System.out.println("You selected: Exit");
                return;

            default:
                System.out.println("Invalid option. Please try again.");
                break;
        }
    }

    private static void displayPayment() {
        List<Transaction> transactions = readTransactionsFromCSV();
        displayLedgerHeader(); // display header
        for (Transaction transaction : transactions) {
            // if the money less than 0 then it will be deposit then it will be display on the console
            if(transaction.getAmount()<=0) {
                displaySingleLedger(transaction);
            }
        }
    }
//create a method . it will only select the deposit

    private static void displayDeposit() {
        List<Transaction> transactions = readTransactionsFromCSV();
        displayLedgerHeader(); // display header
        for (Transaction transaction : transactions) {
            // if the money greter than 0 then it will be deposit then it will be display on the console
            if(transaction.getAmount()>=0) {
            displaySingleLedger(transaction);
            }
        }

    }

    private static void displayAllLedger() {
        //list of transaction objects that will read from files // all
         List<Transaction> transactions = readTransactionsFromCSV();
         displayLedgerHeader(); // display header
         for (Transaction transaction : transactions) {
             displaySingleLedger(transaction); //
         }

    }
    public static void displayLedgerHeader() {
        System.out.printf("%-12s | %-20s | %-20s | %-15s | %10s\n",
                "Date", "Time", "Description", "Vendor", "Amount");
        System.out.println("-------------------------------------------------------------------------------");
    }

    // Display a single transaction in table format
    public static void displaySingleLedger(Transaction transaction) {
        System.out.printf("%-12s | %-20s | %-20s | %-15s | %10.2f\n",
                transaction.getDate(),
                transaction.getTime(),
                transaction.getDescription(),
                transaction.getVendor(),
                transaction.getAmount());
    }


    public static void reportMenu() {
        while (true) {
            System.out.println("\n=== Reports Menu ===");
            System.out.println("1) Month To Date");
            System.out.println("2) Previous Month");
            System.out.println("3) Year To Date");
            System.out.println("4) Previous Year");
            System.out.println("5) Search by Vendor");
            System.out.println("0) Back to Ledger Menu");
            System.out.print("Choose an option: ");

           // String input = Scanner.nextLine();

            // Ask the user what they want to do
            System.out.print("What do you want to see? Type a number: ");

           // Scanner scanner = new Scanner(System.in);

            String choice = scanner.nextLine().toUpperCase();
// This part reads the user's choice and sends it to a method
            // This part reads the user's choice and sends it to a method
            switch (choice) {
                case "1":
                    System.out.println("You chose: This Month");
                    displayMonthToDate(); // call method
                    break;

                case "2":
                    System.out.println("You chose: Last Month");
                    displayPreviousMonth();
                    break;

                case "3":
                    System.out.println("You chose: This Year");
                    displayYearToDate();
                    break;

                case "4":
                    System.out.println("You chose: Last Year");
                    displayPreviousYear();
                    break;

                case "5":
                    System.out.println("You chose: Store Search");
                    searchByVendor();
                    break;

                case "0":
                    System.out.println("Going back...");
                    return;

                default: //error
                    System.out.println("Oops! That's not one of the choices. Please try again.");
            }
        }
    }
//created separate methods



    // 1) Show current month transactions
    public static void displayMonthToDate() {
        List<Transaction> transactions = readTransactionsFromCSV();
        YearMonth currentMonth = YearMonth.now();

        displayLedgerHeader();
        for (Transaction t : transactions) {
            if (YearMonth.parse(t.getDate().substring(0, 7)).equals(currentMonth)) { // check if transaction is in this month
                displaySingleLedger(t);
            }
        }
    }

    // 2) Show previous month transactions
    public static void displayPreviousMonth() {
        List<Transaction> transactions = readTransactionsFromCSV();
        YearMonth lastMonth = YearMonth.now().minusMonths(1);

        displayLedgerHeader();
        for (Transaction t : transactions) {
            if (YearMonth.parse(t.getDate().substring(0, 7)).equals(lastMonth)) {
                displaySingleLedger(t);
            }
        }
    }

    // 3) Show current year transactions
    public static void displayYearToDate() {
        List<Transaction> transactions = readTransactionsFromCSV();
        String currentYear = String.valueOf(LocalDate.now().getYear());

        displayLedgerHeader();
        for (Transaction t : transactions) {
            if (t.getDate().startsWith(currentYear)) {
                displaySingleLedger(t);
            }
        }
    }

    // 4) Show previous year transactions
    public static void displayPreviousYear() {
        List<Transaction> transactions = readTransactionsFromCSV();
        String lastYear = String.valueOf(LocalDate.now().getYear() - 1);

        displayLedgerHeader();
        for (Transaction t : transactions) {
            if (t.getDate().startsWith(lastYear)) {
                displaySingleLedger(t);
            }
        }
    }

    // 5) Search by vendor
    public static void searchByVendor() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter vendor name to search: ");
        String vendorSearch = scanner.nextLine().trim().toLowerCase();

        List<Transaction> transactions = readTransactionsFromCSV();
        displayLedgerHeader();

        for (Transaction t : transactions) {
            if (t.getVendor().equalsIgnoreCase(vendorSearch)) {
                displaySingleLedger(t);
            }
        }
    }

}









