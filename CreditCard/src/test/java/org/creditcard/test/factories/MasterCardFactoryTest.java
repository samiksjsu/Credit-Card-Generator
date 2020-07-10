package org.creditcard.test.factories;

import org.creditcard.factories.CreditCardFactory;
import org.creditcard.factories.MasterCardFactory;
import org.creditcard.products.CreditCard;
import org.creditcard.products.MasterCC;
import org.creditcard.vo.VO;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MasterCardFactoryTest {
	
	VO vo;
	CreditCard creditCard;
	CreditCardFactory creditCardFactory;
	
	@Before
	public void setUp() {
		vo = new VO("5410000000000000", "3/20/2030", "Alice");
		creditCard = new MasterCC(vo, "MasterCard");
		creditCardFactory = new MasterCardFactory();
	}
	
	@Test
	public void generateCreditCardTest() {
		Assert.assertEquals(creditCard, creditCardFactory.generateCreditCard(vo));
	}
}
