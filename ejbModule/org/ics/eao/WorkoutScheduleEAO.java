package org.ics.eao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.ics.ejb.WorkoutSchedule;

/**
 * Session Bean implementation class WorkoutScheduleEAO
 */
@Stateless
public class WorkoutScheduleEAO implements WorkoutScheduleEAOLocal {

	@PersistenceContext(unitName="LabEJBSql")
	private EntityManager em;
	
    public WorkoutScheduleEAO() {
    }
    
    public WorkoutSchedule findByWorkoutScheduleId(long wsId){
    	return em.find(WorkoutSchedule.class, wsId);
    }
    
    public WorkoutSchedule createWorkoutSchedule(WorkoutSchedule w){
    	em.persist(w);
    	return w;
    }
    
    public WorkoutSchedule updateWorkoutSchedule(WorkoutSchedule w){
    	em.merge(w);
    	return w;
    }
    
    public void deleteWorkoutSchedule(long wsId){
    	WorkoutSchedule w = this.findByWorkoutScheduleId(wsId);
    	if(w != null){
    		em.remove(w);
    	}
    }
    	
    public List<WorkoutSchedule> findAll(){
    	TypedQuery<WorkoutSchedule> query = em.createNamedQuery("WorkoutSchedule.findAll", WorkoutSchedule.class);
    	
    	List<WorkoutSchedule> results = query.getResultList();
    	return results;
    }
    
    public List<WorkoutSchedule> findByName(String wsName){
    	TypedQuery<WorkoutSchedule> query = em.createNamedQuery("WorkoutSchedule.findByName", WorkoutSchedule.class);
    	query.setParameter("wsName", "%" + wsName + "%");
    	
    	List<WorkoutSchedule> results = query.getResultList();
    	return results;
    }

}
