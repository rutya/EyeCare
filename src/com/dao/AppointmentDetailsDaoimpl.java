package com.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.main.DBConnection;
import com.model.AppointmentDetails;

public class AppointmentDetailsDaoimpl implements AppointmentDetailsDao {
	
	private static List<AppointmentDetails>allAppointmentList=new ArrayList<AppointmentDetails>();


	@Override
	public AppointmentDetails getAppointmentDetails(int cardId) {
		// TODO Auto-generated method stub
		try {
			//
			AppointmentDetails dummyAppointment=new AppointmentDetails();
			dummyAppointment.setPatient(new PatientDetailsDaoimpl().getPatientDetails(cardId));
			
			if(allAppointmentList.contains(dummyAppointment))
			{
				
			int index=allAppointmentList.indexOf(dummyAppointment);
			return allAppointmentList.get(index);
			}
			//connecting to database
			Connection connection=DBConnection.getConnection();
			//generating SqlQuery
			String sqlQuery="select * from "+TABLEappointmentDetails+" where "+COLcardId+"="+"?";
			//creating PreparedStatment
			PreparedStatement pst=connection.prepareStatement(sqlQuery);
			pst.setInt(1,cardId);
			//executing PreparedStatment
			pst.executeQuery();
			//creating resultset
			ResultSet rs=pst.getResultSet();
			
			if(rs.next()==false)
			{
				return null;
			}
			
			int cardid=rs.getInt(COLcardId);
			Date appointmentDate=rs.getDate(COLappointmentDate);
			String appointmentTime=rs.getString(COLappointmentTime);

			AppointmentDetails appointmentDetail=new AppointmentDetails(new PatientDetailsDaoimpl().getPatientDetails(cardid),appointmentDate,appointmentTime);
			allAppointmentList.add(appointmentDetail);
			return appointmentDetail;
			
			
		} 
		//Exception handling
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		return null;
	}

	@Override
	public List<AppointmentDetails> getAllAppointmentDetails() {
		// TODO Auto-generated method stub
		allAppointmentList=new ArrayList<AppointmentDetails>();
		try {
			
			
			
			
			
			
			//connecting to database
			Connection connection=DBConnection.getConnection();
			//generating SqlQuery
			String sqlQuery="select * from "+TABLEappointmentDetails;
			//creating PreparedStatment
			PreparedStatement pst=connection.prepareStatement(sqlQuery);
			//executing PreparedStatment
			pst.executeQuery();
			//creating resultset
			ResultSet rs=pst.getResultSet();
			
			while(rs.next())
			{
				int cardid=rs.getInt(COLcardId);
				Date appointmentDate=rs.getDate(COLappointmentDate);
				String appointmentTime=rs.getString(COLappointmentTime);

				AppointmentDetails appointmentDetail=new AppointmentDetails(new PatientDetailsDaoimpl().getPatientDetails(cardid),appointmentDate,appointmentTime);
				allAppointmentList.add(appointmentDetail);
				
			}
			
			
			
			return  allAppointmentList;
			
			
		} 
		
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		


		
		return null;
	}

	@Override
	public void addAppointmentDetail(AppointmentDetails appointmentDetails) throws AppointmentDetailsExistsException {
		// TODO Auto-generated method stub
		//creating PreparedStatment
		PreparedStatement pst;
		try {
			//connecting to database
			
			
			

			Connection connection=DBConnection.getConnection();
			//generating SqlQuery
			String sqlQuery="insert into "+TABLEappointmentDetails+" values(?,?,?)";
			
			pst = connection.prepareStatement(sqlQuery);
			pst.setInt(1,appointmentDetails.getPatient().getCardId());
			pst.setDate(2,appointmentDetails.getAppointmentDate());
			pst.setString(3,appointmentDetails.getAppointmentTime());
			//executing PreparedStatment
			pst.executeUpdate();
			allAppointmentList.add(appointmentDetails);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	

	}

	@Override
	public void updateAppointmentDetails(AppointmentDetails appointmentDetails) {
		// TODO Auto-generated method stub
		//creating PreparedStatment
		PreparedStatement pst;
		try {
			//connecting to database
			
			
			
			

			Connection connection=DBConnection.getConnection();
			//generating SqlQuery
			String sqlQuery="update "+TABLEappointmentDetails+" set "+COLappointmentDate+"=?"+","+COLappointmentTime+"=?"+" where "+COLcardId+"=?";
			pst = connection.prepareStatement(sqlQuery);
			
			pst.setDate(1,appointmentDetails.getAppointmentDate());
			pst.setString(2,appointmentDetails.getAppointmentTime());
			pst.setInt(3,appointmentDetails.getPatient().getCardId());
			//executing PreparedStatment
			pst.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		


		

	}

	@Override
	public void deleteAppointmentDetails(AppointmentDetails appointmentDetails) {
		// TODO Auto-generated method stub
		//creating PreparedStatment
		PreparedStatement pst;
		try {
			//connecting to database
			
			
			
		
			Connection connection=DBConnection.getConnection();
			//generating SqlQuery
			String sqlQuery="delete from "+TABLEappointmentDetails+" where "+COLcardId+"=?";
			pst = connection.prepareStatement(sqlQuery);
			
			pst.setInt(1,appointmentDetails.getPatient().getCardId());
			//executing PreparedStatment
			pst.executeUpdate();
			
			allAppointmentList.remove(appointmentDetails);
			
//			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		



	}

}
