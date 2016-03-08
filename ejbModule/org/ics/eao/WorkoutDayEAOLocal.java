package org.ics.eao;

import java.util.List;

import javax.ejb.Local;

import org.ics.ejb.WorkoutDay;
import org.ics.ejb.WorkoutDayID;

@Local
public interface WorkoutDayEAOLocal {
	public WorkoutDay findWorkoutDayById(WorkoutDayID wdNbr);
	public WorkoutDay createWorkoutDay(WorkoutDay wd);
	public WorkoutDay updateWorkoutDay(WorkoutDay wd);
	public void deleteWorkoutDay(WorkoutDayID wdNbr);
	
//	public List<WorkoutDay>findAllFromWsById(WorkoutDay wdNbr);
	}
	
