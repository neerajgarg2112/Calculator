package com.Sapient.Processor;

import java.io.IOException;
import java.text.ParseException;

import com.Sapient.FileHandler.FileFormatNotSupportedException;

import SapientConstants.Constants;

public class ProcessorMain {
	public static void main(String[] args) throws FileFormatNotSupportedException, IOException, ParseException {
		String inputFileName = args.length > 0 && args[0].length() > 0 && args[0] != null ? args[0]
				: Constants.INPUTFILENAME;
		String outputFilename = args.length > 0 && args[1].length() > 0 && args[1] != null ? args[1]
				: Constants.OUTPUTFILENAME;
		FilesController filecontrol = new FilesController();
		filecontrol.fileControl(inputFileName, outputFilename);
	}
}
