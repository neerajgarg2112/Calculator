package com.abcCorp.FileHandler;

public class FileHandlerFactory {
	
	public FileHandler getFileHandler(String filename) throws FileFormatNotSupported {
		
		String name = filename.substring(filename.length() - 3);
		
		if (name.equalsIgnoreCase("csv")) {
			return new CSVFileHandler();
		} else if (name.equalsIgnoreCase("xls")) {
			return new EXCELFileHandler();
		} else {
			throw new FileFormatNotSupported("File format not supported");
		}
		
	}
}
