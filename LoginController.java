
package com.bank.controller;

import com.bank.GUI.LoginView;
import com.bank.GUI.AccountView;
import com.bank.core.Customer;
import com.bank.core.SavingsAccount;
import com.bank.core.InvestmentAccount;
import com.bank.core.ChequeAccount;
import com.bank.core.CustomerDAO;
import com.bank.core.AccountDAO;
import com.bank.GUI.MainApp;

import java.math.BigDecimal;
import java.util.List;

public class LoginController{
private MainApp mainApp;
private LoginView loginView;

private CustomerDAO customerDAO=new CustomerDAO();
private AccountDAO accountDAO=new AccountDAO();

public LoginController(MainApp mainApp){
this.mainApp=mainApp;
this.loginView=new LoginView(this);
initHandlers();
}

public LoginView getLoginView(){
return loginView;
}

private void initHandlers(){
loginView.getLoginButton().setOnAction(e->handleLogin());
loginView.getRegisterButton().setOnAction(e->handleRegister());
}
private void handleLogin(){
String username=loginView.getUsernameField().getText().trim();
String password=loginView.getPasswordField().getText().trim();

if(username.isEmpty()||password.isEmpty()){
loginView.showError("Please fill username and password:");
return;
}
Customer c=customerDAO.findByUsername(username);
if(c==null){
loginView.showError("User not found.Register first.");
return;
}
if(!c.getPassword().equals(password)){
loginView.showError("Incorrect password:");
return;
}

List<com.bank.core.Account>accounts=accountDAO.findByCustomerId(c.getId());
for(com.bank.core.Account a:accounts)c.addAccount(a);

loginView.showInfo("Login successful.Welcome"+c.getFirstName()+"!");
mainApp.showAccountView(c);
}

private void handleRegister(){
String firstname=loginView.getFirstnameField().getText().trim();
String surname=loginView.getSurnameField().getText().trim();
String address=loginView.getAddressField().getText().trim();
String employer=loginView.getEmployerField().getText().trim();
String username=loginView.getUsernameField().getText().trim();
String password=loginView.getPasswordField().getText().trim();

if(firstname.isEmpty()||username.isEmpty()||password.isEmpty()){
loginView.showError("Firstname,username and password are required.");
return;
}
if(customerDAO.findByUsername(username)!=null)
{
loginView.showError("Username already exists.");
return;
}
Customer c = new Customer(firstname, surname, address, employer, username, password);
customerDAO.insert(c); 
SavingsAccount sa=new SavingsAccount(0,BigDecimal.ZERO,"Main Branch");
accountDAO.insert(c.getId(),sa);
c.addAccount(sa);



loginView.showInfo("Registered successfully,You can now login.");
mainApp.showAccountView(c);
}

}














