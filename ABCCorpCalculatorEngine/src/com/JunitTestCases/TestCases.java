package com.JunitTestCases;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.print.attribute.HashAttributeSet;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.ABCCorp.BO.InputBO;
import com.ABCCorp.BO.OutputBO;
import com.ABCCorp.Processor.ABCProcessor;

public class TestCases {
	ABCProcessor process = null; 
	List<InputBO> list=null;
	Map<String,OutputBO> outMap =new HashMap<String,OutputBO>();
	@Before  
	    public void setUp() throws Exception {  
	         process = new ABCProcessor();
	        String data1[]= {"airline","bond","t1","h1","a+","12","10","100"};
	        String data2[]= {"airline","bond","t1","h2","a+","12","10","100"};
	        InputBO input1= new InputBO(data1);
	        InputBO input2= new InputBO(data2);
	         list= new ArrayList<InputBO>();
	        list.add(input1);
	        list.add(input2);
	    }  
	 @Test  
	    public void testProcessor(){  
	       outMap =process.processInputFile(list, "tier", "wty", "sox");
	       assertEquals(outMap.get("t1").getSum(),24.0D,0);
	    }  
	   @After  
	    public void tearDown() throws Exception {  
	          
	    }  
}
