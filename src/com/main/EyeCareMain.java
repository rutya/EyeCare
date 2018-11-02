package com.main;

import java.sql.Date;
import java.util.List;

import com.dao.AppointmentDetailsDao;
import com.dao.AppointmentDetailsDaoimpl;
import com.dao.AppointmentDetailsExistsException;
import com.dao.CardDetailsDao;
import com.dao.CardDetailsDaoimpl;
import com.dao.CardDetailsExistsException;
import com.dao.CheckupDetailsDao;
import com.dao.CheckupDetailsDaoimpl;
import com.dao.CheckupDetailsExistsException;
import com.dao.OperationDetailDaoimpl;
import com.dao.OperationDetailsDao;
import com.dao.PatientDetailsDao;
import com.dao.PatientDetailsDaoimpl;
import com.dao.PatientDetailsExistsException;
import com.model.AppointmentDetails;
import com.model.CardDetails;
import com.model.CheckupDetails;
import com.model.OperationDetails;
import com.model.PatientDetails;

public class EyeCareMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//*********patienDetails implementation**************
		
		/*PatientDetailsDao patientdaoimpl=new PatientDetailsDaoimpl();
		
		PatientDetails patientDetails = patientdaoimpl.getPatientDetails(3); //get single patient details
		
		System.out.println("Patient"+patientDetails);
		
		
		
		//insertion in patientDetails
		
//		PatientDetails patient=new PatientDetails("Rutuja", 22,"9623511929","Sahakar Nagar");
//		try {
//		patientdaoimpl.addPatientDetails(patient);
//		} catch (PatientDetailsExistsException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		
		//deletion
//		PatientDetails patientDetails1 = patientdaoimpl.getPatientDetails(7);
//		patientdaoimpl.deletePatientDetails(patientDetails1);
//		
//		List<PatientDetails> allPatientDetails = patientdaoimpl.getAllPatientDetails();
//		
		
//		for(PatientDetails patient1:allPatientDetails)
//		{
//			System.out.println(patient1);
//		}
		
		
		//Updation
		PatientDetails patientDetails1 = patientdaoimpl.getPatientDetails(3);
		patientDetails1.setAge(24);
		patientDetails1.setMobileNo("9359592077");
		patientDetails1.setAddress("Kharadi");
		patientdaoimpl.updatePatientDetails(patientDetails1);
		
		List<PatientDetails> allPatientDetails = patientdaoimpl.getAllPatientDetails();
		
		
		for(PatientDetails patient1:allPatientDetails)
		{
			System.out.println(patient1);
		}
		*/
		
		
		/*//*********CardDetailimp*************
		
		CardDetailsDao cardDetailsimpl=new CardDetailsDaoimpl();
		
		CardDetails cardDetails = cardDetailsimpl.getCardDetails(1);
		
		//System.out.println(cardDetails);
		
		List<CardDetails> allCardDetails = cardDetailsimpl.getAllCardDetails();
		for(CardDetails card:allCardDetails)
		{
			System.out.println(card);
		}
		
		//Addition 
//		CardDetails carddetails1=new CardDetails(new PatientDetailsDaoimpl().getPatientDetails(2),Date.valueOf("2018-02-01"),Date.valueOf("2018-07-s01"));
//		try {
//			cardDetailsimpl.addCardDetail(carddetails1);
//		} catch (CardDetailsExistsException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	
		allCardDetails = cardDetailsimpl.getAllCardDetails();
		
		System.out.println("after addition");
		for(CardDetails card:allCardDetails)
		{
			System.out.println(card);
		}
		
		//deletion
		CardDetails cardDetails2 = cardDetailsimpl.getCardDetails(1);
		cardDetailsimpl.deleteCardDetails(cardDetails2);
		
		//updation
		CardDetails cardDetails2 = cardDetailsimpl.getCardDetails(1);
		cardDetails2.setIssueDate(Date.valueOf("2018-02-01"));
		cardDetails2.setDueDate(Date.valueOf("2018-07-01"));
		cardDetailsimpl.updateCardDetails(cardDetails2);
		allCardDetails = cardDetailsimpl.getAllCardDetails();
		
		System.out.println("after updatation");
		for(CardDetails card:allCardDetails)
		{
			System.out.println(card);
		}
		*/
		
		//************AppointmentDaoimplementation*******************
		
