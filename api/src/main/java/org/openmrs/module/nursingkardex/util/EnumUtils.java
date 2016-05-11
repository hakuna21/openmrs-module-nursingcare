package org.openmrs.module.nursingkardex.util;

public class EnumUtils {
	
	public enum EncounterTypeEnum {
		
		CHECK_IN(1), VITALS(2), DISCHARGE(3), ADMISSION(4), VISIT_NOTE(5), CHECK_OUT(6), TRANSFER(7), DUTY_SHIFT(8), ROOMING_IN(
		        9), TRANSFER_TO_OTHER_HEALTH_FACILITY(10), HOME_AGAINST_MEDICAL_ADVICE(11), ABSCONDED(12), MORTALITY(13), HOME_PER_REQUEST(
		        14), OUT_ON_PASS(15);
		
		private Integer value;
		
		public Integer getValue() {
			return value;
		}
		
		public void setValue(Integer value) {
			this.value = value;
		}
		
		private EncounterTypeEnum(Integer value) {
			this.value = value;
		}
		
	}
	
	public enum OrderTypeEnum {
		
		DRUG_ORDER(2), TEST_ORDER(3), DIET_ORDER(4), PARENTERAL_ORDER(5), MONITORING_ORDER(6), OXYGENATION_ORDER(7), OTHER_INTERVETION_ORDER(
		        8);
		
		private Integer value;
		
		public Integer getValue() {
			return value;
		}
		
		public void setValue(Integer value) {
			this.value = value;
		}
		
		private OrderTypeEnum(Integer value) {
			this.value = value;
		}
		
	}
	
	public enum MovementType {
		ADMISSION("Admission"), DICHARGE("Discharge"), TRANSFER("Transfer");
		
		private String value;
		
		public String getValue() {
			return value;
		}
		
		private MovementType(String value) {
			this.value = value;
		}
	}
	
	public enum ProcedureTypeEnum {
		
		LABORATORY("laboratory"), PROCEDURE("procedure"), OTHERS("others");
		
		private String value;
		
		public String getValue() {
			return value;
		}
		
		public void setValue(String value) {
			this.value = value;
		}
		
		private ProcedureTypeEnum(String value) {
			this.value = value;
		}
	}
	
	public enum DietConceptEnum {
		
		DIET_TYPE("40978d88-817a-4869-8e91-e483ca34d5eb"), DIETARY_INSTRUCTION("a3943a70-fb60-45a4-b01a-eeb3cf9e24e0"), DIET_ROUTE(
		        "16c66852-ef07-4ce9-b6bd-8208112d5c2d"), DIET_ORDER("f69fdd0a-a5f1-4913-bf9b-09ced6e732e2"), FULL_DIET(
		        "9b794678-f025-4791-9248-ecc3408369dc"), SOFT_DIET("a9c30498-6c11-4e65-a721-de2bc23f7004"), GENERAL_LIQUID(
		        "66518a45-384a-4bf3-893e-fd5ebd45bbc9"), CLEAR_LIQUID("8cc70108-8aba-4bf4-ba5c-13390efe2fca"), NPO(
		        "e3c36c73-cc4a-4911-a637-ddbd96cd1caa"), NPO_EXCEPT_MEDS("ac5085be-0509-40d1-8b21-c27284fb662a"), DIET_AS_TOLERATED(
		        "6f0ea62d-98b6-4fd6-ab2e-bc137133af94"), LIGHT_MEAL("050dd883-ebd1-4817-9883-cdb5148f72c4"), BREASTFEEDING_PER_DEMAND(
		        "3f2574b0-7984-46ca-9b8f-097330ccd00e"), OSTEORIZED_FEEDING("d1b8ab90-de32-4a0b-b379-30fe7ea6c0ca"), MILK_FORMULA(
		        "19478ea4-cf68-4384-b1c4-f03dd378d6ad"), OTHERS("c9432ae5-6e92-4ede-afb5-1675d1b7e388");
		
		private String value;
		
		public String getValue() {
			return value;
		}
		
		public void setValue(String value) {
			this.value = value;
		}
		
		private DietConceptEnum(String value) {
			this.value = value;
		}
		
	}
	
	public enum MonitoringConceptEnum {
		
		ABDOMINAL_GIRTH("13176b46-6610-43a3-aaad-a5ef01e7686f"), CAPILLARY_BLOOD_GLUCOSE(
		        "560430bf-7241-433e-b24d-f03b171f7a01"), WEIGHT("5089AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA"), HEAD_CIRCUMFERENCE(
		        "5314AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA"), NEUROLOGICAL_VITAL_SIGNS("b96733b7-1b2b-486c-805e-375d01abac5c"), VITAL_SIGNS(
		        "1a8b0b91-1a3a-4138-a0cf-4a72da169cd0"), FEVER("5945AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA"), INCREASED_INTRACRANIAL_PRESSURE(
		        "127920AAAAAAAAAAAAAAAAAAAAAAAAAAAAAA"), CONGESTION("859AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA"), OTHER_MONITORING_INSTRUCTION(
		        "f53d68c9-d75d-4930-8d41-cc9f22002138"), PAIN("ae23a19e-c27c-4855-96a2-77bc8baebbef");
		
		private String value;
		
		public String getValue() {
			return value;
		}
		
		public void setValue(String value) {
			this.value = value;
		}
		
		private MonitoringConceptEnum(String value) {
			this.value = value;
		}
	}
	
	public enum ProcedureConceptEnum {
		
		LABORATORY_TEST("f7a1a4ae-8ad2-441e-9d5a-d7b528d2e823"), DIAGNOSTIC_PROCEDURE("1c44f54f-c083-460e-bc5b-865b7385eed4"), INTERVENTIONAL_PROCEDURE(
		        "8eb96473-a5a0-4be4-93ac-988cebe9a138"), OTHER_PROCEDURE("e8171207-745e-4d45-8b9a-ab08c0d6cad4"), OPERATION(
		        "8225336d-ece4-400e-a997-aa4525699517"), 
		        REFERRAL_TO_NEWBORN_SCREENER("46ebbfd1-777a-4d00-819e-aac9a37bffed"), 
		        REFERRAL_TO_ENTEROSTOMAL_NURSE("fb914e2d-c74c-44d1-a717-a7a5c78d7a57"),
		        REFERRAL_TO_DIABETES_MELLITUS_EDUCATOR("8fa6b828-3652-4fcb-b84f-d0e791f5ebc9"),
		        REFERRAL_TO_SPIRITUAL_MINISTER("c2f5772a-78e1-473e-9309-b04ee3288c21"),
		        GRIEVING_MEASURES("9264630a-22cd-405b-be3e-d92bd23a227c"),
		        REFERRAL_TO_PSYCHOLOGIST_OR_PSYCHIATRIST("4ae65658-c8be-4ec6-befc-6cf608dd0c9b"),
		        CODE("29bf47da-e2b1-427c-b0b2-884b29b25f3d"),
		        POST_MORTEM_CARE("aa73c9fc-095b-4153-afe5-8abb3d617d91"),
		        TERMINAL_CLEANING("7a8064c9-c7da-4a19-8ef4-62b19e988fc1"),
		        FIVE_S("85dd8c95-a447-4c8e-a13b-6dd58875d264"),
		        OTHER_SPECIAL_ENDORSEMENT("8a5d6e86-bcf1-4e1e-ae8f-6a3b22b10eb9"), SENT_TO_LABOR_ROOM_OR_DELIVERY_ROOM(
		        "766d5f84-e898-4115-b9f8-1c16a4d9aa80");
		
		private String value;
		
		public String getValue() {
			return value;
		}
		
		public void setValue(String value) {
			this.value = value;
		}
		
		private ProcedureConceptEnum(String value) {
			this.value = value;
		}
	}
	
	public enum OutputConceptEnum {
		
		IO_MONITORING("b364340c-99d3-4e2b-a1e6-043301ccf02c"), STRICT_IO("ab111822-d017-4148-9796-bb6b6c166aee"), REFER_FOR_OLIGURIA(
		        "3d8875af-ab7b-44cb-8885-3a086343b8ac"), FC("bde38694-0646-4539-b226-6946e04ad9cd"), CTT(
		        "82f69d81-d25d-489b-aa24-76255bd8d2f5"), JP_DRAIN("7d8c7355-c930-4046-ad54-3ae80903f120"), COLOSTOMY(
		        "97b4765e-2828-4c1a-8716-54688aefda67"), ILEOSTOMY("932012d7-3732-4509-9494-d61b65d8f0da"), NEPHROSTOMY(
		        "10cfb3a3-37d3-49ce-86c7-661c03984765"), TENCKHOFF_CATHETER("1e553429-febd-4fce-a56b-a6bdf633c6e7"), OTHER_OUTPUT_MONITORING(
		        "c73605d0-333d-46e0-861a-d8793dbc8ee8");
		
		private String value;
		
		public String getValue() {
			return value;
		}
		
		public void setValue(String value) {
			this.value = value;
		}
		
		private OutputConceptEnum(String value) {
			this.value = value;
		}
		
	}
	
	public enum NursingInterventionEnum {
		
		CHANGE_WOUND_DRESSING("ff150345-1190-439b-9a76-b6d4dabd975a"), STRICT_ASEPSIS("89dfcb03-d799-4617-8a5a-e4b578c938ea"), KEEP_THERMOREGULATED(
		        "ecd45401-7826-4541-a914-6f5f2f4407f7"), TEPID_SPONGE_BATH("0f77a77a-cd40-4640-9365-7c67fbed8345"), BED_BATH(
		        "93e112bc-b7ef-431e-b20e-a42691b5ebe0"), HAIR_SHAMPOO("606b7ce4-b927-429f-8bf9-548644055ecd"), NAIL_CARE(
		        "39a4d464-1abc-4c43-83ca-68314fb40ef0"), PERINEAL_CARE("c52ab153-2192-4a31-95ac-2ec6ac5ed1b5"), CBR_WITH_TOILET(
		        "880af0cd-3d67-479c-b12f-a7bb5fdbe535"), CBR_WITHOUT_TOILET("d97fb75e-fdf9-4677-983d-3d9bf341011c"), BEDSORE_PRECAUTION(
		        "f93e02fb-f58d-4271-af46-14f26a04aee5"), UNIVERSAL_PRECAUTION("95b573e3-4124-4cde-8646-1bcfe8b870c9"), SHEA_PRECAUTION(
		        "05122f6c-d697-4436-9df5-cd29d14d50db"), CAST_CARE("34345713-68fd-48de-81b1-7c9223fb8515"), TRACHEOSTOMY_CARE(
		        "b5af63f8-c9b8-46ea-9127-3c7440df59b1"), TRACTION_CARE("e05c1acb-b699-4f4b-8b86-4c5511a7246b"), POSITIONING(
		        "109c5458-7b0c-428e-bc15-0855b017130e"), MASSAGE_BONY_PROMINENCES("a3ea9051-6c80-489a-b729-57bc519eeeb2"), BURN(
		        "116543AAAAAAAAAAAAAAAAAAAAAAAAAAAAAA"), PRESSURE_ULCER_ACQUIRED_FROM_THIS_HEALTH_FACILITY("68321a59-4eef-4bcf-8f5b-bcc47f29f486"),
		        PRESSURE_ULCER_ACQUIRED_FROM_OTHER_LOCATION("55f40bed-8cf0-4ac6-94dc-08c239bc1ff6"),HEALTH_TEACHING(
		        "ab3c762a-8410-4097-b435-78341211cd11"), RELAXATION_MEASURES("2872991d-f9bd-4c5b-ac2a-74ffeb45ec99"),RESTRAINING(
		        "0756e71d-473d-42b9-9a28-f615e55753d1"),
		        OTHER_INTERVENTION("f27013b5-95bc-4e53-82b4-523972ac1cc9");
		
		private String value;
		
		public String getValue() {
			return value;
		}
		
		public void setValue(String value) {
			this.value = value;
		}
		
		private NursingInterventionEnum(String value) {
			this.value = value;
		}
	}
	
	public enum OxygenationEnum {
		
		OXYGEN_SUPPORT("bbd3ffaa-3e7a-48c4-b06b-fb3cb10f8254"), 
		DESCRIPTION_OF_OXYGEN_SUPPORT("61cb7fba-23cc-409b-9d2a-849b4bed48a8"),
		WEANING("c3ec1746-25d3-4393-bb26-b55c29292373"), SUCTIONING(
		        "eb9a20b1-c942-4250-be42-9bb8edc78059"), CHEST_PHYSIOTHERAPY("26eaa376-0f66-4b72-93fa-b9714b843b5e");
		
		private String value;
		
		public String getValue() {
			return value;
		}
		
		public void setValue(String value) {
			this.value = value;
		}
		
		private OxygenationEnum(String value) {
			this.value = value;
		}
	}
	
	public enum ParenteralOrderEnum {
		HEPLOCK("038eeffb-79d7-4bc0-86bc-0d96ad2dbc13"), FEMORAL_CATHETER("e5eb65ee-444b-4b3f-9371-06062d612575"), SUBCLAVIAN_CATHETER(
		        "29dd6d7b-4d12-438f-b0e6-d4f67fa9f0c4"), INTRAJUGULAR_CATHETER("a136919b-4d4f-4480-8537-9ffea5b3be64"), ARTERIOVENOUS_FISTULA(
		        "646881c6-500f-41bc-b393-fcd1bc2e913e"), PARENTERAL_ORDER("8afaa02b-3901-405a-ad18-5113efecf1fe"), CHEMOTHERAPY(
		        "4365fa78-d014-4b49-bb6e-c998e9478f92"),OTHER_PARENTERAL_INSTRUCTION(
		        "5ea0a8ad-4669-450f-8afa-8a246d2ce4a0");
		
		private String value;
		
		public String getValue() {
			return value;
		}
		
		public void setValue(String value) {
			this.value = value;
		}
		
		private ParenteralOrderEnum(String value) {
			this.value = value;
		}
	}
	
	public enum MonitoringReportEnum {
		 VITAL_SIGNS_HOURLY(
		        "SELECT COUNT(DISTINCT patient_id) FROM nursingcare_orders WHERE order_type_id = 6 AND concept_id = (SELECT concept_id FROM concept WHERE uuid = '1a8b0b91-1a3a-4138-a0cf-4a72da169cd0' ) AND instruction = 'q 1h' AND (date_created BETWEEN :startDate AND :endDate ) AND (date_stopped IS NULL OR date_stopped > :endDate ) AND patient_id IN (SELECT DISTINCT nursingcare_patient_case_record.patient_id FROM nursingcare_patient_case_record INNER JOIN nursingcare_patient_movement ON nursingcare_patient_case_record.latest_patient_movement_id = nursingcare_patient_movement.id INNER JOIN encounter ON encounter.encounter_id = nursingcare_patient_movement.encounter_id WHERE encounter.location_id IN ( :locationId ) AND (datetime_discharged IS NULL OR datetime_discharged > :endDate ) ) "), 
		 VITAL_SIGNS_SHIFT(
		        "SELECT COUNT(DISTINCT patient_id) FROM nursingcare_orders WHERE order_type_id = 6 AND concept_id = (SELECT concept_id FROM concept WHERE uuid = '1a8b0b91-1a3a-4138-a0cf-4a72da169cd0' ) AND instruction = 'q shift' AND (date_created BETWEEN :startDate AND :endDate ) AND (date_stopped IS NULL OR date_stopped > :endDate ) AND patient_id IN (SELECT DISTINCT nursingcare_patient_case_record.patient_id FROM nursingcare_patient_case_record INNER JOIN nursingcare_patient_movement ON nursingcare_patient_case_record.latest_patient_movement_id = nursingcare_patient_movement.id INNER JOIN encounter ON encounter.encounter_id = nursingcare_patient_movement.encounter_id WHERE encounter.location_id IN ( :locationId ) AND (datetime_discharged IS NULL OR datetime_discharged > :endDate ) ) "),
		 IO_HOURLY(
			 	"SELECT COUNT(DISTINCT patient_id) FROM nursingcare_orders WHERE order_type_id = 6 AND concept_id = (SELECT concept_id FROM concept WHERE uuid = 'b364340c-99d3-4e2b-a1e6-043301ccf02c' ) AND instruction = 'q 1h' AND (date_created BETWEEN :startDate AND :endDate ) AND (date_stopped IS NULL OR date_stopped > :endDate ) AND patient_id IN (SELECT DISTINCT nursingcare_patient_case_record.patient_id FROM nursingcare_patient_case_record INNER JOIN nursingcare_patient_movement ON nursingcare_patient_case_record.latest_patient_movement_id = nursingcare_patient_movement.id INNER JOIN encounter ON encounter.encounter_id = nursingcare_patient_movement.encounter_id WHERE encounter.location_id IN ( :locationId ) AND (datetime_discharged IS NULL OR datetime_discharged > :endDate ) ) "),
		 IO_SHIFT(
			 	"SELECT COUNT(DISTINCT patient_id) FROM nursingcare_orders WHERE order_type_id = 6 AND concept_id = (SELECT concept_id FROM concept WHERE uuid = 'b364340c-99d3-4e2b-a1e6-043301ccf02c' ) AND instruction = 'q shift' AND (date_created BETWEEN :startDate AND :endDate ) AND (date_stopped IS NULL OR date_stopped > :endDate ) AND patient_id IN (SELECT DISTINCT nursingcare_patient_case_record.patient_id FROM nursingcare_patient_case_record INNER JOIN nursingcare_patient_movement ON nursingcare_patient_case_record.latest_patient_movement_id = nursingcare_patient_movement.id INNER JOIN encounter ON encounter.encounter_id = nursingcare_patient_movement.encounter_id WHERE encounter.location_id IN ( :locationId ) AND (datetime_discharged IS NULL OR datetime_discharged > :endDate ) ) "),
		THERMOREGULATION(
				"SELECT COUNT(DISTINCT patient_id) FROM nursingcare_orders WHERE order_type_id = 8 AND concept_id = (SELECT concept_id FROM concept WHERE uuid = 'ecd45401-7826-4541-a914-6f5f2f4407f7' ) AND instruction != ' ' AND (date_created BETWEEN :startDate AND :endDate ) AND (date_stopped IS NULL OR date_stopped > :endDate ) AND patient_id IN (SELECT DISTINCT nursingcare_patient_case_record.patient_id FROM nursingcare_patient_case_record INNER JOIN nursingcare_patient_movement ON nursingcare_patient_case_record.latest_patient_movement_id = nursingcare_patient_movement.id INNER JOIN encounter ON encounter.encounter_id = nursingcare_patient_movement.encounter_id WHERE encounter.location_id IN ( :locationId ) AND (datetime_discharged IS NULL OR datetime_discharged > :endDate ) ) "),
		PAIN_ASSESSMENT(
				"SELECT COUNT(DISTINCT patient_id) FROM nursingcare_orders WHERE order_type_id = 6 AND concept_id = (SELECT concept_id FROM concept WHERE uuid = 'ae23a19e-c27c-4855-96a2-77bc8baebbef' ) AND instruction != ' ' AND (date_created BETWEEN :startDate AND :endDate ) AND (date_stopped IS NULL OR date_stopped > :endDate ) AND patient_id IN (SELECT DISTINCT nursingcare_patient_case_record.patient_id FROM nursingcare_patient_case_record INNER JOIN nursingcare_patient_movement ON nursingcare_patient_case_record.latest_patient_movement_id = nursingcare_patient_movement.id INNER JOIN encounter ON encounter.encounter_id = nursingcare_patient_movement.encounter_id WHERE encounter.location_id IN ( :locationId ) AND (datetime_discharged IS NULL OR datetime_discharged > :endDate ) ) "),
		CBG(
				"SELECT COUNT(DISTINCT patient_id) FROM nursingcare_orders WHERE order_type_id = 6 AND concept_id = (SELECT concept_id FROM concept WHERE uuid = '560430bf-7241-433e-b24d-f03b171f7a01' ) AND instruction != ' ' AND (date_created BETWEEN :startDate AND :endDate ) AND (date_stopped IS NULL OR date_stopped > :endDate ) AND patient_id IN (SELECT DISTINCT nursingcare_patient_case_record.patient_id FROM nursingcare_patient_case_record INNER JOIN nursingcare_patient_movement ON nursingcare_patient_case_record.latest_patient_movement_id = nursingcare_patient_movement.id INNER JOIN encounter ON encounter.encounter_id = nursingcare_patient_movement.encounter_id WHERE encounter.location_id IN ( :locationId ) AND (datetime_discharged IS NULL OR datetime_discharged > :endDate ) ) "),
		OTHERS(
				"SELECT COUNT(DISTINCT patient_id) FROM nursingcare_orders WHERE order_type_id = 6 AND concept_id = (SELECT concept_id FROM concept WHERE uuid = 'f53d68c9-d75d-4930-8d41-cc9f22002138' ) AND instruction != ' ' AND (date_created BETWEEN :startDate AND :endDate ) AND (date_stopped IS NULL OR date_stopped > :endDate ) AND patient_id IN (SELECT DISTINCT nursingcare_patient_case_record.patient_id FROM nursingcare_patient_case_record INNER JOIN nursingcare_patient_movement ON nursingcare_patient_case_record.latest_patient_movement_id = nursingcare_patient_movement.id INNER JOIN encounter ON encounter.encounter_id = nursingcare_patient_movement.encounter_id WHERE encounter.location_id IN ( :locationId ) AND (datetime_discharged IS NULL OR datetime_discharged > :endDate ) ) ");
		
