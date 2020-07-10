package org.creditcard.test.handlers;

import org.creditcard.handlers.DiscoverCCHandler;
import org.creditcard.handlers.Handler;
import org.creditcard.products.CreditCard;
import org.creditcard.products.DiscoverCC;
import org.creditcard.vo.VO;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DiscoverCCHandlerTest {
	private VO vo;
	private CreditCard creditCard;
	private Handler handler;
	
	@Before
	public void setUp() {
		vo = new VO("6011000000000025", "4/20/2030", "Bob");
		creditCard = new DiscoverCC(vo, "Discover");
		handler = new DiscoverCCHandler(null);
	}
	
	@Test
	public void generateCreditCardTest() {
		Assert.assertEquals(creditCard, handler.handle(vo));
	}
}
