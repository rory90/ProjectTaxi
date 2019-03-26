package com.utech.ap.Taxi_Project.Database; 

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.utech.ap.Taxi_Project.Helper.DbUtil;

public class BookingHelperDbImpl implements BookingHelperDb {
	
	Connection connection = null;
	PreparedStatement ptmt = null;
	ResultSet resultSet = null;
	
	private Connection getConnection() throws SQLException {
		Connection conn;
		conn = DbUtil.getInstance().getConnection();
		return conn;
	}
	
	
	public void setBookingId() {
		
		try {
			String queryString = "update bookingHelper set tempBookingId = tempBookingId+1 where id =1";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			
			ptmt.executeUpdate();
			System.out.println("bookingId in db is Added Successfully");
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

	
	public int getBookingId() {
		
		int cabId = 0;
		
		try {
			String queryString = "SELECT tempBookingId FROM bookinghelper WHERE id = 1";
			connection = getConnection();
			Statement st = connection.createStatement();
		    ResultSet rs = st.executeQuery(queryString);
		    
		    if(rs.next()){
		    	cabId = rs.getInt(1);
		    	
		    	}
		    
		    
			
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
		return cabId;
		
		
	}


	
	
}
