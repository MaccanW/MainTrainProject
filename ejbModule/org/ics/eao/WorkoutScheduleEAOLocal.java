package org.ics.eao;

import java.util.List;

import javax.ejb.Local;

import org.ics.ejb.WorkoutSchedule;

@Local
public interface WorkoutScheduleEAOLocal {
	public WorkoutSchedule findByWorkoutScheduleId(long wsId);
	public WorkoutSchedule createWorkoutSchedule(WorkoutSchedule w);
	public WorkoutSchedule updateWorkoutSchedule(WorkoutSchedule w);
	public void deleteWorkoutSchedule(long wsId);
	
	public List<WorkoutSchedule>findAll();
	public List<WorkoutSchedule>findByName(String wsName);

}
