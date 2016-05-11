package org.openmrs.module.nursingkardex.api;

import java.util.Date;

public interface NursingCareIndicatorService {
	
	
	Integer getVitalSignsHourly(Integer locationId, Date startDate, Date endDate);
	
	Integer getVitalSignsShift(Integer locationId, Date startDate, Date endDate);
	
	Integer getIOHourly(Integer locationId, Date startDate, Date endDate);
	
	Integer getIOShift(Integer locationId, Date startDate, Date endDate);
	
	Integer getThermoRegulation(Integer locationId, Date startDate, Date endDate);
	
	Integer getPainAssessment(Integer locationId, Date startDate, Date endDate);
	
	Integer getCbg(Integer locationId, Date startDate, Date endDate);
	
	Integer getOtherMonitoring(Integer locationId, Date startDate, Date endDate);
	
	
	
	Integer getBedBath(Integer locationId, Date startDate, Date endDate);
	
	Integer getTSB(Integer locationId, Date startDate, Date endDate);

	Integer getHairShampoo(Integer locationId, Date startDate, Date endDate);

	Integer getOrificeCare(Integer locationId, Date startDate, Date endDate);

	Integer getOralCare(Integer locationId, Date startDate, Date endDate);

	Integer getNailCare(Integer locationId, Date startDate, Date endDate);

	Integer getPerinealCare(Integer locationId, Date startDate, Date endDate);

	Integer getMassageBackBonyProminences(Integer locationId, Date startDate, Date endDate);

	Integer getLinenChange(Integer locationId, Date startDate, Date endDate);

	Integer getOtherComfort(Integer locationId, Date startDate, Date endDate);

	
	
	Integer getOral(Integer locationId, Date startDate, Date endDate);

	Integer getNGT(Integer locationId, Date startDate, Date endDate);

	Integer getParenteral(Integer locationId, Date startDate, Date endDate);

	Integer getOtherNutritional(Integer locationId, Date startDate, Date endDate);

	
	
	Integer getOxygenTherapy(Integer locationId, Date startDate, Date endDate);

	Integer getMechanicalVentilator(Integer locationId, Date startDate, Date endDate);

	Integer getSuctioning(Integer locationId, Date startDate, Date endDate);

	Integer getAmbubagging(Integer locationId, Date startDate, Date endDate);

	Integer getNebulization(Integer locationId, Date startDate, Date endDate);

	Integer getPulmonaryPhysiotherapy(Integer locationId, Date startDate, Date endDate);

	Integer getIntubation(Integer locationId, Date startDate, Date endDate);

	Integer getOtherVentilator(Integer locationId, Date startDate, Date endDate);

	
	
	Integer getBowelColostomy(Integer locationId, Date startDate, Date endDate);

	Integer getIleostomy(Integer locationId, Date startDate, Date endDate);

	Integer getFoleyCatheter(Integer locationId, Date startDate, Date endDate);

	Integer getPeritonealDialysis(Integer locationId, Date startDate, Date endDate);

	Integer getHemodialysis(Integer locationId, Date startDate, Date endDate);

	Integer getOtherElimination(Integer locationId, Date startDate, Date endDate);

	
	
	Integer getPositioning(Integer locationId, Date startDate, Date endDate);

	Integer getTransporting(Integer locationId, Date startDate, Date endDate);

	Integer getTurningEveryTwoHours(Integer locationId, Date startDate, Date endDate);

	Integer getFallPrevention(Integer locationId, Date startDate, Date endDate);

	Integer getRestraining(Integer locationId, Date startDate, Date endDate);

	Integer getPassiveROM(Integer locationId, Date startDate, Date endDate);

	Integer getCastCare(Integer locationId, Date startDate, Date endDate);

	Integer getTractionCare(Integer locationId, Date startDate, Date endDate);

	Integer getOtherMobility(Integer locationId, Date startDate, Date endDate);

	
	
	Integer getIVF(Integer locationId, Date startDate, Date endDate);

	Integer getBloodTransfusion(Integer locationId, Date startDate, Date endDate);

	Integer getFreshWholeBlood(Integer locationId, Date startDate, Date endDate);

	Integer getPackedRBC(Integer locationId, Date startDate, Date endDate);

	Integer getChemotherapy(Integer locationId, Date startDate, Date endDate);

	Integer getOtherIVT(Integer locationId, Date startDate, Date endDate);

	Integer getPerOrem(Integer locationId, Date startDate, Date endDate);

	Integer getTopical(Integer locationId, Date startDate, Date endDate);

	Integer getIntravenous(Integer locationId, Date startDate, Date endDate);

	Integer getIntradermal(Integer locationId, Date startDate, Date endDate);

	Integer getIntramuscular(Integer locationId, Date startDate, Date endDate);

	Integer getSubcutaneous(Integer locationId, Date startDate, Date endDate);

	Integer getDrops(Integer locationId, Date startDate, Date endDate);

	Integer getSuppositories(Integer locationId, Date startDate, Date endDate);

	Integer getEnemaIrrigation(Integer locationId, Date startDate, Date endDate);

	Integer getOtherMedication(Integer locationId, Date startDate, Date endDate);

	
	
	Integer getNGTPEG(Integer locationId, Date startDate, Date endDate);

	Integer getNasalCannula(Integer locationId, Date startDate, Date endDate);

	Integer getTracheostomy(Integer locationId, Date startDate, Date endDate);

	Integer getChestTube(Integer locationId, Date startDate, Date endDate);

