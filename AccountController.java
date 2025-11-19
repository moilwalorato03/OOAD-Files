
package com.bank.controller;

import com.bank.GUI.AccountView;
import com.bank.core.Account;
import com.bank.core.Customer;
import com.bank.core.AccountDAO;
import com.bank.core.TransactionDAO;

import java.math.BigDecimal;
import java.util.List;

public class AccountController {

    private MainApp mainApp; 
    private Customer customer;
    private Account selectedAccount;
    private AccountView accountView;
    private AccountDAO accountDAO = new AccountDAO();
    private TransactionDAO txDao = new TransactionDAO();

    public AccountController(Customer customer) {
        this.customer = customer;
        this.accountView = new AccountView(this, customer);
        List<Account> accounts = customer.getAccounts();
        if (!accounts.isEmpty()) {
            this.selectedAccount = accounts.get(0);
        }
        initHandlers();
        refreshAccounts();
    }

    public AccountView getAccountView() {
        return accountView;
    }

    private void initHandlers() {
        accountView.getDepositButton().setOnAction(e -> handleDeposit());
        accountView.getWithdrawButton().setOnAction(e -> handleWithdraw());
        accountView.getApplyInterestButton().setOnAction(e -> handleApplyInterest());
        accountView.getCreateAccountButton().setOnAction(e -> handleCreateAccount());
        accountView.getAccountSelector().setOnAction(e -> handleAccountSelection());
        accountView.getLogoutButton().setOnAction(e -> {
        accountView.showInfo("Logged out");
        });
    }

    private void handleAccountSelection() {
        Account a = accountView.getAccountSelector().getValue();
        if (a != null) {
            selectedAccount = a;
            updateBalanceLabel();
        }
    }

    private void handleDeposit() {
        String text = accountView.getAmountField().getText().trim();
        try {
            BigDecimal amount = new BigDecimal(text);
            if (amount.compareTo(BigDecimal.ZERO) <= 0) {
                accountView.showError("Enter amount > 0");
                return;
            }
            selectedAccount.deposit(amount);
            accountDAO.updateBalance(selectedAccount);
            txDao.record(selectedAccount.getId(), "DEPOSIT", amount.doubleValue());
            accountView.showInfo("Deposit successful: " + amount);
            updateBalanceLabel();
        } catch (NumberFormatException ex) {
            accountView.showError("Enter a valid number.");
        }
    }

    private void handleWithdraw() {
        String text = accountView.getAmountField().getText().trim();
        try {
            BigDecimal amount = new BigDecimal(text);
            if (amount.compareTo(BigDecimal.ZERO) <= 0) {
                accountView.showError("Enter amount > 0");
                return;
            }
            boolean ok = selectedAccount.withdraw(amount);
            if (!ok) {
                accountView.showError("Withdrawal failed (insufficient funds or not allowed).");
                return;
            }
            accountDAO.updateBalance(selectedAccount);
            txDao.record(selectedAccount.getId(), "WITHDRAW", amount.doubleValue());
            accountView.showInfo("Withdrawn: " + amount);
            updateBalanceLabel();
        } catch (NumberFormatException ex) {
            accountView.showError("Enter a valid number.");
        }
    }

    private void handleApplyInterest() {
        if (selectedAccount == null) {
            accountView.showError("Select an account");
            return;
        }
        java.math.BigDecimal interest = selectedAccount.calculateMonthlyInterest();
        if (interest.compareTo(java.math.BigDecimal.ZERO) > 0) {
            selectedAccount.deposit(interest);
            accountDAO.updateBalance(selectedAccount);
            txDao.record(selectedAccount.getId(), "INTEREST", interest.doubleValue());
            accountView.showInfo("Applied interest: " + interest);
            updateBalanceLabel();
        } else {
            accountView.showInfo("This account type has no interest.");
        }
    }

    private void handleCreateAccount() {
        String type = accountView.getNewAccountType();
        String branch = "Main Branch";
        try {
            Account newAcc;
            if ("Savings".equals(type)) {
                newAcc = new com.bank.core.SavingsAccount(0, BigDecimal.ZERO, branch);
            } else if ("Investment".equals(type)) {
                // ensure opening deposit >= 500
                BigDecimal opening = new BigDecimal(accountView.getAmountField().getText().trim());
                if (opening.compareTo(com.bank.core.InvestmentAccount.MIN_OPENING) < 0) {
                    accountView.showError("Investment account requires minimum BWP500.00 opening deposit.");
                    return;
                }
                newAcc = new com.bank.core.InvestmentAccount(0, opening, branch);
            } else { // Cheque
                if (customer.getEmployer() == null || customer.getEmployer().isEmpty()) {
                    accountView.showError("Cheque account requires employer details (customer must be working).");
                    return;
                }
                newAcc = new com.bank.core.ChequeAccount(0, BigDecimal.ZERO, branch);
            }
            accountDAO.insert(customer.getId(), newAcc);
            customer.addAccount(newAcc);
            accountView.showInfo(type + " account created.");
            refreshAccounts();
            updateBalanceLabel();
        } catch (NumberFormatException ex) {
            accountView.showError("Invalid number for opening deposit.");
        }
    }

    private void refreshAccounts() {
        accountView.getAccountSelector().getItems().clear();
        accountView.getAccountSelector().getItems().addAll(customer.getAccounts());
        accountView.getAccountSelector().setConverter(new javafx.util.StringConverter<Account>() {
            @Override
            public String toString(Account account) {
                if (account == null) return "";
                return account.getType() + " - Bal: " + account.getBalance();
            }
            @Override
            public Account fromString(String s) {
                return null;
            }
        });
        if (!customer.getAccounts().isEmpty()) {
            accountView.getAccountSelector().getSelectionModel().select(0);
            selectedAccount = customer.getAccounts().get(0);
            updateBalanceLabel();
        }
    }

    private void updateBalanceLabel() {
        if (selectedAccount != null) {
            accountView.setBalanceText("Balance: P" + selectedAccount.getBalance());
        } else {
            accountView.setBalanceText("Balance: N/A");
        }
    }

    
    private static class MainApp {}
}
