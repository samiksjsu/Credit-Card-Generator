package org.creditcard.handlers;

import org.creditcard.exception.CreditCardException;
import org.creditcard.factories.CreditCardFactory;
import org.creditcard.factories.MasterCardFactory;
import org.creditcard.products.CreditCard;
import org.creditcard.vo.VO;

public class MasterCCHandler implements Handler {

	private Handler nextHandler;

	public MasterCCHandler(Handler nextHandler) {
		// TODO Auto-generated constructor stub
		this.nextHandler = nextHandler;
	}

	public boolean validCard(VO vo) throws CreditCardException {
		try {
			String cardNumber = vo.getCardNumber();

			int firstDigit = Character.getNumericValue(cardNumber.charAt(0));
			int secondDigit = Character.getNumericValue(cardNumber.charAt(1));

			if (firstDigit == 5 && secondDigit >= 1 && secondDigit <= 5 && cardNumber.length() == 16)
				return true;
		} catch (Exception e) {
			// TODO: handle exception
			new CreditCardException("Invalid Credit Card");
		}

		return false;
	}

	public CreditCard handle(VO vo) {

		// TODO Auto-generated method stub
		try {
			if (validCard(vo) == true) {
				CreditCardFactory creditCardFactory = new MasterCardFactory();
				return creditCardFactory.generateCreditCard(vo);
			}
		} catch (CreditCardException e) {
			// TODO: handle exception
			return nextHandler.handle(vo);
		}

		return nextHandler.handle(vo);
	}
}
