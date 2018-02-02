package com.Sapient.Processor;

import java.util.List;

import com.Sapient.BO.InputBO;

public class ProcessingFee {
	public double processFee(List<InputBO> list, InputBO item) {
		InputBO item2 = null;
		double processingFee = 0;
		ProcessingFeeCalculate feecalculate = new ProcessingFeeCalculateImpl();
		for (InputBO input : list) {
			item2 = input;
			processingFee = feecalculate.intradayTransaction(item, item2);
			if (processingFee != 0) {
				return processingFee;
			}
		}
		if (processingFee == 0) {
			processingFee = feecalculate.normalTransaction(item);
		}
		return processingFee;

	}
}
