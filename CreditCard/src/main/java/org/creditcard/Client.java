package org.creditcard;

import org.creditcard.service.Service;

public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			String inputPath = args[0];
			String outputPath = args[1];
			
			Service service = new Service();
			service.processInput(inputPath, outputPath);
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println("Error: Not all arguments present");
		}
		
		
	}

}
