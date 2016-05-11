package org.openmrs.module.nursingkardex.api.impl;

import java.util.Date;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openmrs.api.impl.BaseOpenmrsService;
import org.openmrs.module.nursingkardex.api.NursingCareIndicatorService;
import org.openmrs.module.nursingkardex.api.db.NursingIndicatorCareDAO;

public class NursingCareIndicatorServiceImpl extends BaseOpenmrsService implements NursingCareIndicatorService {
	
	protected final Log log = LogFactory.getLog(this.getClass());
	
	private NursingIndicatorCareDAO dao;
	
	public NursingIndicatorCareDAO getDao() {
		return dao;
	}
	
	public void setDao(NursingIndicatorCareDAO dao) {
		this.dao = dao;
	}
	
	/* (non-Javadoc)
	 * @see org.openmrs.module.nursingkardex.api.impl.NursingCareIndicatorService#getVitalSignsHourly(java.lang.Integer)
	 */
	@Override
	public Integer getVitalSignsHourly(Integer locationId, Date startDate, Date endDate) {
		return dao.getVitalSignsHourly(locationId, startDate, endDate);
	}
	
	public Integer getVitalSignsShift(Integer locationId, Date startDate, Date endDate) {
		return dao.getVitalSignsShift(locationId, startDate, endDate);
	}
	
	public Integer getIOHourly(Integer locationId, Date startDate, Date endDate) {
		return dao.getIOHourly(locationId, startDate, endDate);
	}
	
	public Integer getIOShift(Integer locationId, Date startDate, Date endDate) {
		return dao.getIOShift(locationId, startDate, endDate);
	}
	
	public Integer getThermoRegulation(Integer locationId, Date startDate, Date endDate) {
		return dao.getThermoRegulation(locationId, startDate, endDate);
	}
	
	public Integer getPainAssessment(Integer locationId, Date startDate, Date endDate) {
		return dao.getPainAssessment(locationId, startDate, endDate);
	}
	
	public Integer getCbg(Integer locationId, Date startDate, Date endDate) {
		return dao.getCbg(locationId, startDate, endDate);
	}
	
	public Integer getOtherMonitoring(Integer locationId, Date startDate, Date endDate) {
		return dao.getOtherMonitoring(locationId, startDate, endDate);
	}

	public Integer getBedBath(Integer locationId, Date startDate, Date endDate) {
		return dao.getBedBath(locationId, startDate, endDate);
	}

	public Integer getTSB(Integer locationId, Date startDate, Date endDate) {
		return dao.getTSB(locationId, startDate, endDate);
	}

	public Integer getHairShampoo(Integer locationId, Date startDate, Date endDate) {
		return dao.getHairShampoo(locationId, startDate, endDate);
	}

	public Integer getOrificeCare(Integer locationId, Date startDate, Date endDate) {
		return dao.getOrificeCare(locationId, startDate, endDate);
	}

	public Integer getOralCare(Integer locationId, Date startDate, Date endDate) {
		return dao.getOralCare(locationId, startDate, endDate);
	}

	public Integer getNailCare(Integer locationId, Date startDate, Date endDate) {
		return dao.getNailCare(locationId, startDate, endDate);
	}

	public Integer getPerinealCare(Integer locationId, Date startDate, Date endDate) {
		return dao.getPerinealCare(locationId, startDate, endDate);
	}

	public Integer getMassageBackBonyProminences(Integer locationId, Date startDate, Date endDate) {
		return dao.getMassageBackBonyProminences(locationId, startDate, endDate);
	}

	public Integer getLinenChange(Integer locationId, Date startDate, Date endDate) {
		return dao.getLinenChange(locationId, startDate, endDate);
	}

	public Integer getOtherComfort(Integer locationId, Date startDate, Date endDate) {
		return dao.getOtherComfort(locationId, startDate, endDate);
	}

	public Integer getOral(Integer locationId, Date startDate, Date endDate) {
		return dao.getOral(locationId, startDate, endDate);
	}

	public Integer getNGT(Integer locationId, Date startDate, Date endDate) {
		return dao.getNGT(locationId, startDate, endDate);
	}

