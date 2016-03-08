package org.ics.ejb;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

public class WorkoutDayID implements Serializable{
	//@Id
	private long wsId;
	//@Id
	private int wdNbr;
	
	public WorkoutDayID(){
	
	}
	
	public WorkoutDayID(long wsId, int wdNbr){
		this.wsId = wsId;
		this.wdNbr = wdNbr;
	}
	
	@Column(name="wsId", nullable= false)
	public long getWsId() {
		return wsId;
	}

	public void setWsId(long wsId) {
		this.wsId = wsId;
	}
	
	@Column(name="wdNbr", nullable=false)
	public int getWdNbr() {
		return wdNbr;
	}

	public void setWdNbr(int wdNbr) {
		this.wdNbr = wdNbr;
	}
	
	public boolean equals(Object other){
		if((this == other)){
			return true;
		}
		
		if ((other == null)){
			return false;
		}
		
		if (!(other instanceof WorkoutDayID)){
			return false;
		}
		
		WorkoutDayID castOther = (WorkoutDayID) other;
		
		return ((this.getWsId() == castOther.getWsId()) ||
					(this.getWsId() != 0 && castOther.getWsId() != 0 && this.getWsId()==(castOther.getWsId())))
				&&
				((this.getWdNbr() == castOther.getWdNbr()) || 
					(this.getWdNbr() != 0 && castOther.getWdNbr() != 0 && this.getWdNbr()==(castOther.getWdNbr())));
	}
	
	public int hashCode(){
		return super.hashCode();
	}
	
	
	
	
	
	

}
