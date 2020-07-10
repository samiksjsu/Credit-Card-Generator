package org.creditcard.test.handlers;

import org.creditcard.handlers.Handler;
import org.creditcard.handlers.MasterCCHandler;
import org.creditcard.products.CreditCard;
import org.creditcard.products.MasterCC;
import org.creditcard.responsibility.Responsibility;
import org.creditcard.vo.VO;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MasterCCHandlerTest {
	private VO vo;
	private CreditCard creditCard;
	private Handler handler;
	
	@Before
	public void setUp() {
		vo = new VO("5410000000000000", "3/20/2030", "Alice");
		creditCard = new MasterCC(vo, "MasterCard");
		handler = new MasterCCHandler(null);
	}
	
	@Test
	public void generateCreditCardTest() {
		Assert.assertEquals(creditCard, handler.handle(vo));
	}
}
