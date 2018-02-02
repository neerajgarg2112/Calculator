package com.abcCorp.PerCapitaIncome.Processor;

import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.abcCorp.BO.Currency;
import com.abcCorp.BO.InputBO;
import com.abcCorp.BO.OutputBO;

public class ABCCorpProcessor implements Processor {
	
	public List<OutputBO> process(List<InputBO> inputList) throws IOException {
		double NewAvgIncome = 0;
		Currency currency = null;
		double avgIncome = 0;
		String CountryOrCity = null;
		String key = null;
		Map<String, OutputBO> outputMap = new HashMap<String, OutputBO>();
		// FileWriter writer =new FileWriter(new File("C://temp/sample_output.csv"));
		for (InputBO line : inputList) {
			currency = line.getCurrency();
			avgIncome = line.getAverageIncome();
			// NewAvgIncome = currencyconvert.currencyConvertor(currency, avgIncome);
			NewAvgIncome = currency.convertCurrencyIntoUSD(avgIncome);
			if (line.getCountry() != null && line.getCountry().trim().length() > 0) {
				CountryOrCity = line.getCountry();
			} else {
				CountryOrCity = line.getCity();
			}
			key = CountryOrCity + line.getGender();
			OutputBO out = null;
			if (!outputMap.containsKey(key)) {

				out = new OutputBO();
				out.setCountryOrCity(CountryOrCity);
				out.setGender(line.getGender());
				outputMap.put(key, out);

			} else {
				out = outputMap.get(key);
			}
			out.getListInput().add(line);
			out.setSum(NewAvgIncome + out.getSum());

		}
		List<OutputBO> outputBOList = new LinkedList<>(outputMap.values());

		Collections.sort(outputBOList, new ABCCorpComparator());
		return outputBOList;
		/*
		 * ; for(OutputBO l:outputBOList) {
		 * System.out.println(l.getCountryOrCity()+" "+l.getGender().name()+" "+(l.
		 * getSum()/l.getListInput().size()));
		 * writer.write(l.getCountryOrCity()+","+l.getGender().name()+","+(l.getSum()/l.
		 * getListInput().size())+"\n");
		 * 
		 * }
		 * 
		 * writer.flush(); writer.close();
		 */
	}

}
