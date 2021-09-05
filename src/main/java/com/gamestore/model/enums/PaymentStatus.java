package com.gamestore.model.enums;

public enum PaymentStatus {
	
	PENDING(1, "Pending"),
	DONE(2, "Done"),
	CANCEL(3, "Cancel");
	
	private int cod;
	private String status;

	PaymentStatus(Integer cod, String status) {
		this.cod = cod;
		this.status = status;
	}
	
	public int getCod() {
		return cod;
	}

	public String getStatus() {
		return status;
	}
	
	public static PaymentStatus toEnum(Integer cod) {
		if (cod == null) {
			return null;
		}
		
		for (PaymentStatus p : PaymentStatus.values()) {
			if (cod.equals(p.getCod())) {
				return p;
			}
		}
		
		throw new IllegalArgumentException("Status invalid!");
		
	}

	
}
