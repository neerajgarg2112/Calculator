package com.Sapient.FileHandler;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.Sapient.BO.InputBO;
import com.Sapient.BO.OutputBO;

public class CSVFileHandler implements HandlesAllTypeOfFiles {

	@Override
	public List<InputBO> readFile(String filename) throws IOException, ParseException {
		FileReader fr = new FileReader(new File(filename));
		BufferedReader br = new BufferedReader(fr);
		br.readLine();
		String str = null;
		InputBO input = null;
		List<InputBO> inputList = new ArrayList<InputBO>();
		while ((str = br.readLine()) != null) {
			String[] data = str.split(",");
			if (data.length < 0) {
				break;
			}
			input = new InputBO(data);
			inputList.add(input);
		}
		return inputList;
	}

	@Override
	public void writeFile(List<OutputBO> outList, String outfilename) throws IOException {
		FileWriter writer = new FileWriter(outfilename);
		SimpleDateFormat format = new SimpleDateFormat("dd-mm-yyyy");
		writer.write("ClientID" + "," + "TransactionType" + "," + "Trnsactiondate" + "," + "Priority" + ","
				+ "ProcessingFee" + "\n");
		for (OutputBO out : outList) {
			writer.write(out.getClientID() + ",");
			writer.write(out.getTransactionType().name() + ",");
			writer.write(format.format(out.getTransactionDate()) + ",");
			writer.write(out.getPriority().name() + ",");
			writer.write(out.getProcessingFee() + "\n");

		}
		writer.flush();
		writer.close();
	}

}