		private String value;
		
		public String getValue() {
			return value;
		}
		
		public void setValue(String value) {
			this.value = value;
		}
		
		private MonitoringReportEnum(String value) {
			this.value = value;
		}
		
	}

	public enum ComfortReportEnum {
		BED_BATH(
		        "SELECT COUNT(DISTINCT patient_id) FROM nursingcare_orders WHERE order_type_id = 8 AND concept_id = (SELECT concept_id FROM concept WHERE uuid = '93e112bc-b7ef-431e-b20e-a42691b5ebe0' ) AND instruction != ' ' AND (date_created BETWEEN :startDate AND :endDate ) AND (date_stopped IS NULL OR date_stopped > :endDate ) AND patient_id IN (SELECT DISTINCT nursingcare_patient_case_record.patient_id FROM nursingcare_patient_case_record INNER JOIN nursingcare_patient_movement ON nursingcare_patient_case_record.latest_patient_movement_id = nursingcare_patient_movement.id INNER JOIN encounter ON encounter.encounter_id = nursingcare_patient_movement.encounter_id WHERE encounter.location_id IN ( :locationId ) AND (datetime_discharged IS NULL OR datetime_discharged > :endDate ) ) "), 
		TSB(
				"SELECT COUNT(DISTINCT patient_id) FROM nursingcare_orders WHERE order_type_id = 8 AND concept_id = (SELECT concept_id FROM concept WHERE uuid = '0f77a77a-cd40-4640-9365-7c67fbed8345' ) AND instruction != ' ' AND (date_created BETWEEN :startDate AND :endDate ) AND (date_stopped IS NULL OR date_stopped > :endDate ) AND patient_id IN (SELECT DISTINCT nursingcare_patient_case_record.patient_id FROM nursingcare_patient_case_record INNER JOIN nursingcare_patient_movement ON nursingcare_patient_case_record.latest_patient_movement_id = nursingcare_patient_movement.id INNER JOIN encounter ON encounter.encounter_id = nursingcare_patient_movement.encounter_id WHERE encounter.location_id IN ( :locationId ) AND (datetime_discharged IS NULL OR datetime_discharged > :endDate ) ) "),
		HAIR_SHAMPOO(
				 "SELECT COUNT(DISTINCT patient_id) FROM nursingcare_orders WHERE order_type_id = 8 AND concept_id = (SELECT concept_id FROM concept WHERE uuid = '606b7ce4-b927-429f-8bf9-548644055ecd' ) AND instruction != ' ' AND (date_created BETWEEN :startDate AND :endDate ) AND (date_stopped IS NULL OR date_stopped > :endDate ) AND patient_id IN (SELECT DISTINCT nursingcare_patient_case_record.patient_id FROM nursingcare_patient_case_record INNER JOIN nursingcare_patient_movement ON nursingcare_patient_case_record.latest_patient_movement_id = nursingcare_patient_movement.id INNER JOIN encounter ON encounter.encounter_id = nursingcare_patient_movement.encounter_id WHERE encounter.location_id IN ( :locationId ) AND (datetime_discharged IS NULL OR datetime_discharged > :endDate ) ) "),
		ORIFICE_CARE(
				 "SELECT COUNT(DISTINCT patient_id) FROM nursingcare_orders WHERE concept_id IN (SELECT concept_id FROM concept WHERE uuid IN ( 'bde38694-0646-4539-b226-6946e04ad9cd','26993480-87d1-4bce-8705-36e1ae9cb127','8afa8466-f4be-4564-87d7-d40ab1f7b91b','bbd3ffaa-3e7a-48c4-b06b-fb3cb10f8254' )) AND (date_created BETWEEN :startDate AND :endDate ) AND (date_stopped IS NULL OR date_stopped > :endDate ) AND patient_id IN (SELECT DISTINCT nursingcare_patient_case_record.patient_id FROM nursingcare_patient_case_record INNER JOIN nursingcare_patient_movement ON nursingcare_patient_case_record.latest_patient_movement_id = nursingcare_patient_movement.id INNER JOIN encounter ON encounter.encounter_id = nursingcare_patient_movement.encounter_id WHERE encounter.location_id IN ( :locationId ) AND (datetime_discharged IS NULL OR datetime_discharged > :endDate ) ) "),
		ORAL_CARE(
				 "SELECT COUNT(DISTINCT patient_id) FROM nursingcare_orders WHERE concept_id IN (SELECT concept_id FROM concept WHERE uuid IN ( '26993480-87d1-4bce-8705-36e1ae9cb127','8afa8466-f4be-4564-87d7-d40ab1f7b91b','bbd3ffaa-3e7a-48c4-b06b-fb3cb10f8254' )) AND (date_created BETWEEN :startDate AND :endDate ) AND (date_stopped IS NULL OR date_stopped > :endDate ) AND patient_id IN (SELECT DISTINCT nursingcare_patient_case_record.patient_id FROM nursingcare_patient_case_record INNER JOIN nursingcare_patient_movement ON nursingcare_patient_case_record.latest_patient_movement_id = nursingcare_patient_movement.id INNER JOIN encounter ON encounter.encounter_id = nursingcare_patient_movement.encounter_id WHERE encounter.location_id IN ( :locationId ) AND (datetime_discharged IS NULL OR datetime_discharged > :endDate ) ) "),
		NAIL_CARE(
				 "SELECT COUNT(DISTINCT patient_id) FROM nursingcare_orders WHERE order_type_id = 8 AND concept_id = (SELECT concept_id FROM concept WHERE uuid = '39a4d464-1abc-4c43-83ca-68314fb40ef0' ) AND instruction != ' ' AND (date_created BETWEEN :startDate AND :endDate ) AND (date_stopped IS NULL OR date_stopped > :endDate ) AND patient_id IN (SELECT DISTINCT nursingcare_patient_case_record.patient_id FROM nursingcare_patient_case_record INNER JOIN nursingcare_patient_movement ON nursingcare_patient_case_record.latest_patient_movement_id = nursingcare_patient_movement.id INNER JOIN encounter ON encounter.encounter_id = nursingcare_patient_movement.encounter_id WHERE encounter.location_id IN ( :locationId ) AND (datetime_discharged IS NULL OR datetime_discharged > :endDate ) ) "),
		PERINEAL_CARE(
				 "SELECT COUNT(DISTINCT patient_id) FROM nursingcare_orders WHERE order_type_id = 8 AND concept_id = (SELECT concept_id FROM concept WHERE uuid = 'c52ab153-2192-4a31-95ac-2ec6ac5ed1b5' ) AND instruction != ' ' AND (date_created BETWEEN :startDate AND :endDate ) AND (date_stopped IS NULL OR date_stopped > :endDate ) AND patient_id IN (SELECT DISTINCT nursingcare_patient_case_record.patient_id FROM nursingcare_patient_case_record INNER JOIN nursingcare_patient_movement ON nursingcare_patient_case_record.latest_patient_movement_id = nursingcare_patient_movement.id INNER JOIN encounter ON encounter.encounter_id = nursingcare_patient_movement.encounter_id WHERE encounter.location_id IN ( :locationId ) AND (datetime_discharged IS NULL OR datetime_discharged > :endDate ) ) "),
		MASSAGE_BACK_BONY_PROMINENCES(
				 "SELECT COUNT(DISTINCT patient_id) FROM nursingcare_orders WHERE order_type_id = 8 AND concept_id = (SELECT concept_id FROM concept WHERE uuid = 'a3ea9051-6c80-489a-b729-57bc519eeeb2' ) AND instruction != ' ' AND (date_created BETWEEN :startDate AND :endDate ) AND (date_stopped IS NULL OR date_stopped > :endDate ) AND patient_id IN (SELECT DISTINCT nursingcare_patient_case_record.patient_id FROM nursingcare_patient_case_record INNER JOIN nursingcare_patient_movement ON nursingcare_patient_case_record.latest_patient_movement_id = nursingcare_patient_movement.id INNER JOIN encounter ON encounter.encounter_id = nursingcare_patient_movement.encounter_id WHERE encounter.location_id IN ( :locationId ) AND (datetime_discharged IS NULL OR datetime_discharged > :endDate ) ) "),
		LINEN_CHANGE(
				 "SELECT COUNT(DISTINCT patient_id) FROM nursingcare_orders WHERE order_type_id = 8 AND concept_id = (SELECT concept_id FROM concept WHERE uuid = '116543AAAAAAAAAAAAAAAAAAAAAAAAAAAAAA' ) AND instruction != ' ' AND (date_created BETWEEN :startDate AND :endDate ) AND (date_stopped IS NULL OR date_stopped > :endDate ) AND patient_id IN (SELECT DISTINCT nursingcare_patient_case_record.patient_id FROM nursingcare_patient_case_record INNER JOIN nursingcare_patient_movement ON nursingcare_patient_case_record.latest_patient_movement_id = nursingcare_patient_movement.id INNER JOIN encounter ON encounter.encounter_id = nursingcare_patient_movement.encounter_id WHERE encounter.location_id IN ( :locationId ) AND (datetime_discharged IS NULL OR datetime_discharged > :endDate ) ) "),
		OTHER_COMFORT(
				 "SELECT COUNT(DISTINCT patient_id) FROM nursingcare_orders WHERE order_type_id = 8 AND concept_id IN (SELECT concept_id FROM concept WHERE uuid IN ( 'f93e02fb-f58d-4271-af46-14f26a04aee5','d97fb75e-fdf9-4677-983d-3d9bf341011c','880af0cd-3d67-479c-b12f-a7bb5fdbe535' )) AND instruction != ' ' AND (date_created BETWEEN :startDate AND :endDate ) AND (date_stopped IS NULL OR date_stopped > :endDate ) AND patient_id IN (SELECT DISTINCT nursingcare_patient_case_record.patient_id FROM nursingcare_patient_case_record INNER JOIN nursingcare_patient_movement ON nursingcare_patient_case_record.latest_patient_movement_id = nursingcare_patient_movement.id INNER JOIN encounter ON encounter.encounter_id = nursingcare_patient_movement.encounter_id WHERE encounter.location_id IN ( :locationId ) AND (datetime_discharged IS NULL OR datetime_discharged > :endDate ) ) ")
		;
		
		private String value;
		
		public String getValue() {
			return value;
		}
		
		public void setValue(String value) {
			this.value = value;
		}
		
		private ComfortReportEnum(String value) {
			this.value = value;
		}
		
	}
	


	public enum NutritionalReportEnum {
		ORAL(
				 "SELECT COUNT(DISTINCT patient_id) FROM nursingcare_orders WHERE order_type_id = 4 AND concept_id = (SELECT concept_id FROM concept WHERE uuid = '8089bb45-cf67-4ae0-b5bd-65e0287a0e44' ) AND (date_created BETWEEN :startDate AND :endDate ) AND (date_stopped IS NULL OR date_stopped > :endDate ) AND patient_id IN (SELECT DISTINCT nursingcare_patient_case_record.patient_id FROM nursingcare_patient_case_record INNER JOIN nursingcare_patient_movement ON nursingcare_patient_case_record.latest_patient_movement_id = nursingcare_patient_movement.id INNER JOIN encounter ON encounter.encounter_id = nursingcare_patient_movement.encounter_id WHERE encounter.location_id IN ( :locationId ) AND (datetime_discharged IS NULL OR datetime_discharged > :endDate ) ) "),
		NGT(
				 "SELECT COUNT(DISTINCT patient_id) FROM nursingcare_orders WHERE concept_id IN (SELECT concept_id FROM concept WHERE uuid IN ( '26993480-87d1-4bce-8705-36e1ae9cb127','8afa8466-f4be-4564-87d7-d40ab1f7b91b','0189693f-cf00-4de4-b5fc-d83094681fd6','c355adce-64aa-483e-ae8d-adef75fd9152' )) AND (date_created BETWEEN :startDate AND :endDate ) AND (date_stopped IS NULL OR date_stopped > :endDate ) AND patient_id IN (SELECT DISTINCT nursingcare_patient_case_record.patient_id FROM nursingcare_patient_case_record INNER JOIN nursingcare_patient_movement ON nursingcare_patient_case_record.latest_patient_movement_id = nursingcare_patient_movement.id INNER JOIN encounter ON encounter.encounter_id = nursingcare_patient_movement.encounter_id WHERE encounter.location_id IN ( :locationId ) AND (datetime_discharged IS NULL OR datetime_discharged > :endDate ) ) "),
		PARENTERAL(
				 "SELECT COUNT(DISTINCT patient_case_record_id) FROM nursingcare_parenteral_order_infusion WHERE parenteral_order_infusion_type IN (SELECT id FROM nursingcare_parenteral_order_type WHERE intravenous_fluid = 'TPN' ) AND (datetime_started BETWEEN :startDate AND :endDate ) AND (datetime_stopped IS NULL OR datetime_stopped > :endDate ) AND patient_case_record_id IN (SELECT DISTINCT nursingcare_patient_case_record.id FROM nursingcare_patient_case_record INNER JOIN nursingcare_patient_movement ON nursingcare_patient_case_record.latest_patient_movement_id = nursingcare_patient_movement.id INNER JOIN encounter ON encounter.encounter_id = nursingcare_patient_movement.encounter_id WHERE encounter.location_id IN ( :locationId ) AND (datetime_discharged IS NULL OR datetime_discharged > :endDate ) ) "),
		OTHER_NUTRITIONAL(
				 "SELECT COUNT(DISTINCT patient_id) FROM nursingcare_orders WHERE order_type_id = 4 AND concept_id = (SELECT concept_id FROM concept WHERE uuid = 'c9432ae5-6e92-4ede-afb5-1675d1b7e388' ) AND instruction != ' ' AND (date_created BETWEEN :startDate AND :endDate ) AND (date_stopped IS NULL OR date_stopped > :endDate ) AND patient_id IN (SELECT DISTINCT nursingcare_patient_case_record.patient_id FROM nursingcare_patient_case_record INNER JOIN nursingcare_patient_movement ON nursingcare_patient_case_record.latest_patient_movement_id = nursingcare_patient_movement.id INNER JOIN encounter ON encounter.encounter_id = nursingcare_patient_movement.encounter_id WHERE encounter.location_id IN ( :locationId ) AND (datetime_discharged IS NULL OR datetime_discharged > :endDate ) ) ")
		;
		
		private String value;
		
		public String getValue() {
			return value;
		}
		
		public void setValue(String value) {
			this.value = value;
		}
		
		private NutritionalReportEnum(String value) {
			this.value = value;
		}
		
	}
	

