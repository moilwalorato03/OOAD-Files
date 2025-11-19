package com.bank.GUI;

import com.bank.controller.LoginController;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class LoginView {

    private VBox view;
    private TextField usernameField;
    private PasswordField passwordField;
    private Button loginButton;
    private Button registerButton;

    private TextField firstnameField;
    private TextField surnameField;
    private TextField addressField;
    private TextField employerField;

    private LoginController controller; 
    public LoginView(LoginController controller) {
        this.controller = controller;
        createUI();
    }

    private void createUI() {
        Label title = new Label("SmartBank");
        title.setFont(Font.font(26));
        title.setTextFill(Color.DARKBLUE);

        firstnameField = new TextField();
        firstnameField.setPromptText("Firstname (for register)");

        surnameField = new TextField();
        surnameField.setPromptText("Surname");

        addressField = new TextField();
        addressField.setPromptText("Address");

        employerField = new TextField();
        employerField.setPromptText("Employer (for Cheque account)");

        usernameField = new TextField();
        usernameField.setPromptText("Username (login)");

        passwordField = new PasswordField();
        passwordField.setPromptText("Password");

        loginButton = new Button("Login");
        registerButton = new Button("Register Customer");

        view = new VBox(10, title,
                firstnameField, surnameField, addressField, employerField,
                usernameField, passwordField,
                loginButton, registerButton);
        view.setPadding(new Insets(18));
        view.setAlignment(Pos.CENTER);
        view.setStyle("-fx-background-color: linear-gradient(to bottom, #e3f2fd, #bbdefb);"
                + "-fx-border-color: #0d47a1; -fx-border-width: 2; -fx-padding: 15;");
        view.setPrefSize(420, 520);
    }

    // getters for controller
    public VBox getView() { return view; }
    public TextField getUsernameField() { return usernameField; }
    public PasswordField getPasswordField() { return passwordField; }
    public Button getLoginButton() { return loginButton; }
    public Button getRegisterButton() { return registerButton; }

    // registration fields getters
    public TextField getFirstnameField() { return firstnameField; }
    public TextField getSurnameField() { return surnameField; }
    public TextField getAddressField() { return addressField; }
    public TextField getEmployerField() { return employerField; }

    // small helpers
    public void showError(String msg) {
        Alert a = new Alert(Alert.AlertType.ERROR);
        a.setTitle("Error");
        a.setHeaderText(null);
        a.setContentText(msg);
        a.showAndWait();
    }
    public void showInfo(String msg) {
        Alert a = new Alert(Alert.AlertType.INFORMATION);
        a.setTitle("Info");
        a.setHeaderText(null);
        a.setContentText(msg);
        a.showAndWait();
    }
}
