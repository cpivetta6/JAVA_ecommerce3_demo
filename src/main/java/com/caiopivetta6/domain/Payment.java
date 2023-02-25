package com.caiopivetta6.domain;

import java.util.Objects;

import com.caiopivetta6.domain.enums.StatePayment;

public abstract class Payment {

	private Integer id;
	private Integer state;
	
	public Payment() {
		
	}

	public Payment(Integer id, StatePayment state) {
		super();
		this.id = id;
		this.state = state.getCode();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public StatePayment getState() {
		return StatePayment.toEnum(state);
	}

	public void setState(StatePayment state) {
		this.state = state.getCode();
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Payment other = (Payment) obj;
		return Objects.equals(id, other.id);
	}
	

	
	
	
	
	
	
}
