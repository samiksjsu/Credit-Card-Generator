package org.creditcard.vo;

import java.util.Date;

public class VO {
	private String cardNumber;
	private String expirationDate;
	private String cardHolderName;
	
	public VO(String cardNumber, String expirationDate, String cardHolderName) {
		this.cardNumber = cardNumber;
		this.expirationDate = expirationDate;
		this.cardHolderName = cardHolderName;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(String expirationDate) {
		this.expirationDate = expirationDate;
	}

	public String getCardHolderName() {
		return cardHolderName;
	}

	public void setCardHolderName(String cardHolderName) {
		this.cardHolderName = cardHolderName;
	}

	@Override
	public String toString() {
		return "VO [cardNumber=" + cardNumber + ", expirationDate=" + expirationDate + ", cardHolderName="
				+ cardHolderName + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cardHolderName == null) ? 0 : cardHolderName.hashCode());
		result = prime * result + ((cardNumber == null) ? 0 : cardNumber.hashCode());
		result = prime * result + ((expirationDate == null) ? 0 : expirationDate.hashCode());
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
		VO other = (VO) obj;
		if (cardHolderName == null) {
			if (other.cardHolderName != null)
				return false;
		} else if (!cardHolderName.equals(other.cardHolderName))
			return false;
		if (cardNumber == null) {
			if (other.cardNumber != null)
				return false;
		} else if (!cardNumber.equals(other.cardNumber))
			return false;
		if (expirationDate == null) {
			if (other.expirationDate != null)
				return false;
		} else if (!expirationDate.equals(other.expirationDate))
			return false;
		return true;
	}
	
	
}
