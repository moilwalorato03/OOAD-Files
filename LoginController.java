package com.bank.controller;

import com.bank.GUI.LoginView;
import com.bank.GUI.MainApp;
import java.util.HashMap;
import java.util.Map;
import com.bank.core.Customer;
import com.bank.core.Account;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import java.util.HashMap;
import java.util.Map;

public class LoginController {
    private MainApp mainApp;
    private LoginView loginView;
    private static Map<String,String>registeredUsers=new HashMap<>();
     
    public LoginController(MainApp mainApp) {
        this.mainApp=mainApp;
        this.loginView=new LoginView();
        initHandlers();
        }
     private void initHandlers() {
     loginView.getLoginButton().setOnAction(e->handleLogin());
     loginView.getRegisterButton().setOnAction(e->handleRegister());
     }
     
     private void handleLogin() {
     String username=loginView.getUsernameField().getText();
     String password=loginView.getPasswordField().getText();
     
     if(registeredUsers.containsKey(username)&&registeredUsers.get(username).equals(password)) {
     mainApp.showAccountView(username);
     }else{
     Alert alert=new Alert(AlertType.ERROR);
     alert.setTitle("Login Failed");
     alert.setHeaderText(null);
     alert.setContentText("Invalid username or password!");
     alert.showAndWait();
     }
     }
     
     private void handleRegister() {
     String username=loginView.getUsernameField().getText();
     String password=loginView.getPasswordField().getText();
     
     if(registeredUsers.containsKey(username)){
     Alert alert=new Alert(AlertType.WARNING);alert.setTitle("Registration Failed");
     alert.setHeaderText(null);
     alert.setContentText("User already exists!");
     alert.showAndWait();
     }else{
     registeredUsers.put(username,password);
     Alert alert=new Alert(AlertType.INFORMATION);
     alert.setTitle("Registration Successful");
     alert.setHeaderText(null);
     alert.setContentText("Account created successfully!");
     alert.showAndWait();
     }
     }
     
     public LoginView getLoginView() {
     return loginView;
     }
     }

    