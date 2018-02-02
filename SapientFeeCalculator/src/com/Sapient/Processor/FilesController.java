package com.Sapient.Processor;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

import com.Sapient.BO.InputBO;
import com.Sapient.BO.OutputBO;
import com.Sapient.FileHandler.CSVFileHandler;
import com.Sapient.FileHandler.FileFactory;
import com.Sapient.FileHandler.FileFormatNotSupportedException;
import com.Sapient.FileHandler.HandlesAllTypeOfFiles;

public class FilesController {
	public void fileControl(String inputFileName, String outputFilename)
			throws FileFormatNotSupportedException, IOException, ParseException {
		FileFactory fileFactory = new FileFactory();
		fileFactory.processFiles(inputFileName);
		HandlesAllTypeOfFiles csvFileRead = new CSVFileHandler();
		List<InputBO> inputList = csvFileRead.readFile(inputFileName);
		SapientDataProcessor dataProcess = new SapientDataProcessor();
		List<OutputBO> outList = dataProcess.dataprocessor(inputList);
		csvFileRead.writeFile(outList, outputFilename);
	}
}
