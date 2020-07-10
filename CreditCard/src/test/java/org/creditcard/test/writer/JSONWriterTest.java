package org.creditcard.test.writer;

import java.util.ArrayList;

import org.creditcard.exception.CreditCardException;
import org.creditcard.products.CreditCard;
import org.creditcard.writer.JSONWriter;
import org.creditcard.writer.Writer;
import org.junit.Before;
import org.junit.Test;

public class JSONWriterTest {
	private Writer jsonWriter;
	String outputPath;
	
	@Before
	public void setUp() {
		jsonWriter = new JSONWriter();
		outputPath = "C:\\Users\\samik\\Desktop\\Subjects\\CMPE 202\\Individual Project\\Sample Files\\Output.json";
	}
	
	@Test(expected = CreditCardException.class)
	public void WriteTestAllNull() throws CreditCardException {
		jsonWriter.write(null, null);
	}
	
	@Test(expected = CreditCardException.class)
	public void WriteTestArrayNull() throws CreditCardException {
		jsonWriter.write(null, outputPath);
	}
	
	@Test(expected = CreditCardException.class)
	public void WriteTestOutputPathNull() throws CreditCardException {
		jsonWriter.write(new ArrayList<CreditCard>(), null);
	}
}
