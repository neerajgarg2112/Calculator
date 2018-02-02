package com.Sapient.FileHandler;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.util.List;

import com.Sapient.BO.InputBO;
import com.Sapient.BO.OutputBO;

public interface HandlesAllTypeOfFiles {
	List<InputBO> readFile(String filename) throws FileNotFoundException, IOException, ParseException;

	void writeFile(List<OutputBO> outList, String filename) throws IOException;
}
