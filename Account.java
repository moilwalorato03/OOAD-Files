package com.bank.core;
import java.math.BigDecimal;
import java.util.List;
import java.util.ArrayList;



//Abstract base class for all account types
public abstract class Account{
    protected static int nextAccountNumber=1500;

    protected final int accountNumber;
    protected String owner;
    protected BigDecimal balance;
    protected final String branch;
    protected final List<Transaction> transactions=new ArrayList<>();

    protected BigDecimal initialDeposit;
    
 
public Account(int accountNumber,String owner,String branch,BigDecimal balance){
  this.accountNumber=nextAccountNumber;
  this.owner=owner;
   this.branch=branch;
  this.balance=balance;
  transactions.add(new Transaction(TransactionType.DEPOSIT,initialDeposit,balance));
   }


  public Account(Customer owner2, String branch2, String deposit) {
    this.accountNumber = 0;
    this.branch = "";
}


  public Account(String owner2, String branch2, String deposit) {
    this.accountNumber = 0;
    this.branch = "";}
    
  

  public abstract void deposit(BigDecimal amount);
  public abstract void withdraw(BigDecimal amount);
  
  public int getAccountNumber() {
  return accountNumber;
  }
  public BigDecimal getBalance() {
  return balance;
  }
  @Override
  public String toString() {
    return "Account{"+
          "accountNumber=" +accountNumber+
          ", owner="+ owner +
          ",balance="+balance+'}';
            }
}

