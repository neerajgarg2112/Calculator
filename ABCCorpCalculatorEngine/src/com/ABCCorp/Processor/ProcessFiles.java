package com.ABCCorp.Processor;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import com.ABCCorp.BO.InputBO;
import com.ABCCorp.BO.OutputBO;
import com.ABCCorp.Filehandler.CSVFileReader;
import com.ABCCorp.Filehandler.FileFactory;
import com.ABCCorp.Filehandler.FileFormatNotSupportedException;
import com.ABCCorp.Filehandler.ABCCorpFileReader;

public class ProcessFiles {
public void ProcessInputOutputFiles(String inputFile,String OutputFile,String col1,String col2,String col3) throws FileFormatNotSupportedException, IOException
{
	FileFactory factory= new FileFactory();
	
	ABCCorpFileReader fileread = factory.typeOfFile(inputFile);
	List<InputBO> inputList= fileread.readInputFile(inputFile);
	ABCProcessor processor =new ABCProcessor();
	Map<String,OutputBO> outMap = processor.processInputFile(inputList,col1,col2,col3);
	fileread.writeOutputFile(outMap, OutputFile,col1,col2,col3);
}
}
