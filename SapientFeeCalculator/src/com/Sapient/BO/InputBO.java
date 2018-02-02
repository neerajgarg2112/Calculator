package com.Sapient.BO;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class InputBO {
	private String externalTransactionID;
	private String clientID;
	private String securityID;
	private TransactionType transactionType;
	private Date transactionDate;
	private double marketValue;
	private PriorityBO priority;

	// DateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
	public InputBO(String[] line) throws ParseException {
		this.externalTransactionID = line[0];
		this.clientID = line[1];
		this.securityID = line[2];
		this.transactionType = TransactionType.valueOf(line[3]);
		this.transactionDate = new SimpleDateFormat("dd-mm-yyyy").parse(line[4]);
		this.marketValue = Double.parseDouble(line[5]);
		this.priority = PriorityBO.valueOf(line[6]);

	}

	public String getExternalTransactionID() {
		return externalTransactionID;
	}

	public void setExternalTransactionID(String externalTransactionID) {
		this.externalTransactionID = externalTransactionID;
	}

	public String getClientID() {
		return clientID;
	}

	public void setClientID(String clientID) {
		this.clientID = clientID;
	}

	public String getSecurityID() {
		return securityID;
	}

	public void setSecurityID(String securityID) {
		this.securityID = securityID;
	}

	public TransactionType getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(TransactionType transactionType) {
		this.transactionType = transactionType;
	}

	public Date getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}

	public double getMarketValue() {
		return marketValue;
	}

	public void setMarketValue(double marketValue) {
		this.marketValue = marketValue;
	}

	public PriorityBO getPriority() {
		return priority;
	}

	public void setPriority(PriorityBO priority) {
		this.priority = priority;
	}

}