//		AppointmentDetailsDao appointmentdetailimpl=new AppointmentDetailsDaoimpl();
//		List<AppointmentDetails> allAppointmentDetails = appointmentdetailimpl.getAllAppointmentDetails();
//		for(AppointmentDetails appointment:allAppointmentDetails)
//		{
//			System.out.println(appointment);
//		}
		//AppointmentDetails appointmentDetails = appointmentdetailimpl.getAppointmentDetails(1);
		//System.out.println(appointmentDetails);
		
//		AppointmentDetails appointment=new AppointmentDetails(new PatientDetailsDaoimpl().getPatientDetails(2),Date.valueOf("2018-04-03"),"3-4");
//		
//		try {
//			appointmentdetailimpl.addAppointmentDetail(appointment);
//		} catch (AppointmentDetailsExistsException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
	/*	 allAppointmentDetails = appointmentdetailimpl.getAllAppointmentDetails();
		 System.out.println("After Addition");
		for(AppointmentDetails appointment1:allAppointmentDetails)
		{
			System.out.println(appointment1);
		}
		
		AppointmentDetails appointmentDetails = appointmentdetailimpl.getAppointmentDetails(2);
		appointmentDetails.setAppointmentTime("8-9");
		appointmentDetails.setAppointmentDate(Date.valueOf("2018-09-04"));
		
		appointmentdetailimpl.updateAppointmentDetails(appointmentDetails);
		
		allAppointmentDetails = appointmentdetailimpl.getAllAppointmentDetails();
		System.out.println("After updattion");
		for(AppointmentDetails appointment1:allAppointmentDetails)
		{
			System.out.println(appointment1);
		}
		
		appointmentdetailimpl.deleteAppointmentDetails(appointmentDetails);
		
		allAppointmentDetails = appointmentdetailimpl.getAllAppointmentDetails();
		System.out.println("after deletion");
		for(AppointmentDetails appointment1:allAppointmentDetails)
		{
			System.out.println(appointment1);
		}
		*/
		
		
		
		//*******Checkupdetails implementation***********
		
		CheckupDetailsDao checkupdaoimpl=new CheckupDetailsDaoimpl();
		
		
//		CheckupDetails checkup=new CheckupDetails(new PatientDetailsDaoimpl().getPatientDetails(3),1, 1, "no", "tratment2", "mainTreatment2", "poona", Date.valueOf("2018-08-09"));
//		
//		try {
//			checkupdaoimpl.addCheckupDetails(checkup);
//		} catch (CheckupDetailsExistsException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		

//		List<CheckupDetails> allCheckupDetails = checkupdaoimpl.getAllCheckupDetails();
//		
//		System.out.println("alll ");
//		
//		for(CheckupDetails ch:allCheckupDetails)
//		{
//			System.out.println(ch);
//		}
		
//		CheckupDetails checkupDetails = checkupdaoimpl.getCheckupDetails(4);
//		checkupDetails.setMainTreatmentName("ABC");
//		checkupdaoimpl.updateMainTreatment(checkupDetails);
//		
//		List<CheckupDetails> allCheckupDetails = checkupdaoimpl.getAllCheckupDetails();
//		
//		System.out.println("alll ");
//	
//		for(CheckupDetails ch:allCheckupDetails)
//		{
//			System.out.println(ch);
//		}
		
	//	CheckupDetails checkupDetails = checkupdaoimpl.getCheckupDetails(2);
		//System.out.println(checkupDetails);
		
//		checkupDetails.setLeftEyeNo(2);
//		checkupDetails.setRightEyeNo(3);
		
		//checkupdaoimpl.updateEyeNo(checkupDetails);
		
//		checkupDetails = checkupdaoimpl.getCheckupDetails(3);
//		//System.out.println(checkupDetails);
//		
//
//		checkupDetails.setMainTreatmentName("mainn");
//		checkupDetails.setSuggestedHospitalName("bharatii");
//		checkupDetails.setOperationDate(Date.valueOf("2017-01-02"));
//		checkupdaoimpl.updateMainTreatment(checkupDetails);
//		checkupDetails = checkupdaoimpl.getCheckupDetails(3);
//		System.out.println("updated  "+checkupDetails);
//		
//		checkupdaoimpl.deleteCheckupDetails(checkupDetails);
		
//		allCheckupDetails = checkupdaoimpl.getAllCheckupDetails();
//		
//		System.out.println("alll ");
//		
//		for(CheckupDetails ch:allCheckupDetails)
//		{
//			System.out.println(ch);
//		}
		
		OperationDetailsDao op =  new OperationDetailDaoimpl();
		List<OperationDetails> allOpeartionDetails = op.getAllOpeartionDetails();
		for(OperationDetails opl:allOpeartionDetails)
		{
			System.out.println(opl);
		}
		
		
	}

}
