package com.model;

import java.sql.Date;

public class AppointmentDetails {
	PatientDetails patient;
	Date appointmentDate;
	String appointmentTime;
	
	
	public AppointmentDetails() {
		super();
	}

	public AppointmentDetails(PatientDetails patient, Date appointmentDate, String appointmentTime) {
		super();
		this.patient = patient;
		this.appointmentDate = appointmentDate;
		this.appointmentTime = appointmentTime;
	}

	public PatientDetails getPatient() {
		return patient;
	}

	public void setPatient(PatientDetails patient) {
		this.patient = patient;
	}

	public Date getAppointmentDate() {
		return appointmentDate;
	}

	public void setAppointmentDate(Date appointmentDate) {
		this.appointmentDate = appointmentDate;
	}

	public String getAppointmentTime() {
		return appointmentTime;
	}

	public void setAppointmentTime(String appointmentTime) {
		this.appointmentTime = appointmentTime;
	}

	@Override
	public String toString() {
		return "AppointmentDetails [patient=" + patient + ", appointmentDate=" + appointmentDate + ", appointmentTime="
				+ appointmentTime + "]";
	}
	

	

}
