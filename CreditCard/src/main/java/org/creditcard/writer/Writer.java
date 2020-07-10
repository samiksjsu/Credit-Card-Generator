package org.creditcard.writer;

import java.util.ArrayList;

import org.creditcard.exception.CreditCardException;
import org.creditcard.products.CreditCard;

public interface Writer {
	void write(ArrayList<CreditCard> creditCards, String outputPath) throws CreditCardException;
}
