package org.creditcard.service;

import java.util.ArrayList;

import org.apache.commons.io.FilenameUtils;
import org.creditcard.exception.CreditCardException;
import org.creditcard.handlers.Handler;
import org.creditcard.products.CreditCard;
import org.creditcard.reader.CSVFileReader;
import org.creditcard.reader.JSONReader;
import org.creditcard.reader.Reader;
import org.creditcard.reader.XMLReader;
import org.creditcard.responsibility.Responsibility;
import org.creditcard.utils.AcceptedFileTypes;
import org.creditcard.vo.VO;
import org.creditcard.writer.CSVFileWriter;
import org.creditcard.writer.JSONWriter;
import org.creditcard.writer.Writer;
import org.creditcard.writer.XMLWriter;

public class Service {

	private Reader reader;
	private Writer writer;
	private Handler handler;

	public Service() {

	}

	public void processInput(String inputPath, String outputPath) {
		ArrayList<VO> voList = new ArrayList<VO>();
		ArrayList<CreditCard> creditCards = new ArrayList<CreditCard>();
		handler = Responsibility.setResponsibility();

		String inputFileExtention = FilenameUtils.getExtension(inputPath);
		String outputFileExtention = FilenameUtils.getExtension(outputPath);
		
		AcceptedFileTypes acceptedFileTypes = new AcceptedFileTypes();
		
		try {

			if (inputFileExtention.equals(outputFileExtention) && acceptedFileTypes.hasFileType(inputFileExtention)
					&& acceptedFileTypes.hasFileType(outputFileExtention)) {
				if (inputFileExtention.equals("json")) {
					System.out.println("Reading json file----->");
					reader = new JSONReader();
				} else if (inputFileExtention.equals("csv")) {
					System.out.println("Reading csv file----->");
					reader = new CSVFileReader();
				} else if (inputFileExtention.equals("xml")) {
					System.out.println("Reading xml file----->");
					reader = new XMLReader();
				}

				voList = reader.readFile(inputPath);
				for (VO vo : voList) {
					System.out.println("Generating card " + vo);
					CreditCard creditCard = handler.handle(vo);
					System.out.println("Card Generated " + creditCard);
					creditCards.add(creditCard);
				}

				if (inputFileExtention.equals("json")) {
					System.out.println("Writing json file----->");
					writer = new JSONWriter();
				} else if (inputFileExtention.equals("csv")) {
					System.out.println("Writing csv file----->");
					writer = new CSVFileWriter();
				} else if (inputFileExtention.equals("xml")) {
					System.out.println("Writing xml file----->");
					writer = new XMLWriter();
				}

				writer.write(creditCards, outputPath);
				System.out.println("All input files have been succesfully processed");
				System.out.println("Please check output at " + outputPath);
			} else {
				throw new CreditCardException("File type error");
			}

		} catch (CreditCardException e) {
			System.out.println(e.getErrorMessage());
		}

	}
}
