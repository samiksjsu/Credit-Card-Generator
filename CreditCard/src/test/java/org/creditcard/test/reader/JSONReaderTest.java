package org.creditcard.test.reader;

import java.util.ArrayList;

import org.creditcard.exception.CreditCardException;
import org.creditcard.reader.JSONReader;
import org.creditcard.reader.Reader;
import org.creditcard.vo.VO;
import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;

public class JSONReaderTest {
	private String WORKING_DIR = System.getProperty("user.dir").replaceAll("\\\\", "////");
	private String inputPath = WORKING_DIR + "/src/test/resources/Input/Sample.json";
	private Reader jsonReader;
	ArrayList<VO> vos;

	@Before
	public void setUp() {
		vos = new ArrayList<VO>();
		jsonReader = new JSONReader();
	}

	@Test
	public void readTest() throws CreditCardException {
		Assert.assertEquals(vos.getClass(), jsonReader.readFile(inputPath).getClass());
	}

	@Test(expected = CreditCardException.class)
	public void readTestNull() throws CreditCardException {
		jsonReader.readFile(null);
	}
}