	public enum VentilatoryReportEnum {
		OXYGEN_THERAPY(
				 "SELECT COUNT(DISTINCT patient_id) FROM nursingcare_orders WHERE order_type_id = 7 AND concept_id IN (SELECT concept_id FROM concept WHERE uuid IN ( 'bbd3ffaa-3e7a-48c4-b06b-fb3cb10f8254' )) AND instruction IN (SELECT concept_id FROM concept WHERE uuid IN ( 'd11ff6f8-44f1-4a3c-a4ca-0f724539ab1b','06d06043-2582-4197-a569-71750ddbc59c','209e3b60-3b14-4090-a82f-eb546b2dca89','f8429743-7a88-4afb-9cfb-a2e0fc7ded44','3b2e47f0-3848-4ff1-baa6-bd4318638cd0' )) AND (date_created BETWEEN :startDate AND :endDate ) AND (date_stopped IS NULL OR date_stopped > :endDate ) AND patient_id IN (SELECT DISTINCT nursingcare_patient_case_record.patient_id FROM nursingcare_patient_case_record INNER JOIN nursingcare_patient_movement ON nursingcare_patient_case_record.latest_patient_movement_id = nursingcare_patient_movement.id INNER JOIN encounter ON encounter.encounter_id = nursingcare_patient_movement.encounter_id WHERE encounter.location_id IN ( :locationId ) AND (datetime_discharged IS NULL OR datetime_discharged > :endDate ) ) "),
		MECHANICAL_VENTILATOR(
				 "SELECT COUNT(DISTINCT patient_id) FROM nursingcare_orders WHERE order_type_id = 7 AND concept_id IN (SELECT concept_id FROM concept WHERE uuid IN ( 'bbd3ffaa-3e7a-48c4-b06b-fb3cb10f8254' )) AND instruction IN (SELECT concept_id FROM concept WHERE uuid = '3b2e47f0-3848-4ff1-baa6-bd4318638cd0' ) AND (date_created BETWEEN :startDate AND :endDate ) AND (date_stopped IS NULL OR date_stopped > :endDate ) AND patient_id IN (SELECT DISTINCT nursingcare_patient_case_record.patient_id FROM nursingcare_patient_case_record INNER JOIN nursingcare_patient_movement ON nursingcare_patient_case_record.latest_patient_movement_id = nursingcare_patient_movement.id INNER JOIN encounter ON encounter.encounter_id = nursingcare_patient_movement.encounter_id WHERE encounter.location_id IN ( :locationId ) AND (datetime_discharged IS NULL OR datetime_discharged > :endDate ) ) "),
		SUCTIONING(
				 "SELECT COUNT(DISTINCT patient_id) FROM nursingcare_orders WHERE order_type_id = 7 AND concept_id = (SELECT concept_id FROM concept WHERE uuid = 'eb9a20b1-c942-4250-be42-9bb8edc78059' ) AND instruction != ' ' AND (date_created BETWEEN :startDate AND :endDate ) AND (date_stopped IS NULL OR date_stopped > :endDate ) AND patient_id IN (SELECT DISTINCT nursingcare_patient_case_record.patient_id FROM nursingcare_patient_case_record INNER JOIN nursingcare_patient_movement ON nursingcare_patient_case_record.latest_patient_movement_id = nursingcare_patient_movement.id INNER JOIN encounter ON encounter.encounter_id = nursingcare_patient_movement.encounter_id WHERE encounter.location_id IN ( :locationId ) AND (datetime_discharged IS NULL OR datetime_discharged > :endDate ) ) "),
		AMBUBAGGING(
				 "SELECT COUNT(DISTINCT patient_id) FROM nursingcare_orders WHERE order_type_id = 7 AND concept_id = (SELECT concept_id FROM concept WHERE uuid = 'eecc4320-2a60-4384-8790-f7b82ee3d2d3' ) AND instruction != ' ' AND (date_created BETWEEN :startDate AND :endDate ) AND (date_stopped IS NULL OR date_stopped > :endDate ) AND patient_id IN (SELECT DISTINCT nursingcare_patient_case_record.patient_id FROM nursingcare_patient_case_record INNER JOIN nursingcare_patient_movement ON nursingcare_patient_case_record.latest_patient_movement_id = nursingcare_patient_movement.id INNER JOIN encounter ON encounter.encounter_id = nursingcare_patient_movement.encounter_id WHERE encounter.location_id IN ( :locationId ) AND (datetime_discharged IS NULL OR datetime_discharged > :endDate ) ) "),
		NEBULIZATION(
				 "SELECT COUNT(DISTINCT patient_id) FROM nursingcare_orders WHERE order_type_id = 7 AND concept_id = (SELECT concept_id FROM concept WHERE uuid = 'b9efdbac-44a6-48b9-9580-a64ca59fddfb' ) AND instruction != ' ' AND (date_created BETWEEN :startDate AND :endDate ) AND (date_stopped IS NULL OR date_stopped > :endDate ) AND patient_id IN (SELECT DISTINCT nursingcare_patient_case_record.patient_id FROM nursingcare_patient_case_record INNER JOIN nursingcare_patient_movement ON nursingcare_patient_case_record.latest_patient_movement_id = nursingcare_patient_movement.id INNER JOIN encounter ON encounter.encounter_id = nursingcare_patient_movement.encounter_id WHERE encounter.location_id IN ( :locationId ) AND (datetime_discharged IS NULL OR datetime_discharged > :endDate ) ) "),
		PULMONARY_PHYSIOTHERAPY(
				 "SELECT COUNT(DISTINCT patient_id) FROM nursingcare_orders WHERE order_type_id = 7 AND concept_id = (SELECT concept_id FROM concept WHERE uuid = '26eaa376-0f66-4b72-93fa-b9714b843b5e' ) AND instruction != ' ' AND (date_created BETWEEN :startDate AND :endDate ) AND (date_stopped IS NULL OR date_stopped > :endDate ) AND patient_id IN (SELECT DISTINCT nursingcare_patient_case_record.patient_id FROM nursingcare_patient_case_record INNER JOIN nursingcare_patient_movement ON nursingcare_patient_case_record.latest_patient_movement_id = nursingcare_patient_movement.id INNER JOIN encounter ON encounter.encounter_id = nursingcare_patient_movement.encounter_id WHERE encounter.location_id IN ( :locationId ) AND (datetime_discharged IS NULL OR datetime_discharged > :endDate ) ) "),
		INTUBATION(
				 "SELECT COUNT(DISTINCT patient_id) FROM nursingcare_orders WHERE order_type_id = 7 AND concept_id = (SELECT concept_id FROM concept WHERE uuid = '745203a4-adc0-4170-a05f-e9f258be63da' ) AND instruction != ' ' AND (date_created BETWEEN :startDate AND :endDate ) AND (date_stopped IS NULL OR date_stopped > :endDate ) AND patient_id IN (SELECT DISTINCT nursingcare_patient_case_record.patient_id FROM nursingcare_patient_case_record INNER JOIN nursingcare_patient_movement ON nursingcare_patient_case_record.latest_patient_movement_id = nursingcare_patient_movement.id INNER JOIN encounter ON encounter.encounter_id = nursingcare_patient_movement.encounter_id WHERE encounter.location_id IN ( :locationId ) AND (datetime_discharged IS NULL OR datetime_discharged > :endDate ) ) "),
		OTHER_VENTILATOR(
				 "SELECT COUNT(DISTINCT patient_id) FROM nursingcare_orders WHERE order_type_id = 7 AND concept_id = (SELECT concept_id FROM concept WHERE uuid = 'c3ec1746-25d3-4393-bb26-b55c29292373' ) AND instruction != ' ' AND (date_created BETWEEN :startDate AND :endDate ) AND (date_stopped IS NULL OR date_stopped > :endDate ) AND patient_id IN (SELECT DISTINCT nursingcare_patient_case_record.patient_id FROM nursingcare_patient_case_record INNER JOIN nursingcare_patient_movement ON nursingcare_patient_case_record.latest_patient_movement_id = nursingcare_patient_movement.id INNER JOIN encounter ON encounter.encounter_id = nursingcare_patient_movement.encounter_id WHERE encounter.location_id IN ( :locationId ) AND (datetime_discharged IS NULL OR datetime_discharged > :endDate ) ) ")
		;
		
		private String value;
		
		public String getValue() {
			return value;
		}
		
		public void setValue(String value) {
			this.value = value;
		}
		
		private VentilatoryReportEnum(String value) {
			this.value = value;
		}
		
	}
	

	public enum EliminationReportEnum {
		BOWEL_COLOSTOMY(
				 "SELECT COUNT(DISTINCT patient_id) FROM nursingcare_orders WHERE order_type_id = 6 AND concept_id IN (SELECT concept_id FROM concept WHERE uuid IN ( '97b4765e-2828-4c1a-8716-54688aefda67', '932012d7-3732-4509-9494-d61b65d8f0da' )) AND instruction != ' ' AND (date_created BETWEEN :startDate AND :endDate ) AND (date_stopped IS NULL OR date_stopped > :endDate ) AND patient_id IN (SELECT DISTINCT nursingcare_patient_case_record.patient_id FROM nursingcare_patient_case_record INNER JOIN nursingcare_patient_movement ON nursingcare_patient_case_record.latest_patient_movement_id = nursingcare_patient_movement.id INNER JOIN encounter ON encounter.encounter_id = nursingcare_patient_movement.encounter_id WHERE encounter.location_id IN ( :locationId ) AND (datetime_discharged IS NULL OR datetime_discharged > :endDate ) ) "),
		ILEOSTOMY(
				 "SELECT COUNT(DISTINCT patient_id) FROM nursingcare_orders WHERE order_type_id = 6 AND concept_id IN (SELECT concept_id FROM concept WHERE uuid IN ( '97b4765e-2828-4c1a-8716-54688aefda67', '932012d7-3732-4509-9494-d61b65d8f0da' )) AND instruction != ' ' AND (date_created BETWEEN :startDate AND :endDate ) AND (date_stopped IS NULL OR date_stopped > :endDate ) AND patient_id IN (SELECT DISTINCT nursingcare_patient_case_record.patient_id FROM nursingcare_patient_case_record INNER JOIN nursingcare_patient_movement ON nursingcare_patient_case_record.latest_patient_movement_id = nursingcare_patient_movement.id INNER JOIN encounter ON encounter.encounter_id = nursingcare_patient_movement.encounter_id WHERE encounter.location_id IN ( :locationId ) AND (datetime_discharged IS NULL OR datetime_discharged > :endDate ) ) "),
		FOLEY_CATHETER(
				 "SELECT COUNT(DISTINCT patient_id) FROM nursingcare_orders WHERE order_type_id = 6 AND concept_id = (SELECT concept_id FROM concept WHERE uuid = 'bde38694-0646-4539-b226-6946e04ad9cd' ) AND instruction != ' ' AND (date_created BETWEEN :startDate AND :endDate ) AND (date_stopped IS NULL OR date_stopped > :endDate ) AND patient_id IN (SELECT DISTINCT nursingcare_patient_case_record.patient_id FROM nursingcare_patient_case_record INNER JOIN nursingcare_patient_movement ON nursingcare_patient_case_record.latest_patient_movement_id = nursingcare_patient_movement.id INNER JOIN encounter ON encounter.encounter_id = nursingcare_patient_movement.encounter_id WHERE encounter.location_id IN ( :locationId ) AND (datetime_discharged IS NULL OR datetime_discharged > :endDate ) ) "),
		PERITONEAL_DIALYSIS(
				 "SELECT COUNT(DISTINCT patient_id) FROM nursingcare_orders WHERE order_type_id = 6 AND concept_id = (SELECT concept_id FROM concept WHERE uuid = '1e553429-febd-4fce-a56b-a6bdf633c6e7' ) AND instruction != ' ' AND (date_created BETWEEN :startDate AND :endDate ) AND (date_stopped IS NULL OR date_stopped > :endDate ) AND patient_id IN (SELECT DISTINCT nursingcare_patient_case_record.patient_id FROM nursingcare_patient_case_record INNER JOIN nursingcare_patient_movement ON nursingcare_patient_case_record.latest_patient_movement_id = nursingcare_patient_movement.id INNER JOIN encounter ON encounter.encounter_id = nursingcare_patient_movement.encounter_id WHERE encounter.location_id IN ( :locationId ) AND (datetime_discharged IS NULL OR datetime_discharged > :endDate ) ) "),
		HEMODIALYSIS(
				 "SELECT COUNT(DISTINCT patient_id) FROM nursingcare_patient_case_record INNER JOIN nursingcare_procedure ON nursingcare_procedure.patient_case_record_id = nursingcare_patient_case_record.id WHERE procedure_concept_id = (SELECT concept_id FROM concept WHERE uuid = '40b5f439-1a62-4d80-9fd1-0259a68d11b0' ) AND (date_schedule BETWEEN :startDate AND :endDate ) AND patient_id IN (SELECT DISTINCT nursingcare_patient_case_record.patient_id FROM nursingcare_patient_case_record INNER JOIN nursingcare_patient_movement ON nursingcare_patient_case_record.latest_patient_movement_id = nursingcare_patient_movement.id INNER JOIN encounter ON encounter.encounter_id = nursingcare_patient_movement.encounter_id WHERE encounter.location_id IN ( :locationId ) AND (datetime_discharged IS NULL OR datetime_discharged > :endDate ) ) "),
		OTHER_ELIMINATION(
				 "SELECT COUNT(DISTINCT patient_id) FROM nursingcare_orders WHERE order_type_id = 6 AND concept_id = (SELECT concept_id FROM concept WHERE uuid = 'c73605d0-333d-46e0-861a-d8793dbc8ee8' ) AND instruction != ' ' AND (date_created BETWEEN :startDate AND :endDate ) AND (date_stopped IS NULL OR date_stopped > :endDate ) AND patient_id IN (SELECT DISTINCT nursingcare_patient_case_record.patient_id FROM nursingcare_patient_case_record INNER JOIN nursingcare_patient_movement ON nursingcare_patient_case_record.latest_patient_movement_id = nursingcare_patient_movement.id INNER JOIN encounter ON encounter.encounter_id = nursingcare_patient_movement.encounter_id WHERE encounter.location_id IN ( :locationId ) AND (datetime_discharged IS NULL OR datetime_discharged > :endDate ) ) ")
		;
		
		private String value;
		
		public String getValue() {
			return value;
		}
		
		public void setValue(String value) {
			this.value = value;
		}
		
		private EliminationReportEnum(String value) {
			this.value = value;
		}
		
	}


	public enum MobilityReportEnum {
		POSITIONING(
				 "SELECT COUNT(DISTINCT patient_id) FROM nursingcare_orders WHERE order_type_id = 8 AND concept_id = (SELECT concept_id FROM concept WHERE uuid = '109c5458-7b0c-428e-bc15-0855b017130e' ) AND instruction != ' ' AND (date_created BETWEEN :startDate AND :endDate ) AND (date_stopped IS NULL OR date_stopped > :endDate ) AND patient_id IN (SELECT DISTINCT nursingcare_patient_case_record.patient_id FROM nursingcare_patient_case_record INNER JOIN nursingcare_patient_movement ON nursingcare_patient_case_record.latest_patient_movement_id = nursingcare_patient_movement.id INNER JOIN encounter ON encounter.encounter_id = nursingcare_patient_movement.encounter_id WHERE encounter.location_id IN ( :locationId ) AND (datetime_discharged IS NULL OR datetime_discharged > :endDate ) ) "),
		TRANSPORTING(
				 "SELECT COUNT(DISTINCT patient_id) FROM nursingcare_orders WHERE order_type_id = 8 AND concept_id IN (SELECT concept_id FROM concept WHERE uuid IN ( '34345713-68fd-48de-81b1-7c9223fb8515', 'e05c1acb-b699-4f4b-8b86-4c5511a7246b', 'f93e02fb-f58d-4271-af46-14f26a04aee5' )) AND instruction != ' ' AND (date_created BETWEEN :startDate AND :endDate ) AND (date_stopped IS NULL OR date_stopped > :endDate ) AND patient_id IN (SELECT DISTINCT nursingcare_patient_case_record.patient_id FROM nursingcare_patient_case_record INNER JOIN nursingcare_patient_movement ON nursingcare_patient_case_record.latest_patient_movement_id = nursingcare_patient_movement.id INNER JOIN encounter ON encounter.encounter_id = nursingcare_patient_movement.encounter_id WHERE encounter.location_id IN ( :locationId ) AND (datetime_discharged IS NULL OR datetime_discharged > :endDate ) ) "),
		TURNING_EVERY_TWO_HOURS(
				 "SELECT COUNT(DISTINCT patient_id) FROM nursingcare_orders WHERE order_type_id = 8 AND concept_id = (SELECT concept_id FROM concept WHERE uuid = 'f93e02fb-f58d-4271-af46-14f26a04aee5' ) AND instruction != ' ' AND (date_created BETWEEN :startDate AND :endDate ) AND (date_stopped IS NULL OR date_stopped > :endDate ) AND patient_id IN (SELECT DISTINCT nursingcare_patient_case_record.patient_id FROM nursingcare_patient_case_record INNER JOIN nursingcare_patient_movement ON nursingcare_patient_case_record.latest_patient_movement_id = nursingcare_patient_movement.id INNER JOIN encounter ON encounter.encounter_id = nursingcare_patient_movement.encounter_id WHERE encounter.location_id IN ( :locationId ) AND (datetime_discharged IS NULL OR datetime_discharged > :endDate ) ) "),
		FALL_PREVENTION(
				 "SELECT COUNT(DISTINCT patient_id) FROM nursingcare_orders WHERE order_type_id = 8 AND concept_id = (SELECT concept_id FROM concept WHERE uuid = 'f93e02fb-f58d-4271-af46-14f26a04aee5' ) AND instruction != ' ' AND (date_created BETWEEN :startDate AND :endDate ) AND (date_stopped IS NULL OR date_stopped > :endDate ) AND patient_id IN (SELECT DISTINCT nursingcare_patient_case_record.patient_id FROM nursingcare_patient_case_record INNER JOIN nursingcare_patient_movement ON nursingcare_patient_case_record.latest_patient_movement_id = nursingcare_patient_movement.id INNER JOIN encounter ON encounter.encounter_id = nursingcare_patient_movement.encounter_id WHERE encounter.location_id IN ( :locationId ) AND (datetime_discharged IS NULL OR datetime_discharged > :endDate ) ) "),
		RESTRAINING(
				 "SELECT COUNT(DISTINCT patient_id) FROM nursingcare_orders WHERE order_type_id = 8 AND concept_id = (SELECT concept_id FROM concept WHERE uuid = '0756e71d-473d-42b9-9a28-f615e55753d1' ) AND instruction != ' ' AND (date_created BETWEEN :startDate AND :endDate ) AND (date_stopped IS NULL OR date_stopped > :endDate ) AND patient_id IN (SELECT DISTINCT nursingcare_patient_case_record.patient_id FROM nursingcare_patient_case_record INNER JOIN nursingcare_patient_movement ON nursingcare_patient_case_record.latest_patient_movement_id = nursingcare_patient_movement.id INNER JOIN encounter ON encounter.encounter_id = nursingcare_patient_movement.encounter_id WHERE encounter.location_id IN ( :locationId ) AND (datetime_discharged IS NULL OR datetime_discharged > :endDate ) ) "),
		PASSIVE_ROM(
				 "SELECT COUNT(DISTINCT patient_id) FROM nursingcare_orders WHERE order_type_id = 8 AND concept_id = (SELECT concept_id FROM concept WHERE uuid = 'f93e02fb-f58d-4271-af46-14f26a04aee5' ) AND instruction != ' ' AND (date_created BETWEEN :startDate AND :endDate ) AND (date_stopped IS NULL OR date_stopped > :endDate ) AND patient_id IN (SELECT DISTINCT nursingcare_patient_case_record.patient_id FROM nursingcare_patient_case_record INNER JOIN nursingcare_patient_movement ON nursingcare_patient_case_record.latest_patient_movement_id = nursingcare_patient_movement.id INNER JOIN encounter ON encounter.encounter_id = nursingcare_patient_movement.encounter_id WHERE encounter.location_id IN ( :locationId ) AND (datetime_discharged IS NULL OR datetime_discharged > :endDate ) ) "),
		CAST_CARE(
				"SELECT COUNT(DISTINCT patient_id) FROM nursingcare_orders WHERE order_type_id = 8 AND concept_id = (SELECT concept_id FROM concept WHERE uuid = '34345713-68fd-48de-81b1-7c9223fb8515' ) AND instruction != ' ' AND (date_created BETWEEN :startDate AND :endDate ) AND (date_stopped IS NULL OR date_stopped > :endDate ) AND patient_id IN (SELECT DISTINCT nursingcare_patient_case_record.patient_id FROM nursingcare_patient_case_record INNER JOIN nursingcare_patient_movement ON nursingcare_patient_case_record.latest_patient_movement_id = nursingcare_patient_movement.id INNER JOIN encounter ON encounter.encounter_id = nursingcare_patient_movement.encounter_id WHERE encounter.location_id IN ( :locationId ) AND (datetime_discharged IS NULL OR datetime_discharged > :endDate ) ) "),
		TRACTION_CARE(
				 "SELECT COUNT(DISTINCT patient_id) FROM nursingcare_orders WHERE order_type_id = 8 AND concept_id = (SELECT concept_id FROM concept WHERE uuid = 'e05c1acb-b699-4f4b-8b86-4c5511a7246b' ) AND instruction != ' ' AND (date_created BETWEEN :startDate AND :endDate ) AND (date_stopped IS NULL OR date_stopped > :endDate ) AND patient_id IN (SELECT DISTINCT nursingcare_patient_case_record.patient_id FROM nursingcare_patient_case_record INNER JOIN nursingcare_patient_movement ON nursingcare_patient_case_record.latest_patient_movement_id = nursingcare_patient_movement.id INNER JOIN encounter ON encounter.encounter_id = nursingcare_patient_movement.encounter_id WHERE encounter.location_id IN ( :locationId ) AND (datetime_discharged IS NULL OR datetime_discharged > :endDate ) ) "),
		OTHER_MOBILITY(
				 "SELECT COUNT(DISTINCT patient_id) FROM nursingcare_orders WHERE order_type_id = 8 AND concept_id = (SELECT concept_id FROM concept WHERE uuid = '05122f6c-d697-4436-9df5-cd29d14d50db' ) AND instruction != ' ' AND (date_created BETWEEN :startDate AND :endDate ) AND (date_stopped IS NULL OR date_stopped > :endDate ) AND patient_id IN (SELECT DISTINCT nursingcare_patient_case_record.patient_id FROM nursingcare_patient_case_record INNER JOIN nursingcare_patient_movement ON nursingcare_patient_case_record.latest_patient_movement_id = nursingcare_patient_movement.id INNER JOIN encounter ON encounter.encounter_id = nursingcare_patient_movement.encounter_id WHERE encounter.location_id IN ( :locationId ) AND (datetime_discharged IS NULL OR datetime_discharged > :endDate ) ) ")
		;
		
