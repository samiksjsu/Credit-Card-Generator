package org.creditcard.test.factories;

import org.creditcard.factories.CreditCardFactory;
import org.creditcard.factories.DefaultFactory;
import org.creditcard.products.CreditCard;
import org.creditcard.products.DefaultCC;
import org.creditcard.vo.VO;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DefaultFactoryTest {
	VO vo;
	CreditCard creditCard;
	CreditCardFactory creditCardFactory;
	
	@Before
	public void setUp() {
		vo = new VO("412640000000000", "4/20/2030", "Bob");
		creditCard = new DefaultCC(vo, "DefaultCC");
		creditCardFactory = new DefaultFactory();
	}
	
	@Test
	public void generateCreditCardTest() {
		Assert.assertEquals(creditCard, creditCardFactory.generateCreditCard(vo));
	}
}
