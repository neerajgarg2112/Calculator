package com.ABCCorp.Processor;

import java.util.List;

import com.ABCCorp.BO.InputBO;

public class ColumnName implements getColumnName{


	@Override
	public String getSortColumnName(InputBO input, String columnName) {
		if(columnName.equalsIgnoreCase("tier"))
		{
			return input.getTier();
		}
		else if(columnName.equalsIgnoreCase("vendor"))
		{
			return input.getVendor();
		}
		else if(columnName.equalsIgnoreCase("rating"))
		{
			return input.getRating();
		}
		return null;
	}

	@Override
	public double getCalculationcolumnName(InputBO input, String columnName) {
		// TODO Auto-generated method stub
	 if(columnName.equalsIgnoreCase("wty"))
		{
			return input.getWty();
		}
		else if(columnName.equalsIgnoreCase("sox"))
		{
			return input.getSox();
		}
		else if(columnName.equalsIgnoreCase("amount"))
		{
			return input.getAmount();
		}
		return 0;
		
		
	}
}
