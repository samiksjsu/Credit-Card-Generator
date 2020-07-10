package org.creditcard.factories;

import org.creditcard.products.CreditCard;
import org.creditcard.products.VisaCC;
import org.creditcard.vo.VO;

public class VisaFactory implements CreditCardFactory {

	public CreditCard generateCreditCard(VO vo) {
		// TODO Auto-generated method stub
		return new VisaCC(vo, "Visa");
	}
	
}
