package com.Sapient.FileHandler;

public class FileFactory {
	public HandlesAllTypeOfFiles processFiles(String filename) throws FileFormatNotSupportedException {
		String name = filename.substring(filename.length() - 3);
		if (name.equalsIgnoreCase("csv")) {
			return new CSVFileHandler();
		} else if (name.equalsIgnoreCase("xls")) {
			return new ExcelFileHandler();
		} else
			throw new FileFormatNotSupportedException("This file format is not supported");

	}
}
