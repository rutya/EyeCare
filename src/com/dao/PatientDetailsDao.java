package com.dao;

import java.util.List;
import com.model.PatientDetails;

public interface PatientDetailsDao {
	String TABLEpatientDetails="PatientDetails",COLcardId="CardId",COLpatientName="PatientName";
	String COLage="Age",COLmobileNo="MobileNo",COLaddress="Address";
	
	PatientDetails getPatientDetails(int cardId);
	
	List<PatientDetails> getAllPatientDetails();
	void addPatientDetails(PatientDetails patient) throws PatientDetailsExistsException;
	void updatePatientDetails(PatientDetails patient);
	void deletePatientDetails(PatientDetails patient);
	
	
}
