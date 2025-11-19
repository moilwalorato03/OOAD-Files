package com.bank.GUI;

import com.bank.controller.AccountController;
import com.bank.core.Account;
import com.bank.core.Customer;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class AccountView {

    private VBox view;
    private Label welcomeLabel;
    private Label balanceLabel;
    private TextField amountField;
    private Button depositButton;
    private Button withdrawButton;
    private Button applyInterestButton;
    private Button createAccountButton;
    private Button logoutButton;
    private ComboBox<Account> accountSelector;
    private ComboBox<String> newAccountType;

    private AccountController controller;

    public AccountView(AccountController controller, Customer customer) {
        this.controller = controller;
        createUI(customer);
    }

    private void createUI(Customer customer) {
        welcomeLabel = new Label("Welcome, " + customer.getFirstName());
        welcomeLabel.setFont(Font.font(20));
        welcomeLabel.setTextFill(Color.DARKBLUE);

        balanceLabel = new Label("Balance: P0.00");
        balanceLabel.setFont(Font.font(18));
        balanceLabel.setTextFill(Color.DARKCYAN);

        accountSelector = new ComboBox<>();
        accountSelector.setPromptText("Select account");

        amountField = new TextField();
        amountField.setPromptText("Enter amount");

        depositButton = new Button("Deposit");
        withdrawButton = new Button("Withdraw");
        applyInterestButton = new Button("Apply Interest");
        createAccountButton = new Button("Create Account");
        logoutButton = new Button("Logout");

        newAccountType = new ComboBox<>(FXCollections.observableArrayList("Savings", "Investment", "Cheque"));
        newAccountType.setValue("Savings");

        view = new VBox(10,
                welcomeLabel,
                accountSelector,
                balanceLabel,
                amountField,
                newAccountType,
                createAccountButton,
                depositButton,
                withdrawButton,
                applyInterestButton,
                logoutButton);
        view.setPadding(new Insets(18));
        view.setAlignment(Pos.CENTER);
        view.setStyle("-fx-background-color: linear-gradient(to bottom, #e8f6ff, #d0ebff); -fx-border-color: #1565c0; -fx-border-width: 2;");
        view.setPrefSize(520, 520);
    }

    // getters for controller
    public VBox getView() { return view; }
    public TextField getAmountField() { return amountField; }
    public Button getDepositButton() { return depositButton; }
    public Button getWithdrawButton() { return withdrawButton; }
    public Button getApplyInterestButton() { return applyInterestButton; }
    public Button getCreateAccountButton() { return createAccountButton; }
    public Button getLogoutButton() { return logoutButton; }
    public ComboBox<Account> getAccountSelector() { return accountSelector; }
    public String getNewAccountType() { return newAccountType.getValue(); }
    public ComboBox<String> getNewAccountTypeCombo() { return newAccountType; }

    // small helpers used by controllers:
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
    public void setBalanceText(String t) { balanceLabel.setText(t); }
    public String getAmountInput() { return amountField.getText(); }
}

    