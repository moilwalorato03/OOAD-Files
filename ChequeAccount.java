package com.bank.core;
import java.math.BigDecimal;

public class ChequeAccount extends Account{
public ChequeAccount(int id,BigDecimal initialBalance,String branch){
super(id,"Cheque",initialBalance,branch);
}

@Override
public BigDecimal calculateMonthlyInterest(){
return BigDecimal.ZERO;
}
}