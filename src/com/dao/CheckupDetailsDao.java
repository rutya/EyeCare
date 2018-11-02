package com.dao;

import java.util.List;

import com.model.CheckupDetails;

public interface CheckupDetailsDao {
	
	String TABLEcheckupDetails="CheckupDetails",COLcardId="CardId",COLleftEyeNo="LeftEyeNo",COLrightEyeNo="RightEyeNo",COLglassesGrantedStatus="GlassesGrantedStatus";
	String COLsuggestedTreatment="SuggestedTreatment",COLmainTreatmentName="MainTreatmentName",COLoperationDate="OperationDate",COLsuggestedHospitalName="SuggestedHospitalName";
	
	
	CheckupDetails getCheckupDetails(int cardId);
	
	List<CheckupDetails> getAllCheckupDetails();
	void addCheckupDetails(CheckupDetails checkupdetail) throws CheckupDetailsExistsException;
	void updateEyeNo(CheckupDetails checkupDetail);//update lefteyeno and righteyeno
	void updateGlassGrantedStatus(CheckupDetails checkupDetail);
	void updateSuggestedTreatment(CheckupDetails checkupDetail);
	void updateMainTreatment(CheckupDetails checkupDetail);	//update maintreatmentname,operationdate,suggestedhospital
	void deleteCheckupDetails(CheckupDetails checkupdetail);
	

}
