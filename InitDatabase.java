package com.bank.core;
   

import java.sql.Connection;
import java.sql.Statement;

import java.io.File;
import java.sql.*;

public class InitDatabase {

    public static void main(String[] args) {
        try {
            
            File folder = new File("database");
            if (!folder.exists()) {
                folder.mkdir();
                System.out.println("Created folder: database/");
            }

            String url = "jdbc:sqlite:database/bank.db";
            Connection conn = DriverManager.getConnection(url);
            System.out.println("Connected to SQLite database!");

            Statement stmt = conn.createStatement();

            String createCustomers = "CREATE TABLE IF NOT EXISTS customers (" +
                    "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "firstname TEXT NOT NULL," +
                    "surname TEXT NOT NULL," +
                    "address TEXT," +
                    "employer TEXT," +
                    "username TEXT UNIQUE," +
                    "password TEXT" +
                    ")";
            stmt.execute(createCustomers);
            System.out.println("Customers table ready!");

            String createAccounts = "CREATE TABLE IF NOT EXISTS accounts (" +
                    "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "customer_id INTEGER NOT NULL," +
                    "account_type TEXT NOT NULL," +   
                     "balance REAL NOT NULL," +
                     "branch TEXT NOT NULL," +

                    "created_at TEXT DEFAULT CURRENT_TIMESTAMP," +
                    "FOREIGN KEY(customer_id) REFERENCES customers(id)" +
                    ")";
            stmt.execute(createAccounts);
            System.out.println("Accounts table ready!");

            String createTransactions = "CREATE TABLE IF NOT EXISTS transactions (" +
                    "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "account_id INTEGER NOT NULL," +
                    "type TEXT NOT NULL," +   
                    "amount REAL NOT NULL," +
                    "timestamp TEXT DEFAULT CURRENT_TIMESTAMP," +
                    "FOREIGN KEY(account_id) REFERENCES accounts(id)" +
                    ")";
            stmt.execute(createTransactions);
            System.out.println("Transactions table ready!");

            stmt.close();
            conn.close();
            System.out.println("Database initialization complete!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
