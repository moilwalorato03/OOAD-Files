package com.bank.GUI;

import com.bank.controller.LoginController;
import com.bank.core.Customer;
import com.bank.controller.AccountController;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainApp extends Application {

    private Stage primaryStage;
    private LoginController loginController;

    @Override
    public void start(Stage stage) {
        this.primaryStage = stage;
        this.loginController = new LoginController(this);
        showLogin();
    }

    public void showLogin() {
        Scene scene = new Scene(loginController.getLoginView().getView());
        primaryStage.setTitle("Banking System - Login");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void showAccountView(Customer customer) {
        AccountController accountController = new AccountController(customer);
        Scene scene = new Scene(accountController.getAccountView().getView());
        primaryStage.setScene(scene);
        primaryStage.setTitle("Banking - Accounts for " + customer.getFirstName());
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
