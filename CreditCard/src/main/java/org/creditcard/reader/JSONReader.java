package org.creditcard.reader;

import java.io.FileReader;
import java.util.ArrayList;

import org.creditcard.exception.CreditCardException;
import org.creditcard.vo.VO;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class JSONReader implements Reader {

	public ArrayList<VO> readFile(String inputPath) throws CreditCardException {
		
		// TODO Auto-generated method stub
		JSONParser jsonParser = new JSONParser();
		
		try {
			FileReader fileReader = new FileReader(inputPath);
			Object object = jsonParser.parse(fileReader);
			JSONArray jsonArray = (JSONArray) object;
			ArrayList<VO> vos = new ArrayList<VO>();
			
			for (Object jsonObject : jsonArray) {
				JSONObject jsonVO = (JSONObject) jsonObject;
				VO vo = new VO(jsonVO.get("CardNumber").toString(), jsonVO.get("ExpirationDate").toString(), jsonVO.get("NameOfCardholder").toString());
				vos.add(vo);
			}
			
			return vos;
			
		} catch (Exception e) {
			// TODO: handle exception
			throw new CreditCardException("Unable to read JSON file");
		}
	}

}
