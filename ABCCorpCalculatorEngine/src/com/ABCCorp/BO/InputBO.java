package com.ABCCorp.BO;

public class InputBO {
String fin_Type;
String sub_Type;
String tier;
String vendor;
String rating;
double wty;
double sox;
double amount;
public InputBO(String[] line) {
this.fin_Type=line[0];
this.sub_Type=line[1];
this.tier=line[2];
this.vendor=line[3];
this.rating=line[4];
this.wty=Double.parseDouble(line[5]);
this.sox=Double.parseDouble(line[6]);
this.amount=Double.parseDouble(line[7]);
}
public String getFin_Type() {
	return fin_Type;
}
public void setFin_Type(String fin_Type) {
	this.fin_Type = fin_Type;
}
public String getSub_Type() {
	return sub_Type;
}
public void setSub_Type(String sub_Type) {
	this.sub_Type = sub_Type;
}
public String getTier() {
	return tier;
}
public void setTier(String tier) {
	this.tier = tier;
}
public String getVendor() {
	return vendor;
}
public void setVendor(String vendor) {
	this.vendor = vendor;
}
public String getRating() {
	return rating;
}
public void setRating(String rating) {
	this.rating = rating;
}
public double getWty() {
	return wty;
}
public void setWty(double wty) {
	this.wty = wty;
}
public double getSox() {
	return sox;
}
public void setSox(double sox) {
	this.sox = sox;
}
public double getAmount() {
	return amount;
}
public void setAmount(double amount) {
	this.amount = amount;
}

}
