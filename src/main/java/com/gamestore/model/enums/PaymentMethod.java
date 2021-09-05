package com.gamestore.model.enums;

public enum PaymentMethod {
	
	CREDITO(1, "Credito"),
	DEBITO(2, "Debito"),
	BOLETO(3, "Boleto"),
	PIX(4, "PIX");
	
	private int cod;
	private String name;

	private PaymentMethod(int cod, String name) {
		this.cod = cod;
		this.name = name;
	}

	public int getCod() {
		return cod;
	}

	public String getName() {
		return name;
	}
	
	public static PaymentMethod toEnum(Integer cod) {
		if (cod == null) {
			return null;
		}
		
		for (PaymentMethod p : PaymentMethod.values()) {
			if (cod.equals(p.getCod())) {
				return p;
			}
		}
		
		throw new IllegalArgumentException("Payment method invalid!");
		
	}
}
