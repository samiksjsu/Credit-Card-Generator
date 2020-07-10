package org.creditcard.utils;

import java.util.HashSet;

public class AcceptedFileTypes {
	private static HashSet<String> acceptedFileTypes = new HashSet<String>();
	
	public AcceptedFileTypes() {
		acceptedFileTypes.add("json");
		acceptedFileTypes.add("xml");
		acceptedFileTypes.add("csv");
	}
	
	public static void addNewFileType(String fileType) {
		acceptedFileTypes.add(fileType);
	}
	
	public static boolean hasFileType(String fileType) {
		return acceptedFileTypes.contains(fileType);
	}
}
