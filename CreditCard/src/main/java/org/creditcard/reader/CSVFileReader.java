package org.creditcard.reader;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import org.creditcard.exception.CreditCardException;
import org.creditcard.vo.VO;

import au.com.bytecode.opencsv.CSVReader;

public class CSVFileReader implements Reader {

	public ArrayList<VO> readFile(String inputPath) throws CreditCardException {
		// TODO Auto-generated method stub

		ArrayList<VO> vos = new ArrayList<VO>();
		
		try {
			CSVReader csvReader = new CSVReader(new FileReader(inputPath), ',', '"', 1);
			List<String[]> allRows = csvReader.readAll();
			for (String[] row : allRows) {
				VO vo = new VO(row[0].toString(), row[1].toString(), row[2].toString());
				vos.add(vo);
			}
			csvReader.close();

		} catch (Exception e) {
			// TODO: handle exception
			throw new CreditCardException("Unable to read C file");
		}
		
		return vos;
	}

}
