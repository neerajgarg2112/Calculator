package com.Sapient.Processor;

import java.util.Comparator;

import com.Sapient.BO.OutputBO;

public class FeeComparator implements Comparator<OutputBO> {

	@Override
	public int compare(OutputBO o1, OutputBO o2) {
		// TODO Auto-generated method stub
		if (o1.getClientID().compareTo(o2.getClientID()) == 0) {
			if (o1.getTransactionType().compareTo(o2.getTransactionType()) == 0) {
				if (o1.getTransactionDate().compareTo(o2.getTransactionDate()) == 0) {
					return (o1.getPriority().compareTo(o2.getPriority()));
				}
				return o1.getTransactionDate().compareTo(o2.getTransactionDate());
			}
			return o1.getTransactionType().compareTo(o2.getTransactionType());
		}
		return o1.getClientID().compareTo(o2.getClientID());
	}

}
