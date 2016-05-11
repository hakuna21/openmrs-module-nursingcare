package org.openmrs.module.nursingkardex.web.controller;

import java.util.Date;

import org.openmrs.User;
import org.openmrs.api.context.Context;
import org.openmrs.module.nursingkardex.Nurse;
import org.openmrs.module.nursingkardex.api.NursingCareIndicatorService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.ParseException;
import java.text.SimpleDateFormat;

@Controller
public class NursingIndicatorReportController {
	
	@RequestMapping(value = "/module/nursingkardex/nursingIndicatorReport", method = RequestMethod.GET)
	public void showFrom(@RequestParam (value="endDate", required=false) Date endDate, ModelMap model) throws ParseException {
		//dischargedDate = (dischargedDate != null) ? dischargedDate : dischargedDate;
		SimpleDateFormat df = new SimpleDateFormat("MM/dd/yyyy");
		endDate = df.parse("03/16/2016");
		Date startDate = df.parse("01/01/2010");
		performSearch(model, startDate, endDate);

		model.addAttribute("user", Context.getUserContext().getAuthenticatedUser());

	}
	
	public void searchReport(@RequestParam ("endDate") Date endDate, Date startDate, ModelMap model) {
		performSearch(model,  startDate, endDate);
	}
	
	private void performSearch(ModelMap model, Date startDate, Date endDate) {
		Nurse nurse = new KardexHelper().deriveNurse();
		Integer locationId = (nurse != null) ? nurse.getLocation().getId() : null;
		NursingCareIndicatorService nursingCareIndicatorService = Context.getService(NursingCareIndicatorService.class);
		
		//try
		locationId = 14; 
		
		model.put("vitalSignsHourly", nursingCareIndicatorService.getVitalSignsHourly(locationId, startDate, endDate));
		model.put("vitalSignsShift", nursingCareIndicatorService.getVitalSignsShift(locationId, startDate, endDate));
		model.put("ioHourly", nursingCareIndicatorService.getIOHourly(locationId, startDate, endDate));
		model.put("ioShift", nursingCareIndicatorService.getIOShift(locationId, startDate, endDate));
		model.put("thermoRegulation", nursingCareIndicatorService.getThermoRegulation(locationId, startDate, endDate));
		model.put("painAssessment", nursingCareIndicatorService.getPainAssessment(locationId, startDate, endDate));
		model.put("cbg", nursingCareIndicatorService.getCbg(locationId, startDate, endDate));
		model.put("otherMonitoring", nursingCareIndicatorService.getOtherMonitoring(locationId, startDate, endDate));
		

		model.put("bedBath", nursingCareIndicatorService.getBedBath(locationId, startDate, endDate));
		model.put("tsb", nursingCareIndicatorService.getTSB(locationId, startDate, endDate));
		model.put("hairShampoo", nursingCareIndicatorService.getHairShampoo(locationId, startDate, endDate));
		model.put("orificeCare", nursingCareIndicatorService.getOrificeCare(locationId, startDate, endDate));
		model.put("oralCare", nursingCareIndicatorService.getOralCare(locationId, startDate, endDate));
		model.put("nailCare", nursingCareIndicatorService.getNailCare(locationId, startDate, endDate));
		model.put("perinealCare", nursingCareIndicatorService.getPerinealCare(locationId, startDate, endDate));
		model.put("massageBackBonyProminences", nursingCareIndicatorService.getMassageBackBonyProminences(locationId, startDate, endDate));
		model.put("linenChange", nursingCareIndicatorService.getLinenChange(locationId, startDate, endDate));
		model.put("otherComfort", nursingCareIndicatorService.getOtherComfort(locationId, startDate, endDate));
		
		
		model.put("oral", nursingCareIndicatorService.getOral(locationId, startDate, endDate));
		model.put("nGT", nursingCareIndicatorService.getNGT(locationId, startDate, endDate));
		model.put("parenteral", nursingCareIndicatorService.getParenteral(locationId, startDate, endDate));
		model.put("otherNutritional", nursingCareIndicatorService.getOtherNutritional(locationId, startDate, endDate));
		
		
		model.put("oxygenTherapy", nursingCareIndicatorService.getOxygenTherapy(locationId, startDate, endDate));
		model.put("mechanicalVentilator", nursingCareIndicatorService.getMechanicalVentilator(locationId, startDate, endDate));
		model.put("suctioning", nursingCareIndicatorService.getSuctioning(locationId, startDate, endDate));
		model.put("ambubagging", nursingCareIndicatorService.getAmbubagging(locationId, startDate, endDate));
		model.put("nebulization", nursingCareIndicatorService.getNebulization(locationId, startDate, endDate));
		model.put("pulmonaryPhysiotherapy", nursingCareIndicatorService.getPulmonaryPhysiotherapy(locationId, startDate, endDate));
		model.put("intubation", nursingCareIndicatorService.getIntubation(locationId, startDate, endDate));
		model.put("otherVentilator", nursingCareIndicatorService.getOtherVentilator(locationId, startDate, endDate));
		
		
		model.put("bowelColostomy", nursingCareIndicatorService.getBowelColostomy(locationId, startDate, endDate));
		model.put("ileostomy", nursingCareIndicatorService.getIleostomy(locationId, startDate, endDate));
		model.put("foleyCatheter", nursingCareIndicatorService.getFoleyCatheter(locationId, startDate, endDate));
		model.put("peritonealDialysis", nursingCareIndicatorService.getPeritonealDialysis(locationId, startDate, endDate));
		model.put("hemodialysis", nursingCareIndicatorService.getHemodialysis(locationId, startDate, endDate));
		model.put("otherElimination", nursingCareIndicatorService.getOtherElimination(locationId, startDate, endDate));
		model.put("positioning", nursingCareIndicatorService.getPositioning(locationId, startDate, endDate));
		model.put("transporting", nursingCareIndicatorService.getTransporting(locationId, startDate, endDate));
		model.put("turningEveryTwoHours", nursingCareIndicatorService.getTurningEveryTwoHours(locationId, startDate, endDate));
		model.put("fallPrevention", nursingCareIndicatorService.getFallPrevention(locationId, startDate, endDate));
		model.put("restraining", nursingCareIndicatorService.getRestraining(locationId, startDate, endDate));
		model.put("passiveROM", nursingCareIndicatorService.getPassiveROM(locationId, startDate, endDate));
		model.put("castCare", nursingCareIndicatorService.getCastCare(locationId, startDate, endDate));
		model.put("tractionCare", nursingCareIndicatorService.getTractionCare(locationId, startDate, endDate));
		model.put("otherMobility", nursingCareIndicatorService.getOtherMobility(locationId, startDate, endDate));
		
		
		model.put("iVF", nursingCareIndicatorService.getIVF(locationId, startDate, endDate));
		model.put("bloodTransfusion", nursingCareIndicatorService.getBloodTransfusion(locationId, startDate, endDate));
		model.put("freshWholeBlood", nursingCareIndicatorService.getFreshWholeBlood(locationId, startDate, endDate));
		model.put("packedRBC", nursingCareIndicatorService.getPackedRBC(locationId, startDate, endDate));
		model.put("chemotherapy", nursingCareIndicatorService.getChemotherapy(locationId, startDate, endDate));
		model.put("otherIVT", nursingCareIndicatorService.getOtherIVT(locationId, startDate, endDate));
		model.put("perOrem", nursingCareIndicatorService.getPerOrem(locationId, startDate, endDate));
		model.put("topical", nursingCareIndicatorService.getTopical(locationId, startDate, endDate));
		model.put("intravenous", nursingCareIndicatorService.getIntravenous(locationId, startDate, endDate));
		model.put("intradermal", nursingCareIndicatorService.getIntradermal(locationId, startDate, endDate));
		model.put("intramuscular", nursingCareIndicatorService.getIntramuscular(locationId, startDate, endDate));
		model.put("subcutaneous", nursingCareIndicatorService.getSubcutaneous(locationId, startDate, endDate));
		model.put("drops", nursingCareIndicatorService.getDrops(locationId, startDate, endDate));
		model.put("suppositories", nursingCareIndicatorService.getSuppositories(locationId, startDate, endDate));
		model.put("enemaIrrigation", nursingCareIndicatorService.getEnemaIrrigation(locationId, startDate, endDate));
		model.put("otherMedication", nursingCareIndicatorService.getOtherMedication(locationId, startDate, endDate));
		
		
		model.put("nGTPEG", nursingCareIndicatorService.getNGTPEG(locationId, startDate, endDate));
		model.put("nasalCannula", nursingCareIndicatorService.getNasalCannula(locationId, startDate, endDate));
		model.put("tracheostomy", nursingCareIndicatorService.getTracheostomy(locationId, startDate, endDate));
		model.put("chestTube", nursingCareIndicatorService.getChestTube(locationId, startDate, endDate));
		model.put("foleyCatheterCare", nursingCareIndicatorService.getFoleyCatheterCare(locationId, startDate, endDate));
		model.put("jacksonPratt", nursingCareIndicatorService.getJacksonPratt(locationId, startDate, endDate));
		model.put("iJCatheter", nursingCareIndicatorService.getIJCatheter(locationId, startDate, endDate));
		model.put("femoralCatheter", nursingCareIndicatorService.getFemoralCatheter(locationId, startDate, endDate));
		model.put("nephrostomyTube", nursingCareIndicatorService.getNephrostomyTube(locationId, startDate, endDate));
		model.put("aVFistula", nursingCareIndicatorService.getAVFistula(locationId, startDate, endDate));
		model.put("subclavianCatheter", nursingCareIndicatorService.getSubclavianCatheter(locationId, startDate, endDate));
		model.put("tenckhoffCatheter", nursingCareIndicatorService.getTenckhoffCatheter(locationId, startDate, endDate));
		model.put("colostomyIleostomy", nursingCareIndicatorService.getColostomyIleostomy(locationId, startDate, endDate));
		model.put("jejunostomy", nursingCareIndicatorService.getJejunostomy(locationId, startDate, endDate));
		model.put("otherTube", nursingCareIndicatorService.getOtherTube(locationId, startDate, endDate));
		
		
		model.put("operativeSite", nursingCareIndicatorService.getOperativeSite(locationId, startDate, endDate));
		model.put("pressureSore", nursingCareIndicatorService.getPressureSore(locationId, startDate, endDate));
		model.put("burn", nursingCareIndicatorService.getBurn(locationId, startDate, endDate));
		model.put("otherWound", nursingCareIndicatorService.getOtherWound(locationId, startDate, endDate));
		model.put("xray", nursingCareIndicatorService.getXray(locationId, startDate, endDate));
		model.put("cTScan", nursingCareIndicatorService.getCTScan(locationId, startDate, endDate));
		model.put("ultrasound", nursingCareIndicatorService.getUltrasound(locationId, startDate, endDate));
		model.put("mRI", nursingCareIndicatorService.getMRI(locationId, startDate, endDate));
		model.put("eCG", nursingCareIndicatorService.getECG(locationId, startDate, endDate));
		model.put("eEG", nursingCareIndicatorService.getEEG(locationId, startDate, endDate));
		model.put("twoDEcho", nursingCareIndicatorService.getTwoDEcho(locationId, startDate, endDate));
		model.put("specimenCollection", nursingCareIndicatorService.getSpecimenCollection(locationId, startDate, endDate));
		model.put("blood", nursingCareIndicatorService.getBlood(locationId, startDate, endDate));
		model.put("urine", nursingCareIndicatorService.getUrine(locationId, startDate, endDate));
		model.put("sputum", nursingCareIndicatorService.getSputum(locationId, startDate, endDate));
		model.put("cSF", nursingCareIndicatorService.getCSF(locationId, startDate, endDate));
		model.put("otherDiagnostic", nursingCareIndicatorService.getOtherDiagnostic(locationId, startDate, endDate));
		
		
		model.put("peritonealDialysisProcedure", nursingCareIndicatorService.getPeritonealDialysisProcedure(locationId, startDate, endDate));
		model.put("hemodialysisProcedure", nursingCareIndicatorService.getHemodialysisProcedure(locationId, startDate, endDate));
		model.put("bronchoscopy", nursingCareIndicatorService.getBronchoscopy(locationId, startDate, endDate));
		model.put("thoracentesis", nursingCareIndicatorService.getThoracentesis(locationId, startDate, endDate));
		model.put("endoscopy", nursingCareIndicatorService.getEndoscopy(locationId, startDate, endDate));
		model.put("paracentesis", nursingCareIndicatorService.getParacentesis(locationId, startDate, endDate));
		model.put("coronaryAngiography", nursingCareIndicatorService.getCoronaryAngiography(locationId, startDate, endDate));
		model.put("boneMarrowAspiration", nursingCareIndicatorService.getBoneMarrowAspiration(locationId, startDate, endDate));
		model.put("biopsy", nursingCareIndicatorService.getBiopsy(locationId, startDate, endDate));
		model.put("perioperativeCare", nursingCareIndicatorService.getPerioperativeCare(locationId, startDate, endDate));
		model.put("lumbarTap", nursingCareIndicatorService.getLumbarTap(locationId, startDate, endDate));
		model.put("electroconvulsiveTherapy", nursingCareIndicatorService.getElectroconvulsiveTherapy(locationId, startDate, endDate));
		model.put("otherInvasiveProcedure", nursingCareIndicatorService.getOtherInvasiveProcedure(locationId, startDate, endDate));
		model.put("referralToReligiousMinister", nursingCareIndicatorService.getReferralToReligiousMinister(locationId, startDate, endDate));
		model.put("otherSpiritualCare", nursingCareIndicatorService.getOtherSpiritualCare(locationId, startDate, endDate));
		model.put("counselingGrievingMeasures", nursingCareIndicatorService.getCounselingGrievingMeasures(locationId, startDate, endDate));
		model.put("anxietyReductionTechniques", nursingCareIndicatorService.getAnxietyReductionTechniques(locationId, startDate, endDate));
		model.put("relaxationMeasures", nursingCareIndicatorService.getRelaxationMeasures(locationId, startDate, endDate));
		model.put("provisionOfStructuredActivities", nursingCareIndicatorService.getProvisionOfStructuredActivities(locationId, startDate, endDate));
		model.put("homicidalSuicidalAndEscapePrecautions", nursingCareIndicatorService.getHomicidalSuicidalAndEscapePrecautions(locationId, startDate, endDate));
		model.put("healthTeaching", nursingCareIndicatorService.getHealthTeaching(locationId, startDate, endDate));
		model.put("otherPsychosocial", nursingCareIndicatorService.getOtherPsychosocial(locationId, startDate, endDate));
		
		
		model.put("code", nursingCareIndicatorService.getCode(locationId, startDate, endDate));
		model.put("postMortemCare", nursingCareIndicatorService.getPostMortemCare(locationId, startDate, endDate));
		model.put("terminalCleaning", nursingCareIndicatorService.getTerminalCleaning(locationId, startDate, endDate));
		model.put("fiveS", nursingCareIndicatorService.getFiveS(locationId, startDate, endDate));
		model.put("levelOne", nursingCareIndicatorService.getLevelOne(locationId, startDate, endDate));
		model.put("levelTwo", nursingCareIndicatorService.getLevelTwo(locationId, startDate, endDate));
		model.put("levelThree", nursingCareIndicatorService.getLevelThree(locationId, startDate, endDate));
		model.put("levelFour", nursingCareIndicatorService.getLevelFour(locationId, startDate, endDate));
		model.put("hCAI", nursingCareIndicatorService.getHCAI(locationId, startDate, endDate));
		model.put("withBedsores", nursingCareIndicatorService.getWithBedsores(locationId, startDate, endDate));
		model.put("withBedsoresAcquiredInTheHospital", nursingCareIndicatorService.getWithBedsoresAcquiredInTheHospital(locationId, startDate, endDate));
		model.put("oROnCall", nursingCareIndicatorService.getOROnCall(locationId, startDate, endDate));
		model.put("forOperation", nursingCareIndicatorService.getForOperation(locationId, startDate, endDate));
		model.put("adverseSentinelEvents", nursingCareIndicatorService.getAdverseSentinelEvents(locationId, startDate, endDate));
		model.put("documentation", nursingCareIndicatorService.getDocumentation(locationId, startDate, endDate));
		
	}
	
}
