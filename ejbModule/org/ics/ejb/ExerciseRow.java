package org.ics.ejb;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="ExerciseRow")
//@SequenceGenerator(name="ERID_SEQ", allocationSize=1)
public class ExerciseRow implements Serializable {

	private ExerciseRowID exrId;
	private int eReps;
	private int eSets;
	private double eDuration;
	private int eDistance;
	private long exId;
	private WorkoutDay workoutDay;//kan endast tillhöra en dag
	private Exercise exercise;//kan endast tillhöra en övning
	
	@EmbeddedId
	public ExerciseRowID getExrId(){
		return exrId;
	}
	
	public void setExrId(ExerciseRowID exrId){
		this.exrId = exrId;
	}
	
	@Column(name="Reps")
	public int getEReps() {
		return eReps;
	}

	public void setEReps(int eReps) {
		this.eReps = eReps;
	}
	
	@Column(name="eSets")
	public int getESets() {
		return eSets;
	}

	public void setESets(int eSets) {
		this.eSets = eSets;
	}
	
	@Column(name="Duration")
	public double getEDuration() {
		return eDuration;
	}

	public void setEDuration(double eDuration) {
		this.eDuration = eDuration;
	}
	
	@Column(name="Distance")
	public int getEDistance() {
		return eDistance;
	}

	public void setEDistance(int eDistance) {
		this.eDistance = eDistance;
	}

	@ManyToOne
	@JoinColumns({
		@JoinColumn(name="wdNbr", referencedColumnName="wdNbr", insertable=false, updatable=false),
		@JoinColumn(name="wsId", referencedColumnName="wsId", insertable=false, updatable=false)
	})
	public WorkoutDay getWorkoutDay(){
		return workoutDay;	
	}
	
	public void setWorkoutDay(WorkoutDay workoutDay){
		this.workoutDay = workoutDay;
	}
	
	@ManyToOne
	@JoinColumn(name="exId", referencedColumnName="exId", insertable = false, updatable = false)
	public Exercise getExercise(){
		return exercise;
	}
	
	public void setExercise(Exercise exercise){
		this.exercise = exercise;
	}
	
//	@Column(name="exId", insertable=false, updatable=false)
	public long getExId() {
		return exId;
	}

	public void setExId(long exId) {
		this.exId = exId;
	}
	
	
}
