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
<img width="440" alt="image" src="https://github.com/user-attachments/assets/142a482f-e95a-4b78-8091-674fcc409c3b" />

### 📋 Ledger View:
<img width="383" alt="image" src="https://github.com/user-attachments/assets/05a7d023-2e48-4ac2-82e5-dea264898a73" />


### 📊 Reports Menu:
<img width="395" alt="image" src="https://github.com/user-attachments/assets/140e3384-1de7-476d-805d-80a1c7d1e483" />


### 🗃️ CSV File Entry:
<img width="401" alt="image" src="https://github.com/user-attachments/assets/2cac69d7-8c6c-40bf-9c69-d222ccd9284a" />


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













   
