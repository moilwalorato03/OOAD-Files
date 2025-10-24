package com.bank.GUI;

import com.bank.core.Customer;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import java.math.BigDecimal;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import com.bank.controller.AccountController;
import com.bank.GUI.MainApp;

public class AccountView{
private VBox view;
private Label balanceLabel;
private TextField amountField;
private Button depositButton;
private Button withdrawButton;
private Button logoutButton;

public AccountView() {
createUI();
}

private void createUI() {
Label title=new Label("Account DashBoard");
title.setFont(new Font("Arial",22));

balanceLabel=new Label("Balance:P2000.00");
amountField=new TextField();
amountField.setPromptText("Enter amount");

depositButton=new Button("Deposit");
withdrawButton=new Button("Withdraw");
logoutButton=new Button("Logout");

HBox actions=new HBox(10,depositButton,withdrawButton);
actions.setAlignment(Pos.CENTER);

VBox layout=new VBox(15,title,balanceLabel,amountField,actions,logoutButton);
layout.setAlignment(Pos.CENTER);
layout.setStyle("-fx-background-color:linear-gradient(to bottom,#a1ffce,#faffd1);-fx-padding:25;");

view=layout;
}
 public VBox getView() {return view;}
    public Label getBalanceLabel(){return balanceLabel;}
    public TextField getAmountField() {return amountField;}
    public Button getDepositButton() {return depositButton;}
    public Button getWithdrawButton() {return withdrawButton;}
    public Button getLogoutButton() {return logoutButton;}

    }

    