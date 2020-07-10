package org.creditcard.test.handlers;

import org.creditcard.handlers.DefaultHandler;
import org.creditcard.handlers.Handler;
import org.creditcard.products.CreditCard;
import org.creditcard.products.DefaultCC;
import org.creditcard.vo.VO;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DefaultCCHandlerTest {
	private VO vo;
	private CreditCard creditCard;
	private Handler handler;
	
	@Before
	public void setUp() {
		vo = new VO("60000000025", "4/20/2030", "Bob");
		creditCard = new DefaultCC(vo, "DefaultCC");
		handler = new DefaultHandler(null);
	}
	
	@Test
	public void generateCreditCardTest() {
		Assert.assertEquals(creditCard, handler.handle(vo));
	}
}