	Integer getFoleyCatheterCare(Integer locationId, Date startDate, Date endDate);

	Integer getJacksonPratt(Integer locationId, Date startDate, Date endDate);

	Integer getIJCatheter(Integer locationId, Date startDate, Date endDate);

	Integer getFemoralCatheter(Integer locationId, Date startDate, Date endDate);

	Integer getNephrostomyTube(Integer locationId, Date startDate, Date endDate);

	Integer getAVFistula(Integer locationId, Date startDate, Date endDate);

	Integer getSubclavianCatheter(Integer locationId, Date startDate, Date endDate);

	Integer getTenckhoffCatheter(Integer locationId, Date startDate, Date endDate);

	Integer getColostomyIleostomy(Integer locationId, Date startDate, Date endDate);

	Integer getJejunostomy(Integer locationId, Date startDate, Date endDate);

	Integer getOtherTube(Integer locationId, Date startDate, Date endDate);

	
	
	Integer getOperativeSite(Integer locationId, Date startDate, Date endDate);

	Integer getPressureSore(Integer locationId, Date startDate, Date endDate);

	Integer getBurn(Integer locationId, Date startDate, Date endDate);

	Integer getOtherWound(Integer locationId, Date startDate, Date endDate);

	Integer getXray(Integer locationId, Date startDate, Date endDate);

	Integer getCTScan(Integer locationId, Date startDate, Date endDate);

	Integer getUltrasound(Integer locationId, Date startDate, Date endDate);

	Integer getMRI(Integer locationId, Date startDate, Date endDate);

	Integer getECG(Integer locationId, Date startDate, Date endDate);

	Integer getEEG(Integer locationId, Date startDate, Date endDate);

	Integer getTwoDEcho(Integer locationId, Date startDate, Date endDate);

	Integer getSpecimenCollection(Integer locationId, Date startDate, Date endDate);

	Integer getBlood(Integer locationId, Date startDate, Date endDate);

	Integer getUrine(Integer locationId, Date startDate, Date endDate);

	Integer getSputum(Integer locationId, Date startDate, Date endDate);

	Integer getCSF(Integer locationId, Date startDate, Date endDate);

	Integer getOtherDiagnostic(Integer locationId, Date startDate, Date endDate);

	
	
	Integer getPeritonealDialysisProcedure(Integer locationId, Date startDate, Date endDate);

	Integer getHemodialysisProcedure(Integer locationId, Date startDate, Date endDate);

	Integer getBronchoscopy(Integer locationId, Date startDate, Date endDate);

	Integer getThoracentesis(Integer locationId, Date startDate, Date endDate);

	Integer getEndoscopy(Integer locationId, Date startDate, Date endDate);

	Integer getParacentesis(Integer locationId, Date startDate, Date endDate);

	Integer getCoronaryAngiography(Integer locationId, Date startDate, Date endDate);

	Integer getBoneMarrowAspiration(Integer locationId, Date startDate, Date endDate);

	Integer getBiopsy(Integer locationId, Date startDate, Date endDate);

	Integer getPerioperativeCare(Integer locationId, Date startDate, Date endDate);

	Integer getLumbarTap(Integer locationId, Date startDate, Date endDate);

	Integer getElectroconvulsiveTherapy(Integer locationId, Date startDate, Date endDate);

	Integer getOtherInvasiveProcedure(Integer locationId, Date startDate, Date endDate);

	Integer getReferralToReligiousMinister(Integer locationId, Date startDate, Date endDate);

	Integer getOtherSpiritualCare(Integer locationId, Date startDate, Date endDate);

	Integer getCounselingGrievingMeasures(Integer locationId, Date startDate, Date endDate);

	Integer getAnxietyReductionTechniques(Integer locationId, Date startDate, Date endDate);

	Integer getRelaxationMeasures(Integer locationId, Date startDate, Date endDate);

	Integer getProvisionOfStructuredActivities(Integer locationId, Date startDate, Date endDate);

	Integer getHomicidalSuicidalAndEscapePrecautions(Integer locationId, Date startDate, Date endDate);

	Integer getHealthTeaching(Integer locationId, Date startDate, Date endDate);

	Integer getOtherPsychosocial(Integer locationId, Date startDate, Date endDate);

	
	
	Integer getCode(Integer locationId, Date startDate, Date endDate);

	Integer getPostMortemCare(Integer locationId, Date startDate, Date endDate);

	Integer getTerminalCleaning(Integer locationId, Date startDate, Date endDate);

	Integer getFiveS(Integer locationId, Date startDate, Date endDate);

	Integer getLevelOne(Integer locationId, Date startDate, Date endDate);

	Integer getLevelTwo(Integer locationId, Date startDate, Date endDate);

	Integer getLevelThree(Integer locationId, Date startDate, Date endDate);

	Integer getLevelFour(Integer locationId, Date startDate, Date endDate);

	Integer getHCAI(Integer locationId, Date startDate, Date endDate);

	Integer getWithBedsores(Integer locationId, Date startDate, Date endDate);

	Integer getWithBedsoresAcquiredInTheHospital(Integer locationId, Date startDate, Date endDate);

	Integer getOROnCall(Integer locationId, Date startDate, Date endDate);

	Integer getForOperation(Integer locationId, Date startDate, Date endDate);

	Integer getAdverseSentinelEvents(Integer locationId, Date startDate, Date endDate);

	Integer getDocumentation(Integer locationId, Date startDate, Date endDate);

}
