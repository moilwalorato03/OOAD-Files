package com.bank.core;
import java.math.BigDecimal;
import java.util.*;

public class Bank {
    private final String name;
    private final Map<Long, Customer> customers=new HashMap<>();
    private static List<Account>accounts;
    private Bank bank;

    public Bank(String name){
        this.name=name;
        Bank.accounts=new ArrayList<>();
    }
    public static void addAccount(Account account) {
        if(account==null){
            throw new IllegalArgumentException("Account cannot be null");}
            try {
                accounts.add(account);
            } catch (Exception e) {
                
                e.printStackTrace();
            }
        }
    
    public String registerCustomer(String firstname,String surname,String address,String phoneNumber){
        Customer cust=new Customer(firstname,surname,address,phoneNumber);
        return cust.getFullName();
        
       
    }
    public SavingsAccount openSavingsAccount(String owner,String branch,BigDecimal deposit){
        SavingsAccount acc=new SavingsAccount(owner,branch,deposit);
        Bank.addAccount(acc);
        return acc;
    }
    public InvestmentAccount
    openInvestmentAccount(String owner,String branch,BigDecimal deposit){
        InvestmentAccount acc=new InvestmentAccount(owner,branch,deposit);
        Bank.addAccount(acc);
        return acc;
    }
    public ChequeAccount openChequeAccount(String owner,String branch,BigDecimal deposit,String employerName,String employerAddress){
        ChequeAccount acc=new ChequeAccount(owner,branch,deposit,employerName,employerAddress);
        return acc;
    }
    public void applyInterestToAllAccounts(){
        for(Customer owner:customers.values()){
            for(Account acc:owner.getAccounts()){
                if(acc instanceof InterestPayable interestAcc){
                    interestAcc.applyMonthlyInterest();
                }
            }
        }
    }
    @Override
    public String toString(){
        return String.format("Bank[name=%s,customers=%d]",name,customers.size());
    }
}
    