	public Integer getParenteral(Integer locationId, Date startDate, Date endDate) {
		return dao.getParenteral(locationId, startDate, endDate);
	}

	public Integer getOtherNutritional(Integer locationId, Date startDate, Date endDate) {
		return dao.getOtherNutritional(locationId, startDate, endDate);
	}

	public Integer getOxygenTherapy(Integer locationId, Date startDate, Date endDate) {
		return dao.getOxygenTherapy(locationId, startDate, endDate);
	}

	public Integer getMechanicalVentilator(Integer locationId, Date startDate, Date endDate) {
		return dao.getMechanicalVentilator(locationId, startDate, endDate);
	}

	public Integer getSuctioning(Integer locationId, Date startDate, Date endDate) {
		return dao.getSuctioning(locationId, startDate, endDate);
	}

	public Integer getAmbubagging(Integer locationId, Date startDate, Date endDate) {
		return dao.getAmbubagging(locationId, startDate, endDate);
	}

	public Integer getNebulization(Integer locationId, Date startDate, Date endDate) {
		return dao.getNebulization(locationId, startDate, endDate);
	}

	public Integer getPulmonaryPhysiotherapy(Integer locationId, Date startDate, Date endDate) {
		return dao.getPulmonaryPhysiotherapy(locationId, startDate, endDate);
	}

	public Integer getIntubation(Integer locationId, Date startDate, Date endDate) {
		return dao.getIntubation(locationId, startDate, endDate);
	}

	public Integer getOtherVentilator(Integer locationId, Date startDate, Date endDate) {
		return dao.getOtherVentilator(locationId, startDate, endDate);
	}

	public Integer getBowelColostomy(Integer locationId, Date startDate, Date endDate) {
		return dao.getBowelColostomy(locationId, startDate, endDate);
	}

	public Integer getIleostomy(Integer locationId, Date startDate, Date endDate) {
		return dao.getIleostomy(locationId, startDate, endDate);
	}

	public Integer getFoleyCatheter(Integer locationId, Date startDate, Date endDate) {
		return dao.getFoleyCatheter(locationId, startDate, endDate);
	}

	public Integer getPeritonealDialysis(Integer locationId, Date startDate, Date endDate) {
		return dao.getPeritonealDialysis(locationId, startDate, endDate);
	}

	public Integer getHemodialysis(Integer locationId, Date startDate, Date endDate) {
		return dao.getHemodialysis(locationId, startDate, endDate);
	}

	public Integer getOtherElimination(Integer locationId, Date startDate, Date endDate) {
		return dao.getOtherElimination(locationId, startDate, endDate);
	}

	public Integer getPositioning(Integer locationId, Date startDate, Date endDate) {
		return dao.getPositioning(locationId, startDate, endDate);
	}

	public Integer getTransporting(Integer locationId, Date startDate, Date endDate) {
		return dao.getTransporting(locationId, startDate, endDate);
	}

	public Integer getTurningEveryTwoHours(Integer locationId, Date startDate, Date endDate) {
		return dao.getTurningEveryTwoHours(locationId, startDate, endDate);
	}

	public Integer getFallPrevention(Integer locationId, Date startDate, Date endDate) {
		return dao.getFallPrevention(locationId, startDate, endDate);
	}

	public Integer getRestraining(Integer locationId, Date startDate, Date endDate) {
		return dao.getRestraining(locationId, startDate, endDate);
	}

	public Integer getPassiveROM(Integer locationId, Date startDate, Date endDate) {
		return dao.getPassiveROM(locationId, startDate, endDate);
	}

	public Integer getCastCare(Integer locationId, Date startDate, Date endDate) {
		return dao.getCastCare(locationId, startDate, endDate);
	}

	public Integer getTractionCare(Integer locationId, Date startDate, Date endDate) {
		return dao.getTractionCare(locationId, startDate, endDate);
	}

	public Integer getOtherMobility(Integer locationId, Date startDate, Date endDate) {
		return dao.getOtherMobility(locationId, startDate, endDate);
	}

