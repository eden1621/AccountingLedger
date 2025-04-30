# 📖 Bank of America – Console-Based Accounting Ledger  
A simple Java console application for managing personal deposits, payments, and financial reports using CSV file storage.

GitHub last commit

## 📜 Project Description  
This Java application allows users to:

💵 Add deposits with a description and vendor  
💳 Record payments (debits)  
📄 View all transactions in a formatted ledger  
📊 Generate reports (month-to-date, previous month, year-to-date, etc.)  
🔍 Search transactions by vendor  
🔁 Navigate easily through menus using simple keyboard input  

It uses custom classes, file handling, and menu-based console interaction.

## 📦 Features  

📖 Add new transactions (deposit/payment)  
✅ Save data persistently to CSV  
📋 View all transactions in a formatted table  
📊 Generate various financial reports  
🔎 Search transactions by vendor  
🛑 Handle user input errors and invalid entries gracefully  

## 💡 How to Run  

1. Clone or download the repository.  
2. Make sure you have **Java 8+** installed.  
3. Navigate to your project directory:  
   ```bash
   cd accounting-ledger
   javac -d out src/com/pluralsight/*.java
   java -cp out com.pluralsight.BankOfAmerica

## 📸 Screenshots

### 🏠 Home Screen:
<img width="176" alt="image" src="https://github.com/user-attachments/assets/df441550-6bb5-4cd1-b5dc-c28e91822ff4" />



### 🧾 Add Deposit or Payment:
Displays how users enter transaction details.

### 📋 Ledger View:
Displays all recorded transactions in a table format.

### 📊 Reports Menu:
Lets users filter results by date or vendor.

### 🗃️ CSV File Entry:
Example of how transaction data is saved in trasaction.csv.

🔍 Interesting Code

``` public static void saveTransactionsToCSV(Transaction transaction) {
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
``` 













   
