package com.bank.core;


import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {

        
        SavingsAccount savings = new SavingsAccount(
                101,
                new BigDecimal("5000.00"),
                "Main Branch"
        );

        InvestmentAccount investment = new InvestmentAccount(
                102,
                new BigDecimal("12000.00"),
                "Main Branch"
        );

        ChequeAccount cheque = new ChequeAccount(
                103,
                new BigDecimal("2000.00"),
                "Main Branch"
        );


        savings.deposit(new BigDecimal("1000"));
        investment.deposit(new BigDecimal("2000"));
        cheque.deposit(new BigDecimal("500"));

        savings.withdraw(new BigDecimal("400"));
        cheque.withdraw(new BigDecimal("600"));


        savings.calculateMonthlyInterest();
        investment.calculateMonthlyInterest();


        System.out.println("=== ACCOUNT DETAILS AFTER TRANSACTIONS ===");
        System.out.println(savings);
        System.out.println(investment);
        System.out.println(cheque);
    }
}
