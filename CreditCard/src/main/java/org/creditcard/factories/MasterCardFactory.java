package org.creditcard.factories;

import org.creditcard.products.CreditCard;
import org.creditcard.products.MasterCC;
import org.creditcard.vo.VO;

public class MasterCardFactory implements CreditCardFactory{

	public CreditCard generateCreditCard(VO vo) {
		// TODO Auto-generated method stub
		return new MasterCC(vo, "MasterCard");
	}

}
