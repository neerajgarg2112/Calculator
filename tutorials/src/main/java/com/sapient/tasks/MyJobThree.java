package com.sapient.tasks;

import org.quartz.DisallowConcurrentExecution;
import org.springframework.stereotype.Service;

@DisallowConcurrentExecution
@Service("jobthree")
public class MyJobThree {
    protected void myTask() throws InterruptedException {
    	System.out.println("Executing 3");
    	Thread.sleep(1000);
    }
} 
