package com.bank.core;

import java.math.BigDecimal;

public class Main{
    public static void main(String[] args){
        Bank bank=new Bank("BW National Bank");
        String cust=bank.registerCustomer("Lorato", "Moilwa","Gaborone","+26774696815");

        SavingsAccount sa=bank.openSavingsAccount(cust,"Main Branch",new BigDecimal(1400.0));
        InvestmentAccount ia=bank.openInvestmentAccount(cust,"Main Branch",new BigDecimal(2000.0));
        ChequeAccount ca=bank.openChequeAccount(cust,"Main Branch",new BigDecimal(4500.0),"Wonderland","Plot 52 Railpark");

        sa.deposit(new BigDecimal(500.0));
        ia.withdraw(new BigDecimal(300.0));
        ca.deposit(new BigDecimal(1000.0));

        bank.applyInterestToAllAccounts();

        System.out.println(sa);
        System.out.println(ia);
        System.out.println(ca);
    }
}