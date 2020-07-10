package org.creditcard.exception;

public class CreditCardException extends Exception{
	private String errorMessage;
	
	public CreditCardException(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	
}
