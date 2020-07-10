package org.creditcard.test.reader;

import java.util.ArrayList;

import org.creditcard.exception.CreditCardException;
import org.creditcard.reader.Reader;
import org.creditcard.reader.XMLReader;
import org.creditcard.vo.VO;
import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;

public class XMLReaderTest {
	private String WORKING_DIR = System.getProperty("user.dir").replaceAll("\\\\", "////");
	private String inputPath = WORKING_DIR + "/src/test/resources/Input/Sample.xml";
	private Reader xmlReader;
	ArrayList<VO> vos;

	@Before
	public void setUp() {
		vos = new ArrayList<VO>();
		xmlReader = new XMLReader();
	}

	@Test
	public void readTest() throws CreditCardException {
		Assert.assertEquals(vos.getClass(), xmlReader.readFile(inputPath).getClass());
	}

	@Test(expected = CreditCardException.class)
	public void readTestNull() throws CreditCardException {
		xmlReader.readFile(null);
	}
}
