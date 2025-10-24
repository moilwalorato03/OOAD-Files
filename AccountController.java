package com.bank.controller;

import com.bank.GUI.*;
import com.bank.GUI.AccountView;
import com.bank.core.Customer;
import com.bank.core.Account;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import java.math.BigDecimal;

public  class AccountController {
private MainApp mainApp;
private AccountView accountView;
private String customerName;
private BigDecimal balance=BigDecimal.ZERO;

public AccountController(MainApp mainApp,String customerName) {
this.mainApp=mainApp;
this.customerName=customerName;
this.accountView=new AccountView();
initHandlers();
}

public void initHandlers() {
accountView.getDepositButton().setOnAction(e->handleDeposit());
accountView.getWithdrawButton().setOnAction(e->handleWithdraw());
accountView.getLogoutButton().setOnAction(e->mainApp.showLoginView());
}

private void handleDeposit() {
try{
   BigDecimal amount=new BigDecimal(accountView.getAmountField().getText());
   if(amount.compareTo(BigDecimal.ZERO)>0){
   balance=balance.add(amount);
   updateBalanceLabel();
   showAlert("Deposit Successful","Deposited:P"+amount,AlertType.INFORMATION);
   }else{
   showAlert("Invalid Amount","Enter an amount greater than 0",AlertType.WARNING);
   }
   }catch(Exception ex) {
   showAlert("Error","Invalid input!Please enter a valid number.",AlertType.ERROR);
   }
   }
   
   private void handleWithdraw() {
   try{
   BigDecimal amount=new BigDecimal(accountView.getAmountField().getText());
   if(amount.compareTo(balance)<=0&&amount.compareTo(BigDecimal.ZERO)>0) {
   balance=balance.subtract(amount);
   updateBalanceLabel();
   showAlert("Withdrawal Successful","Withdrew:P"+amount,AlertType.INFORMATION);
   }else{
   showAlert("Error","Insufficient funds or invalid amount",AlertType.ERROR);
   }
   }catch(Exception ex) {
   showAlert("Error","Invalid input!Please enter a valid number.",AlertType.ERROR);
   }
   }
   
   private void updateBalanceLabel() {
   accountView.getBalanceLabel().setText("Balance:P"+balance);
   }
   
   private void showAlert(String title, String message, AlertType type) {
   Alert alert=new Alert(type);
   alert.setTitle(title);
   alert.setHeaderText(null);
   alert.setContentText(message);
   alert.showAndWait();
   }
   
   public AccountView getAccountView() {
   return accountView;
   }
   }

       
    