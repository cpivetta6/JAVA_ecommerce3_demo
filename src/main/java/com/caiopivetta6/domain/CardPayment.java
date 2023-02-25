package com.caiopivetta6.domain;

import java.time.Instant;

import com.caiopivetta6.domain.enums.StatePayment;

public class CardPayment extends Payment {

	private Instant date_payment;
	
	public CardPayment() {
		
	}

	public CardPayment(Integer id, StatePayment state, Instant date_payment) {
		super(id, state);
		this.date_payment = date_payment;
		
	}

	public Instant getDate_payment() {
		return date_payment;
	}

	public void setDate_payment(Instant date_payment) {
		this.date_payment = date_payment;
	}
	
	
	
	
	
}
