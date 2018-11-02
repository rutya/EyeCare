package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.main.DBConnection;

import com.model.PatientDetails;

public class PatientDetailsDaoimpl implements PatientDetailsDao {
	
	private static List<PatientDetails>allPatientList=new ArrayList<PatientDetails>();

	@Override
	public PatientDetails getPatientDetails(int cardId) {
		// TODO Auto-generated method stub
		try {
			PatientDetails dummypatient=new PatientDetails();
			dummypatient.setCardId(cardId);
			
			if(allPatientList.contains(dummypatient))
			{
				
				int index=allPatientList.indexOf(dummypatient);
				return allPatientList.get(index);
			}
			//connecting to database
			
			
			
			

			Connection connection=DBConnection.getConnection();
			//generating SqlQuery
			String sqlQuery="select * from "+TABLEpatientDetails+" where "+COLcardId+"="+"?";
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
			
			int cardid=rs.getInt(COLcardId);
			String patientname=rs.getString(COLpatientName);
			int age=rs.getInt(COLage);
			String mobileno=rs.getString(COLmobileNo);
			String address=rs.getString(COLaddress);
			PatientDetails patientDetails = new PatientDetails(cardid, patientname,age,mobileno, address);
			allPatientList.add(patientDetails);
		
			return patientDetails;
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		
		return null;
	}

	@Override
	public List<PatientDetails> getAllPatientDetails() {
		// TODO Auto-generated method stub
		allPatientList=new ArrayList<PatientDetails>();
		try {
			
			//connecting to database
			
			
			
			

			Connection connection=DBConnection.getConnection();
			//generating SqlQuery
			String sqlQuery="select * from "+TABLEpatientDetails;
			//creating PreparedStatment
			PreparedStatement pst=connection.prepareStatement(sqlQuery);
			//executing PreparedStatment
			pst.executeQuery();
			//creating resultset
			ResultSet rs=pst.getResultSet();
			
			while(rs.next())
			{
				int cardid=rs.getInt(COLcardId);
				String patientname=rs.getString(COLpatientName);
				int age=rs.getInt(COLage);
				String mobileno=rs.getString(COLmobileNo);
				String address=rs.getString(COLaddress);
				PatientDetails patientDetails = new PatientDetails(cardid, patientname,age,mobileno, address);
				allPatientList.add(patientDetails);
				
			}
			return  allPatientList;
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		return null;
	}

	@Override
	public void addPatientDetails(PatientDetails patient) throws PatientDetailsExistsException {
		// TODO Auto-generated method stub
		//creating PreparedStatment
		PreparedStatement pst;
		try {
			
			
			
			
			
			//connecting to database
			Connection connection=DBConnection.getConnection();
			//generating SqlQuery
			String sqlQuery="insert into "+TABLEpatientDetails+"("+COLpatientName+","+COLage+","+COLmobileNo+","+COLaddress+")"+" values(?,?,?,?)";
			pst = connection.prepareStatement(sqlQuery);
			//pst.setInt(1,patient.getCardId());
			pst.setString(1,patient.getPatientName());
			pst.setInt(2,patient.getAge());
			pst.setString(3,patient.getMobileNo());
			pst.setString(4,patient.getAddress());
			//executing PreparedStatment
			pst.executeUpdate();
			allPatientList.add(patient);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		


	}

	@Override
	public void updatePatientDetails(PatientDetails patient) {
		// TODO Auto-generated method stub
		//creating PreparedStatment
		PreparedStatement pst;
		try {
			//connecting to database
			Connection connection=DBConnection.getConnection();
			//generating SqlQuery
			String sqlQuery="update "+TABLEpatientDetails+" set "+COLage+"=?"+","+COLmobileNo+"=?"+","+COLaddress+"=?"+" where "+COLcardId+"=?";
			pst = connection.prepareStatement(sqlQuery);
			
			pst.setInt(1,patient.getAge());
			pst.setString(2,patient.getMobileNo());
			pst.setString(3,patient.getAddress());
			pst.setInt(4,patient.getCardId());
			//executing PreparedStatment
			pst.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		


	}

	@Override
	public void deletePatientDetails(PatientDetails patient) {
		// TODO Auto-generated method stub
		//creating PreparedStatment
		PreparedStatement pst;
		try {
			//connecting to database
			Connection connection=DBConnection.getConnection();
			//generating SqlQuery
			String sqlQuery="delete from "+TABLEpatientDetails+" where "+COLcardId+"=?";
			pst = connection.prepareStatement(sqlQuery);
			
			pst.setInt(1,patient.getCardId());
			//executing PreparedStatment
			pst.executeUpdate();
			
			allPatientList.remove(patient);
			
//			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

	}

}
