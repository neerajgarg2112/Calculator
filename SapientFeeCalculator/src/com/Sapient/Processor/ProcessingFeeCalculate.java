package com.Sapient.Processor;

import com.Sapient.BO.InputBO;

public interface ProcessingFeeCalculate {
	double intradayTransaction(InputBO input1, InputBO input2);

	double normalTransaction(InputBO input);
}
