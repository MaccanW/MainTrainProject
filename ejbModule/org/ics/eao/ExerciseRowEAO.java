package org.ics.eao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.ics.ejb.ExerciseRow;
import org.ics.ejb.ExerciseRowID;

/**
 * Session Bean implementation class ExerciseRowEAO
 */
@Stateless
public class ExerciseRowEAO implements ExerciseRowEAOLocal {

	@PersistenceContext(unitName="LabEJBSql")
	private EntityManager em;
	
    public ExerciseRowEAO() {
    }
    
    public ExerciseRow findExerciseRowById(ExerciseRowID exrId){
    	//ExerciseRowID exridId = new ExerciseRowID(exrId, wsId, wdNbr);
    	return em.find(ExerciseRow.class, exrId);
    }
    
    public ExerciseRow createExerciseRow(ExerciseRow exr){
    	em.persist(exr);
    	return exr;
    }
    
    public ExerciseRow updateExerciseRow(ExerciseRow exr){
    	em.merge(exr);
    	return exr;
    }
    
    public void deleteExerciseRow(ExerciseRowID exrId){
    	ExerciseRow exr = this.findExerciseRowById(exrId);
    	if(exr != null){
    		em.remove(exr);
    	}
    }



}
