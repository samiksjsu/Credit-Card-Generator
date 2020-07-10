package org.creditcard.handlers;

import org.creditcard.exception.CreditCardException;
import org.creditcard.factories.CreditCardFactory;
import org.creditcard.factories.DiscoverFactory;
import org.creditcard.products.CreditCard;
import org.creditcard.vo.VO;

public class DiscoverCCHandler implements Handler {

	private Handler nextHandler;

	public DiscoverCCHandler(Handler nextHandler) {
		// TODO Auto-generated constructor stub
		this.nextHandler = nextHandler;
	}

	public boolean validCard(VO vo) throws CreditCardException {
		try {
			String cardNumber = vo.getCardNumber();

			int firstFourDigits = Integer.parseInt(cardNumber.substring(0, 4));
			
			if (firstFourDigits == 6011 && cardNumber.length() == 16)
				return true;
		} catch (Exception e) {
			// TODO: handle exception
			throw new CreditCardException("Invalid Credit Card");
		}

		return false;
	}

	public CreditCard handle(VO vo) {

		// TODO Auto-generated method stub
		try {
			if (validCard(vo) == true) {
				CreditCardFactory creditCardFactory = new DiscoverFactory();
				return creditCardFactory.generateCreditCard(vo);
			}
		} catch (CreditCardException e) {
			// TODO: handle exception
			return nextHandler.handle(vo);
		}

		return nextHandler.handle(vo);
	}
}
