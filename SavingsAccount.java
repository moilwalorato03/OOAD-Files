package com.bank.core;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class SavingsAccount extends Account{
private static final BigDecimal RATE=new BigDecimal("0.0005");

public SavingsAccount(int id,BigDecimal initialBalance,String branch){
super(id,"Savings",initialBalance,branch);
}

@Override
public BigDecimal calculateMonthlyInterest(){
return balance.multiply(RATE);
}

@Override
public boolean withdraw(BigDecimal amount){
return false;
}
}