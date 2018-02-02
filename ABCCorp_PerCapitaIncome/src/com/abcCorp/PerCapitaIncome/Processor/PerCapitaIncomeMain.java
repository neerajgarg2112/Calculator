package com.abcCorp.PerCapitaIncome.Processor;

import java.io.IOException;
import java.util.List;

import com.abcCorp.BO.InputBO;
import com.abcCorp.BO.OutputBO;
import com.abcCorp.FileHandler.FileFormatNotSupported;
import com.abcCorp.FileHandler.FileHandler;
import com.abcCorp.FileHandler.FileHandlerFactory;

public class PerCapitaIncomeMain {
	
	public static void main(String[] args) throws FileFormatNotSupported, IOException {

		String inputfilename = args[0] != null && args[0].length() > 0 ? args[0] : "C://temp/Sample_input.csv";
		String outputFileName = args[1] != null && args[1].length() > 0 ? args[1] : "C://temp/Sample_output2.csv";
		
		calculatePerCapitaIncome(inputfilename, outputFileName);
		

	}

	private static void calculatePerCapitaIncome(String inputfilename, String outputFileName)
			throws FileFormatNotSupported, IOException {
		
		FileHandlerFactory fileFactory = new FileHandlerFactory();
		Processor process = new ABCCorpProcessor();
		
		FileHandler fileHanlder =  fileFactory.getFileHandler(inputfilename);
		
		List<InputBO> inputBO = fileHanlder.HandleInputCSVFile(inputfilename);
		
		List<OutputBO> outputList = process.process(inputBO);
		
		fileHanlder.writeOutputFile(outputList, outputFileName);
	}
}
