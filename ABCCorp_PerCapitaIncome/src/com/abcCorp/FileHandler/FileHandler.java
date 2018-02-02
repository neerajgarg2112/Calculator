package com.abcCorp.FileHandler;

import java.io.IOException;
import java.util.List;

import com.abcCorp.BO.InputBO;
import com.abcCorp.BO.OutputBO;

public interface FileHandler {
	
	List<InputBO> HandleInputCSVFile(String filename);
	
	void writeOutputFile(List<OutputBO> outputList, String filename) throws IOException;
		
}
