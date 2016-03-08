package org.ics.eao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.ics.ejb.Exercise;

/**
 * Session Bean implementation class ExerciseEAO
 */
@Stateless
public class ExerciseEAO implements ExerciseEAOLocal {

	@PersistenceContext(unitName="LabEJBSql")
	private EntityManager em;
	
    public ExerciseEAO() {
    }
    
    public Exercise findByExerciseId(long exId){
    	return em.find(Exercise.class, exId);
    }
   
    //KAOS 
    public Exercise createExercise(Exercise e){
    	em.persist(e);
    	return e;
    }
    
    public Exercise updateExercise(Exercise e){
    	em.merge(e);
    	return e;
    }
    
    public void deleteExercise(long exId){
    	Exercise e = this.findByExerciseId(exId);
    	if(e != null){
    		em.remove(e);
    	}
    }
    
    public List<Exercise>findAll(){
    	TypedQuery<Exercise>query = em.createNamedQuery("Exercise.findAll", Exercise.class);
    	
    	List<Exercise> results = query.getResultList();
    	return results;
    }
    
    //Ska vi ha "%"? då kommer man hitta alla övningar som innehåller en del av namnet
    public List<Exercise> findByName(String name){
    	TypedQuery<Exercise> query = em.createNamedQuery("Exercise.findByName", Exercise.class);
    	query.setParameter("ename", "%" + name + "%");
    	
    	List<Exercise> results = query.getResultList();
    	return results;
    	}

}
