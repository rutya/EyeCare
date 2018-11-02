package com.model;

import java.sql.Date;

public class CheckupDetails {

	PatientDetails patient;
	float leftEyeNo,rightEyeNo;
	String glassesGrantedStatus,suggestedTreatment,mainTreatmentName,suggestedHospitalName;
	Date operationDate;

	public CheckupDetails() {
		super();
	}
	public CheckupDetails(PatientDetails patient, float leftEyeNo, float rightEyeNo, String glassesGrantedStatus,
			String suggestedTreatment, String mainTreatmentName, String suggestedHospitalName, Date operationDate) {
		super();
		this.patient = patient;
		this.leftEyeNo = leftEyeNo;
		this.rightEyeNo = rightEyeNo;
		this.glassesGrantedStatus = glassesGrantedStatus;
		this.suggestedTreatment = suggestedTreatment;
		this.mainTreatmentName = mainTreatmentName;
		this.suggestedHospitalName = suggestedHospitalName;
		this.operationDate = operationDate;
	}
	public PatientDetails getPatient() {
		return patient;
	}
	public void setPatient(PatientDetails patient) {
		this.patient = patient;
	}
	public float getLeftEyeNo() {
		return leftEyeNo;
	}
	public void setLeftEyeNo(float leftEyeNo) {
		this.leftEyeNo = leftEyeNo;
	}
	public float getRightEyeNo() {
		return rightEyeNo;
	}
	public void setRightEyeNo(float rightEyeNo) {
		this.rightEyeNo = rightEyeNo;
	}
	public String getGlassesGrantedStatus() {
		return glassesGrantedStatus;
	}
	public void setGlassesGrantedStatus(String glassesGrantedStatus) {
		this.glassesGrantedStatus = glassesGrantedStatus;
	}
	public String getSuggestedTreatment() {
		return suggestedTreatment;
	}
	public void setSuggestedTreatment(String suggestedTreatment) {
		this.suggestedTreatment = suggestedTreatment;
	}
	public String getMainTreatmentName() {
		return mainTreatmentName;
	}
	public void setMainTreatmentName(String mainTreatmentName) {
		this.mainTreatmentName = mainTreatmentName;
	}
	public String getSuggestedHospitalName() {
		return suggestedHospitalName;
	}
	public void setSuggestedHospitalName(String suggestedHospitalName) {
		this.suggestedHospitalName = suggestedHospitalName;
	}
	public Date getOperationDate() {
		return operationDate;
	}
	public void setOperationDate(Date operationDate) {
		this.operationDate = operationDate;
	}
	@Override
	public String toString() {
		return "CheckupDetails [patient=" + patient + ", leftEyeNo=" + leftEyeNo + ", rightEyeNo=" + rightEyeNo
				+ ", glassesGrantedStatus=" + glassesGrantedStatus + ", suggestedTreatment=" + suggestedTreatment
				+ ", mainTreatmentName=" + mainTreatmentName + ", suggestedHospitalName=" + suggestedHospitalName
				+ ", operationDate=" + operationDate + "]";
	}
	
	
	
	
	
}
