package org.ics.eao;

import javax.ejb.Local;

import org.ics.ejb.ExerciseRow;
import org.ics.ejb.ExerciseRowID;

@Local
public interface ExerciseRowEAOLocal {
	public ExerciseRow findExerciseRowById(ExerciseRowID exrId);
	public ExerciseRow createExerciseRow(ExerciseRow exr);
	public ExerciseRow updateExerciseRow(ExerciseRow exr);
	public void deleteExerciseRow(ExerciseRowID exrID);
}
