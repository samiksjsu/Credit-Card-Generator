package org.creditcard.writer;

import java.io.FileWriter;
import java.util.ArrayList;

import org.creditcard.exception.CreditCardException;
import org.creditcard.products.CreditCard;
import org.json.JSONObject;
import org.json.simple.JSONArray;

public class JSONWriter implements Writer {

	public void write(ArrayList<CreditCard> creditCards, String outputPath) throws CreditCardException {
		// TODO Auto-generated method stub

		try {
			JSONArray creditCardsArray = new JSONArray();

			for (CreditCard creditCard : creditCards) {
				JSONObject obj = new JSONObject();
				obj.put("CardNumber", creditCard.getCardNumber());

				if (creditCard.getType().equals("DefaultCC")) {
					obj.put("CardType", "Invalid");
					obj.put("Error", "InvalidCardNumber");
				} else {
					obj.put("CardType", creditCard.getType());
					obj.put("Error", "None");
				}

				creditCardsArray.add(obj);
			}

			FileWriter fileWriter = new FileWriter(outputPath);
			fileWriter.write(creditCardsArray.toJSONString());
			fileWriter.flush();
			fileWriter.close();
		} catch (Exception e) {
			// TODO: handle exception
			throw new CreditCardException("Error while writing file");
		}
	}

}
