package org.ics.facade;

import java.util.List;

import javax.ejb.Local;

import org.ics.ejb.Exercise;
import org.ics.ejb.ExerciseRow;
import org.ics.ejb.ExerciseRowID;
import org.ics.ejb.User;
import org.ics.ejb.WorkoutDay;
import org.ics.ejb.WorkoutDayID;
import org.ics.ejb.WorkoutSchedule;

@Local
public interface FacadeLocal {
	public Exercise findByExerciseId(long exId);
	public Exercise createExercise(Exercise e);
	public Exercise updateExercise(Exercise e);
	public void deleteExercise(long exId);
	
	public List<Exercise> findAllExercises();
	public List<Exercise> findExercisesByName(String name);

	
	public WorkoutSchedule findByWorkoutScheduleId(long wsId);
	public WorkoutSchedule createWorkoutSchedule(WorkoutSchedule w);
	public WorkoutSchedule updateWorkoutSchedule(WorkoutSchedule w);
	public void deleteWorkoutSchedule(long wsId);
	
	public List<WorkoutSchedule> findAllWorkoutSchedules();
	public List<WorkoutSchedule> findWorkoutScheduleByName(String wsName);
	
	public WorkoutDay findByWorkoutDayId(WorkoutDayID wdNbr);
	public WorkoutDay createWorkoutDay(WorkoutDay wd);
	public WorkoutDay updateWorkoutDay(WorkoutDay wd);
	public void deleteWorkoutDay(WorkoutDayID wdNbr);
	
//	public List<WorkoutDay> findAllFromWsById(WorkoutDay wdNbr);
	
	public ExerciseRow findExerciseRowById(ExerciseRowID wdNbr);
	public ExerciseRow createExerciseRow(ExerciseRow exr);
	public ExerciseRow updateExerciseRow(ExerciseRow exr);
	public void deleteExerciseRow(ExerciseRowID wdNbr);
	
	public User findUserByUserName(String userName);
	public User createUser(User u);
    public User update(User u);
    public void deleteUser(String userName);
    public List<User>findUser(String userName);
	public boolean authenticateUser(String userName, String passWord);
	public List<User> findAllUsers();
}
