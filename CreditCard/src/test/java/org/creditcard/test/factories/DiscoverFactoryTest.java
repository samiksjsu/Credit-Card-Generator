package org.creditcard.test.factories;

import org.creditcard.factories.CreditCardFactory;
import org.creditcard.factories.DiscoverFactory;
import org.creditcard.products.CreditCard;
import org.creditcard.products.DiscoverCC;
import org.creditcard.vo.VO;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DiscoverFactoryTest {
	VO vo;
	CreditCard creditCard;
	CreditCardFactory creditCardFactory;
	
	@Before
	public void setUp() {
		vo = new VO("6011000000000025", "4/20/2030", "Bob");
		creditCard = new DiscoverCC(vo, "Discover");
		creditCardFactory = new DiscoverFactory();
	}
	
	@Test
	public void generateCreditCardTest() {
		Assert.assertEquals(creditCard, creditCardFactory.generateCreditCard(vo));
	}
}
