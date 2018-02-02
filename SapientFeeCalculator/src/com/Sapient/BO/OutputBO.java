package com.Sapient.BO;

import java.util.Date;

public class OutputBO {
	private String clientID;
	private TransactionType transactionType;
	private Date transactionDate;
	private PriorityBO priority;
	private double processingFee;

	public String getClientID() {
		return clientID;
	}

	public void setClientID(String clientID) {
		this.clientID = clientID;
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

	public PriorityBO getPriority() {
		return priority;
	}

	public void setPriority(PriorityBO priority) {
		this.priority = priority;
	}

	public double getProcessingFee() {
		return processingFee;
	}

	public void setProcessingFee(double processingFee) {
		this.processingFee = processingFee;
	}

}
