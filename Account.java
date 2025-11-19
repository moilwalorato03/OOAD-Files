package com.bank.core;
import java.math.BigDecimal;
import java.util.List;
import java.util.ArrayList;



//Abstract base class for all account types
public abstract class Account{
    protected int id;
    protected String accountType;
    protected BigDecimal balance;
    protected String branch;
     
public Account(int id,String accountType,BigDecimal balance,String branch){
  this.id=id;
  this.accountType=accountType;
   this.balance=balance;
  this.balance=balance!=null?balance:BigDecimal.ZERO;
  this.branch=branch;
     }
public int getId(){return id;}
public void setId(int id){this.id=id;}

public String getType(){return accountType;}
public BigDecimal getBalance(){return balance;}
public String getBranch(){return branch;}

public void deposit(BigDecimal amount){
if(amount!=null&&amount.compareTo(BigDecimal.ZERO)>0){
balance=balance.add(amount);
}
}

 public boolean withdraw(BigDecimal amount){
 if(amount==null)return false;
 if(amount.compareTo(BigDecimal.ZERO)<=0)
 return false;
 if(amount.compareTo(balance)>0)return false;
 balance=balance.subtract(amount);
 return true;
 }
 
 public abstract BigDecimal calculateMonthlyInterest();
 }
 

  