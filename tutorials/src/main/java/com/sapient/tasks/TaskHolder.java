package com.sapient.tasks;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class TaskHolder {
	
	private String taskName;
	private String timmings;
	private boolean isRunning;
	private String lastRunTimmings;
	public String getTaskName() {
		return taskName;
	}
	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}
	public String getTimmings() {
		return timmings;
	}
	public void setTimmings(String timmings) {
		this.timmings = timmings;
	}
	public boolean isRunning() {
		return isRunning;
	}
	public void setRunning(boolean isRunning) {
		this.isRunning = isRunning;
	}
	public String getLastRunTimmings() {
		return lastRunTimmings;
	}
	public void setLastRunTimmings(String lastRunTimmings) {
		this.lastRunTimmings = lastRunTimmings;
	}
	
	

}
