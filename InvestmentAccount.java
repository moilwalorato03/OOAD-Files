 package com.bank.core;

import java.math.BigDecimal;

public class InvestmentAccount extends Account{
private static final BigDecimal RATE=new BigDecimal("0.05");
public static final BigDecimal MIN_OPENING=new BigDecimal("500.00");

public InvestmentAccount(int id,BigDecimal initialBalance,String branch){
super(id,"Investment",initialBalance,branch);
}

@Override
public BigDecimal calculateMonthlyInterest(){
return balance.multiply(RATE);
}
}