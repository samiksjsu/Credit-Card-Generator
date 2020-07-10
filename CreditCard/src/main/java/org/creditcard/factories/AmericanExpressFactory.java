package org.creditcard.factories;

import org.creditcard.products.AmExCC;
import org.creditcard.products.CreditCard;
import org.creditcard.vo.VO;

public class AmericanExpressFactory implements CreditCardFactory {

	public CreditCard generateCreditCard(VO vo) {
		// TODO Auto-generated method stub
		return new AmExCC(vo, "AmericanExpress");
	}

}