	public Integer getIVF(Integer locationId, Date startDate, Date endDate) {
		return dao.getIVF(locationId, startDate, endDate);
	}

	public Integer getBloodTransfusion(Integer locationId, Date startDate, Date endDate) {
		return dao.getBloodTransfusion(locationId, startDate, endDate);
	}

	public Integer getFreshWholeBlood(Integer locationId, Date startDate, Date endDate) {
		return dao.getFreshWholeBlood(locationId, startDate, endDate);
	}

	public Integer getPackedRBC(Integer locationId, Date startDate, Date endDate) {
		return dao.getOtherComfort(locationId, startDate, endDate);
	}

	public Integer getChemotherapy(Integer locationId, Date startDate, Date endDate) {
		return dao.getChemotherapy(locationId, startDate, endDate);
	}

	public Integer getOtherIVT(Integer locationId, Date startDate, Date endDate) {
		return dao.getOtherIVT(locationId, startDate, endDate);
	}

	public Integer getPerOrem(Integer locationId, Date startDate, Date endDate) {
		return dao.getOtherComfort(locationId, startDate, endDate);
	}

	public Integer getTopical(Integer locationId, Date startDate, Date endDate) {
		return dao.getTopical(locationId, startDate, endDate);
	}

	public Integer getIntravenous(Integer locationId, Date startDate, Date endDate) {
		return dao.getIntravenous(locationId, startDate, endDate);
	}

	public Integer getIntradermal(Integer locationId, Date startDate, Date endDate) {
		return dao.getIntradermal(locationId, startDate, endDate);
	}

	public Integer getIntramuscular(Integer locationId, Date startDate, Date endDate) {
		return dao.getIntramuscular(locationId, startDate, endDate);
	}

	public Integer getSubcutaneous(Integer locationId, Date startDate, Date endDate) {
		return dao.getSubcutaneous(locationId, startDate, endDate);
	}

	public Integer getDrops(Integer locationId, Date startDate, Date endDate) {
		return dao.getOtherComfort(locationId, startDate, endDate);
	}

	public Integer getSuppositories(Integer locationId, Date startDate, Date endDate) {
		return dao.getSuppositories(locationId, startDate, endDate);
	}

	public Integer getEnemaIrrigation(Integer locationId, Date startDate, Date endDate) {
		return dao.getEnemaIrrigation(locationId, startDate, endDate);
	}

	public Integer getOtherMedication(Integer locationId, Date startDate, Date endDate) {
		return dao.getOtherMedication(locationId, startDate, endDate);
	}

	public Integer getNGTPEG(Integer locationId, Date startDate, Date endDate) {
		return dao.getNGTPEG(locationId, startDate, endDate);
	}

	public Integer getNasalCannula(Integer locationId, Date startDate, Date endDate) {
		return dao.getNasalCannula(locationId, startDate, endDate);
	}

	public Integer getTracheostomy(Integer locationId, Date startDate, Date endDate) {
		return dao.getTracheostomy(locationId, startDate, endDate);
	}

	public Integer getChestTube(Integer locationId, Date startDate, Date endDate) {
		return dao.getChestTube(locationId, startDate, endDate);
	}

	public Integer getFoleyCatheterCare(Integer locationId, Date startDate, Date endDate) {
		return dao.getFoleyCatheterCare(locationId, startDate, endDate);
	}

	public Integer getJacksonPratt(Integer locationId, Date startDate, Date endDate) {
		return dao.getJacksonPratt(locationId, startDate, endDate);
	}

	public Integer getIJCatheter(Integer locationId, Date startDate, Date endDate) {
		return dao.getIJCatheter(locationId, startDate, endDate);
	}

	public Integer getFemoralCatheter(Integer locationId, Date startDate, Date endDate) {
		return dao.getFemoralCatheter(locationId, startDate, endDate);
	}

	public Integer getNephrostomyTube(Integer locationId, Date startDate, Date endDate) {
		return dao.getNephrostomyTube(locationId, startDate, endDate);
	}

	public Integer getAVFistula(Integer locationId, Date startDate, Date endDate) {
		return dao.getAVFistula(locationId, startDate, endDate);
	}

