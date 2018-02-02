package com.ABCCorp.Filehandler;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.ABCCorp.BO.InputBO;
import com.ABCCorp.BO.OutputBO;

public class CSVFileReader implements ABCCorpFileReader {

	@Override
	public List<InputBO> readInputFile(String filename) throws IOException {
		FileReader fr =new FileReader(new File(filename));
		BufferedReader br=new BufferedReader(fr);
		String str =null;
		InputBO inputbo= null;
		List<InputBO> inputList= new ArrayList<InputBO>();
		br.readLine();
		while((str=br.readLine())!=null)
		{
			String data[] =str.split(",");
			if(data.length<0)
			{
				break;
			}
			inputbo = new InputBO(data);
			inputList.add(inputbo);
		}
		return inputList;
	}

	@Override
	public void writeOutputFile(Map<String, OutputBO> outMap, String filename,String col1,String col2,String col3) throws IOException {

		FileWriter writer =new FileWriter(new File(filename));
		writer.write(col1+","+col2+","+col3+"\n");
		for(Entry<String,OutputBO> map:outMap.entrySet())
		{
			writer.write(map.getValue().getColumnName()+","+map.getValue().getSum()+","+
		((map.getValue().getSum())/map.getValue().getList().size())+"\n");
					
		}
		writer.flush();
		writer.close();
	}

	

}
