package com.Sapient.Processor;

import com.Sapient.BO.InputBO;
import com.Sapient.BO.PriorityBO;
import com.Sapient.BO.TransactionType;

public class ProcessingFeeCalculateImpl implements ProcessingFeeCalculate {

	@Override
	public double intradayTransaction(InputBO input1, InputBO input2) {
		if (input1.getClientID().equalsIgnoreCase(input2.getClientID()) && input1.getSecurityID().equalsIgnoreCase(input2.getSecurityID())
				&& input1.getTransactionDate().compareTo(input2.getTransactionDate())==0) {
			if ((input1.getTransactionType() == TransactionType.BUY
					&& input2.getTransactionType() == TransactionType.SELL)
					|| (input1.getTransactionType() == TransactionType.SELL
							&& input2.getTransactionType() == TransactionType.BUY))

			{
				return 10;
			}
		}
		return 0;
	}

	@Override
	public double normalTransaction(InputBO input) {
		// TODO Auto-generated method stub
		if (input.getPriority() == PriorityBO.Y) {
			return 500;
		} else {
			if (input.getTransactionType() == TransactionType.SELL
					|| input.getTransactionType() == TransactionType.WITHDRAW) {
				return 100;
			} else if (input.getTransactionType() == TransactionType.BUY
					|| input.getTransactionType() == TransactionType.DEPOSIT) {
				return 50;
			}
		}
		return 0;
	}
}
