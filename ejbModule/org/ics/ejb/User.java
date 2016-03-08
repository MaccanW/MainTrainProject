package org.ics.ejb;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@NamedQueries({
	@NamedQuery(name="User.findByUserName", query = "SELECT u FROM User u WHERE u.userName LIKE :userName"),
	@NamedQuery(name="User.findAll", query = "SELECT u FROM User u")
})

@Entity
@Table(name="Users")
public class User implements Serializable{

	private String userName;
	private String passWord;
	private Set<WorkoutSchedule>workoutSchedules;
//	private int length;
//	private int weight;
	
	public User(String userName, String passWord) {
		this.userName = userName;
		this.passWord = passWord;
	}
	
	public User(){
		
	}

	@Id
	@Column(name="userName")
	public String getUserName(){
		return userName;
	}

	public void setUserName(String userName){
		this.userName = userName;
	}
	
	@Column(name="passWord")
	public String getPassWord(){
		return passWord;
	}
	
	public void setPassWord(String passWord){
		this.passWord = passWord;
	}
	
	@OneToMany(mappedBy="user", fetch=FetchType.EAGER)
	public Set<WorkoutSchedule> getWorkoutSchedules(){
		return workoutSchedules;
	}
	
	public void setWorkoutSchedules(Set<WorkoutSchedule>workoutSchedules){
		this.workoutSchedules = workoutSchedules;
	}

	
}
