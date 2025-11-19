package com.bank.core;
import java.math.BigDecimal;
import java.util.*;


public class Bank {

    private String bankName;
    private Map<Integer, Customer> customers;
    private Map<Integer, Account> accounts;

    public Bank(String bankName) {
        this.bankName = bankName;
        this.customers = new HashMap<>();
        this.accounts = new HashMap<>();
    }

     public void addCustomer(Customer customer) {
        customers.put(customer.getId(), customer);
    }

    public Customer getCustomer(int id) {
        return customers.get(id);
    }

    public Collection<Customer> getAllCustomers() {
        return customers.values();
    }

    public void addAccount(Account account) {
        accounts.put(account.getId(), account);
    }

    public Account getAccount(int accountId) {
        return accounts.get(accountId);
    }

    public List<Account> getAccountsByCustomer(int customerId) {
        List<Account> list = new ArrayList<>();
        for (Account acc : accounts.values()) {
            if (acc.getCustomerId() == customerId) {
                list.add(acc);
            }
        }
        return list;
    }

    public Collection<Account> getAllAccounts() {
        return accounts.values();
    }

    public void printSummary() {
        System.out.println("\n===== BANK SUMMARY: " + bankName + " =====");

        System.out.println("\nCustomers:");
        for (Customer c : customers.values()) {
            System.out.println(" - " + c.getFirstname() + " " + c.getSurname());
        }

        System.out.println("\nAccounts:");
        for (Account a : accounts.values()) {
            System.out.println(" - Account " + a.getId() + " | Balance: " + a.getBalance());
        }

        System.out.println("====================================\n");
    }
}
