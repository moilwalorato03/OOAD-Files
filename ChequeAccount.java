package com.bank.core;
import java.math.BigDecimal;

//Cheque account: for salaried customers,requires employer information.
public class ChequeAccount extends Account{
    private static String deposit;
    protected BigDecimal overdraftLimit;
    private final String employerName;
    private final String employerAddress;
    private BigDecimal transcations;

    public ChequeAccount(String owner,String branch,BigDecimal Deposit,String employerName,String employerAddress){
        super(owner,branch,deposit);
        this.employerName=employerName;
        this.employerAddress=employerAddress;
    }
    

     @Override
public void deposit(BigDecimal amount){
if(amount.compareTo(BigDecimal.ZERO)<=0)
throw new IllegalArgumentException("Deposit must be positive");
return;
}

@Override
public void withdraw(BigDecimal amount){
    if(amount.compareTo(balance)>0)
    throw new IllegalArgumentException("Insufficient funds");
    balance=balance.subtract(amount);
    transactions.add(new Transaction(TransactionType.WITHDRAWAL, amount, balance));
}

}
