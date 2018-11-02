package com.dao;

import java.util.List;


import com.model.AppointmentDetails;

//inteface for storing AppoinmentDetails
public interface AppointmentDetailsDao {
	
String TABLEappointmentDetails="AppointmentDetails",COLcardId="CardId",COLappointmentDate="AppointmentDate",COLappointmentTime="AppointmentTime";
	
//declaration of methods
	AppointmentDetails getAppointmentDetails(int cardId);
	List<AppointmentDetails> getAllAppointmentDetails();
	void addAppointmentDetail(AppointmentDetails appointmentDetails)throws AppointmentDetailsExistsException;
	void updateAppointmentDetails(AppointmentDetails appointmentDetails);
	void deleteAppointmentDetails(AppointmentDetails appointmentDetails);
	
	

}
