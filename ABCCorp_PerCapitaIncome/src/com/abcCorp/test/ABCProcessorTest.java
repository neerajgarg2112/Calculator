package com.abcCorp.test;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.abcCorp.BO.InputBO;
import com.abcCorp.BO.OutputBO;
import com.abcCorp.FileHandler.FileFormatNotSupported;
import com.abcCorp.FileHandler.FileHandler;
import com.abcCorp.FileHandler.FileHandlerFactory;
import com.abcCorp.PerCapitaIncome.Processor.ABCCorpProcessor;

public class ABCProcessorTest {

	// List<OutputBO> outputList = new ArrayList<OutputBO>();

	private ABCCorpProcessor abcCorpProcessor;
	private List<InputBO> list = null;

	/** * Initialization */
	@Before
	public void setUp() {
		abcCorpProcessor = new ABCCorpProcessor();
		String[] data1 = new String[] { "NewDelhi", "India", "F", "INR", "2500" };
		String[] data2 = new String[] { "Houstan", "USA", "F", "USD", "100" };
		InputBO input1 = new InputBO(data1);
		InputBO input2 = new InputBO(data2);
		list = new ArrayList<InputBO>();
		list.add(input1);
		list.add(input2);
	}

	/**
	 * * Test case for add method
	 * 
	 * @throws IOException
	 */
	@Test
	public void testProcessor() throws IOException {

		List<OutputBO> outList = abcCorpProcessor.process(list);
		assertEquals(outList.get(0).getCountryOrCity(), "India");
	}
    @Test
	public void testFileHandler() throws FileFormatNotSupported {
		FileHandlerFactory fhf = new FileHandlerFactory();
		FileHandler fh= fhf.getFileHandler("C://temp/input.csv");
		assertEquals(fh.getClass().getName(),"com.abcCorp.FileHandler.CSVFileHandler");
	}

	/** * destroy the object */
	@After
	public void tearDown() {
		abcCorpProcessor = null;
		list = null;
	}
}
