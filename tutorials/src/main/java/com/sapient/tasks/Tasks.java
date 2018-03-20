package com.sapient.tasks;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import org.springframework.context.annotation.Scope;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

public class Tasks {
	
	static Map<String,TaskHolder> tasks = new HashMap<>();
	
	DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

	@Scheduled (fixedDelay = 50000)
	public void testTask1() {
		TaskHolder t = new TaskHolder();
		t.setTaskName("Task 1");
		t.setTimmings("50000");
		t.setRunning(true);
		StopWatch s = new StopWatch();
		
		s.start();
		System.out.println("Task 1  started" + dateFormat.format(Calendar.getInstance().getTime()));
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Task 1  completed" + dateFormat.format(Calendar.getInstance().getTime()));
		s.stop();
		t.setLastRunTimmings(s.getLastTaskTimeMillis() + "");
		tasks.put("Task 1",t);
		
	}
	
	@Scheduled (fixedDelay = 50000)
	public void testTask2() {
		
		System.out.println("Task 2  started" + dateFormat.format(Calendar.getInstance().getTime()));
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Task 2  completed" + dateFormat.format(Calendar.getInstance().getTime()));
		
	}
	
	@Scheduled (fixedDelay = 50000)
	public void testTask3() {
		
		System.out.println("Task 3 started" + dateFormat.format(Calendar.getInstance().getTime()));
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Task 3  completed" + dateFormat.format(Calendar.getInstance().getTime()));
		
	}
	
	@Scheduled (fixedDelay = 50000)
	public void testTask4() {
		System.out.println("Task 4  started" + dateFormat.format(Calendar.getInstance().getTime()));
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Task 4  completed" + dateFormat.format(Calendar.getInstance().getTime()));
		
	}
	
}