		private String value;
		
		public String getValue() {
			return value;
		}
		
		public void setValue(String value) {
			this.value = value;
		}
		
		private MobilityReportEnum(String value) {
			this.value = value;
		}
		
	}

	public enum IVTReportEnum {
		IVF(
				 "SELECT COUNT(DISTINCT patient_case_record_id) FROM nursingcare_parenteral_order_infusion WHERE ((parenteral_order_infusion_type IN (SELECT DISTINCT id FROM nursingcare_parenteral_order_type WHERE intravenous_fluid NOT IN ( 'TPN','pRBC','FWB','FFP','Cryoprecipitate','Platelet Concentrate' ))) OR intravenous_fluid IS NOT NULL ) AND (datetime_started BETWEEN :startDate AND :endDate ) AND (datetime_stopped IS NULL OR datetime_stopped > :endDate ) AND patient_case_record_id IN (SELECT DISTINCT nursingcare_patient_case_record.id FROM nursingcare_patient_case_record INNER JOIN nursingcare_patient_movement ON nursingcare_patient_case_record.latest_patient_movement_id = nursingcare_patient_movement.id INNER JOIN encounter ON encounter.encounter_id = nursingcare_patient_movement.encounter_id WHERE encounter.location_id IN ( :locationId ) AND (datetime_discharged IS NULL OR datetime_discharged > :endDate ) ) "),
		BLOOD_TRANSFUSION(
				 "SELECT COUNT(DISTINCT patient_case_record_id) FROM nursingcare_parenteral_order_infusion WHERE parenteral_order_infusion_type IN (SELECT DISTINCT id FROM nursingcare_parenteral_order_type WHERE intravenous_fluid IN ( 'TPN','pRBC','FWB','FFP','Cryoprecipitate','Platelet Concentrate' )) AND (datetime_started BETWEEN :startDate AND :endDate ) AND (datetime_stopped IS NULL OR datetime_stopped > :endDate ) AND patient_case_record_id IN (SELECT DISTINCT nursingcare_patient_case_record.id FROM nursingcare_patient_case_record INNER JOIN nursingcare_patient_movement ON nursingcare_patient_case_record.latest_patient_movement_id = nursingcare_patient_movement.id INNER JOIN encounter ON encounter.encounter_id = nursingcare_patient_movement.encounter_id WHERE encounter.location_id IN ( :locationId ) AND (datetime_discharged IS NULL OR datetime_discharged > :endDate ) ) "),
		FRESH_WHOLE_BLOOD(
				 "SELECT COUNT(DISTINCT patient_case_record_id) FROM nursingcare_parenteral_order_infusion WHERE parenteral_order_infusion_type IN (SELECT id FROM nursingcare_parenteral_order_type WHERE intravenous_fluid = 'FWB' ) AND (datetime_started BETWEEN :startDate AND :endDate ) AND (datetime_stopped IS NULL OR datetime_stopped > :endDate ) AND patient_case_record_id IN (SELECT DISTINCT nursingcare_patient_case_record.id FROM nursingcare_patient_case_record INNER JOIN nursingcare_patient_movement ON nursingcare_patient_case_record.latest_patient_movement_id = nursingcare_patient_movement.id INNER JOIN encounter ON encounter.encounter_id = nursingcare_patient_movement.encounter_id WHERE encounter.location_id IN ( :locationId ) AND (datetime_discharged IS NULL OR datetime_discharged > :endDate ) ) "),
		PACKED_RBC(
				 "SELECT COUNT(DISTINCT patient_case_record_id) FROM nursingcare_parenteral_order_infusion WHERE parenteral_order_infusion_type IN (SELECT id FROM nursingcare_parenteral_order_type WHERE intravenous_fluid = 'pRBC' ) AND (datetime_started BETWEEN :startDate AND :endDate ) AND (datetime_stopped IS NULL OR datetime_stopped > :endDate ) AND patient_case_record_id IN (SELECT DISTINCT nursingcare_patient_case_record.id FROM nursingcare_patient_case_record INNER JOIN nursingcare_patient_movement ON nursingcare_patient_case_record.latest_patient_movement_id = nursingcare_patient_movement.id INNER JOIN encounter ON encounter.encounter_id = nursingcare_patient_movement.encounter_id WHERE encounter.location_id IN ( :locationId ) AND (datetime_discharged IS NULL OR datetime_discharged > :endDate ) ) "),
		CHEMOTHERAPY(
				 "SELECT COUNT(DISTINCT patient_id) FROM nursingcare_orders WHERE order_type_id = 8 AND concept_id = (SELECT concept_id FROM concept WHERE uuid = '4365fa78-d014-4b49-bb6e-c998e9478f92' ) AND instruction != ' ' AND (date_created BETWEEN :startDate AND :endDate ) AND patient_id IN (SELECT DISTINCT nursingcare_patient_case_record.patient_id FROM nursingcare_patient_case_record INNER JOIN nursingcare_patient_movement ON nursingcare_patient_case_record.latest_patient_movement_id = nursingcare_patient_movement.id INNER JOIN encounter ON encounter.encounter_id = nursingcare_patient_movement.encounter_id WHERE encounter.location_id IN ( :locationId ) AND (datetime_discharged IS NULL OR datetime_discharged > :endDate ) ) "),
		OTHER_IVT(
				 "SELECT COUNT(DISTINCT patient_id) FROM nursingcare_orders WHERE order_type_id = 5 AND concept_id IN (SELECT concept_id FROM concept WHERE uuid IN ( '038eeffb-79d7-4bc0-86bc-0d96ad2dbc13','a136919b-4d4f-4480-8537-9ffea5b3be64','29dd6d7b-4d12-438f-b0e6-d4f67fa9f0c4','e5eb65ee-444b-4b3f-9371-06062d612575','5ea0a8ad-4669-450f-8afa-8a246d2ce4a0' )) AND instruction != ' ' AND (date_created BETWEEN :startDate AND :endDate ) AND patient_id IN (SELECT DISTINCT nursingcare_patient_case_record.patient_id FROM nursingcare_patient_case_record INNER JOIN nursingcare_patient_movement ON nursingcare_patient_case_record.latest_patient_movement_id = nursingcare_patient_movement.id INNER JOIN encounter ON encounter.encounter_id = nursingcare_patient_movement.encounter_id WHERE encounter.location_id IN ( :locationId ) AND (datetime_discharged IS NULL OR datetime_discharged > :endDate ) ) ")
		;
		
		private String value;
		
		public String getValue() {
			return value;
		}
		
		public void setValue(String value) {
			this.value = value;
		}
		
		private IVTReportEnum(String value) {
			this.value = value;
		}
		
	}
	

	public enum MedicationReportEnum {
		PER_OREM(
				 "SELECT COUNT(*) FROM nursingcare_ward_aggregate WHERE concept_id = (SELECT concept_id FROM concept WHERE uuid = '197cad2f-6f4f-4133-9e18-e538dee2a0ce' ) AND (date_created BETWEEN :startDate AND :endDate ) AND location_id IN ( :locationId ) "),
		TOPICAL(
				 "SELECT COUNT(*) FROM nursingcare_ward_aggregate WHERE concept_id = (SELECT concept_id FROM concept WHERE uuid = '5933151f-f4f0-47ba-bd1d-84169e44c6bc' ) AND (date_created BETWEEN :startDate AND :endDate ) AND location_id IN ( :locationId ) "),
		INTRAVENOUS(
				 "SELECT COUNT(*) FROM nursingcare_ward_aggregate WHERE concept_id = (SELECT concept_id FROM concept WHERE uuid = 'd4f1e277-0afe-4c5f-a485-fd4fcebd8c28' ) AND (date_created BETWEEN :startDate AND :endDate ) AND location_id IN ( :locationId ) "),
		INTRADERMAL(
				 "SELECT COUNT(*) FROM nursingcare_ward_aggregate WHERE concept_id = (SELECT concept_id FROM concept WHERE uuid = 'df6ac41e-a9b6-43be-9565-1c8c0058564f' ) AND (date_created BETWEEN :startDate AND :endDate ) AND location_id IN ( :locationId ) "),
		INTRAMUSCULAR(
				 "SELECT COUNT(*) FROM nursingcare_ward_aggregate WHERE concept_id = (SELECT concept_id FROM concept WHERE uuid = '9f3ea05d-c35a-47c5-9c4f-8322724b31c4' ) AND (date_created BETWEEN :startDate AND :endDate ) AND location_id IN ( :locationId ) "),
		SUBCUTANEOUS(
				 "SELECT COUNT(*) FROM nursingcare_ward_aggregate WHERE concept_id = (SELECT concept_id FROM concept WHERE uuid = '2bb6befd-3703-4e4e-b87e-b66a4077f822' ) AND (date_created BETWEEN :startDate AND :endDate ) AND location_id IN ( :locationId ) "),
		DROPS(
				 "SELECT COUNT(*) FROM nursingcare_ward_aggregate WHERE concept_id = (SELECT concept_id FROM concept WHERE uuid = '79adbc59-7111-4640-bfcd-9959c6551798' ) AND (date_created BETWEEN :startDate AND :endDate ) AND location_id IN ( :locationId ) "),
		SUPPOSITORIES(
				 "SELECT COUNT(*) FROM nursingcare_ward_aggregate WHERE concept_id = (SELECT concept_id FROM concept WHERE uuid = '0db473ee-ef5f-4a73-98f9-8f38bd8b80ba' ) AND (date_created BETWEEN :startDate AND :endDate ) AND location_id IN ( :locationId ) "),
		ENEMA_IRRIGATION(
				 "SELECT COUNT(*) FROM nursingcare_ward_aggregate WHERE concept_id = (SELECT concept_id FROM concept WHERE uuid = '2df7b954-8fcc-4e62-96e1-7c2726cd28cb' ) AND (date_created BETWEEN :startDate AND :endDate ) AND location_id IN ( :locationId ) "),
		OTHER_MEDICATION(
				 "SELECT COUNT(*) FROM nursingcare_ward_aggregate WHERE concept_id = (SELECT concept_id FROM concept WHERE uuid = 'bb61411e-5d98-4e15-ab14-caae5b42e3e4' ) AND (date_created BETWEEN :startDate AND :endDate ) AND location_id IN ( :locationId ) ")
		;
		
		private String value;
		
		public String getValue() {
			return value;
		}
		
		public void setValue(String value) {
			this.value = value;
		}
		
		private MedicationReportEnum(String value) {
			this.value = value;
		}
		
	}
	
