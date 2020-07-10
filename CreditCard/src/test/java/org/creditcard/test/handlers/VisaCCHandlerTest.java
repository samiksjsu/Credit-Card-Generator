package org.creditcard.test.handlers;

import org.creditcard.handlers.Handler;
import org.creditcard.handlers.VisaCCHandler;
import org.creditcard.products.CreditCard;
import org.creditcard.products.VisaCC;
import org.creditcard.vo.VO;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class VisaCCHandlerTest {
	private VO vo;
	private CreditCard creditCard;
	private Handler handler;
	
	@Before
	public void setUp() {
		vo = new VO("4120000000000", "4/20/2030", "Bob");
		creditCard = new VisaCC(vo, "Visa");
		handler = new VisaCCHandler(null);
	}
	
	@Test
	public void generateCreditCardTest() {
		Assert.assertEquals(creditCard, handler.handle(vo));
	}
}
