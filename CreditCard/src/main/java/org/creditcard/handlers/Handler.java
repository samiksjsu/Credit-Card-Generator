package org.creditcard.handlers;

import org.creditcard.exception.CreditCardException;
import org.creditcard.products.CreditCard;
import org.creditcard.vo.VO;

public interface Handler {
	boolean validCard(VO vo) throws CreditCardException;
	CreditCard handle(VO vo);
}
