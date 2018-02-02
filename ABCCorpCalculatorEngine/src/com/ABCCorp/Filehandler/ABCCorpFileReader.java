package com.ABCCorp.Filehandler;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import com.ABCCorp.BO.InputBO;
import com.ABCCorp.BO.OutputBO;

public interface ABCCorpFileReader {
List<InputBO> readInputFile(String filename) throws FileNotFoundException, IOException;
void writeOutputFile(Map<String,OutputBO> outMap,String filename,String col1,String col2,String col3) throws IOException;
}
