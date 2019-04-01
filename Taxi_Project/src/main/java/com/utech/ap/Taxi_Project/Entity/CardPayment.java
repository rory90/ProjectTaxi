package com.utech.ap.Taxi_Project.Entity;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity(name="ata_tbl_card_payment")

public class CardPayment {
	
	@Id
    @Column(name="card_number")
    private String  CardNumber;
    @Column(name="valid_from")
    @Temporal(TemporalType.DATE)
    private Date validFrom;
    @Column(name="valid_to")
    @Temporal(TemporalType.DATE)
    private Date validTo;
    @Column(name="balance")
    private float Balance;
    
	public String getCardNumber() {
		return CardNumber;
	}
	public void setCardNumber(String cardNumber) {
		CardNumber = cardNumber;
	}
	public Date getValidFrom() {
		return validFrom;
	}
	public void setValidFrom(Date validFrom) {
		this.validFrom = validFrom;
	}
	public Date getValidTo() {
		return validTo;
	}
	public void setValidTo(Date validTo) {
		this.validTo = validTo;
	}
	
	public void setBalance(float balance) {
		this.Balance = balance;
	}
	public float getBalance() {
		return Balance;
	}
	

	
}
