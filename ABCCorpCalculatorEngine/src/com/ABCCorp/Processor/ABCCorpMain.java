package com.ABCCorp.Processor;

import java.io.IOException;

import com.ABCCorp.Filehandler.FileFormatNotSupportedException;

public class ABCCorpMain {
	public static void main(String[] args) throws FileFormatNotSupportedException, IOException {

		String inputFileName= checkArgument(args, 0) ? args[0] : "C://temp/sample_inputcalculator.csv";
		String outputFileName= checkArgument(args, 1)  ? args[1] : "C://temp/sample_outputcalculator.csv";
		String col1 = checkArgument(args, 2)  ? args[2] : "rating";
		String col2 = checkArgument(args, 3)  ? args[3] : "wty";
		String col3 = checkArgument(args, 4)  ? args[4] : "amount";
		//String inputFileName = "C://temp/sample_inputcalculator.csv";
		//String outputFileName = "C://temp/sample_outputcalculator.csv";
		ProcessFiles processfile= new ProcessFiles();
		processfile.ProcessInputOutputFiles(inputFileName, outputFileName,col1,col2,col3);

	}

	private static boolean checkArgument(String[] args, int index) {
		return args.length > index && args[index] != null && args[index].trim().length() > 0;
	}
}
