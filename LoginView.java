package com.bank.GUI;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import java.math.BigDecimal;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.control.PasswordField;
import javafx.stage.Stage;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import com.bank.controller.LoginController;


public class LoginView{
    private MainApp mainApp;
    private VBox view;
    private TextField usernameField;
    private PasswordField passwordField;
    private Button loginButton;
    private Button registerButton;
    
    public LoginView() {
    createUI();
    }
    
    private void createUI() {
    Label title=new Label("Banking System Login");
    title.setFont(new Font("Arial",20));
    
    usernameField=new TextField();
    usernameField.setPromptText("Enter Username");
    
    passwordField=new PasswordField();
    passwordField.setPromptText("Enter password");
    
    loginButton=new Button("Login");
    registerButton=new Button("Register New Customer");
    
    VBox layout=new VBox(10,title,usernameField,passwordField,loginButton,registerButton);
    layout.setAlignment(Pos.CENTER);
    layout.setStyle("-fx-background-color:linear-gradient(to bottom,#8EC5FC,#E0C3FC);-fx-padding:20");
    
    view=layout;
    }
    public VBox getView() {return view;}
    public TextField getUsernameField(){return usernameField;}
    public PasswordField getPasswordField() {return passwordField;}
    public Button getLoginButton() {return loginButton;}
    public Button getRegisterButton() {return registerButton;}
    }

    