package com.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.main.DBConnection;
import com.model.CheckupDetails;
import com.model.PatientDetails;


public class CheckupDetailsDaoimpl implements CheckupDetailsDao {
	
	private static List<CheckupDetails> allcheckuplist = new ArrayList<CheckupDetails>();
	//Get Check up details of one patient
	@Override
	public CheckupDetails getCheckupDetails(int cardId) {
		
		try {
			
			CheckupDetails dummypatient=new CheckupDetails();
			dummypatient.setPatient(new PatientDetailsDaoimpl().getPatientDetails(cardId));
			if(allcheckuplist.contains(dummypatient))
			{
				int index = allcheckuplist.indexOf(dummypatient);
				return allcheckuplist.get(index);
			}
			
			//connecting to database
			Connection connection=DBConnection.getConnection();
			//generating SqlQuery
			String sqlQuery="select * from "+TABLEcheckupDetails+" where "+COLcardId+"="+"?";
			//creating PreparedStatment
			PreparedStatement pst=connection.prepareStatement(sqlQuery);
			pst.setInt(1, cardId);
			//executing PreparedStatment
			pst.executeQuery();
			//creating resultset
			ResultSet rs=pst.getResultSet();
			
			if(rs.next()==false)
			{
				return null;
			}
			
			//int cardid=rs.getInt(COLcardId);
			float lefteyeno =rs.getFloat(COLleftEyeNo);
			float righteyeno = rs.getFloat(COLrightEyeNo);
			String glassesgrantedstatus = rs.getString(COLglassesGrantedStatus);
			String suggestedtreatment = rs.getString(COLsuggestedTreatment);
			String maintreatmentname = rs.getString(COLmainTreatmentName);
			Date operationdate = rs.getDate(COLoperationDate);
			String suggestedhospitalname = rs.getString(COLsuggestedHospitalName);
			CheckupDetails checkupdetails = new CheckupDetails(new PatientDetailsDaoimpl().getPatientDetails(cardId), lefteyeno, righteyeno, glassesgrantedstatus, suggestedtreatment, maintreatmentname, suggestedhospitalname, operationdate);
			allcheckuplist.add(checkupdetails);
		
			return checkupdetails;
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	return null;
	
	}

	//get details of all the patients
	@Override
	public List<CheckupDetails> getAllCheckupDetails() {
		//connecting to database

		Connection connection=DBConnection.getConnection();
		List<CheckupDetails> checkupdetailsList =  new ArrayList<CheckupDetails>();	
		

		try {
									
			//generating SqlQuery

			String sqlQuery="select * from "+TABLEcheckupDetails;
			//creating PreparedStatment
			PreparedStatement ps = connection.prepareStatement(sqlQuery);
			//executing PreparedStatment

			ps.executeQuery();
			//creating resultset

			ResultSet rs=ps.getResultSet();
			
			while(rs.next())
			{
				int cardid=rs.getInt(COLcardId);
				float lefteyeno =rs.getFloat(COLleftEyeNo);
				float righteyeno = rs.getFloat(COLrightEyeNo);
				String glassesgrantedstatus = rs.getString(COLglassesGrantedStatus);
				String suggestedtreatment = rs.getString(COLsuggestedTreatment);
				String maintreatmentname = rs.getString(COLmainTreatmentName);
				Date operationdate = rs.getDate(COLoperationDate);
				String suggestedhospitalname = rs.getString(COLsuggestedHospitalName);
				CheckupDetails checkupdetails = new CheckupDetails(new PatientDetailsDaoimpl().getPatientDetails(cardid), lefteyeno, righteyeno, glassesgrantedstatus, suggestedtreatment, maintreatmentname, suggestedhospitalname, operationdate);
				checkupdetailsList.add(checkupdetails);
			}
		return checkupdetailsList;		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return null;
		
	}

	
	//add check up details of a patient
	@Override
	public void addCheckupDetails(CheckupDetails checkupdetail) throws CheckupDetailsExistsException 
	{
		//connecting to database
		
		
		
		

		Connection connection=DBConnection.getConnection();
		List<CheckupDetails> checkupdetailsList =  new ArrayList<CheckupDetails>();
		//generating SqlQuery
		String sqlQuery = "insert into "+TABLEcheckupDetails+" values(?,?,?,?,?,?,?,?)";
		try {
			//creating PreparedStatment
			PreparedStatement pst = connection.prepareStatement(sqlQuery);
			
			pst.setInt(1, checkupdetail.getPatient().getCardId());
			pst.setFloat(2, checkupdetail.getLeftEyeNo());
			pst.setFloat(3, checkupdetail.getRightEyeNo());
			pst.setString(4,checkupdetail.getGlassesGrantedStatus());
			pst.setString(5, checkupdetail.getSuggestedTreatment());
			pst.setString(6, checkupdetail.getMainTreatmentName());
			pst.setDate(7, checkupdetail.getOperationDate());
			pst.setString(8, checkupdetail.getSuggestedHospitalName());
			//executing PreparedStatment
			pst.executeUpdate();
			
			checkupdetailsList.add(checkupdetail);
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	
	//update eyes number of a patient after machine eye checkup
	@Override
	public void updateEyeNo(CheckupDetails checkupDetail) 
	{
		//connecting to database
		
		
		

		Connection connection=DBConnection.getConnection();
		List<CheckupDetails> checkupdetailsList =  new ArrayList<CheckupDetails>();
		//generating SqlQuery
		String sqlQuery = "update "+TABLEcheckupDetails+" set "+COLleftEyeNo+"="+"?"+","+COLrightEyeNo+"="+"?"+" where "+COLcardId+"="+"?";
		try {
			//creating PreparedStatment
			PreparedStatement pst = connection.prepareStatement(sqlQuery);
			
			pst.setFloat(1, checkupDetail.getLeftEyeNo());
			pst.setFloat(2, checkupDetail.getRightEyeNo());
			pst.setInt(3, checkupDetail.getPatient().getCardId());
			//executing PreparedStatment
			pst.executeUpdate();
			
			
			checkupdetailsList.add(checkupDetail);
			
			} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//update glass granted status of a patient by Shopkeeper
	@Override
	public void updateGlassGrantedStatus(CheckupDetails checkupDetail) 
	{
		//connecting to database
		
		
		
		

		Connection connection=DBConnection.getConnection();
		List<CheckupDetails> checkupdetailsList =  new ArrayList<CheckupDetails>();
		//generating SqlQuery
		String sqlQuery = "update "+TABLEcheckupDetails+" set "+COLglassesGrantedStatus +"="+"?"+" where "+COLcardId+"="+"?";
		try {
			//creating PreparedStatment
			PreparedStatement pst = connection.prepareStatement(sqlQuery);
			
			pst.setString(1,checkupDetail.getGlassesGrantedStatus());
			pst.setInt(2, checkupDetail.getPatient().getCardId());
			//executing PreparedStatment
			pst.executeUpdate();
			
		
			checkupdetailsList.add(checkupDetail);
			
			} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}
	
	//update suggested treatment of a patient by junior doctor

	@Override
	public void updateSuggestedTreatment(CheckupDetails checkupDetail) 
	{
		//connecting to database
		
		
		
		

		Connection connection=DBConnection.getConnection();
		List<CheckupDetails> checkupdetailsList =  new ArrayList<CheckupDetails>();
		//generating SqlQuery
		String sqlQuery = "update "+TABLEcheckupDetails+" set "+COLsuggestedTreatment +"="+"?"+" where "+COLcardId+"="+"?";
		try {
			//creating PreparedStatment
			PreparedStatement pst = connection.prepareStatement(sqlQuery);
			
			pst.setString(1,checkupDetail.getSuggestedTreatment());
			pst.setInt(2, checkupDetail.getPatient().getCardId());
			//executing PreparedStatment
			pst.executeUpdate();
			
			
			checkupdetailsList.add(checkupDetail);
			
			} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

	//update main treatment name , operation date and suggested hospital name by main doctor
	@Override
	public void updateMainTreatment(CheckupDetails checkupDetail) 
	{
		//connecting to database
		
		

		Connection connection=DBConnection.getConnection();
		List<CheckupDetails> checkupdetailsList =  new ArrayList<CheckupDetails>();
		//generating SqlQuery
		String sqlQuery = "update "+TABLEcheckupDetails+" set "+COLmainTreatmentName+"="+"?"+","+COLoperationDate+"="+"?"+","+COLsuggestedHospitalName+"="+"?"+" where "+COLcardId+"="+"?";
		try {
			//creating PreparedStatment
			PreparedStatement pst = connection.prepareStatement(sqlQuery);
			
			pst.setString(1, checkupDetail.getMainTreatmentName());
			pst.setDate(2, checkupDetail.getOperationDate());
			pst.setString(3, checkupDetail.getSuggestedHospitalName());
			pst.setInt(4, checkupDetail.getPatient().getCardId());
			//executing PreparedStatment
			pst.executeUpdate();
			
			
			checkupdetailsList.add(checkupDetail);
			
			} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}
	
	//delete details of patient

	@Override
	public void deleteCheckupDetails(CheckupDetails checkupdetail) {
		//connecting to database

		Connection connection=DBConnection.getConnection();
		List<CheckupDetails> checkupdetailsList =  new ArrayList<CheckupDetails>();
		//generating SqlQuery
		String sqlQuery = "delete from "+TABLEcheckupDetails+" where "+COLcardId+"="+"?";
		try {
			//creating PreparedStatment
			PreparedStatement pst = connection.prepareStatement(sqlQuery);
			pst.setInt(1, checkupdetail.getPatient().getCardId());
			//executing PreparedStatment
			pst.executeUpdate();
			checkupdetailsList.remove(checkupdetail);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
