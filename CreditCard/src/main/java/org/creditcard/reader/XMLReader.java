package org.creditcard.reader;

import java.io.FileReader;
import java.util.ArrayList;

import org.creditcard.exception.CreditCardException;
import org.creditcard.vo.VO;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.XML;

public class XMLReader implements Reader {

	public ArrayList<VO> readFile(String inputPath) throws CreditCardException{

		// TODO Auto-generated method stub
		try {

			JSONObject jsondata = XML.toJSONObject(new FileReader(inputPath));			
			JSONArray jsonArray = (JSONArray) ((JSONObject) jsondata.get("root")).get("row");
			ArrayList<VO> vos = new ArrayList<VO>();

			for (Object jsonObject : jsonArray) {

				JSONObject jsonVO = (JSONObject) jsonObject;

				VO vo = new VO(jsonVO.get("CardNumber").toString(), jsonVO.get("ExpirationDate").toString(),
						jsonVO.get("NameOfCardholder").toString());
				vos.add(vo);
			}

			return vos;

		} catch (Exception e) {
			// TODO: handle exception
			throw new CreditCardException("Unable to read JSON file");
		}
	}

}
