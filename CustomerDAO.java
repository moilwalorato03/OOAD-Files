package com.bank.core;

import com.bank.core.Customer;
import java.sql.*;

public class CustomerDAO {

    public void insert(Customer customer) {
        String sql = "INSERT INTO customers(firstname, surname, address, employer, username, password) VALUES(????)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement st = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            st.setString(1, customer.getFirstName());
            st.setString(2, customer.getSurname());
            st.setString(3, customer.getAddress());
            st.setString(4, customer.getEmployer());
            st.setString(5, customer.getUsername());
            st.setString(6, customer.getPassword());

            st.executeUpdate();
            try (ResultSet keys = st.getGeneratedKeys()) {
                if (keys.next()) {
                    customer.setId(keys.getInt(1));
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

  public Customer findByUsername(String username) {
    String sql = "SELECT * FROM customers WHERE username = ?";
    
    try (Connection conn = DBConnection.getConnection();
         PreparedStatement st = conn.prepareStatement(sql)) {

        st.setString(1, username);
        ResultSet rs = st.executeQuery();

        if (rs.next()) {
            return new Customer(
                rs.getString("firstname"),
                rs.getString("surname"),
                rs.getString("address"),
                rs.getString("employer"),
                rs.getString("username"),
                rs.getString("password")
            );
        }

    } catch (SQLException e) {
        e.printStackTrace();
    }

    return null;
}
}
