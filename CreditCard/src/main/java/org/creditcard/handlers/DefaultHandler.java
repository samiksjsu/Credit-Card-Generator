package org.creditcard.handlers;

import org.creditcard.exception.CreditCardException;
import org.creditcard.factories.CreditCardFactory;
import org.creditcard.factories.DefaultFactory;
import org.creditcard.products.CreditCard;
import org.creditcard.vo.VO;

public class DefaultHandler implements Handler {

	private Handler nextHandler;

	public DefaultHandler(Handler nextHandler) {
		// TODO Auto-generated constructor stub
		this.nextHandler = null;
	}

	public boolean validCard(VO vo) throws CreditCardException {
		return false;
	}

	public CreditCard handle(VO vo) {

		// TODO Auto-generated method stub
		CreditCardFactory creditCardFactory = new DefaultFactory();
		return creditCardFactory.generateCreditCard(vo);
	}

}
