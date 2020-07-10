package org.creditcard.test.writer;

import java.util.ArrayList;

import org.creditcard.exception.CreditCardException;
import org.creditcard.products.CreditCard;
import org.creditcard.writer.Writer;
import org.creditcard.writer.XMLWriter;
import org.junit.Before;
import org.junit.Test;

public class XMLWriterTest {
	private Writer xmlWriter;
	String outputPath;
	
	@Before
	public void setUp() {
		xmlWriter = new XMLWriter();
		outputPath = "C:\\Users\\samik\\Desktop\\Subjects\\CMPE 202\\Individual Project\\Sample Files\\Output.xml";
	}
	
	@Test(expected = CreditCardException.class)
	public void WriteTestAllNull() throws CreditCardException {
		xmlWriter.write(null, null);
	}
	
	@Test(expected = CreditCardException.class)
	public void WriteTestArrayNull() throws CreditCardException {
		xmlWriter.write(null, outputPath);
	}
	
	@Test
	public void WriteTestOutputPathNull() throws CreditCardException {
		xmlWriter.write(new ArrayList<CreditCard>(), null);
	}
}
