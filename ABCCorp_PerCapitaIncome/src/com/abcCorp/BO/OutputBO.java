package com.abcCorp.BO;

import java.util.ArrayList;
import java.util.List;

public class OutputBO {
	String CountryOrCity;
	// String Gender;
	Gender gender;
	String AverageIncome;
	double sum;
	List<InputBO> listInput = new ArrayList<InputBO>();

	public String getCountryOrCity() {
		return CountryOrCity;
	}

	public void setCountryOrCity(String countryOrCity) {
		CountryOrCity = countryOrCity;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public String getAverageIncome() {
		return AverageIncome;
	}

	public void setAverageIncome(String averageIncome) {
		AverageIncome = averageIncome;
	}

	public double getSum() {
		return sum;
	}

	public void setSum(double sum) {
		this.sum = sum;
	}

	public List<InputBO> getListInput() {
		return listInput;
	}

	public void setListInput(List<InputBO> listInput) {
		this.listInput = listInput;
	}

}