	public enum TubeCareReportEnum {
		NGT_PEG(
				 "SELECT COUNT(DISTINCT patient_id) FROM nursingcare_orders WHERE order_type_id = 4 AND concept_id IN (SELECT concept_id FROM concept WHERE uuid IN ( '26993480-87d1-4bce-8705-36e1ae9cb127','8afa8466-f4be-4564-87d7-d40ab1f7b91b','0189693f-cf00-4de4-b5fc-d83094681fd6' )) AND (date_created BETWEEN :startDate AND :endDate ) AND (date_stopped IS NULL OR date_stopped > :endDate ) AND patient_id IN (SELECT DISTINCT nursingcare_patient_case_record.patient_id FROM nursingcare_patient_case_record INNER JOIN nursingcare_patient_movement ON nursingcare_patient_case_record.latest_patient_movement_id = nursingcare_patient_movement.id INNER JOIN encounter ON encounter.encounter_id = nursingcare_patient_movement.encounter_id WHERE encounter.location_id IN ( :locationId ) AND (datetime_discharged IS NULL OR datetime_discharged > :endDate ) ) "),
		NASAL_CANNULA(
				 "SELECT COUNT(DISTINCT patient_id) FROM nursingcare_orders WHERE order_type_id = 7 AND concept_id IN (SELECT concept_id FROM concept WHERE uuid IN ( 'bbd3ffaa-3e7a-48c4-b06b-fb3cb10f8254' )) AND instruction IN (SELECT concept_id FROM concept WHERE uuid IN ( 'd11ff6f8-44f1-4a3c-a4ca-0f724539ab1b' )) AND (date_created BETWEEN :startDate AND :endDate ) AND (date_stopped IS NULL OR date_stopped > :endDate ) AND patient_id IN (SELECT DISTINCT nursingcare_patient_case_record.patient_id FROM nursingcare_patient_case_record INNER JOIN nursingcare_patient_movement ON nursingcare_patient_case_record.latest_patient_movement_id = nursingcare_patient_movement.id INNER JOIN encounter ON encounter.encounter_id = nursingcare_patient_movement.encounter_id WHERE encounter.location_id IN ( :locationId ) AND (datetime_discharged IS NULL OR datetime_discharged > :endDate ) ) "),
		TRACHEOSTOMY(
				 "SELECT COUNT(DISTINCT patient_id) FROM nursingcare_orders WHERE order_type_id = 7 AND concept_id IN (SELECT concept_id FROM concept WHERE uuid IN ( 'bbd3ffaa-3e7a-48c4-b06b-fb3cb10f8254' )) AND instruction IN (SELECT concept_id FROM concept WHERE uuid IN ( '209e3b60-3b14-4090-a82f-eb546b2dca89' )) AND (date_created BETWEEN :startDate AND :endDate ) AND (date_stopped IS NULL OR date_stopped > :endDate ) AND patient_id IN (SELECT DISTINCT nursingcare_patient_case_record.patient_id FROM nursingcare_patient_case_record INNER JOIN nursingcare_patient_movement ON nursingcare_patient_case_record.latest_patient_movement_id = nursingcare_patient_movement.id INNER JOIN encounter ON encounter.encounter_id = nursingcare_patient_movement.encounter_id WHERE encounter.location_id IN ( :locationId ) AND (datetime_discharged IS NULL OR datetime_discharged > :endDate ) ) "),
		CHEST_TUBE(
				 "SELECT COUNT(DISTINCT patient_id) FROM nursingcare_orders WHERE order_type_id = 6 AND concept_id = (SELECT concept_id FROM concept WHERE uuid = '82f69d81-d25d-489b-aa24-76255bd8d2f5' ) AND instruction != ' ' AND (date_created BETWEEN :startDate AND :endDate ) AND (date_stopped IS NULL OR date_stopped > :endDate ) AND patient_id IN (SELECT DISTINCT nursingcare_patient_case_record.patient_id FROM nursingcare_patient_case_record INNER JOIN nursingcare_patient_movement ON nursingcare_patient_case_record.latest_patient_movement_id = nursingcare_patient_movement.id INNER JOIN encounter ON encounter.encounter_id = nursingcare_patient_movement.encounter_id WHERE encounter.location_id IN ( :locationId ) AND (datetime_discharged IS NULL OR datetime_discharged > :endDate ) ) "),
		FOLEY_CATHETER(
				 "SELECT COUNT(DISTINCT patient_id) FROM nursingcare_orders WHERE order_type_id = 6 AND concept_id = (SELECT concept_id FROM concept WHERE uuid = 'bde38694-0646-4539-b226-6946e04ad9cd' ) AND instruction != ' ' AND (date_created BETWEEN :startDate AND :endDate ) AND (date_stopped IS NULL OR date_stopped > :endDate ) AND patient_id IN (SELECT DISTINCT nursingcare_patient_case_record.patient_id FROM nursingcare_patient_case_record INNER JOIN nursingcare_patient_movement ON nursingcare_patient_case_record.latest_patient_movement_id = nursingcare_patient_movement.id INNER JOIN encounter ON encounter.encounter_id = nursingcare_patient_movement.encounter_id WHERE encounter.location_id IN ( :locationId ) AND (datetime_discharged IS NULL OR datetime_discharged > :endDate ) ) "),
		JACKSON_PRATT(
				 "SELECT COUNT(DISTINCT patient_id) FROM nursingcare_orders WHERE order_type_id = 6 AND concept_id = (SELECT concept_id FROM concept WHERE uuid = '7d8c7355-c930-4046-ad54-3ae80903f120' ) AND instruction != ' ' AND (date_created BETWEEN :startDate AND :endDate ) AND (date_stopped IS NULL OR date_stopped > :endDate ) AND patient_id IN (SELECT DISTINCT nursingcare_patient_case_record.patient_id FROM nursingcare_patient_case_record INNER JOIN nursingcare_patient_movement ON nursingcare_patient_case_record.latest_patient_movement_id = nursingcare_patient_movement.id INNER JOIN encounter ON encounter.encounter_id = nursingcare_patient_movement.encounter_id WHERE encounter.location_id IN ( :locationId ) AND (datetime_discharged IS NULL OR datetime_discharged > :endDate ) ) "),
		IJ_CATHETER(
				 "SELECT COUNT(DISTINCT patient_id) FROM nursingcare_orders WHERE order_type_id = 5 AND concept_id = (SELECT concept_id FROM concept WHERE uuid = 'a136919b-4d4f-4480-8537-9ffea5b3be64' ) AND instruction != ' ' AND (date_created BETWEEN :startDate AND :endDate ) AND (date_stopped IS NULL OR date_stopped > :endDate ) AND patient_id IN (SELECT DISTINCT nursingcare_patient_case_record.patient_id FROM nursingcare_patient_case_record INNER JOIN nursingcare_patient_movement ON nursingcare_patient_case_record.latest_patient_movement_id = nursingcare_patient_movement.id INNER JOIN encounter ON encounter.encounter_id = nursingcare_patient_movement.encounter_id WHERE encounter.location_id IN ( :locationId ) AND (datetime_discharged IS NULL OR datetime_discharged > :endDate ) ) "),
		FEMORAL_CATHETER(
				 "SELECT COUNT(DISTINCT patient_id) FROM nursingcare_orders WHERE order_type_id = 5 AND concept_id = (SELECT concept_id FROM concept WHERE uuid = 'e5eb65ee-444b-4b3f-9371-06062d612575' ) AND instruction != ' ' AND (date_created BETWEEN :startDate AND :endDate ) AND (date_stopped IS NULL OR date_stopped > :endDate ) AND patient_id IN (SELECT DISTINCT nursingcare_patient_case_record.patient_id FROM nursingcare_patient_case_record INNER JOIN nursingcare_patient_movement ON nursingcare_patient_case_record.latest_patient_movement_id = nursingcare_patient_movement.id INNER JOIN encounter ON encounter.encounter_id = nursingcare_patient_movement.encounter_id WHERE encounter.location_id IN ( :locationId ) AND (datetime_discharged IS NULL OR datetime_discharged > :endDate ) ) "),
		NEPHROSTOMY_TUBE(
				 "SELECT COUNT(DISTINCT patient_id) FROM nursingcare_orders WHERE order_type_id = 6 AND concept_id = (SELECT concept_id FROM concept WHERE uuid = '10cfb3a3-37d3-49ce-86c7-661c03984765' ) AND instruction != ' ' AND (date_created BETWEEN :startDate AND :endDate ) AND (date_stopped IS NULL OR date_stopped > :endDate ) AND patient_id IN (SELECT DISTINCT nursingcare_patient_case_record.patient_id FROM nursingcare_patient_case_record INNER JOIN nursingcare_patient_movement ON nursingcare_patient_case_record.latest_patient_movement_id = nursingcare_patient_movement.id INNER JOIN encounter ON encounter.encounter_id = nursingcare_patient_movement.encounter_id WHERE encounter.location_id IN ( :locationId ) AND (datetime_discharged IS NULL OR datetime_discharged > :endDate ) ) "),
		AV_FISTULA(
				 "SELECT COUNT(DISTINCT patient_id) FROM nursingcare_orders WHERE order_type_id = 5 AND concept_id = (SELECT concept_id FROM concept WHERE uuid = '646881c6-500f-41bc-b393-fcd1bc2e913e' ) AND instruction != ' ' AND (date_created BETWEEN :startDate AND :endDate ) AND (date_stopped IS NULL OR date_stopped > :endDate ) AND patient_id IN (SELECT DISTINCT nursingcare_patient_case_record.patient_id FROM nursingcare_patient_case_record INNER JOIN nursingcare_patient_movement ON nursingcare_patient_case_record.latest_patient_movement_id = nursingcare_patient_movement.id INNER JOIN encounter ON encounter.encounter_id = nursingcare_patient_movement.encounter_id WHERE encounter.location_id IN ( :locationId ) AND (datetime_discharged IS NULL OR datetime_discharged > :endDate ) ) "),
		SUBCLAVIAN_CATHETER(
				 "SELECT COUNT(DISTINCT patient_id) FROM nursingcare_orders WHERE order_type_id = 5 AND concept_id = (SELECT concept_id FROM concept WHERE uuid = '29dd6d7b-4d12-438f-b0e6-d4f67fa9f0c4' ) AND instruction != ' ' AND (date_created BETWEEN :startDate AND :endDate ) AND (date_stopped IS NULL OR date_stopped > :endDate ) AND patient_id IN (SELECT DISTINCT nursingcare_patient_case_record.patient_id FROM nursingcare_patient_case_record INNER JOIN nursingcare_patient_movement ON nursingcare_patient_case_record.latest_patient_movement_id = nursingcare_patient_movement.id INNER JOIN encounter ON encounter.encounter_id = nursingcare_patient_movement.encounter_id WHERE encounter.location_id IN ( :locationId ) AND (datetime_discharged IS NULL OR datetime_discharged > :endDate ) ) "),
		TENCKHOFF_CATHETER(
				 "SELECT COUNT(DISTINCT patient_id) FROM nursingcare_orders WHERE order_type_id = 6 AND concept_id = (SELECT concept_id FROM concept WHERE uuid = '1e553429-febd-4fce-a56b-a6bdf633c6e7' ) AND instruction != ' ' AND (date_created BETWEEN :startDate AND :endDate ) AND (date_stopped IS NULL OR date_stopped > :endDate ) AND patient_id IN (SELECT DISTINCT nursingcare_patient_case_record.patient_id FROM nursingcare_patient_case_record INNER JOIN nursingcare_patient_movement ON nursingcare_patient_case_record.latest_patient_movement_id = nursingcare_patient_movement.id INNER JOIN encounter ON encounter.encounter_id = nursingcare_patient_movement.encounter_id WHERE encounter.location_id IN ( :locationId ) AND (datetime_discharged IS NULL OR datetime_discharged > :endDate ) ) "),
		COLOSTOMY_ILEOSTOMY(
				 "SELECT COUNT(DISTINCT patient_id) FROM nursingcare_orders WHERE order_type_id = 6 AND concept_id IN (SELECT concept_id FROM concept WHERE uuid IN ( '97b4765e-2828-4c1a-8716-54688aefda67','932012d7-3732-4509-9494-d61b65d8f0da' )) AND instruction != ' ' AND (date_created BETWEEN :startDate AND :endDate ) AND (date_stopped IS NULL OR date_stopped > :endDate ) AND patient_id IN (SELECT DISTINCT nursingcare_patient_case_record.patient_id FROM nursingcare_patient_case_record INNER JOIN nursingcare_patient_movement ON nursingcare_patient_case_record.latest_patient_movement_id = nursingcare_patient_movement.id INNER JOIN encounter ON encounter.encounter_id = nursingcare_patient_movement.encounter_id WHERE encounter.location_id IN ( :locationId ) AND (datetime_discharged IS NULL OR datetime_discharged > :endDate ) ) "),
		JEJUNOSTOMY(
				 "SELECT COUNT(DISTINCT patient_id) FROM nursingcare_orders WHERE order_type_id = 4 AND concept_id = (SELECT concept_id FROM concept WHERE uuid = 'c355adce-64aa-483e-ae8d-adef75fd9152' ) AND (date_created BETWEEN :startDate AND :endDate ) AND (date_stopped IS NULL OR date_stopped > :endDate ) AND patient_id IN (SELECT DISTINCT nursingcare_patient_case_record.patient_id FROM nursingcare_patient_case_record INNER JOIN nursingcare_patient_movement ON nursingcare_patient_case_record.latest_patient_movement_id = nursingcare_patient_movement.id INNER JOIN encounter ON encounter.encounter_id = nursingcare_patient_movement.encounter_id WHERE encounter.location_id IN ( :locationId ) AND (datetime_discharged IS NULL OR datetime_discharged > :endDate ) ) "),
		OTHER_TUBE(
				 "SELECT COUNT(DISTINCT patient_id) FROM nursingcare_orders WHERE order_type_id = 7 AND concept_id IN (SELECT concept_id FROM concept WHERE uuid IN ( 'bbd3ffaa-3e7a-48c4-b06b-fb3cb10f8254' )) AND instruction IN (SELECT concept_id FROM concept WHERE uuid IN ( 'f8429743-7a88-4afb-9cfb-a2e0fc7ded44' )) AND (date_created BETWEEN :startDate AND :endDate ) AND (date_stopped IS NULL OR date_stopped > :endDate ) AND patient_id IN (SELECT DISTINCT nursingcare_patient_case_record.patient_id FROM nursingcare_patient_case_record INNER JOIN nursingcare_patient_movement ON nursingcare_patient_case_record.latest_patient_movement_id = nursingcare_patient_movement.id INNER JOIN encounter ON encounter.encounter_id = nursingcare_patient_movement.encounter_id WHERE encounter.location_id IN ( :locationId ) AND (datetime_discharged IS NULL OR datetime_discharged > :endDate ) ) ")
		;
		
		private String value;
		
		public String getValue() {
			return value;
		}
		
		public void setValue(String value) {
			this.value = value;
		}
		
		private TubeCareReportEnum(String value) {
			this.value = value;
		}
		
	}
	
	

	public enum WoundCareReportEnum {
		OPERATIVE_SITE(
				 "SELECT COUNT(DISTINCT patient_case_record_id) FROM nursingcare_operation WHERE (date_schedule BETWEEN :startDate AND :endDate ) AND patient_case_record_id IN (SELECT DISTINCT nursingcare_patient_case_record.id FROM nursingcare_patient_case_record INNER JOIN nursingcare_patient_movement ON nursingcare_patient_case_record.latest_patient_movement_id = nursingcare_patient_movement.id INNER JOIN encounter ON encounter.encounter_id = nursingcare_patient_movement.encounter_id WHERE encounter.location_id IN ( :locationId ) AND (datetime_discharged IS NULL OR datetime_discharged > :endDate ) ) "),
		PRESSURE_SORE(
				 "SELECT COUNT(DISTINCT patient_id) FROM nursingcare_orders WHERE order_type_id = 8 AND concept_id = (SELECT concept_id FROM concept WHERE uuid = 'a19af714-912b-4fd5-b83a-591bf893ddb6' ) AND instruction != ' ' AND (date_created BETWEEN :startDate AND :endDate ) AND (date_stopped IS NULL OR date_stopped > :endDate ) AND patient_id IN (SELECT DISTINCT nursingcare_patient_case_record.patient_id FROM nursingcare_patient_case_record INNER JOIN nursingcare_patient_movement ON nursingcare_patient_case_record.latest_patient_movement_id = nursingcare_patient_movement.id INNER JOIN encounter ON encounter.encounter_id = nursingcare_patient_movement.encounter_id WHERE encounter.location_id IN ( :locationId ) AND (datetime_discharged IS NULL OR datetime_discharged > :endDate ) ) "),
		BURN(
				 "SELECT COUNT(DISTINCT patient_id) FROM nursingcare_orders WHERE order_type_id = 8 AND concept_id = (SELECT concept_id FROM concept WHERE uuid = '116543AAAAAAAAAAAAAAAAAAAAAAAAAAAAAA' ) AND instruction != ' ' AND (date_created BETWEEN :startDate AND :endDate ) AND (date_stopped IS NULL OR date_stopped > :endDate ) AND patient_id IN (SELECT DISTINCT nursingcare_patient_case_record.patient_id FROM nursingcare_patient_case_record INNER JOIN nursingcare_patient_movement ON nursingcare_patient_case_record.latest_patient_movement_id = nursingcare_patient_movement.id INNER JOIN encounter ON encounter.encounter_id = nursingcare_patient_movement.encounter_id WHERE encounter.location_id IN ( :locationId ) AND (datetime_discharged IS NULL OR datetime_discharged > :endDate ) ) "),
		OTHER_WOUND(
				 "SELECT COUNT(DISTINCT patient_id) FROM nursingcare_orders WHERE order_type_id = 8 AND concept_id = (SELECT concept_id FROM concept WHERE uuid = '116543AAAAAAAAAAAAAAAAAAAAAAAAAAAAAA' ) AND instruction != ' ' AND (date_created BETWEEN :startDate AND :endDate ) AND (date_stopped IS NULL OR date_stopped > :endDate ) AND patient_id IN (SELECT DISTINCT nursingcare_patient_case_record.patient_id FROM nursingcare_patient_case_record INNER JOIN nursingcare_patient_movement ON nursingcare_patient_case_record.latest_patient_movement_id = nursingcare_patient_movement.id INNER JOIN encounter ON encounter.encounter_id = nursingcare_patient_movement.encounter_id WHERE encounter.location_id IN ( :locationId ) AND (datetime_discharged IS NULL OR datetime_discharged > :endDate ) ) ")
		;
		
		private String value;
		
		public String getValue() {
			return value;
		}
		
		public void setValue(String value) {
			this.value = value;
		}
		
		private WoundCareReportEnum(String value) {
			this.value = value;
		}
		
	}
	
	

