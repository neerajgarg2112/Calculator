package com.Sapient.Processor;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.Sapient.BO.InputBO;
import com.Sapient.BO.OutputBO;

public class SapientDataProcessor {
	public List<OutputBO> dataprocessor(List<InputBO> inputList) {

		String key = null;
		ProcessingFee fee = new ProcessingFee();
		double newFee = 0;
		OutputBO out = null;
		InputBO item2 = null;
		InputBO item1 = null;
		// ProcessingFeeCalculate feecalculate= new ProcessingFeeCalculateImpl();
		double processingFee = 0;
		boolean flag = true;
		ProcessingFee pf = new ProcessingFee();
		Map<String, OutputBO> outputMap = new HashMap<String, OutputBO>();
		for (InputBO input : inputList) {
			/*
			 * item2=input; if(flag) { item1=item2; flag=false; continue;
			 * 
			 * } processingFee = feecalculate.intradayTransaction(item1, item2);
			 * item1=item2; if(processingFee == 0) { processingFee =
			 * feecalculate.normalTransaction(input); }
			 */
			// newFee = fee.processFee(input);
			processingFee = pf.processFee(inputList, input);

			key = input.getClientID() + input.getTransactionType() + input.getTransactionDate() + input.getPriority();

			if (!outputMap.containsKey(key)) {
				out = new OutputBO();
				outputMap.put(key, out);
			} else {
				outputMap.get(key);
			}
			out.setClientID(input.getClientID());
			out.setTransactionDate(input.getTransactionDate());
			out.setTransactionType(input.getTransactionType());
			out.setPriority(input.getPriority());
			out.setProcessingFee(processingFee);
		}
		List<OutputBO> outList = new LinkedList<>(outputMap.values());
		Collections.sort(outList, new FeeComparator());
		for (Entry<String, OutputBO> map : outputMap.entrySet()) {
			System.out.println(map.getValue().getClientID() + " " + map.getValue().getTransactionType() + " "
					+ map.getValue().getTransactionDate() + " " + map.getValue().getPriority() + " "
					+ map.getValue().getProcessingFee());
		}
		return outList;
	}
}
