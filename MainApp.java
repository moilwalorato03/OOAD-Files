package com.bank.GUI;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Parent;
import com.bank.controller.LoginController;
import com.bank.GUI.LoginView;

public class MainApp extends Application {

    private Stage primaryStage;
    
    @Override
    public void start(Stage stage){
    this.primaryStage=stage;
    showLoginView();
    
    
          }
        public void changeScene(Parent root){
            Scene scene=new Scene(root,500,400);
            primaryStage.setScene(scene);
           }
           
        public void showLoginView() {
        LoginController loginController=new LoginController(this);
        Scene scene=new Scene(loginController.getLoginView().getView(),400,300);
           primaryStage.setScene(scene);
           primaryStage.setTitle("Banking System-Login");
           primaryStage.show();
           }
           
           public void showAccountView(String customerName) {
           com.bank.controller.AccountController accountController=new com.bank.controller.AccountController(this,customerName);
           Scene scene=new Scene(accountController.getAccountView().getView(),500,350);
           primaryStage.setScene(scene);
           primaryStage.setTitle("Account Dashboard");
           primaryStage.show();
           }

    public static void main(String[] args){
        launch(args);
    }
}

