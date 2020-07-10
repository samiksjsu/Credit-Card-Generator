package org.creditcard.writer;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.creditcard.exception.CreditCardException;
import org.creditcard.products.CreditCard;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class XMLWriter implements Writer {

	public void write(ArrayList<CreditCard> creditCards, String outputPath) throws CreditCardException {
		// TODO Auto-generated method stub

		try {
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.newDocument();
			Element rootElement = doc.createElement("root");
			
			doc.appendChild(rootElement);
			for (CreditCard creditCard : creditCards) {

				Element row = doc.createElement("row");
				rootElement.appendChild(row);

				Element cardNumber = doc.createElement("CardNumber");

				cardNumber.appendChild(doc.createTextNode(creditCard.getCardNumber()));
				row.appendChild(cardNumber);

				if (creditCard.getType().equals("DefaultCC")) {
					Element cardType = doc.createElement("CardType");
					cardType.appendChild(doc.createTextNode("Invalid"));
					row.appendChild(cardType);

					Element error = doc.createElement("Error");
					error.appendChild(doc.createTextNode("InvalidCardNumber"));
					row.appendChild(error);
				} else {
					Element cardType = doc.createElement("CardType");
					cardType.appendChild(doc.createTextNode(creditCard.getType()));
					row.appendChild(cardType);

					Element error = doc.createElement("Error");
					error.appendChild(doc.createTextNode("None"));
					row.appendChild(error);
				}

				TransformerFactory transformerFactory = TransformerFactory.newInstance();
				Transformer transformer = transformerFactory.newTransformer();
				DOMSource source = new DOMSource(doc);

				StreamResult result = new StreamResult(new File(outputPath));
				transformer.transform(source, result);

			}
		} catch (Exception e) {
			throw new CreditCardException("Error while writing file");
		}
	}
}