	public enum DiagnosticProcedureReportEnum {
		XRAY(
				 "SELECT COUNT(DISTINCT patient_id) FROM nursingcare_patient_case_record INNER JOIN nursingcare_procedure ON nursingcare_procedure.patient_case_record_id = nursingcare_patient_case_record.id WHERE ((procedure_concept_id IN ( (SELECT concept_id FROM concept WHERE uuid IN ( 'd63ac018-511a-4449-9835-edc52547c053' )))) OR (procedure_name LIKE '%x%ray%' )) AND (date_schedule BETWEEN :startDate AND :endDate ) AND patient_case_record_id IN (SELECT DISTINCT nursingcare_patient_case_record.id FROM nursingcare_patient_case_record INNER JOIN nursingcare_patient_movement ON nursingcare_patient_case_record.latest_patient_movement_id = nursingcare_patient_movement.id INNER JOIN encounter ON encounter.encounter_id = nursingcare_patient_movement.encounter_id WHERE encounter.location_id IN ( :locationId ) AND (datetime_discharged IS NULL OR datetime_discharged > :endDate ) ) "),
		CT_SCAN(
				 "SELECT COUNT(DISTINCT patient_id) FROM nursingcare_patient_case_record INNER JOIN nursingcare_procedure ON nursingcare_procedure.patient_case_record_id = nursingcare_patient_case_record.id WHERE ((procedure_concept_id IN ( (SELECT concept_id FROM concept WHERE uuid IN ( 'c65dfd6b-6217-449b-a47e-39384bcdeecf','5778619a-baf4-4772-95d2-df0531bfd758','bcdb3bd8-714c-4501-bd3c-2b48864b6883' )))) OR (procedure_name LIKE '%ct%scan%' )) AND (date_schedule BETWEEN :startDate AND :endDate ) AND patient_case_record_id IN (SELECT DISTINCT nursingcare_patient_case_record.id FROM nursingcare_patient_case_record INNER JOIN nursingcare_patient_movement ON nursingcare_patient_case_record.latest_patient_movement_id = nursingcare_patient_movement.id INNER JOIN encounter ON encounter.encounter_id = nursingcare_patient_movement.encounter_id WHERE encounter.location_id IN ( :locationId ) AND (datetime_discharged IS NULL OR datetime_discharged > :endDate ) ) "),
		ULTRASOUND(
				 "SELECT COUNT(DISTINCT patient_id) FROM nursingcare_patient_case_record INNER JOIN nursingcare_procedure ON nursingcare_procedure.patient_case_record_id = nursingcare_patient_case_record.id WHERE ((procedure_concept_id IN ( (SELECT concept_id FROM concept WHERE uuid IN ( 'b3516bee-6851-4aa5-b3d3-856429f22902' )))) OR (procedure_name LIKE 'ultrasound' OR procedure_name LIKE '%utz%' )) AND (date_schedule BETWEEN :startDate AND :endDate ) AND patient_case_record_id IN (SELECT DISTINCT nursingcare_patient_case_record.id FROM nursingcare_patient_case_record INNER JOIN nursingcare_patient_movement ON nursingcare_patient_case_record.latest_patient_movement_id = nursingcare_patient_movement.id INNER JOIN encounter ON encounter.encounter_id = nursingcare_patient_movement.encounter_id WHERE encounter.location_id IN ( :locationId ) AND (datetime_discharged IS NULL OR datetime_discharged > :endDate ) ) "),
		MRI(
				 "SELECT COUNT(DISTINCT patient_id) FROM nursingcare_patient_case_record INNER JOIN nursingcare_procedure ON nursingcare_procedure.patient_case_record_id = nursingcare_patient_case_record.id WHERE ((procedure_concept_id IN ( (SELECT concept_id FROM concept WHERE uuid IN ( 'b3516bee-6851-4aa5-b3d3-856429f22902' )))) OR (procedure_name LIKE 'magnetic resonance imaging' OR procedure_name LIKE '%mri%' )) AND (date_schedule BETWEEN :startDate AND :endDate ) AND patient_case_record_id IN (SELECT DISTINCT nursingcare_patient_case_record.id FROM nursingcare_patient_case_record INNER JOIN nursingcare_patient_movement ON nursingcare_patient_case_record.latest_patient_movement_id = nursingcare_patient_movement.id INNER JOIN encounter ON encounter.encounter_id = nursingcare_patient_movement.encounter_id WHERE encounter.location_id IN ( :locationId ) AND (datetime_discharged IS NULL OR datetime_discharged > :endDate ) ) "),
		ECG(
				 "SELECT COUNT(DISTINCT patient_id) FROM nursingcare_patient_case_record INNER JOIN nursingcare_procedure ON nursingcare_procedure.patient_case_record_id = nursingcare_patient_case_record.id WHERE ((procedure_concept_id IN ( (SELECT concept_id FROM concept WHERE uuid IN ( 'c185b976-38b7-4f2f-862e-9eebffa2765a' )))) OR (procedure_name LIKE 'electrocardiogram' OR procedure_name LIKE 'electrokardiogram' OR procedure_name LIKE 'ekg' OR procedure_name LIKE '%ecg%' )) AND (date_schedule BETWEEN :startDate AND :endDate ) AND patient_case_record_id IN (SELECT DISTINCT nursingcare_patient_case_record.id FROM nursingcare_patient_case_record INNER JOIN nursingcare_patient_movement ON nursingcare_patient_case_record.latest_patient_movement_id = nursingcare_patient_movement.id INNER JOIN encounter ON encounter.encounter_id = nursingcare_patient_movement.encounter_id WHERE encounter.location_id IN ( :locationId ) AND (datetime_discharged IS NULL OR datetime_discharged > :endDate ) ) "),
		EEG(
				 "SELECT COUNT(DISTINCT patient_id) FROM nursingcare_patient_case_record INNER JOIN nursingcare_procedure ON nursingcare_procedure.patient_case_record_id = nursingcare_patient_case_record.id WHERE ((procedure_concept_id IN ( (SELECT concept_id FROM concept WHERE uuid IN ( '6412ea11-e1cc-4bf0-814d-43e921c69e59' )))) OR (procedure_name LIKE 'electroencephalogram' OR procedure_name LIKE '%eeg%' )) AND (date_schedule BETWEEN :startDate AND :endDate ) AND patient_case_record_id IN (SELECT DISTINCT nursingcare_patient_case_record.id FROM nursingcare_patient_case_record INNER JOIN nursingcare_patient_movement ON nursingcare_patient_case_record.latest_patient_movement_id = nursingcare_patient_movement.id INNER JOIN encounter ON encounter.encounter_id = nursingcare_patient_movement.encounter_id WHERE encounter.location_id IN ( :locationId ) AND (datetime_discharged IS NULL OR datetime_discharged > :endDate ) ) "),
		TWOD_ECHO(
				 "SELECT COUNT(DISTINCT patient_id) FROM nursingcare_patient_case_record INNER JOIN nursingcare_procedure ON nursingcare_procedure.patient_case_record_id = nursingcare_patient_case_record.id WHERE ((procedure_concept_id IN ( (SELECT concept_id FROM concept WHERE uuid IN ( '498f32fa-15ba-4b11-b101-17c19f7c6622' )))) OR (procedure_name LIKE 'two%D%echocardio%' OR procedure_name LIKE '%2%d%echo%' )) AND (date_schedule BETWEEN :startDate AND :endDate ) AND patient_case_record_id IN (SELECT DISTINCT nursingcare_patient_case_record.id FROM nursingcare_patient_case_record INNER JOIN nursingcare_patient_movement ON nursingcare_patient_case_record.latest_patient_movement_id = nursingcare_patient_movement.id INNER JOIN encounter ON encounter.encounter_id = nursingcare_patient_movement.encounter_id WHERE encounter.location_id IN ( :locationId ) AND (datetime_discharged IS NULL OR datetime_discharged > :endDate ) ) "),
		SPECIMEN_COLLECTION(
				 "SELECT COUNT(DISTINCT patient_id) FROM nursingcare_patient_case_record INNER JOIN nursingcare_procedure ON nursingcare_procedure.patient_case_record_id = nursingcare_patient_case_record.id WHERE type = 'laboratory' OR (procedure_name LIKE '%urin%' OR procedure_name LIKE '%blood%' OR procedure_name LIKE '%fecal%' OR procedure_name LIKE '%csf%' ) AND (date_schedule BETWEEN :startDate AND :endDate ) AND patient_case_record_id IN (SELECT DISTINCT nursingcare_patient_case_record.id FROM nursingcare_patient_case_record INNER JOIN nursingcare_patient_movement ON nursingcare_patient_case_record.latest_patient_movement_id = nursingcare_patient_movement.id INNER JOIN encounter ON encounter.encounter_id = nursingcare_patient_movement.encounter_id WHERE encounter.location_id IN ( :locationId ) AND (datetime_discharged IS NULL OR datetime_discharged > :endDate ) ) "),
		BLOOD(
				 "SELECT COUNT(DISTINCT patient_id) FROM nursingcare_patient_case_record INNER JOIN nursingcare_procedure ON nursingcare_procedure.patient_case_record_id = nursingcare_patient_case_record.id WHERE ((procedure_concept_id NOT IN ( (SELECT concept_id FROM concept WHERE uuid IN ( '3ac037a5-9b32-4d49-9a2a-b45b1f0d84fd','96d35cda-a2b7-49b5-93d5-4119bec02382','d810a263-a67b-4aef-8132-0503941a8c49' )))) OR (procedure_name NOT LIKE '%urin%' AND procedure_name NOT LIKE '%fecal%' AND procedure_name NOT LIKE '%csf%' )) AND (type NOT IN ('operation','procedure')) AND (date_schedule BETWEEN :startDate AND :endDate ) AND patient_case_record_id IN (SELECT DISTINCT nursingcare_patient_case_record.id FROM nursingcare_patient_case_record INNER JOIN nursingcare_patient_movement ON nursingcare_patient_case_record.latest_patient_movement_id = nursingcare_patient_movement.id INNER JOIN encounter ON encounter.encounter_id = nursingcare_patient_movement.encounter_id WHERE encounter.location_id IN ( :locationId ) AND (datetime_discharged IS NULL OR datetime_discharged > :endDate ) ) "),
		URINE(
				 "SELECT COUNT(DISTINCT patient_id) FROM nursingcare_patient_case_record INNER JOIN nursingcare_procedure ON nursingcare_procedure.patient_case_record_id = nursingcare_patient_case_record.id WHERE ((procedure_concept_id IN ( (SELECT concept_id FROM concept WHERE uuid IN ( '3ac037a5-9b32-4d49-9a2a-b45b1f0d84fd' )))) OR (procedure_name NOT LIKE '%blood%' AND procedure_name NOT LIKE '%fecal%' AND procedure_name LIKE '%urin%' )) AND (type NOT IN ('operation','procedure')) AND (date_schedule BETWEEN :startDate AND :endDate ) AND patient_case_record_id IN (SELECT DISTINCT nursingcare_patient_case_record.id FROM nursingcare_patient_case_record INNER JOIN nursingcare_patient_movement ON nursingcare_patient_case_record.latest_patient_movement_id = nursingcare_patient_movement.id INNER JOIN encounter ON encounter.encounter_id = nursingcare_patient_movement.encounter_id WHERE encounter.location_id IN ( :locationId ) AND (datetime_discharged IS NULL OR datetime_discharged > :endDate ) ) "),
		SPUTUM(
				 "SELECT COUNT(DISTINCT patient_id) FROM nursingcare_patient_case_record INNER JOIN nursingcare_procedure ON nursingcare_procedure.patient_case_record_id = nursingcare_patient_case_record.id WHERE (procedure_name NOT LIKE '%blood%' AND procedure_name NOT LIKE '%fecal%' AND procedure_name NOT LIKE '%urin%' AND procedure_name LIKE '%sputum%' ) AND (type NOT IN ('operation','procedure')) AND (date_schedule BETWEEN :startDate AND :endDate ) AND patient_case_record_id IN (SELECT DISTINCT nursingcare_patient_case_record.id FROM nursingcare_patient_case_record INNER JOIN nursingcare_patient_movement ON nursingcare_patient_case_record.latest_patient_movement_id = nursingcare_patient_movement.id INNER JOIN encounter ON encounter.encounter_id = nursingcare_patient_movement.encounter_id WHERE encounter.location_id IN ( :locationId ) AND (datetime_discharged IS NULL OR datetime_discharged > :endDate ) ) "),
		CSF(
				 "SELECT COUNT(DISTINCT patient_id) FROM nursingcare_patient_case_record INNER JOIN nursingcare_procedure ON nursingcare_procedure.patient_case_record_id = nursingcare_patient_case_record.id WHERE (procedure_name NOT LIKE '%blood%' AND procedure_name NOT LIKE '%fecal%' AND procedure_name NOT LIKE '%urin%' AND procedure_name NOT LIKE '%sputum%' AND (procedure_name LIKE '%cerebrospinal%fluid%' OR procedure_name LIKE '%csf%' )) AND (type NOT IN ('operation','procedure')) AND (date_schedule BETWEEN :startDate AND :endDate ) AND patient_case_record_id IN (SELECT DISTINCT nursingcare_patient_case_record.id FROM nursingcare_patient_case_record INNER JOIN nursingcare_patient_movement ON nursingcare_patient_case_record.latest_patient_movement_id = nursingcare_patient_movement.id INNER JOIN encounter ON encounter.encounter_id = nursingcare_patient_movement.encounter_id WHERE encounter.location_id IN ( :locationId ) AND (datetime_discharged IS NULL OR datetime_discharged > :endDate ) ) "),
		OTHER_DIAGNOSTIC(
				 "SELECT COUNT(DISTINCT patient_id) FROM nursingcare_orders WHERE order_type_id = 8 AND concept_id = (SELECT concept_id FROM concept WHERE uuid = '116543AAAAAAAAAAAAAAAAAAAAAAAAAAAAAA' ) AND instruction != ' ' AND (date_created BETWEEN :startDate AND :endDate ) AND (date_stopped IS NULL OR date_stopped > :endDate ) AND patient_id IN (SELECT DISTINCT nursingcare_patient_case_record.patient_id FROM nursingcare_patient_case_record INNER JOIN nursingcare_patient_movement ON nursingcare_patient_case_record.latest_patient_movement_id = nursingcare_patient_movement.id INNER JOIN encounter ON encounter.encounter_id = nursingcare_patient_movement.encounter_id WHERE encounter.location_id IN ( :locationId ) AND (datetime_discharged IS NULL OR datetime_discharged > :endDate ) ) ")
		;
		
		private String value;
		
		public String getValue() {
			return value;
		}
		
		public void setValue(String value) {
			this.value = value;
		}
		
		private DiagnosticProcedureReportEnum(String value) {
			this.value = value;
		}
		
	}
	

	public enum InvasiveProcedureReportEnum {
		PERITONEAL_DIALYSIS(
				 "SELECT COUNT(DISTINCT patient_id) FROM nursingcare_orders WHERE order_type_id = 6 AND concept_id = (SELECT concept_id FROM concept WHERE uuid = '1e553429-febd-4fce-a56b-a6bdf633c6e7' ) AND instruction != ' ' AND (date_created BETWEEN :startDate AND :endDate ) AND (date_stopped IS NULL OR date_stopped > :endDate ) AND patient_id IN (SELECT DISTINCT nursingcare_patient_case_record.patient_id FROM nursingcare_patient_case_record INNER JOIN nursingcare_patient_movement ON nursingcare_patient_case_record.latest_patient_movement_id = nursingcare_patient_movement.id INNER JOIN encounter ON encounter.encounter_id = nursingcare_patient_movement.encounter_id WHERE encounter.location_id IN ( :locationId ) AND (datetime_discharged IS NULL OR datetime_discharged > :endDate ) ) "),
		HEMODIALYSIS(
				 "SELECT COUNT(DISTINCT patient_id) FROM nursingcare_patient_case_record INNER JOIN nursingcare_procedure ON nursingcare_procedure.patient_case_record_id = nursingcare_patient_case_record.id WHERE procedure_concept_id = (SELECT concept_id FROM concept WHERE uuid = '40b5f439-1a62-4d80-9fd1-0259a68d11b0' ) AND (date_schedule BETWEEN :startDate AND :endDate ) AND patient_case_record_id IN (SELECT DISTINCT nursingcare_patient_case_record.id FROM nursingcare_patient_case_record INNER JOIN nursingcare_patient_movement ON nursingcare_patient_case_record.latest_patient_movement_id = nursingcare_patient_movement.id INNER JOIN encounter ON encounter.encounter_id = nursingcare_patient_movement.encounter_id WHERE encounter.location_id IN ( :locationId ) AND (datetime_discharged IS NULL OR datetime_discharged > :endDate ) ) "),
		BRONCHOSCOPY(
				 "SELECT COUNT(DISTINCT patient_id) FROM nursingcare_patient_case_record INNER JOIN nursingcare_procedure ON nursingcare_procedure.patient_case_record_id = nursingcare_patient_case_record.id WHERE procedure_concept_id = (SELECT concept_id FROM concept WHERE uuid = '45523f38-54f7-4c6e-a661-aa5e910422d7' ) AND (date_schedule BETWEEN :startDate AND :endDate ) AND patient_case_record_id IN (SELECT DISTINCT nursingcare_patient_case_record.id FROM nursingcare_patient_case_record INNER JOIN nursingcare_patient_movement ON nursingcare_patient_case_record.latest_patient_movement_id = nursingcare_patient_movement.id INNER JOIN encounter ON encounter.encounter_id = nursingcare_patient_movement.encounter_id WHERE encounter.location_id IN ( :locationId ) AND (datetime_discharged IS NULL OR datetime_discharged > :endDate ) ) "),
		THORACENTESIS(
				 "SELECT COUNT(DISTINCT patient_id) FROM nursingcare_patient_case_record INNER JOIN nursingcare_procedure ON nursingcare_procedure.patient_case_record_id = nursingcare_patient_case_record.id WHERE procedure_concept_id = (SELECT concept_id FROM concept WHERE uuid = 'ed3040c5-a00c-4a7a-b2cb-8e12c0a787f7' ) AND (date_schedule BETWEEN :startDate AND :endDate ) AND patient_case_record_id IN (SELECT DISTINCT nursingcare_patient_case_record.id FROM nursingcare_patient_case_record INNER JOIN nursingcare_patient_movement ON nursingcare_patient_case_record.latest_patient_movement_id = nursingcare_patient_movement.id INNER JOIN encounter ON encounter.encounter_id = nursingcare_patient_movement.encounter_id WHERE encounter.location_id IN ( :locationId ) AND (datetime_discharged IS NULL OR datetime_discharged > :endDate ) ) "),
		ENDOSCOPY(
				 "SELECT COUNT(DISTINCT patient_id) FROM nursingcare_patient_case_record INNER JOIN nursingcare_procedure ON nursingcare_procedure.patient_case_record_id = nursingcare_patient_case_record.id WHERE procedure_concept_id = (SELECT concept_id FROM concept WHERE uuid = 'a6b56126-4276-44a1-8f79-e0475e0e013e' ) AND (date_schedule BETWEEN :startDate AND :endDate ) AND patient_case_record_id IN (SELECT DISTINCT nursingcare_patient_case_record.id FROM nursingcare_patient_case_record INNER JOIN nursingcare_patient_movement ON nursingcare_patient_case_record.latest_patient_movement_id = nursingcare_patient_movement.id INNER JOIN encounter ON encounter.encounter_id = nursingcare_patient_movement.encounter_id WHERE encounter.location_id IN ( :locationId ) AND (datetime_discharged IS NULL OR datetime_discharged > :endDate ) ) "),
		PARACENTESIS(
				 "SELECT COUNT(DISTINCT patient_id) FROM nursingcare_patient_case_record INNER JOIN nursingcare_procedure ON nursingcare_procedure.patient_case_record_id = nursingcare_patient_case_record.id WHERE procedure_concept_id = (SELECT concept_id FROM concept WHERE uuid = '1c9e2873-d876-4cef-8cc9-76e426b43f21' ) AND (date_schedule BETWEEN :startDate AND :endDate ) AND patient_case_record_id IN (SELECT DISTINCT nursingcare_patient_case_record.id FROM nursingcare_patient_case_record INNER JOIN nursingcare_patient_movement ON nursingcare_patient_case_record.latest_patient_movement_id = nursingcare_patient_movement.id INNER JOIN encounter ON encounter.encounter_id = nursingcare_patient_movement.encounter_id WHERE encounter.location_id IN ( :locationId ) AND (datetime_discharged IS NULL OR datetime_discharged > :endDate ) ) "),
		CORONARY_ANGIOGRAPHY(
				 "SELECT COUNT(DISTINCT patient_id) FROM nursingcare_patient_case_record INNER JOIN nursingcare_procedure ON nursingcare_procedure.patient_case_record_id = nursingcare_patient_case_record.id WHERE procedure_concept_id = (SELECT concept_id FROM concept WHERE uuid = '01c240cb-bdbd-47c8-a745-f1ec805375aa' ) AND (date_schedule BETWEEN :startDate AND :endDate ) AND patient_case_record_id IN (SELECT DISTINCT nursingcare_patient_case_record.id FROM nursingcare_patient_case_record INNER JOIN nursingcare_patient_movement ON nursingcare_patient_case_record.latest_patient_movement_id = nursingcare_patient_movement.id INNER JOIN encounter ON encounter.encounter_id = nursingcare_patient_movement.encounter_id WHERE encounter.location_id IN ( :locationId ) AND (datetime_discharged IS NULL OR datetime_discharged > :endDate ) ) "),
		BONE_MARROW_ASPIRATION(
				 "SELECT COUNT(DISTINCT patient_id) FROM nursingcare_patient_case_record INNER JOIN nursingcare_procedure ON nursingcare_procedure.patient_case_record_id = nursingcare_patient_case_record.id WHERE procedure_concept_id = (SELECT concept_id FROM concept WHERE uuid = '61f99094-3e83-4289-8858-ad901389cb5f' ) AND (date_schedule BETWEEN :startDate AND :endDate ) AND patient_case_record_id IN (SELECT DISTINCT nursingcare_patient_case_record.id FROM nursingcare_patient_case_record INNER JOIN nursingcare_patient_movement ON nursingcare_patient_case_record.latest_patient_movement_id = nursingcare_patient_movement.id INNER JOIN encounter ON encounter.encounter_id = nursingcare_patient_movement.encounter_id WHERE encounter.location_id IN ( :locationId ) AND (datetime_discharged IS NULL OR datetime_discharged > :endDate ) ) "),
		BIOPSY(
				 "SELECT COUNT(DISTINCT patient_id) FROM nursingcare_patient_case_record INNER JOIN nursingcare_procedure ON nursingcare_procedure.patient_case_record_id = nursingcare_patient_case_record.id WHERE ((procedure_concept_id IN ( (SELECT concept_id FROM concept WHERE uuid IN ( '6d9d7605-b184-454c-aa23-ed2c1fcaa164' )))) OR (procedure_name LIKE '%biopsy%' )) AND (date_schedule BETWEEN :startDate AND :endDate ) AND patient_case_record_id IN (SELECT DISTINCT nursingcare_patient_case_record.id FROM nursingcare_patient_case_record INNER JOIN nursingcare_patient_movement ON nursingcare_patient_case_record.latest_patient_movement_id = nursingcare_patient_movement.id INNER JOIN encounter ON encounter.encounter_id = nursingcare_patient_movement.encounter_id WHERE encounter.location_id IN ( :locationId ) AND (datetime_discharged IS NULL OR datetime_discharged > :endDate ) ) "),
		PERIOPERATIVE_CARE(
				 "SELECT COUNT(DISTINCT patient_case_record_id) FROM nursingcare_operation WHERE (date_schedule BETWEEN :startDate AND :endDate ) AND patient_case_record_id IN (SELECT DISTINCT nursingcare_patient_case_record.id FROM nursingcare_patient_case_record INNER JOIN nursingcare_patient_movement ON nursingcare_patient_case_record.latest_patient_movement_id = nursingcare_patient_movement.id INNER JOIN encounter ON encounter.encounter_id = nursingcare_patient_movement.encounter_id WHERE encounter.location_id IN ( :locationId ) AND (datetime_discharged IS NULL OR datetime_discharged > :endDate ) ) "),
		LUMBAR_TAP(
				 "SELECT COUNT(DISTINCT patient_id) FROM nursingcare_patient_case_record INNER JOIN nursingcare_procedure ON nursingcare_procedure.patient_case_record_id = nursingcare_patient_case_record.id WHERE ((procedure_concept_id IN ( (SELECT concept_id FROM concept WHERE uuid IN ( '59c2f772-7a9a-4e98-b25a-5a8be05a230a' )))) OR (procedure_name LIKE 'lumbar tap' OR procedure_name LIKE 'lt' OR procedure_name LIKE 'lp' OR procedure_name LIKE '%lumbar%puncture%' )) AND (date_schedule BETWEEN :startDate AND :endDate ) AND patient_case_record_id IN (SELECT DISTINCT nursingcare_patient_case_record.id FROM nursingcare_patient_case_record INNER JOIN nursingcare_patient_movement ON nursingcare_patient_case_record.latest_patient_movement_id = nursingcare_patient_movement.id INNER JOIN encounter ON encounter.encounter_id = nursingcare_patient_movement.encounter_id WHERE encounter.location_id IN ( :locationId ) AND (datetime_discharged IS NULL OR datetime_discharged > :endDate ) ) "),
		ELECTROCONVULSIVE_THERAPY(
				 "SELECT COUNT(DISTINCT patient_id) FROM nursingcare_patient_case_record INNER JOIN nursingcare_procedure ON nursingcare_procedure.patient_case_record_id = nursingcare_patient_case_record.id WHERE procedure_concept_id = (SELECT concept_id FROM concept WHERE uuid = 'f0930bb1-1b82-441a-b8b7-72be6405054d' ) AND (date_schedule BETWEEN :startDate AND :endDate ) AND patient_case_record_id IN (SELECT DISTINCT nursingcare_patient_case_record.id FROM nursingcare_patient_case_record INNER JOIN nursingcare_patient_movement ON nursingcare_patient_case_record.latest_patient_movement_id = nursingcare_patient_movement.id INNER JOIN encounter ON encounter.encounter_id = nursingcare_patient_movement.encounter_id WHERE encounter.location_id IN ( :locationId ) AND (datetime_discharged IS NULL OR datetime_discharged > :endDate ) ) "),
		OTHER_INVASIVE(
				 "SELECT COUNT(DISTINCT patient_id) FROM nursingcare_orders WHERE order_type_id = 8 AND concept_id = (SELECT concept_id FROM concept WHERE uuid = '116543AAAAAAAAAAAAAAAAAAAAAAAAAAAAAA' ) AND instruction != ' ' AND (date_created BETWEEN :startDate AND :endDate ) AND (date_stopped IS NULL OR date_stopped > :endDate ) AND patient_id IN (SELECT DISTINCT nursingcare_patient_case_record.patient_id FROM nursingcare_patient_case_record INNER JOIN nursingcare_patient_movement ON nursingcare_patient_case_record.latest_patient_movement_id = nursingcare_patient_movement.id INNER JOIN encounter ON encounter.encounter_id = nursingcare_patient_movement.encounter_id WHERE encounter.location_id IN ( :locationId ) AND (datetime_discharged IS NULL OR datetime_discharged > :endDate ) ) ")
		;
		
