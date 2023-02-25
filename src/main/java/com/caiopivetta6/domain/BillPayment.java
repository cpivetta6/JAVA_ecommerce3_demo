package com.caiopivetta6.domain;

import java.time.Instant;

import com.caiopivetta6.domain.enums.StatePayment;

import jakarta.persistence.Entity;

@Entity
public class BillPayment extends Payment {

	private Instant datePayment;
	
	public BillPayment() {
		
	}

	public BillPayment(Integer id, StatePayment state, Instant datePayment) {
		super(id, state);
		this.datePayment = datePayment;
		// TODO Auto-generated constructor stub
	}

	public Instant getDatePayment() {
		return datePayment;
	}

	public void setDatePayment(Instant datePayment) {
		this.datePayment = datePayment;
	}
	
	
	
	
	
	
}
