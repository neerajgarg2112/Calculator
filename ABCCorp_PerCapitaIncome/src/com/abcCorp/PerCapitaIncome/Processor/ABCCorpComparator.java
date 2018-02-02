package com.abcCorp.PerCapitaIncome.Processor;

import java.util.Comparator;

import com.abcCorp.BO.OutputBO;

public class ABCCorpComparator implements Comparator<OutputBO> {

	@Override
	public int compare(OutputBO o1, OutputBO o2) {
		// TODO Auto-generated method stub
		int countryorcity = o1.getCountryOrCity().compareTo(o2.getCountryOrCity());
		if (countryorcity == 0) {

			if (o1.getGender().compareTo(o2.getGender()) == 0) {

				return o1.getAverageIncome().compareTo(o2.getAverageIncome());
			}
			return o1.getGender().compareTo(o2.getGender());
		}

		return countryorcity;
	}

}
