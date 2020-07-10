package org.creditcard.factories;

import org.creditcard.products.CreditCard;
import org.creditcard.products.DiscoverCC;
import org.creditcard.vo.VO;

public class DiscoverFactory implements CreditCardFactory {

	public CreditCard generateCreditCard(VO vo) {
		// TODO Auto-generated method stub
		return new DiscoverCC(vo, "Discover");
	}

}
