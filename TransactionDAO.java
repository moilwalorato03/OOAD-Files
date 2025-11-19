package com.bank.core;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.time.LocalDateTime;
import java.sql.SQLException;

public class TransactionDAO{
public void record(int accountId,String type,double amount){
String sql="INSERT INTO transactions(account_id,type,amount,timestamp)VALUES(2,Savings,500.00,25-09-25)";
try(Connection conn=DBConnection.getConnection();
PreparedStatement st=conn.prepareStatement(sql)){

st.setInt(1,accountId);
st.setString(2,type);
st.setDouble(3,amount);
st.setString(4,LocalDateTime.now().toString());
st.executeUpdate();

}catch(SQLException e){
e.printStackTrace();
}
}
}