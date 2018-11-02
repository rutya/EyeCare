package com.model;

import java.sql.Date;

public class CardDetails {
	
	PatientDetails patient;
	Date issueDate,dueDate;
	
	
	public CardDetails() {
		super();
	}
	public CardDetails(PatientDetails patient, Date issueDate, Date dueDate) {
		super();
		this.patient = patient;
		this.issueDate = issueDate;
		this.dueDate = dueDate;
	}
	public PatientDetails getPatient() {
		return patient;
	}
	public void setPatient(PatientDetails patient) {
		this.patient = patient;
	}
	public Date getIssueDate() {
		return issueDate;
	}
	public void setIssueDate(Date issueDate) {
		this.issueDate = issueDate;
	}
	public Date getDueDate() {
		return dueDate;
	}
	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}
	@Override
	public String toString() {
		return "CardDetails [patient=" + patient + ", IssueDate=" + issueDate + ", DueDate=" + dueDate + "]";
	}
	
	

}
