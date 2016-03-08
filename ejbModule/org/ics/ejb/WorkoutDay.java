package org.ics.ejb;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

//@NamedQueries({
//	//Hitta (?) dagar alla dagar från schema med samma wsid-nyckel.
//	@NamedQuery(name="WorkoutDay.findAllFromWsById",
//			query="select wd from WorkoutDay wd inner join wd.workoutSchedule ws where ws.wsId LIKE :random")
//})

//kan bli lite klurigt med id osv

@Entity
@Table(name="WorkoutDay")
public class WorkoutDay implements Serializable {
	
	private WorkoutDayID wdNbr;

	private String wdName;
	private String wdType;
	private WorkoutSchedule workoutSchedule;
	private Set<ExerciseRow>exerciseRows;//workoutday kan ha många övningsrader
	
	@EmbeddedId
	@AttributeOverrides({
		@AttributeOverride(name="wsId", column = @Column(name="wsId")),
		@AttributeOverride(name="wdNbr", column = @Column(name="wdNbr"))
	})
	public WorkoutDayID getWdNbr(){
		return wdNbr;
	}
	
	public void setWdNbr(WorkoutDayID wdNbr){
		this.wdNbr = wdNbr;
	}
	
	@Column(name="wdName")
	public String getWdName(){
		return wdName;
	}
	
	public void setWdName(String wdName){
		this.wdName = wdName;
	}
	
	@Column(name="wdType")
	public String getWdType(){
		return wdType;
	}
	
	public void setWdType(String dayType){
		this.wdType = dayType;
	}
	
	@ManyToOne
	@JoinColumn(name="WsId", referencedColumnName="wsId", insertable = false, updatable = false)
	public WorkoutSchedule getWorkoutSchedule(){
		return workoutSchedule;
	}
	
	public void setWorkoutSchedule(WorkoutSchedule workoutSchedule){
		this.workoutSchedule = workoutSchedule;
	}
	
	@OneToMany(mappedBy="workoutDay", fetch=FetchType.EAGER)
	public Set<ExerciseRow>getExerciseRows(){
		return exerciseRows;
	}
	
	public void setExerciseRows(Set<ExerciseRow>exerciseRows){
		this.exerciseRows = exerciseRows;
	}

}
