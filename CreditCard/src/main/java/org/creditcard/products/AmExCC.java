package org.creditcard.products;

import org.creditcard.vo.VO;

public class AmExCC implements CreditCard{

	VO vo;
	String type;
	
	public AmExCC(VO vo, String type) {
		this.vo = vo;
		this.type = type;
	}

	public String getDescription() {
		// TODO Auto-generated method stub
		return toString();
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	public String getCardNumber() {
		return vo.getCardNumber();
	}

	public void setCardNumber(String cardNumber) {
		this.vo.setCardNumber(cardNumber);
	}

	public String getExpirationDate() {
		return vo.getExpirationDate();
	}

	public void setExpirationDate(String expirationDate) {
		this.vo.setExpirationDate(expirationDate);
	}

	public String getCardHolderName() {
		return vo.getCardHolderName();
	}

	public void setCardHolderName(String cardHolderName) {
		this.vo.setCardHolderName(cardHolderName);
	}

	@Override
	public String toString() {
		return "AmExCC [cardNumber=" + vo.getCardNumber() + ", expirationDate=" + vo.getExpirationDate() + ", cardHolderName="
				+ vo.getCardHolderName() + ", type=" + type + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		result = prime * result + ((vo == null) ? 0 : vo.hashCode());
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
		AmExCC other = (AmExCC) obj;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		if (vo == null) {
			if (other.vo != null)
				return false;
		} else if (!vo.equals(other.vo))
			return false;
		return true;
	}
}
