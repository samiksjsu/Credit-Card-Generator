package org.creditcard.reader;

import java.util.ArrayList;

import org.creditcard.exception.CreditCardException;
import org.creditcard.vo.VO;

public interface Reader {
	ArrayList<VO> readFile(String inputPath) throws CreditCardException;
}
