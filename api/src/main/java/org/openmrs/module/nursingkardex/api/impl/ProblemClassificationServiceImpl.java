package org.openmrs.module.nursingkardex.api.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openmrs.api.impl.BaseOpenmrsService;
import org.openmrs.module.nursingkardex.ProblemClassification;
import org.openmrs.module.nursingkardex.api.ProblemClassificationService;
import org.openmrs.module.nursingkardex.api.db.ProblemClassificationDAO;

public class ProblemClassificationServiceImpl extends BaseOpenmrsService
		implements ProblemClassificationService {

	protected final Log log = LogFactory.getLog(this.getClass());
	private ProblemClassificationDAO dao;

	public ProblemClassificationDAO getDao() {
		return dao;
	}

	public void setDao(ProblemClassificationDAO dao) {
		this.dao = dao;
	}

	@Override
	public List<ProblemClassification> getAllProblemClassifications() {
		return dao.getAllProblemClassifications();
	}

	@Override
	public ProblemClassification getProblemClassificationById(Integer id) {
		return dao.getProblemClassificationById(id);
	}

	@Override
	public ProblemClassification saveProblemClassification(
			ProblemClassification problemClassification) {
		return dao.saveProblemClassification(problemClassification);
	}

	@Override
	public void deleteProblemClassification(
			ProblemClassification problemClassification) {
		dao.deleteProblemClassification(problemClassification);
	}

}
