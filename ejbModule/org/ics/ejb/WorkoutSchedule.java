package org.ics.ejb;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Set;

import javax.persistence.Column;
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

@NamedQueries({
	@NamedQuery(name="WorkoutSchedule.findAll",
			query="SELECT w FROM WorkoutSchedule w"),
	@NamedQuery(name="WorkoutSchedule.findByName",
			query="SELECT w FROM WorkoutSchedule w WHERE w.wsName LIKE :wsName")
})

@Entity
@Table(name="WorkoutSchedule")
public class WorkoutSchedule implements Serializable {
	
	private long wsId;
	private String wsName;
	private String wsType; //Lista med kategorier?
	private String wsDescr;
	private Set<WorkoutDay>workoutDays; //workoutschedule kan ha många days
	private User user;
	private String userName;
	
	@Id
	@SequenceGenerator(name = "a1_seq", sequenceName = "a1_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "a1_seq")
	@Column(name="wsId")
	public long getWsId(){
		return wsId;
	}
	
	public void setWsId(long wsId){
		this.wsId = wsId;
	}
	
	@Column(name="wsName")
	public String getWsName(){
		return wsName;
	}
	
	public void setWsName(String wsName){
		this.wsName = wsName;
	}
	
	@Column(name="wsType")
	public String getWsType(){
		return wsType;
	}
	
	public void setWsType(String wsType){
		this.wsType = wsType;
	}
	
	@Column(name="wsDescription")
	public String getWsDescr(){
		return wsDescr;
	}
	
	public void setWsDescr(String wsDescr){
		this.wsDescr = wsDescr;
	}	
	
	//mappar workoutschedule med days (one to many)
	@OneToMany(mappedBy="workoutSchedule", fetch=FetchType.EAGER)
	public Set<WorkoutDay>getWorkoutDays(){
		return workoutDays;
	}
	
	public void setWorkoutDays(Set<WorkoutDay>workoutDays){
		this.workoutDays = workoutDays;
	}
	
	@ManyToOne
	@JoinColumn(name="userName", referencedColumnName="userName", insertable = false, updatable = false)
	public User getUser(){
		return user;
	}
	
	public void setUser(User user){
		this.user = user;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	
}
