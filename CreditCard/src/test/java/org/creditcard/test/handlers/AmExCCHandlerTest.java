package org.creditcard.test.handlers;

import org.creditcard.handlers.AmExCCHandler;
import org.creditcard.handlers.Handler;
import org.creditcard.products.AmExCC;
import org.creditcard.products.CreditCard;
import org.creditcard.vo.VO;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AmExCCHandlerTest {
	private VO vo;
	private CreditCard creditCard;
	private Handler handler;
	
	@Before
	public void setUp() {
		vo = new VO("341000000000000", "5/20/2030", "Eve");
		creditCard = new AmExCC(vo, "AmericanExpress");
		handler = new AmExCCHandler(null);
	}
	
	@Test
	public void generateCreditCardTest() {
		Assert.assertEquals(creditCard, handler.handle(vo));
	}
}
