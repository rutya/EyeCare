package com.dao;

import java.util.List;

import com.model.AppointmentDetails;
import com.model.OperationDetails;

public interface OperationDetailsDao {
String TABLEoperationDetails="OperationDetails",COLoperationName="OperationName",COLhospitalName="HospitalName",COLsrNo="SrNo";
	List<OperationDetails>  getOperationalDetails(String operationName);
	List<OperationDetails> getAllOpeartionDetails();
	void addOperationDetails(OperationDetails operationDetails);
	void updateOpeartionDetails(OperationDetails operationDetails);
	void deleteOpeartionDetails(OperationDetails opeartionDetails);
}
