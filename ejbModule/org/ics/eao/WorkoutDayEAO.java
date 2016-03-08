package org.ics.eao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.ics.ejb.WorkoutDay;
import org.ics.ejb.WorkoutDayID;

/**
 * Session Bean implementation class WorkoutDayEAO
 */
@Stateless
public class WorkoutDayEAO implements WorkoutDayEAOLocal {

   @PersistenceContext(unitName="LabEJBSql")
   private EntityManager em;
  // private WorkoutDayID wd;
	
    public WorkoutDayEAO() {
    }
    
    public WorkoutDay findWorkoutDayById(WorkoutDayID wdNbr){
    	//WorkoutDayID wdId = new WorkoutDayID(wsId, wdNbr);
    	return em.find(WorkoutDay.class, wdNbr);
    }
    
    public WorkoutDay createWorkoutDay(WorkoutDay wd){
    	em.persist(wd);
    	return wd;
    }
    
    public WorkoutDay updateWorkoutDay(WorkoutDay wd){
    	em.merge(wd);
    	return wd;
    }
    
    public void deleteWorkoutDay(WorkoutDayID wdNbr){
    	WorkoutDay wd = this.findWorkoutDayById(wdNbr);
    	if(wd != null){
    		em.remove(wd);
    	}
    }
    
    //gå igenom
//    public List<WorkoutDay> findAllFromWsById(WorkoutDay wdNbr){
//    	TypedQuery<WorkoutDay> query = em.createNamedQuery("WorkoutDay.findAllFromWsById", WorkoutDay.class);
//    	 query.setParameter("random", wdNbr);
//    	 
//    	 List<WorkoutDay> results = query.getResultList();
//    	 return results;
//    }



}
