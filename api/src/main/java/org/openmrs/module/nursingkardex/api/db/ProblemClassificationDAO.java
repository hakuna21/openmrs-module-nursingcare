package org.openmrs.module.nursingkardex.api.db;

import java.util.List;

import org.openmrs.module.nursingkardex.ProblemClassification;

public interface ProblemClassificationDAO {

	List<ProblemClassification> getAllProblemClassifications();

	ProblemClassification getProblemClassificationById(Integer id);

	ProblemClassification saveProblemClassification(
			ProblemClassification problemClassification);

	void deleteProblemClassification(ProblemClassification problemClassification);

}
