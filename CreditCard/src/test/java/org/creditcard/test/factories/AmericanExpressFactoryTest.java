package org.creditcard.test.factories;

import org.creditcard.factories.AmericanExpressFactory;
import org.creditcard.factories.CreditCardFactory;
import org.creditcard.products.AmExCC;
import org.creditcard.products.CreditCard;
import org.creditcard.vo.VO;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AmericanExpressFactoryTest {
	VO vo;
	CreditCard creditCard;
	CreditCardFactory creditCardFactory;
	
	@Before
	public void setUp() {
		vo = new VO("341000000000000", "5/20/2030", "Eve");
		creditCard = new AmExCC(vo, "AmericanExpress");
		creditCardFactory = new AmericanExpressFactory();
	}	
	
	@Test
	public void generateCreditCardTest() {
		Assert.assertEquals(creditCard, creditCardFactory.generateCreditCard(vo));
	}
}
