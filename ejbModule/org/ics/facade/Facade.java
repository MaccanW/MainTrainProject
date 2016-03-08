package org.ics.facade;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import org.ics.eao.ExerciseEAOLocal;
import org.ics.eao.ExerciseRowEAOLocal;
import org.ics.eao.UserEAOLocal;
import org.ics.eao.WorkoutDayEAOLocal;
import org.ics.eao.WorkoutScheduleEAOLocal;
import org.ics.ejb.Exercise;
import org.ics.ejb.ExerciseRow;
import org.ics.ejb.ExerciseRowID;
import org.ics.ejb.User;
import org.ics.ejb.WorkoutDay;
import org.ics.ejb.WorkoutDayID;
import org.ics.ejb.WorkoutSchedule;

/**
 * Session Bean implementation class facade
 */
@Stateless
public class Facade implements FacadeLocal {

	@EJB
	ExerciseEAOLocal exerciseEAO;
	@EJB
	WorkoutScheduleEAOLocal workoutScheduleEAO;
	@EJB
	WorkoutDayEAOLocal workoutDayEAO;
	@EJB
	ExerciseRowEAOLocal exerciseRowEAO;
	@EJB
	UserEAOLocal userEAO;
	
    public Facade() {
    }
    
    public Exercise findByExerciseId(long exId){
    	return exerciseEAO.findByExerciseId(exId);
    }
    
    public Exercise createExercise(Exercise e){
    	return exerciseEAO.createExercise(e);
    }
    
    public Exercise updateExercise(Exercise e){
    	return exerciseEAO.updateExercise(e);
    }
    
    public void deleteExercise(long exId){
    	exerciseEAO.deleteExercise(exId);
    }
    
    public List<Exercise> findAllExercises(){
    	return exerciseEAO.findAll();
    }

    public List<Exercise> findExercisesByName(String name){
    	return exerciseEAO.findByName(name);
    }
    
    public WorkoutSchedule findByWorkoutScheduleId(long wsId){
    	return workoutScheduleEAO.findByWorkoutScheduleId(wsId);
    }
    
    public WorkoutSchedule createWorkoutSchedule(WorkoutSchedule w){
    	return workoutScheduleEAO.createWorkoutSchedule(w);
    }
    
    public WorkoutSchedule updateWorkoutSchedule(WorkoutSchedule w){
    	return workoutScheduleEAO.updateWorkoutSchedule(w);
    }
    
    public void deleteWorkoutSchedule(long wsId){
    	workoutScheduleEAO.deleteWorkoutSchedule(wsId);
    }
    
    public List<WorkoutSchedule> findAllWorkoutSchedules(){
    	return workoutScheduleEAO.findAll();
    }
    
    public List<WorkoutSchedule> findWorkoutScheduleByName(String wsName){
    	return workoutScheduleEAO.findByName(wsName);
    }
    
    public WorkoutDay findByWorkoutDayId(WorkoutDayID wdNbr){
    	return workoutDayEAO.findWorkoutDayById(wdNbr);
    }
    
    public WorkoutDay createWorkoutDay(WorkoutDay wd){
    	return workoutDayEAO.createWorkoutDay(wd);
    }
    
    public WorkoutDay updateWorkoutDay(WorkoutDay wd){
    	return workoutDayEAO.updateWorkoutDay(wd);
    }
    
    public void deleteWorkoutDay(WorkoutDayID wdNbr){
    	workoutDayEAO.deleteWorkoutDay(wdNbr);
    }
    
//    public List<WorkoutDay> findAllFromWsById(WorkoutDay wdNbr){
//    	return workoutDayEAO.findAllFromWsById(wdNbr);
//    }
    
    public ExerciseRow findExerciseRowById(ExerciseRowID exrId){
    	return exerciseRowEAO.findExerciseRowById(exrId);
    }
	public ExerciseRow createExerciseRow(ExerciseRow exr){
		return exerciseRowEAO.createExerciseRow(exr);
	}
	public ExerciseRow updateExerciseRow(ExerciseRow exr){
		return exerciseRowEAO.updateExerciseRow(exr);
	}
	public void deleteExerciseRow(ExerciseRowID exrId){
		exerciseRowEAO.deleteExerciseRow(exrId);
	}

	//User
	
	 public void deleteUser(String userName){
		 userEAO.deleteUser(userName);
	 }
	 
	 public User findUserByUserName(String userName){
		return userEAO.findUserByUserName(userName);
	 }
	 
	 public User createUser(User u){
		 return userEAO.createUser(u);
	 }
	 
     public User update(User u){
    	 return userEAO.update(u);
     }

	@Override
	public List<User>findUser(String userName){
		return userEAO.findByUserName(userName);
	}
	
	@Override
	public boolean authenticateUser(String userName, String passWord){
		return userEAO.authenticateUser(userName, passWord);
	}
	
	public List<User> findAllUsers(){
		return userEAO.findAll();
	}
    
    
    

}
