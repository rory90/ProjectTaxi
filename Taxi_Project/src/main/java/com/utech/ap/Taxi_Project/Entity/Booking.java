package com.utech.ap.Taxi_Project.Entity;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name="ata_tbl_booking")
public class Booking {
	@Id
    @Column(name="booking_id")
    private String  bookingid;
    @Column(name="cab_number")
    private String cabNumber;
    @Column(name="booking_date")
    private Date bookingDate;
    @Column(name="journey_date")
    private Date journeyDate;
    @Column(name="route_id")
    private String routeid;
    @Column(name="fare")
    private float fare;
	
    @Column(name="login_id")
   	private String loginid;

   	    public String getBookingid() {
   		return bookingid;
   	}
   	public void setBookingid(String bookingid) {
   		this.bookingid = bookingid;
   	}
   	public String getVehicleNumber() {
   		return cabNumber;
   	}
   	public void setVehicleNumber(String cabNumber) {
   		this.cabNumber = cabNumber;
   	}
   	public Date getBookingDate() {
   		return bookingDate;
   	}
   	public void setBookingDate(Date bookingDate) {
   		this.bookingDate = bookingDate;
   	}
   	public Date getJourneyDate() {
   		return journeyDate;
   	}
   	public void setJourneyDate(Date journeyDate) {
   		this.journeyDate = journeyDate;
   	}
   	public String getRouteid() {
   		return routeid;
   	}
   	public void setRouteid(String routeid) {
   		this.routeid = routeid;
   	}
   	public float getFare() {
   		return fare;
   	}
   	public void setFare(float fare) {
   		this.fare = fare;
   	}
   	public String getLoginid() {
   		return loginid;
   	}
   	public void setLoginid(String loginid) {
   		this.loginid = loginid;
   	}



}