	public Integer getSubclavianCatheter(Integer locationId, Date startDate, Date endDate) {
		return dao.getSubclavianCatheter(locationId, startDate, endDate);
	}

	public Integer getTenckhoffCatheter(Integer locationId, Date startDate, Date endDate) {
		return dao.getTenckhoffCatheter(locationId, startDate, endDate);
	}

	public Integer getColostomyIleostomy(Integer locationId, Date startDate, Date endDate) {
		return dao.getColostomyIleostomy(locationId, startDate, endDate);
	}

	public Integer getJejunostomy(Integer locationId, Date startDate, Date endDate) {
		return dao.getJejunostomy(locationId, startDate, endDate);
	}

	public Integer getOtherTube(Integer locationId, Date startDate, Date endDate) {
		return dao.getOtherComfort(locationId, startDate, endDate);
	}

	public Integer getOperativeSite(Integer locationId, Date startDate, Date endDate) {
		return dao.getOperativeSite(locationId, startDate, endDate);
	}

	public Integer getPressureSore(Integer locationId, Date startDate, Date endDate) {
		return dao.getPressureSore(locationId, startDate, endDate);
	}

	public Integer getBurn(Integer locationId, Date startDate, Date endDate) {
		return dao.getBurn(locationId, startDate, endDate);
	}

	public Integer getOtherWound(Integer locationId, Date startDate, Date endDate) {
		return dao.getOtherWound(locationId, startDate, endDate);
	}

	public Integer getXray(Integer locationId, Date startDate, Date endDate) {
		return dao.getXray(locationId, startDate, endDate);
	}

	public Integer getCTScan(Integer locationId, Date startDate, Date endDate) {
		return dao.getCTScan(locationId, startDate, endDate);
	}

	public Integer getUltrasound(Integer locationId, Date startDate, Date endDate) {
		return dao.getUltrasound(locationId, startDate, endDate);
	}

	public Integer getMRI(Integer locationId, Date startDate, Date endDate) {
		return dao.getMRI(locationId, startDate, endDate);
	}

	public Integer getECG(Integer locationId, Date startDate, Date endDate) {
		return dao.getECG(locationId, startDate, endDate);
	}

	public Integer getEEG(Integer locationId, Date startDate, Date endDate) {
		return dao.getEEG(locationId, startDate, endDate);
	}

	public Integer getTwoDEcho(Integer locationId, Date startDate, Date endDate) {
		return dao.getTwoDEcho(locationId, startDate, endDate);
	}

	public Integer getSpecimenCollection(Integer locationId, Date startDate, Date endDate) {
		return dao.getSpecimenCollection(locationId, startDate, endDate);
	}

	public Integer getBlood(Integer locationId, Date startDate, Date endDate) {
		return dao.getBlood(locationId, startDate, endDate);
	}

	public Integer getUrine(Integer locationId, Date startDate, Date endDate) {
		return dao.getUrine(locationId, startDate, endDate);
	}

	public Integer getSputum(Integer locationId, Date startDate, Date endDate) {
		return dao.getOtherComfort(locationId, startDate, endDate);
	}

	public Integer getCSF(Integer locationId, Date startDate, Date endDate) {
		return dao.getCSF(locationId, startDate, endDate);
	}

	public Integer getOtherDiagnostic(Integer locationId, Date startDate, Date endDate) {
		return dao.getOtherDiagnostic(locationId, startDate, endDate);
	}

	public Integer getPeritonealDialysisProcedure(Integer locationId, Date startDate, Date endDate) {
		return dao.getPeritonealDialysisProcedure(locationId, startDate, endDate);
	}

	public Integer getHemodialysisProcedure(Integer locationId, Date startDate, Date endDate) {
		return dao.getHemodialysisProcedure(locationId, startDate, endDate);
	}

	public Integer getBronchoscopy(Integer locationId, Date startDate, Date endDate) {
		return dao.getBronchoscopy(locationId, startDate, endDate);
	}

	public Integer getThoracentesis(Integer locationId, Date startDate, Date endDate) {
		return dao.getThoracentesis(locationId, startDate, endDate);
	}

