package com.abcCorp.PerCapitaIncome.Processor;

import java.io.IOException;
import java.util.List;

import com.abcCorp.BO.InputBO;
import com.abcCorp.BO.OutputBO;

public interface Processor {

	public List<OutputBO> process(List<InputBO> inputList) throws IOException;
}
