package org.creditcard.test.writer;

import java.util.ArrayList;

import org.creditcard.exception.CreditCardException;
import org.creditcard.products.CreditCard;
import org.creditcard.writer.CSVFileWriter;
import org.creditcard.writer.Writer;
import org.junit.Before;
import org.junit.Test;

public class CSVFileWriterTest {
	private Writer csvWriter;
	String outputPath;
	
	@Before
	public void setUp() {
		csvWriter = new CSVFileWriter();
		outputPath = "C:\\Users\\samik\\Desktop\\Subjects\\CMPE 202\\Individual Project\\Sample Files\\Output.csv";
	}
	
	@Test(expected = CreditCardException.class)
	public void WriteTestAllNull() throws CreditCardException {
		csvWriter.write(null, null);
	}
	
	@Test(expected = CreditCardException.class)
	public void WriteTestArrayNull() throws CreditCardException {
		csvWriter.write(null, outputPath);
	}
	
	@Test(expected = CreditCardException.class)
	public void WriteTestOutputPathNull() throws CreditCardException {
		csvWriter.write(new ArrayList<CreditCard>(), null);
	}
}
