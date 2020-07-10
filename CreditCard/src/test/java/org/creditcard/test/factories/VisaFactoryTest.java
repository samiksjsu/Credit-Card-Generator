package org.creditcard.test.factories;

import org.creditcard.factories.CreditCardFactory;
import org.creditcard.factories.VisaFactory;
import org.creditcard.products.CreditCard;
import org.creditcard.products.VisaCC;
import org.creditcard.vo.VO;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class VisaFactoryTest {
	VO vo;
	CreditCard creditCard;
	CreditCardFactory creditCardFactory;
	
	@Before
	public void setUp() {
		vo = new VO("4120000000000", "4/20/2030", "Bob");
		creditCard = new VisaCC(vo, "Visa");
		creditCardFactory = new VisaFactory();
	}
	
	@Test
	public void generateCreditCardTest() {
		Assert.assertEquals(creditCard, creditCardFactory.generateCreditCard(vo));
	}
}