	public Integer getEndoscopy(Integer locationId, Date startDate, Date endDate) {
		return dao.getEndoscopy(locationId, startDate, endDate);
	}

	public Integer getParacentesis(Integer locationId, Date startDate, Date endDate) {
		return dao.getParacentesis(locationId, startDate, endDate);
	}

	public Integer getCoronaryAngiography(Integer locationId, Date startDate, Date endDate) {
		return dao.getCoronaryAngiography(locationId, startDate, endDate);
	}

	public Integer getBoneMarrowAspiration(Integer locationId, Date startDate, Date endDate) {
		return dao.getBoneMarrowAspiration(locationId, startDate, endDate);
	}

	public Integer getBiopsy(Integer locationId, Date startDate, Date endDate) {
		return dao.getBiopsy(locationId, startDate, endDate);
	}

	public Integer getPerioperativeCare(Integer locationId, Date startDate, Date endDate) {
		return dao.getPerioperativeCare(locationId, startDate, endDate);
	}

	public Integer getLumbarTap(Integer locationId, Date startDate, Date endDate) {
		return dao.getLumbarTap(locationId, startDate, endDate);
	}

	public Integer getElectroconvulsiveTherapy(Integer locationId, Date startDate, Date endDate) {
		return dao.getElectroconvulsiveTherapy(locationId, startDate, endDate);
	}

	public Integer getOtherInvasiveProcedure(Integer locationId, Date startDate, Date endDate) {
		return dao.getOtherInvasiveProcedure(locationId, startDate, endDate);
	}

	public Integer getReferralToReligiousMinister(Integer locationId, Date startDate, Date endDate) {
		return dao.getReferralToReligiousMinister(locationId, startDate, endDate);
	}

	public Integer getOtherSpiritualCare(Integer locationId, Date startDate, Date endDate) {
		return dao.getOtherSpiritualCare(locationId, startDate, endDate);
	}

	public Integer getCounselingGrievingMeasures(Integer locationId, Date startDate, Date endDate) {
		return dao.getCounselingGrievingMeasures(locationId, startDate, endDate);
	}

	public Integer getAnxietyReductionTechniques(Integer locationId, Date startDate, Date endDate) {
		return dao.getAnxietyReductionTechniques(locationId, startDate, endDate);
	}

	public Integer getRelaxationMeasures(Integer locationId, Date startDate, Date endDate) {
		return dao.getRelaxationMeasures(locationId, startDate, endDate);
	}

	public Integer getProvisionOfStructuredActivities(Integer locationId, Date startDate, Date endDate) {
		return dao.getProvisionOfStructuredActivities(locationId, startDate, endDate);
	}

	public Integer getHomicidalSuicidalAndEscapePrecautions(Integer locationId, Date startDate, Date endDate) {
		return dao.getHomicidalSuicidalAndEscapePrecautions(locationId, startDate, endDate);
	}

	public Integer getHealthTeaching(Integer locationId, Date startDate, Date endDate) {
		return dao.getHealthTeaching(locationId, startDate, endDate);
	}

	public Integer getOtherPsychosocial(Integer locationId, Date startDate, Date endDate) {
		return dao.getOtherPsychosocial(locationId, startDate, endDate);
	}

	public Integer getCode(Integer locationId, Date startDate, Date endDate) {
		return dao.getCode(locationId, startDate, endDate);
	}

	public Integer getPostMortemCare(Integer locationId, Date startDate, Date endDate) {
		return dao.getPostMortemCare(locationId, startDate, endDate);
	}

	public Integer getTerminalCleaning(Integer locationId, Date startDate, Date endDate) {
		return dao.getTerminalCleaning(locationId, startDate, endDate);
	}

	public Integer getFiveS(Integer locationId, Date startDate, Date endDate) {
		return dao.getFiveS(locationId, startDate, endDate);
	}

	public Integer getLevelOne(Integer locationId, Date startDate, Date endDate) {
		return dao.getLevelOne(locationId, startDate, endDate);
	}

