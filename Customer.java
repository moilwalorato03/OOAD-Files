package com.bank.core;

import java.util.ArrayList;
import java.util.List;


  public class Customer {
    private int id;
    private String firstName;
    private String surname;
    private String address;
    private String phoneNumber;
    private String employer;
    private String username;
    private String password;
    private final List<Account> accounts = new ArrayList<>();

  public Customer(String firstName, String surname, String address,String employer,String username,String password) {
       this.firstName = firstName;
       this.surname=surname;
       this.address = address;
       this.employer= employer;
       this.username = username;
       this.password = password;

  }
  
  public Customer(int id, String firstname, String surname, String address, String employer,
                String username, String password) {
    this.id = id;
    this.firstName = firstName;
    this.surname = surname;
    this.address = address;
    this.employer = employer;
    this.username = username;
    this.password = password;
}

 public int getId(){return id;}
 public void setId(int id){this.id=id;}
                
public String getFirstName() { return firstName; }
public String getSurname() { return surname; }
public String getAddress() { return address; }
public String getEmployer() { return employer; }
public String getUsername() { return username; }
public String getPassword() { return password; }

public List<Account> getAccounts() { return accounts; }
public void addAccount(Account a){accounts.add(a);}

public Account getPrimaryAccount(){
if(accounts.isEmpty())return null;
return accounts.get(0);
}
}

                                 