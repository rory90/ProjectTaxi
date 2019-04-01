package com.utech.ap.Taxi_Project.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name="ata_tbl_payment_history")
public class PaymentHistory {
	
	
	@Id
    @Column(name="booking_id")
	private String bookingId;
    @Column(name="total_fare")
    private float totalFare;
    @Column(name="mode_of_payment")
    private String modeOfPayment;
    @Column(name="card_number")
    private String CardNumber;
	public String getBookingId() {
		return bookingId;
	}
	public void setBookingId(String bookingId) {
		this.bookingId = bookingId;
	}
	public float getTotalFare() {
		return totalFare;
	}
	public void setTotalFare(float totalFare) {
		this.totalFare = totalFare;
	}
	public String getModeOfPayment() {
		return modeOfPayment;
	}
	public void setModeOfPayment(String modeOfPayment) {
		this.modeOfPayment = modeOfPayment;
	}
	public String getCardNumber() {
		return CardNumber;
	}
	public void setCardNumber(String cardNumber) {
		CardNumber = cardNumber;
	}
    
    

}
