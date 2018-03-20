package com.sapient.tasks;

import org.quartz.DisallowConcurrentExecution;
import org.springframework.stereotype.Service;

@DisallowConcurrentExecution
@Service("jobone")
public class MyJobOne {
    protected void myTask() throws InterruptedException {
    	System.out.println("Executing 1");
    	Thread.sleep(1000);
    }
} 
