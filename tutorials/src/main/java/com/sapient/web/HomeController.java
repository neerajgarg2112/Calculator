package com.sapient.web;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.quartz.JobKey;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.impl.matchers.GroupMatcher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.sapient.tasks.Student;

@RestController
public class HomeController {

	@Autowired
	private Scheduler scheduler;

	@RequestMapping(value="/hello", 
            method=RequestMethod.GET,
            produces={MediaType.APPLICATION_JSON_VALUE})
	public String hello() {
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Gson g = new Gson();
		
		return g.toJson("Hello World!");
	}
	
	@RequestMapping(value="/dataTable", 
            method=RequestMethod.GET,
            produces={MediaType.APPLICATION_JSON_VALUE})
	public String dataTable() {
		
		List<Student> s = makeStudentList();
		
		Gson g = new Gson();
		
		return g.toJson(s);
	}

	@RequestMapping("/jobs")
	public String getAllScheduledJobs() throws SchedulerException {

		List<String> strings = new ArrayList<String>();
		for (String groupName : scheduler.getJobGroupNames()) {

			for (JobKey jobKey : scheduler.getJobKeys(GroupMatcher.jobGroupEquals(groupName))) {

				String jobName = jobKey.getName();
				String jobGroup = jobKey.getGroup();

				//get job's trigger
				List<Trigger> triggers = (List<Trigger>) scheduler.getTriggersOfJob(jobKey);

				if(triggers != null && triggers.size() > 0 ) {
					Date nextFireTime = triggers.get(0).getNextFireTime(); 
					Date prevFireTime = triggers.get(0).getPreviousFireTime();

					System.out.println("[jobName] : " + jobName + " [groupName] : "
							+ jobGroup + " next fire time - " + nextFireTime  + " prev fire time - " + prevFireTime);
					System.out.println("Trigger Details : " + triggers.get(0));
					strings.add(jobName);
				}
			}

		}
		return new Gson().toJson(strings);
	}
	
	@RequestMapping("/triggerJob/{jobName}")
	public String triggerJob(@PathVariable("jobName") String jobNameToBeTriggered) throws SchedulerException {

		for (String groupName : scheduler.getJobGroupNames()) {

			for (JobKey jobKey : scheduler.getJobKeys(GroupMatcher.jobGroupEquals(groupName))) {

				String jobName = jobKey.getName();
		
				if(jobName.equalsIgnoreCase(jobNameToBeTriggered)) {
					scheduler.triggerJob(jobKey);
				}
				
			
			}

		}
		return new Gson().toJson("Success");
	}

	private List<Student> makeStudentList() {
		List<Student> s = new ArrayList<>();
		s.add(new Student(1, "Neeraj 1", "Ludhiana", 90f, 29, 200000));
		s.add(new Student(2, "Neeraj 2", "Ludhiana", 98f, 24, 60000));
		s.add(new Student(3, "Neeraj 3", "Ludhiana", 93f, 25, 340000));
		s.add(new Student(4, "Neeraj 4", "Ludhiana", 92f, 26, 6450000));
		s.add(new Student(5, "Neeraj 5", "Ludhiana", 95f, 22, 40000));
		s.add(new Student(6, "Neeraj 6", "Ludhiana", 80f, 21, 10000));
		
		return s;
	}



}
