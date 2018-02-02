package com.abcCorp.BO;

public class InputBO {
	String City;
	String Country;
	Gender gender;
	Currency currency;
	// String Gender;
	// String Currency;
	double AverageIncome;

	public InputBO(String[] data) {
		this.City = data[0];
		this.Country = data[1];
		this.gender = Gender.valueOf(data[2]);
		this.currency = Currency.valueOf(data[3]);
		this.AverageIncome = Double.parseDouble(data[4]);
	}

	public String getCity() {
		return City;
	}

	public void setCity(String city) {
		City = city;
	}

	public String getCountry() {
		return Country;
	}

	public void setCountry(String country) {
		Country = country;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public Currency getCurrency() {
		return currency;
	}

	public void setCurrency(Currency currency) {
		this.currency = currency;
	}

	public double getAverageIncome() {
		return AverageIncome;
	}

	public void setAverageIncome(double averageIncome) {
		AverageIncome = averageIncome;
	}

}
