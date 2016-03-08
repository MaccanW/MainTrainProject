package org.ics.ejb;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

public class ExerciseRowID implements Serializable{
//	@Id
	private int exrId;
//	@Id
	private long wsId;
//	@Id
	private int wdNbr;
	
	public ExerciseRowID(){
	}
	
	public ExerciseRowID(int exrId, long wsId, int wdNbr){
		this.exrId = exrId;
		this.wsId = wsId;
		this.wdNbr = wdNbr;
	}
	
	@Column(name="exrId", nullable = false)
	public int getExrId() {
		return exrId;
	}

	public void setExrId(int exrId) {
		this.exrId = exrId;
	}
	
	@Column(name="wsId", nullable = false)
	public long getWsId() {
		return wsId;
	}

	public void setWsId(long wsId) {
		this.wsId = wsId;
	}

	@Column(name="wdNbr", nullable = false)
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
		
		if (!(other instanceof ExerciseRowID)){
			return false;
		}
		
		ExerciseRowID castOther = (ExerciseRowID) other;
		
		return ((this.getExrId() == castOther.getExrId()) ||
				(this.getExrId() != 0 && castOther.getExrId() != 0 && this.getExrId()==(castOther.getExrId())))
				&&
				((this.getWsId() == castOther.getWsId()) ||
					(this.getWsId() != 0 && castOther.getWsId() != 0 && this.getWsId()==(castOther.getWsId())))
				&&
				((this.getWdNbr() == castOther.getWdNbr()) || 
					(this.getWdNbr() != 0 && castOther.getWdNbr() != 0 && this.getWdNbr()==(castOther.getWdNbr())));
	}
	
	public int hashCode(){
		return super.hashCode();
	}
	
	

}
