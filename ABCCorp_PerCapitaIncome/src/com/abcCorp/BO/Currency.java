package com.abcCorp.BO;

public enum Currency {
	USD(1), SGP(1.5), GBP(0.67), HKD(8), INR(66);
	double value;

	private Currency(double value) {
		// TODO Auto-generated constructor stub
		this.value = value;
	}

	public double convertCurrencyIntoUSD(double amount) {
		return amount / value;
	}
}
