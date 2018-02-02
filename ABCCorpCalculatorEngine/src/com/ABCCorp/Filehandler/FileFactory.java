package com.ABCCorp.Filehandler;

public class FileFactory {
public ABCCorpFileReader typeOfFile(String filename) throws FileFormatNotSupportedException
{
	String name=filename.substring(filename.length()-3);
	if(name.equalsIgnoreCase("csv"))
	{
		return new CSVFileReader();
	}
	else if(name.equalsIgnoreCase("xls"))
	{
		return new ExcelFileReader();
	}
	else
	{
		throw new FileFormatNotSupportedException("File format not supported");
	}
}
}
