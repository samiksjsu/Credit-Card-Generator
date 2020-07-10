package org.creditcard.test.reader;

import java.util.ArrayList;

import org.creditcard.exception.CreditCardException;
import org.creditcard.reader.CSVFileReader;
import org.creditcard.reader.Reader;
import org.creditcard.vo.VO;
import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;

public class CSVFileReaderTest {
	private String WORKING_DIR = System.getProperty("user.dir").replaceAll("\\\\", "////");
	private String inputPath = WORKING_DIR + "/src/test/resources/Input/Sample.csv";
	private Reader csvReader;
	ArrayList<VO> vos;
	
	@Before
	public void setUp() {
		vos = new ArrayList<VO>();
		csvReader = new CSVFileReader();
	}
	
	@Test
	public void readTest() throws CreditCardException{
		Assert.assertEquals(vos.getClass(), csvReader.readFile(inputPath).getClass());
	}
	
	@Test(expected=CreditCardException.class)
	public void readTestNull() throws CreditCardException {
		csvReader.readFile(null);
	}
	
}
