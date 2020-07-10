package org.creditcard.factories;

import org.creditcard.products.CreditCard;
import org.creditcard.vo.VO;

public interface CreditCardFactory {
	CreditCard generateCreditCard(VO vo);
}
