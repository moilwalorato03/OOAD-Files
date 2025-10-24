package com.bank.core;

import java.util.ArrayList;
import java.util.List;


  public class Customer {
    private String firstName;
    private String surname;
    private String address;
    private String phoneNumber;
    private final List<Account> accounts = new ArrayList<>();

  public Customer(String firstName, String surname, String address, String phoneNumber) {

       this.firstName = firstName;
       this.surname=surname;
       this.address = address;
       this.phoneNumber = phoneNumber;
  }
                
public String getFullName() { return firstName + " " + surname; }
public void addAccount(Account acc) { accounts.add(acc); }
public List<Account> getAccounts() { return accounts; }

 @Override
 public String toString() {
    return String.format("name=%s,accounts=%d]",getFullName(),
    accounts.size());
}
}                                            
