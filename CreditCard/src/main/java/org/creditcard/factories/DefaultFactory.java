package org.creditcard.factories;

import org.creditcard.products.CreditCard;
import org.creditcard.products.DefaultCC;
import org.creditcard.vo.VO;

public class DefaultFactory implements CreditCardFactory {

	public CreditCard generateCreditCard(VO vo) {
		// TODO Auto-generated method stub
		return new DefaultCC(vo, "DefaultCC");
	}

}
