package com.gamestore.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.gamestore.model.enums.PaymentMethod;
import com.gamestore.model.enums.PaymentStatus;

@Entity
public class Payment implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	private Integer status;
	
	@NotNull
	private Integer type;
	
	@JsonFormat(pattern="dd/MM/yyyy hh:mm:ss")
	private LocalDateTime paymentDate;
	
	@OneToOne(mappedBy = "payment")
	private Order order;
	
	public Payment() {
		
	}

	public Payment(Long id, Integer status, Integer type) {
		this.id = id;
		this.status = status;
		this.type = type;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public PaymentStatus getStatus() {
		return PaymentStatus.toEnum(status);
	}

	public void setStatus(PaymentStatus status) {
		this.status = status.getCod();
	}

	public PaymentMethod getType() {
		return PaymentMethod.toEnum(type);
	}

	public void setType(PaymentMethod type) {
		this.type = type.getCod();
	}

	public LocalDateTime getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(LocalDateTime paymentDate) {
		this.paymentDate = paymentDate;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
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
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