	public Integer getLevelTwo(Integer locationId, Date startDate, Date endDate) {
		return dao.getLevelTwo(locationId, startDate, endDate);
	}

	public Integer getLevelThree(Integer locationId, Date startDate, Date endDate) {
		return dao.getLevelThree(locationId, startDate, endDate);
	}

	public Integer getLevelFour(Integer locationId, Date startDate, Date endDate) {
		return dao.getLevelFour(locationId, startDate, endDate);
	}

	public Integer getHCAI(Integer locationId, Date startDate, Date endDate) {
		return dao.getHCAI(locationId, startDate, endDate);
	}

	public Integer getWithBedsores(Integer locationId, Date startDate, Date endDate) {
		return dao.getWithBedsores(locationId, startDate, endDate);
	}

	public Integer getWithBedsoresAcquiredInTheHospital(Integer locationId, Date startDate, Date endDate) {
		return dao.getWithBedsoresAcquiredInTheHospital(locationId, startDate, endDate);
	}

	public Integer getOROnCall(Integer locationId, Date startDate, Date endDate) {
		return dao.getOROnCall(locationId, startDate, endDate);
	}

	public Integer getForOperation(Integer locationId, Date startDate, Date endDate) {
		return dao.getForOperation(locationId, startDate, endDate);
	}

	public Integer getAdverseSentinelEvents(Integer locationId, Date startDate, Date endDate) {
		return dao.getAdverseSentinelEvents(locationId, startDate, endDate);
	}

	public Integer getDocumentation(Integer locationId, Date startDate, Date endDate) {
		return dao.getDocumentation(locationId, startDate, endDate);
	}

	public Integer getBedCapacity(Integer locationId, Date startDate, Date endDate) {
		return dao.getBedCapacity(locationId, startDate, endDate);
	}

	public Integer getTotalLast(Integer locationId, Date startDate, Date endDate) {
		return dao.getTotalLast(locationId, startDate, endDate);
	}

	public Integer getDailyOccupancyRate(Integer locationId, Date startDate, Date endDate) {
		return dao.getDailyOccupancyRate(locationId, startDate, endDate);
	}

	public Integer getOverflow(Integer locationId, Date startDate, Date endDate) {
		return dao.getOverflow(locationId, startDate, endDate);
	}

	public Integer getAdmission(Integer locationId, Date startDate, Date endDate) {
		return dao.getAdmission(locationId, startDate, endDate);
	}

	public Integer getTransIn(Integer locationId, Date startDate, Date endDate) {
		return dao.getTransIn(locationId, startDate, endDate);
	}

	public Integer getTransOut(Integer locationId, Date startDate, Date endDate) {
		return dao.getTransOut(locationId, startDate, endDate);
	}

	public Integer getDischarged(Integer locationId, Date startDate, Date endDate) {
		return dao.getDischarged(locationId, startDate, endDate);
	}

	public Integer getDeaths(Integer locationId, Date startDate, Date endDate) {
		return dao.getDeaths(locationId, startDate, endDate);
	}

	public Integer getAbsconded(Integer locationId, Date startDate, Date endDate) {
		return dao.getAbsconded(locationId, startDate, endDate);
	}

	public Integer getHomeAgainstAdvice(Integer locationId, Date startDate, Date endDate) {
		return dao.getHomeAgainstAdvice(locationId, startDate, endDate);
	}

	public Integer getHomePerRequest(Integer locationId, Date startDate, Date endDate) {
		return dao.getHomePerRequest(locationId, startDate, endDate);
	}

	public Integer getOperations(Integer locationId, Date startDate, Date endDate) {
		return dao.getOperations(locationId, startDate, endDate);
	}

	public Integer getDeliveries(Integer locationId, Date startDate, Date endDate) {
		return dao.getDeliveries(locationId, startDate, endDate);
	}

	public Integer getRoomingIn(Integer locationId, Date startDate, Date endDate) {
		return dao.getRoomingIn(locationId, startDate, endDate);
	}

	public Integer getOutOnPass(Integer locationId, Date startDate, Date endDate) {
		return dao.getOutOnPass(locationId, startDate, endDate);
	}

}
