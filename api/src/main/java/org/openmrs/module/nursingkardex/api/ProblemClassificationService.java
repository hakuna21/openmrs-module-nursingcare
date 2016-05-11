package org.openmrs.module.nursingkardex.api;

import java.util.List;

import org.openmrs.api.OpenmrsService;
import org.openmrs.module.nursingkardex.ProblemClassification;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface ProblemClassificationService extends OpenmrsService {

	@Transactional(readOnly = true)
	List<ProblemClassification> getAllProblemClassifications();

	@Transactional(readOnly = true)
	ProblemClassification getProblemClassificationById(Integer id);

	ProblemClassification saveProblemClassification(
			ProblemClassification problemClassification);

	void deleteProblemClassification(ProblemClassification problemClassification);

}
