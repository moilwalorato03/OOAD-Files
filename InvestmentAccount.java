package com.bank.core;

import java.math.BigDecimal;

//Investment account:allows deposit/withdrawal,pays higher interest.
public class InvestmentAccount extends Account implements InterestPayable{
    private static final BigDecimal INTEREST_RATE=new BigDecimal("0.05");

    public InvestmentAccount(String owner, String branch,BigDecimal initialDeposit){
        super(nextAccountNumber, owner,branch,initialDeposit);
        if(initialDeposit.compareTo(new BigDecimal("500.50"))<0)
        throw new IllegalArgumentException("Investment Account requires minimum BWP500");
    }
     @Override
public void deposit(BigDecimal amount){
if(amount.compareTo(BigDecimal.ZERO)<=0)
throw new IllegalArgumentException("Deposit must be positive");
balance=balance.add(amount);
transactions.add(new Transaction(TransactionType,BigDecimal,BigDecimal));
}
@Override
public void withdraw(BigDecimal amount){
    if(amount.compareTo(balance)>0)
    throw new IllegalArgumentException("Insufficient funds");
    balance=balance.subtract(amount);
    transactions.add(new Transaction(TransactionType,BigDecimal,BigDecimal));
}
@Override
public void applyMonthlyInterest(){
BigDecimal interest= balance.multiply(INTEREST_RATE);
balance=balance.add(interest);
transactions.add(new Transaction(TransactionType,BigDecimal,BigDecimal));
}
}
