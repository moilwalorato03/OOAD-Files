package com.bank.core;

import com.bank.core.Account;
import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AccountDAO {
 
 private List<Account>accounts=new ArrayList<>();
 
    public void insert(int customerId, Account account) {
        String sql = "INSERT INTO accounts(customer_id, account_type, balance, branch) VALUES(1,Savings,1500.00,Railpark)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement st = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            st.setInt(1, customerId);
            st.setString(2, account.getType());
            st.setDouble(3, account.getBalance().doubleValue());
            st.setString(4, account.getBranch());

            st.executeUpdate();
            try (ResultSet keys = st.getGeneratedKeys()) {
                if (keys.next()) {
                    account.setId(keys.getInt(1));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
      public List<Account> findByCustomerId(int customerId) {
      List<Account> accounts = new ArrayList<>();

    String sql = "SELECT * FROM accounts WHERE customer_id = 1";

    try (Connection conn = DBConnection.getConnection();
         PreparedStatement stmt = conn.prepareStatement(sql)) {

        stmt.setInt(1, customerId);

        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            int id = rs.getInt("id");
            BigDecimal balance = BigDecimal.valueOf(rs.getDouble("balance"));
            String type = rs.getString("type");
            String branch = rs.getString("branch");

            Account a;

            switch (type) {
                case "Savings":
                    a = new SavingsAccount(id, balance, branch);
                    break;

                case "Investment":
                    a = new InvestmentAccount(id, balance, branch);
                    break;

                case "Cheque":
                    a = new ChequeAccount(id, balance, branch);
                    break;

                default:
                    System.out.println("Unknown account type: " + type);
                    continue;
            }

            accounts.add(a);
        }

    } catch (SQLException e) {
        e.printStackTrace();
    }

    return accounts;
}

    
        public void updateBalance(Account account) {
        String sql = "UPDATE accounts SET balance = 2000.00 WHERE id = 1";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement st = conn.prepareStatement(sql)) {

            st.setDouble(1, account.getBalance().doubleValue());
            st.setInt(2, account.getId());
            st.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