		private String value;
		
		public String getValue() {
			return value;
		}
		
		public void setValue(String value) {
			this.value = value;
		}
		
		private InvasiveProcedureReportEnum(String value) {
			this.value = value;
		}
		
	}
	

	public enum SpiritualPsychosocialReportEnum {
		REFERRAL_TO_RELIGIOUS_MINISTER(
				 "SELECT COUNT(DISTINCT patient_id) FROM nursingcare_orders WHERE order_type_id = 8 AND concept_id = (SELECT concept_id FROM concept WHERE uuid = 'c2f5772a-78e1-473e-9309-b04ee3288c21' ) AND instruction != ' ' AND (date_created BETWEEN :startDate AND :endDate ) AND (date_stopped IS NULL OR date_stopped > :endDate ) AND patient_id IN (SELECT DISTINCT nursingcare_patient_case_record.patient_id FROM nursingcare_patient_case_record INNER JOIN nursingcare_patient_movement ON nursingcare_patient_case_record.latest_patient_movement_id = nursingcare_patient_movement.id INNER JOIN encounter ON encounter.encounter_id = nursingcare_patient_movement.encounter_id WHERE encounter.location_id IN ( :locationId ) AND (datetime_discharged IS NULL OR datetime_discharged > :endDate ) ) "),
		OTHER_SPIRITUAL_CARE(
				 "SELECT COUNT(DISTINCT patient_id) FROM nursingcare_orders WHERE order_type_id = 8 AND concept_id = (SELECT concept_id FROM concept WHERE uuid = '712981a0-46ec-45db-853d-91a106e88d48' ) AND instruction != ' ' AND (date_created BETWEEN :startDate AND :endDate ) AND (date_stopped IS NULL OR date_stopped > :endDate ) AND patient_id IN (SELECT DISTINCT nursingcare_patient_case_record.patient_id FROM nursingcare_patient_case_record INNER JOIN nursingcare_patient_movement ON nursingcare_patient_case_record.latest_patient_movement_id = nursingcare_patient_movement.id INNER JOIN encounter ON encounter.encounter_id = nursingcare_patient_movement.encounter_id WHERE encounter.location_id IN ( :locationId ) AND (datetime_discharged IS NULL OR datetime_discharged > :endDate ) ) "),
		COUNSELING_GRIEVING_MEASURES(
				 "SELECT COUNT(DISTINCT patient_id) FROM nursingcare_orders WHERE order_type_id = 8 AND concept_id = (SELECT concept_id FROM concept WHERE uuid = '9264630a-22cd-405b-be3e-d92bd23a227c' ) AND instruction != ' ' AND (date_created BETWEEN :startDate AND :endDate ) AND (date_stopped IS NULL OR date_stopped > :endDate ) AND patient_id IN (SELECT DISTINCT nursingcare_patient_case_record.patient_id FROM nursingcare_patient_case_record INNER JOIN nursingcare_patient_movement ON nursingcare_patient_case_record.latest_patient_movement_id = nursingcare_patient_movement.id INNER JOIN encounter ON encounter.encounter_id = nursingcare_patient_movement.encounter_id WHERE encounter.location_id IN ( :locationId ) AND (datetime_discharged IS NULL OR datetime_discharged > :endDate ) ) "),
		ANXIETY_REDUCTION_TECHNIQUES(
				 "SELECT COUNT(DISTINCT patient_id) FROM nursingcare_orders WHERE order_type_id = 8 AND concept_id = (SELECT concept_id FROM concept WHERE uuid = '2872991d-f9bd-4c5b-ac2a-74ffeb45ec99' ) AND instruction != ' ' AND (date_created BETWEEN :startDate AND :endDate ) AND (date_stopped IS NULL OR date_stopped > :endDate ) AND patient_id IN (SELECT DISTINCT nursingcare_patient_case_record.patient_id FROM nursingcare_patient_case_record INNER JOIN nursingcare_patient_movement ON nursingcare_patient_case_record.latest_patient_movement_id = nursingcare_patient_movement.id INNER JOIN encounter ON encounter.encounter_id = nursingcare_patient_movement.encounter_id WHERE encounter.location_id IN ( :locationId ) AND (datetime_discharged IS NULL OR datetime_discharged > :endDate ) ) "),
		RELAXATION_MEASURES(
				 "SELECT COUNT(DISTINCT patient_id) FROM nursingcare_orders WHERE order_type_id = 8 AND concept_id = (SELECT concept_id FROM concept WHERE uuid = 'cbddb016-ecdb-4f64-a9ab-756396edae4e' ) AND instruction != ' ' AND (date_created BETWEEN :startDate AND :endDate ) AND (date_stopped IS NULL OR date_stopped > :endDate ) AND patient_id IN (SELECT DISTINCT nursingcare_patient_case_record.patient_id FROM nursingcare_patient_case_record INNER JOIN nursingcare_patient_movement ON nursingcare_patient_case_record.latest_patient_movement_id = nursingcare_patient_movement.id INNER JOIN encounter ON encounter.encounter_id = nursingcare_patient_movement.encounter_id WHERE encounter.location_id IN ( :locationId ) AND (datetime_discharged IS NULL OR datetime_discharged > :endDate ) ) "),
		PROVISION_OF_STRUCTURED_ACTIVITIES(
				 "SELECT COUNT(DISTINCT patient_id) FROM nursingcare_orders WHERE order_type_id = 8 AND concept_id = (SELECT concept_id FROM concept WHERE uuid = 'cbddb016-ecdb-4f64-a9ab-756396edae4e' ) AND instruction != ' ' AND (date_created BETWEEN :startDate AND :endDate ) AND (date_stopped IS NULL OR date_stopped > :endDate ) AND patient_id IN (SELECT DISTINCT nursingcare_patient_case_record.patient_id FROM nursingcare_patient_case_record INNER JOIN nursingcare_patient_movement ON nursingcare_patient_case_record.latest_patient_movement_id = nursingcare_patient_movement.id INNER JOIN encounter ON encounter.encounter_id = nursingcare_patient_movement.encounter_id WHERE encounter.location_id IN ( :locationId ) AND (datetime_discharged IS NULL OR datetime_discharged > :endDate ) ) "),
		HOMICIDAL_SUICIDAL_AND_ESCAPE_PRECAUTIONS(
				 "SELECT COUNT(DISTINCT patient_id) FROM nursingcare_orders WHERE order_type_id = 8 AND concept_id = (SELECT concept_id FROM concept WHERE uuid = '05122f6c-d697-4436-9df5-cd29d14d50db' ) AND instruction != ' ' AND (date_created BETWEEN :startDate AND :endDate ) AND (date_stopped IS NULL OR date_stopped > :endDate ) AND patient_id IN (SELECT DISTINCT nursingcare_patient_case_record.patient_id FROM nursingcare_patient_case_record INNER JOIN nursingcare_patient_movement ON nursingcare_patient_case_record.latest_patient_movement_id = nursingcare_patient_movement.id INNER JOIN encounter ON encounter.encounter_id = nursingcare_patient_movement.encounter_id WHERE encounter.location_id IN ( :locationId ) AND (datetime_discharged IS NULL OR datetime_discharged > :endDate ) ) "),
		HEALTH_TEACHING(
				 "SELECT COUNT(DISTINCT patient_id) FROM nursingcare_orders WHERE order_type_id = 8 AND concept_id = (SELECT concept_id FROM concept WHERE uuid = 'ab3c762a-8410-4097-b435-78341211cd11' ) AND instruction != ' ' AND (date_created BETWEEN :startDate AND :endDate ) AND (date_stopped IS NULL OR date_stopped > :endDate ) AND patient_id IN (SELECT DISTINCT nursingcare_patient_case_record.patient_id FROM nursingcare_patient_case_record INNER JOIN nursingcare_patient_movement ON nursingcare_patient_case_record.latest_patient_movement_id = nursingcare_patient_movement.id INNER JOIN encounter ON encounter.encounter_id = nursingcare_patient_movement.encounter_id WHERE encounter.location_id IN ( :locationId ) AND (datetime_discharged IS NULL OR datetime_discharged > :endDate ) ) "),
		OTHER_PSYCHOSOCIAL(
				 "SELECT COUNT(DISTINCT patient_id) FROM nursingcare_orders WHERE order_type_id = 8 AND concept_id = (SELECT concept_id FROM concept WHERE uuid = 'f1e1df14-17fe-4b8e-a54f-24ee79f908f6' ) AND instruction != ' ' AND (date_created BETWEEN :startDate AND :endDate ) AND (date_stopped IS NULL OR date_stopped > :endDate ) AND patient_id IN (SELECT DISTINCT nursingcare_patient_case_record.patient_id FROM nursingcare_patient_case_record INNER JOIN nursingcare_patient_movement ON nursingcare_patient_case_record.latest_patient_movement_id = nursingcare_patient_movement.id INNER JOIN encounter ON encounter.encounter_id = nursingcare_patient_movement.encounter_id WHERE encounter.location_id IN ( :locationId ) AND (datetime_discharged IS NULL OR datetime_discharged > :endDate ) ) ")
		;
		
		private String value;
		
		public String getValue() {
			return value;
		}
		
		public void setValue(String value) {
			this.value = value;
		}
		
		private SpiritualPsychosocialReportEnum(String value) {
			this.value = value;
		}
		
	}
	


	public enum CodeLevelsOfCareReportEnum {
		CODE(
				 "SELECT COUNT(DISTINCT patient_id) FROM nursingcare_orders WHERE order_type_id = 8 AND concept_id = (SELECT concept_id FROM concept WHERE uuid = '29bf47da-e2b1-427c-b0b2-884b29b25f3d' ) AND instruction != ' ' AND (date_created BETWEEN :startDate AND :endDate ) AND (date_stopped IS NULL OR date_stopped > :endDate ) AND patient_id IN (SELECT DISTINCT nursingcare_patient_case_record.patient_id FROM nursingcare_patient_case_record INNER JOIN nursingcare_patient_movement ON nursingcare_patient_case_record.latest_patient_movement_id = nursingcare_patient_movement.id INNER JOIN encounter ON encounter.encounter_id = nursingcare_patient_movement.encounter_id WHERE encounter.location_id IN ( :locationId ) AND (datetime_discharged IS NULL OR datetime_discharged > :endDate ) ) "),
		POST_MORTEM_CARE(
				 "SELECT COUNT(DISTINCT patient_id) FROM nursingcare_orders WHERE order_type_id = 8 AND concept_id = (SELECT concept_id FROM concept WHERE uuid = 'aa73c9fc-095b-4153-afe5-8abb3d617d91' ) AND instruction != ' ' AND (date_created BETWEEN :startDate AND :endDate ) AND (date_stopped IS NULL OR date_stopped > :endDate ) AND patient_id IN (SELECT DISTINCT nursingcare_patient_case_record.patient_id FROM nursingcare_patient_case_record INNER JOIN nursingcare_patient_movement ON nursingcare_patient_case_record.latest_patient_movement_id = nursingcare_patient_movement.id INNER JOIN encounter ON encounter.encounter_id = nursingcare_patient_movement.encounter_id WHERE encounter.location_id IN ( :locationId ) AND (datetime_discharged IS NULL OR datetime_discharged > :endDate ) ) "),
		TERMINAL_CLEANING(
				 "SELECT COUNT(DISTINCT patient_id) FROM nursingcare_orders WHERE order_type_id = 8 AND concept_id = (SELECT concept_id FROM concept WHERE uuid = '7a8064c9-c7da-4a19-8ef4-62b19e988fc1' ) AND instruction != ' ' AND (date_created BETWEEN :startDate AND :endDate ) AND (date_stopped IS NULL OR date_stopped > :endDate ) AND patient_id IN (SELECT DISTINCT nursingcare_patient_case_record.patient_id FROM nursingcare_patient_case_record INNER JOIN nursingcare_patient_movement ON nursingcare_patient_case_record.latest_patient_movement_id = nursingcare_patient_movement.id INNER JOIN encounter ON encounter.encounter_id = nursingcare_patient_movement.encounter_id WHERE encounter.location_id IN ( :locationId ) AND (datetime_discharged IS NULL OR datetime_discharged > :endDate ) ) "),
		FIVE_S(
				 "SELECT COUNT(DISTINCT patient_id) FROM nursingcare_orders WHERE order_type_id = 8 AND concept_id = (SELECT concept_id FROM concept WHERE uuid = '85dd8c95-a447-4c8e-a13b-6dd58875d264' ) AND instruction != ' ' AND (date_created BETWEEN :startDate AND :endDate ) AND (date_stopped IS NULL OR date_stopped > :endDate ) AND patient_id IN (SELECT DISTINCT nursingcare_patient_case_record.patient_id FROM nursingcare_patient_case_record INNER JOIN nursingcare_patient_movement ON nursingcare_patient_case_record.latest_patient_movement_id = nursingcare_patient_movement.id INNER JOIN encounter ON encounter.encounter_id = nursingcare_patient_movement.encounter_id WHERE encounter.location_id IN ( :locationId ) AND (datetime_discharged IS NULL OR datetime_discharged > :endDate ) ) "),
		LEVEL_ONE(
				 "SELECT COUNT(DISTINCT patient_case_record_id) FROM nursingcare_level_of_care WHERE level_of_care = 1 AND (date_created BETWEEN :startDate AND :endDate ) AND patient_case_record_id IN (SELECT DISTINCT nursingcare_patient_case_record.id FROM nursingcare_patient_case_record INNER JOIN nursingcare_patient_movement ON nursingcare_patient_case_record.latest_patient_movement_id = nursingcare_patient_movement.id INNER JOIN encounter ON encounter.encounter_id = nursingcare_patient_movement.encounter_id WHERE encounter.location_id IN ( :locationId )) "),
		LEVEL_TWO(
				 "SELECT COUNT(DISTINCT patient_case_record_id) FROM nursingcare_level_of_care WHERE level_of_care = 2 AND (date_created BETWEEN :startDate AND :endDate ) AND patient_case_record_id IN (SELECT DISTINCT nursingcare_patient_case_record.id FROM nursingcare_patient_case_record INNER JOIN nursingcare_patient_movement ON nursingcare_patient_case_record.latest_patient_movement_id = nursingcare_patient_movement.id INNER JOIN encounter ON encounter.encounter_id = nursingcare_patient_movement.encounter_id WHERE encounter.location_id IN ( :locationId )) "),
		LEVEL_THREE(
				 "SELECT COUNT(DISTINCT patient_case_record_id) FROM nursingcare_level_of_care WHERE level_of_care = 3 AND (date_created BETWEEN :startDate AND :endDate ) AND patient_case_record_id IN (SELECT DISTINCT nursingcare_patient_case_record.id FROM nursingcare_patient_case_record INNER JOIN nursingcare_patient_movement ON nursingcare_patient_case_record.latest_patient_movement_id = nursingcare_patient_movement.id INNER JOIN encounter ON encounter.encounter_id = nursingcare_patient_movement.encounter_id WHERE encounter.location_id IN ( :locationId )) "),
		LEVEL_FOUR(
				 "SELECT COUNT(DISTINCT patient_case_record_id) FROM nursingcare_level_of_care WHERE level_of_care = 4 AND (date_created BETWEEN :startDate AND :endDate ) AND patient_case_record_id IN (SELECT DISTINCT nursingcare_patient_case_record.id FROM nursingcare_patient_case_record INNER JOIN nursingcare_patient_movement ON nursingcare_patient_case_record.latest_patient_movement_id = nursingcare_patient_movement.id INNER JOIN encounter ON encounter.encounter_id = nursingcare_patient_movement.encounter_id WHERE encounter.location_id IN ( :locationId )) "),
		;
		
