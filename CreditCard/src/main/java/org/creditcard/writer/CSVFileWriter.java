package org.creditcard.writer;

import java.io.FileWriter;
import java.util.ArrayList;

import org.creditcard.exception.CreditCardException;
import org.creditcard.products.CreditCard;

import au.com.bytecode.opencsv.CSVWriter;

public class CSVFileWriter implements Writer {

	public void write(ArrayList<CreditCard> creditCards, String outputPath) throws CreditCardException {
		// TODO Auto-generated method stub

		try {
			CSVWriter writer = new CSVWriter(new FileWriter(outputPath));
			String[] headingArray = {"CardNumber", "CardType", "Error"};
			writer.writeNext(headingArray);
			
			for (CreditCard creditCard : creditCards) {
				if (creditCard.getType().equals("DefaultCC")) {
					String[] record = {creditCard.getCardNumber(), "Invalid", "InvalidCardNumber"};
					writer.writeNext(record);
				} else {
					String[] record = {creditCard.getCardNumber(), creditCard.getType(), "None"};
					writer.writeNext(record);
				}
				
			}
			writer.close();
		} catch (Exception e) {
			throw new CreditCardException("Error while writing file");
		}
	}

}
