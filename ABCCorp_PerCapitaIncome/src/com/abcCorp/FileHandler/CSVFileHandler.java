package com.abcCorp.FileHandler;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.abcCorp.BO.InputBO;
import com.abcCorp.BO.OutputBO;

public class CSVFileHandler implements FileHandler{
	
	public List<InputBO> HandleInputCSVFile(String filename) {
		
		File file = new File(filename);
		FileReader fr = null;
		BufferedReader br = null;
		String str = null;
		InputBO inputBo = null;
		List<InputBO> inputList = new ArrayList<InputBO>();
		
		try {
			fr = new FileReader(file);
			br = new BufferedReader(fr);
			br.readLine();
			while ((str = br.readLine()) != null) {

				String data[] = str.split(",");
				if (data.length < 1 || data.equals(null)) {
					break;
				}
				inputBo = new InputBO(data);
				inputList.add(inputBo);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return inputList;

	}
	
	public void writeOutputFile(List<OutputBO> outputList, String filename) throws IOException {
		FileWriter writer = new FileWriter(new File(filename));
		writer.write("CountryOrCity" + ",");
		writer.write("Gender" + ",");
		writer.write("avgIncome" + ",");
		writer.write("\n");
		for (OutputBO l : outputList) {
			// System.out.println(l.getCountryOrCity()+" "+l.getGender().name()+"
			// "+(l.getSum()/l.getListInput().size()));
			writer.write(l.getCountryOrCity() + "," + l.getGender().name() + ","
					+ (l.getSum() / l.getListInput().size()) + "\n");

		}

		writer.flush();
		writer.close();
	}
}