		private String value;
		
		public String getValue() {
			return value;
		}
		
		public void setValue(String value) {
			this.value = value;
		}
		
		private CodeLevelsOfCareReportEnum(String value) {
			this.value = value;
		}
		
	}
	


	public enum OtherReportEnum {
		HCAI(
				 "SELECT COUNT(DISTINCT patient_id) FROM nursingcare_orders WHERE order_type_id = 8 AND concept_id = (SELECT concept_id FROM concept WHERE uuid = '94f510df-8db6-4883-9b19-dd77a5f59584' ) AND instruction != ' ' AND (date_created BETWEEN :startDate AND :endDate ) AND (date_stopped IS NULL OR date_stopped > :endDate ) AND patient_id IN (SELECT DISTINCT nursingcare_patient_case_record.patient_id FROM nursingcare_patient_case_record INNER JOIN nursingcare_patient_movement ON nursingcare_patient_case_record.latest_patient_movement_id = nursingcare_patient_movement.id INNER JOIN encounter ON encounter.encounter_id = nursingcare_patient_movement.encounter_id WHERE encounter.location_id IN ( :locationId ) AND (datetime_discharged IS NULL OR datetime_discharged > :endDate ) ) "),
		WITH_BEDSORES(
				 "SELECT COUNT(DISTINCT patient_id) FROM nursingcare_orders WHERE order_type_id = 8 AND concept_id IN (SELECT concept_id FROM concept WHERE uuid IN ( '68321a59-4eef-4bcf-8f5b-bcc47f29f486','55f40bed-8cf0-4ac6-94dc-08c239bc1ff6' )) AND instruction != ' ' AND (date_created BETWEEN :startDate AND :endDate ) AND (date_stopped IS NULL OR date_stopped > :endDate ) AND patient_id IN (SELECT DISTINCT nursingcare_patient_case_record.patient_id FROM nursingcare_patient_case_record INNER JOIN nursingcare_patient_movement ON nursingcare_patient_case_record.latest_patient_movement_id = nursingcare_patient_movement.id INNER JOIN encounter ON encounter.encounter_id = nursingcare_patient_movement.encounter_id WHERE encounter.location_id IN ( :locationId ) AND (datetime_discharged IS NULL OR datetime_discharged > :endDate ) ) "),
		WITH_BEDSORES_ACQUIRED_IN_THE_HOSPITAL(
				 "SELECT COUNT(DISTINCT patient_id) FROM nursingcare_orders WHERE order_type_id = 8 AND concept_id = (SELECT concept_id FROM concept WHERE uuid = '68321a59-4eef-4bcf-8f5b-bcc47f29f486' ) AND instruction != ' ' AND (date_created BETWEEN :startDate AND :endDate ) AND (date_stopped IS NULL OR date_stopped > :endDate ) AND patient_id IN (SELECT DISTINCT nursingcare_patient_case_record.patient_id FROM nursingcare_patient_case_record INNER JOIN nursingcare_patient_movement ON nursingcare_patient_case_record.latest_patient_movement_id = nursingcare_patient_movement.id INNER JOIN encounter ON encounter.encounter_id = nursingcare_patient_movement.encounter_id WHERE encounter.location_id IN ( :locationId ) AND (datetime_discharged IS NULL OR datetime_discharged > :endDate ) ) "),
		OR_ON_CALL(
				 "SELECT COUNT(DISTINCT patient_id) FROM nursingcare_orders WHERE order_type_id = 8 AND concept_id = (SELECT concept_id FROM concept WHERE uuid = '62df2896-1e43-427e-82d1-d84d741a933d' ) AND instruction != ' ' AND (date_created BETWEEN :startDate AND :endDate ) AND (date_stopped IS NULL OR date_stopped > :endDate ) AND patient_id IN (SELECT DISTINCT nursingcare_patient_case_record.patient_id FROM nursingcare_patient_case_record INNER JOIN nursingcare_patient_movement ON nursingcare_patient_case_record.latest_patient_movement_id = nursingcare_patient_movement.id INNER JOIN encounter ON encounter.encounter_id = nursingcare_patient_movement.encounter_id WHERE encounter.location_id IN ( :locationId ) AND (datetime_discharged IS NULL OR datetime_discharged > :endDate ) ) "),
		FOR_OPERATION(
				 "SELECT COUNT(DISTINCT patient_case_record_id) FROM nursingcare_operation WHERE (date_schedule BETWEEN :startDate AND :endDate ) AND patient_case_record_id IN (SELECT DISTINCT nursingcare_patient_case_record.id FROM nursingcare_patient_case_record INNER JOIN nursingcare_patient_movement ON nursingcare_patient_case_record.latest_patient_movement_id = nursingcare_patient_movement.id INNER JOIN encounter ON encounter.encounter_id = nursingcare_patient_movement.encounter_id WHERE encounter.location_id IN ( :locationId ) AND (datetime_discharged IS NULL OR datetime_discharged > :endDate ) ) "),
		ADVERSE_SENTINEL_EVENTS(
				 "SELECT COUNT(DISTINCT patient_id) FROM nursingcare_orders WHERE order_type_id = 8 AND concept_id = (SELECT concept_id FROM concept WHERE uuid = '861d699b-46e7-40a3-ad21-1486dce48e49' ) AND instruction != ' ' AND (date_created BETWEEN :startDate AND :endDate ) AND (date_stopped IS NULL OR date_stopped > :endDate ) AND patient_id IN (SELECT DISTINCT nursingcare_patient_case_record.patient_id FROM nursingcare_patient_case_record INNER JOIN nursingcare_patient_movement ON nursingcare_patient_case_record.latest_patient_movement_id = nursingcare_patient_movement.id INNER JOIN encounter ON encounter.encounter_id = nursingcare_patient_movement.encounter_id WHERE encounter.location_id IN ( :locationId ) AND (datetime_discharged IS NULL OR datetime_discharged > :endDate ) ) "),
		DOCUMENTATION(
				 "SELECT COUNT(DISTINCT patient_id) FROM nursingcare_orders WHERE (date_created BETWEEN :startDate AND :endDate ) AND patient_id IN (SELECT DISTINCT nursingcare_patient_case_record.patient_id FROM nursingcare_patient_case_record INNER JOIN nursingcare_patient_movement ON nursingcare_patient_case_record.latest_patient_movement_id = nursingcare_patient_movement.id INNER JOIN encounter ON encounter.encounter_id = nursingcare_patient_movement.encounter_id WHERE encounter.location_id IN ( :locationId ) AND (datetime_discharged IS NULL OR datetime_discharged > :endDate ) ) ")
		;
		
		private String value;
		
		public String getValue() {
			return value;
		}
		
		public void setValue(String value) {
			this.value = value;
		}
		
		private OtherReportEnum(String value) {
			this.value = value;
		}
		
	}
	
	public enum DailyHospitalCensusReportEnum {
		BED_CAPACITY(
				 "SELECT COUNT(DISTINCT uuid ) FROM nursingcare_bed WHERE location_id IN ( :locationId ) "),
		TOTAL_LAST(
				 "SELECT COUNT(DISTINCT nursingcare_patient_case_record.patient_id) FROM nursingcare_patient_case_record INNER JOIN nursingcare_patient_movement ON nursingcare_patient_case_record.latest_patient_movement_id = nursingcare_patient_movement.id INNER JOIN encounter ON encounter.encounter_id = nursingcare_patient_movement.encounter_id WHERE (datetime_discharged IS NULL OR datetime_discharged BETWEEN :startDate AND :endDate ) AND encounter.location_id IN ( :locationId ) "),
		DAILY_OCCUPANCY_RATE(
				 "SELECT ( ( SELECT COUNT(DISTINCT nursingcare_patient_case_record.patient_id) FROM nursingcare_patient_case_record INNER JOIN nursingcare_patient_movement ON nursingcare_patient_case_record.latest_patient_movement_id = nursingcare_patient_movement.id INNER JOIN encounter ON encounter.encounter_id = nursingcare_patient_movement.encounter_id WHERE encounter.location_id IN ( :locationId ) AND (datetime_discharged IS NULL OR datetime_discharged BETWEEN :startDate AND :endDate ) ) / ( SELECT COUNT(DISTINCT uuid ) FROM nursingcare_bed WHERE location_id IN ( :locationId ) ) ) * 100 "),
		OVERFLOW(
				 "SELECT IF ( ( (SELECT COUNT(DISTINCT uuid ) FROM nursingcare_bed WHERE location_id IN ( :locationId ) ) > ((SELECT COUNT(DISTINCT nursingcare_patient_case_record.patient_id) FROM nursingcare_patient_case_record INNER JOIN nursingcare_patient_movement ON nursingcare_patient_case_record.latest_patient_movement_id = nursingcare_patient_movement.id INNER JOIN encounter ON encounter.encounter_id = nursingcare_patient_movement.encounter_id WHERE encounter.location_id IN ( :locationId ) AND (datetime_discharged IS NULL OR datetime_discharged  BETWEEN :startDate AND :endDate  ))) ) , 0, ( ((SELECT COUNT(DISTINCT nursingcare_patient_case_record.patient_id) FROM nursingcare_patient_case_record INNER JOIN nursingcare_patient_movement ON nursingcare_patient_case_record.latest_patient_movement_id = nursingcare_patient_movement.id INNER JOIN encounter ON encounter.encounter_id = nursingcare_patient_movement.encounter_id WHERE encounter.location_id IN ( :locationId ) AND (datetime_discharged IS NULL OR datetime_discharged  BETWEEN :startDate AND :endDate  ))) - ((SELECT COUNT(DISTINCT uuid ) FROM nursingcare_bed WHERE location_id IN ( :locationId ) )) ) ) "),
		ADMISSION(
				 "SELECT COUNT(DISTINCT patient_id) FROM encounter WHERE (encounter_datetime BETWEEN :startDate AND :endDate ) AND encounter_type = 4 AND location_id IN ( :locationId ) "),
		TRANS_IN(
				 "SELECT COUNT(DISTINCT patient_id) FROM nursingcare_patient_movement INNER JOIN encounter ON nursingcare_patient_movement.encounter_id = encounter.encounter_id WHERE (movement_datetime BETWEEN :startDate AND :endDate ) AND encounter_type = 7 AND bed_id IN (SELECT id FROM nursingcare_bed WHERE location_id IN ( :locationId )) "),
		TRANS_OUT(
				 "SELECT COUNT(DISTINCT patient_id) FROM nursingcare_patient_movement INNER JOIN encounter ON nursingcare_patient_movement.encounter_id = encounter.encounter_id WHERE (movement_datetime BETWEEN :startDate AND :endDate ) AND encounter_type = 7 AND previous_bed_id IN (SELECT id FROM nursingcare_bed WHERE location_id IN ( :locationId )) "),
		DISCHARGED(
				 "SELECT COUNT(DISTINCT patient_id) FROM encounter WHERE (encounter_datetime BETWEEN :startDate AND :endDate ) AND encounter_type = 3 AND location_id IN ( :locationId ) "),
		DEATHS(
				 "SELECT COUNT(DISTINCT patient_id) FROM encounter WHERE (encounter_datetime BETWEEN :startDate AND :endDate ) AND encounter_type = 13 AND location_id IN ( :locationId ) "),
		ABSCONDED(
				 "SELECT COUNT(DISTINCT patient_id) FROM encounter WHERE (encounter_datetime BETWEEN :startDate AND :endDate ) AND encounter_type = 12 AND location_id IN ( :locationId ) "),
		HOME_AGAINST_ADVICE(
				 "SELECT COUNT(DISTINCT patient_id) FROM encounter WHERE (encounter_datetime BETWEEN :startDate AND :endDate ) AND encounter_type = 11 AND location_id IN ( :locationId ) "),
		HOME_PER_REQUEST(
				 "SELECT COUNT(DISTINCT patient_id) FROM encounter WHERE (encounter_datetime BETWEEN :startDate AND :endDate ) AND encounter_type = 14 AND location_id IN ( :locationId ) "),
		OPERATIONS(
				 "SELECT COUNT(DISTINCT patient_case_record_id) FROM nursingcare_operation WHERE (date_schedule BETWEEN :startDate AND :endDate ) AND patient_case_record_id IN (SELECT DISTINCT nursingcare_patient_case_record.id FROM nursingcare_patient_case_record INNER JOIN nursingcare_patient_movement ON nursingcare_patient_case_record.latest_patient_movement_id = nursingcare_patient_movement.id INNER JOIN encounter ON encounter.encounter_id = nursingcare_patient_movement.encounter_id WHERE encounter.location_id IN ( :locationId )) "),
		DELIVERIES(
				 "SELECT COUNT(DISTINCT patient_case_record_id) FROM nursingcare_operation WHERE (date_schedule BETWEEN :startDate AND :endDate ) AND operation_name LIKE '%deliver%' AND schedule_status = 'available' AND patient_case_record_id IN (SELECT DISTINCT nursingcare_patient_case_record.id FROM nursingcare_patient_case_record INNER JOIN nursingcare_patient_movement ON nursingcare_patient_case_record.latest_patient_movement_id = nursingcare_patient_movement.id INNER JOIN encounter ON encounter.encounter_id = nursingcare_patient_movement.encounter_id WHERE encounter.location_id IN ( :locationId )) "),
		ROOMING_IN(
				 "SELECT COUNT(DISTINCT patient_id) FROM nursingcare_patient_movement INNER JOIN encounter ON nursingcare_patient_movement.encounter_id = encounter.encounter_id WHERE (movement_datetime BETWEEN :startDate AND :endDate ) AND encounter_type = 9 AND bed_id IN (SELECT id FROM nursingcare_bed WHERE location_id IN ( :locationId )) "),
		OUT_ON_PASS(
				 "SELECT COUNT(DISTINCT patient_id) FROM encounter WHERE (encounter_datetime BETWEEN :startDate AND :endDate ) AND encounter_type = 15 AND location_id IN ( :locationId ) ");
		
		private String value;
		
		public String getValue() {
			return value;
		}
		
		public void setValue(String value) {
			this.value = value;
		}
		
		private DailyHospitalCensusReportEnum(String value) {
			this.value = value;
		}
		
	}
	
	public enum WardAggregateEnum {
		
		LINEN_CHANGE("94a61225-d52e-4302-b26f-0692fb4c9fba"), ORAL("197cad2f-6f4f-4133-9e18-e538dee2a0ce"), TOPICAL("5933151f-f4f0-47ba-bd1d-84169e44c6bc"),
				INTRAVENOUS("d4f1e277-0afe-4c5f-a485-fd4fcebd8c28"), INTRADERMAL("df6ac41e-a9b6-43be-9565-1c8c0058564f"),
				INTRAMUSCULAR("9f3ea05d-c35a-47c5-9c4f-8322724b31c4"), SUBCUTANEOUS("2bb6befd-3703-4e4e-b87e-b66a4077f822"),
				DROPS("79adbc59-7111-4640-bfcd-9959c6551798"), SUPPOSITORIES("0db473ee-ef5f-4a73-98f9-8f38bd8b80ba"),
				ENEMA_IRRIGATION("2df7b954-8fcc-4e62-96e1-7c2726cd28cb"), OTHERS ("bb61411e-5d98-4e15-ab14-caae5b42e3e4");
		
		private String value;
		
		public String getValue() {
			return value;
		}
		
		public void setValue(String value) {
			this.value = value;
		}
		
		private WardAggregateEnum(String value) {
			this.value = value;
		}
	}
	
	
}
