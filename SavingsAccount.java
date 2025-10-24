package com.bank.core;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
//Savings account: deposits only,small interest and no withdrawals.
public class SavingsAccount extends Account implements InterestPayable{
    private static final BigDecimal INTEREST_RATE= new BigDecimal("0.005");
    private static int accountNumber;
    private List<Transaction>transactions=new ArrayList<>();
    public SavingsAccount( int accountNumber,String owner,String branch, BigDecimal initialDeposit){
    super(accountNumber,owner,branch,initialDeposit);
}
    
    public SavingsAccount(String owner, String branch, BigDecimal deposit) {
		super(accountNumber,owner,branch,deposit);
}
	

	@Override
    public void withdraw(BigDecimal amount){
    if(amount.compareTo(balance)>0)
    throw new IllegalArgumentException("Insufficient funds");
    balance=balance.subtract(amount);
    transactions.add(new Transaction(TransactionType.WITHDRAWAL, amount, balance));
    }
public void deposit(BigDecimal amount){
if(amount.compareTo(BigDecimal.ZERO)<=0)
throw new IllegalArgumentException("Deposit must be positive");
balance=balance.add(amount);
transactions.add(new Transaction(TransactionType,BigDecimal,BigDecimal));
}
    
@Override
public void applyMonthlyInterest(){
BigDecimal interest= balance.multiply(INTEREST_RATE);
balance=balance.add(interest);
transactions.add(new Transaction(TransactionType.INTEREST,interest,balance));
}
}