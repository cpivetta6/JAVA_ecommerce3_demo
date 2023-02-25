package com.caiopivetta6.domain.enums;

public enum StatePayment {

	PROCESSING_PAYMENT(1, "PROCESSING PAYMENT"), PAID(2, "PAID"), CANCELED(3, "CANCELED");
	
	private Integer code;
	private String status;
	
	private StatePayment(Integer code, String status) {
		this.code = code;
		this.status = status;
	}
	
	public static StatePayment toEnum (Integer code) {
		if(code == null) {
			return null;
		}
		
		for(StatePayment x : StatePayment.values()) {
			if(x.getCode() == code) {
				return x;
			}
		}
		
		throw new IllegalArgumentException("code does't exists");
		
	} 
	
	public Integer getCode() {
		return code;
	}
	
	
	
	
	
}
