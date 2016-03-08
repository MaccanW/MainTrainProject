package org.ics.eao;

import java.util.List;

import javax.ejb.Local;

import org.ics.ejb.Exercise;

@Local
public interface ExerciseEAOLocal {
	public Exercise findByExerciseId(long exId);
	public Exercise createExercise(Exercise e);
	public Exercise updateExercise(Exercise e);
	public void deleteExercise(long exId);
	
	public List<Exercise> findAll();
	public List<Exercise> findByName(String name);

}
