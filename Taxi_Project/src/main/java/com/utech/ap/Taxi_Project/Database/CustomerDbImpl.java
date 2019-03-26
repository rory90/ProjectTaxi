package com.utech.ap.Taxi_Project.Database;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.utech.ap.Taxi_Project.Entity.Customer;
import com.utech.ap.Taxi_Project.Helper.DbUtil;

public class CustomerDbImpl  implements CustomerDb{

	
	Connection connection = null;
	PreparedStatement ptmt = null;
	ResultSet resultSet = null;
	
	public CustomerDbImpl() {};
	
	private Connection getConnection() throws SQLException {
		Connection conn;
		conn = DbUtil.getInstance().getConnection();
		return conn;
	}
	
	
	
public void addCustomer(Customer customer) {
		
		try {
			String queryString = "INSERT INTO Customer(customerId, customerName) VALUES(?,?)";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			ptmt.setInt(1, customer.getCustomerId());
			ptmt.setString(2, customer.getCustomerName());
			ptmt.executeUpdate();
			System.out.println("Data Added Successfully");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (ptmt != null)
					ptmt.close();
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
	}
}
