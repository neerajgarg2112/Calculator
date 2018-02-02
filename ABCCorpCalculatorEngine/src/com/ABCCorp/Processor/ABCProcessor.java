package com.ABCCorp.Processor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ABCCorp.BO.InputBO;
import com.ABCCorp.BO.OutputBO;

public class ABCProcessor {
public Map<String,OutputBO> processInputFile(List<InputBO> inputList,String groupByColumn,String sumColumn,String avgColumn)
{
	Map<String,OutputBO> outputMap =new HashMap<String,OutputBO>();
	ColumnName cn=new ColumnName();
	for(InputBO item: inputList)
	{
		String sortName= cn.getSortColumnName(item,groupByColumn);
		double sumcolumn =cn.getCalculationcolumnName(item, sumColumn);
		//double avgcolumn =cn.getCalculationcolumnName(item, avgColumn);
		String key = sortName;
		OutputBO out=null;
		if(!outputMap.containsKey(key))
		{
			out =new OutputBO();
			outputMap.put(key,out );
		}
		else
		{
			out = outputMap.get(key);
		}
		out.setColumnName(sortName);
		out.setSum(sumcolumn+out.getSum());
		out.getList().add(item);
	}
	return outputMap;
}
}
