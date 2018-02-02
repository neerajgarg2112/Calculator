package com.ABCCorp.BO;

import java.util.ArrayList;
import java.util.List;

public class OutputBO {
String ColumnName;
List<InputBO> list=new ArrayList<InputBO>();
double sum;
double avg;
public String getColumnName() {
	return ColumnName;
}
public void setColumnName(String columnName) {
	ColumnName = columnName;
}
public List<InputBO> getList() {
	return list;
}
public void setList(List<InputBO> list) {
	this.list = list;
}
public double getSum() {
	return sum;
}
public void setSum(double sum) {
	this.sum = sum;
}
public double getAvg() {
	return avg;
}
public void setAvg(double avg) {
	this.avg = avg;
}

}
