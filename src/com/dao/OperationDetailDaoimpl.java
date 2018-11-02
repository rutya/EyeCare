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
import com.model.OperationDetails;

public class OperationDetailDaoimpl implements OperationDetailsDao 
{
	private static List<OperationDetails>allOperationDeatilsList=new ArrayList<OperationDetails>();
	@Override
	public List<OperationDetails> getOperationalDetails(String operationName) {
		try {
			
			
			

			allOperationDeatilsList=new ArrayList<OperationDetails>();
			OperationDetails dummyOpeartion=new OperationDetails();
			dummyOpeartion.setOpeartionName(operationName);
			
			if(allOperationDeatilsList.contains(dummyOpeartion))
			{
				
			int index=allOperationDeatilsList.indexOf(dummyOpeartion);
			return (List<OperationDetails>) allOperationDeatilsList.get(index);
			}
			//connecting to database
			Connection connection=DBConnection.getConnection();
			//generating SqlQuery
			String sqlQuery="select * from "+TABLEoperationDetails+" where "+COLoperationName+"="+"?";
			//creating PreparedStatment
			PreparedStatement pst=connection.prepareStatement(sqlQuery);
			pst.setString(1,operationName);
			//executing PreparedStatment
			pst.executeQuery();
			//creating resultset
			ResultSet rs=pst.getResultSet();
	
			while(rs.next()==true)
			{
				String operationname=rs.getString(COLoperationName);
				String hospitalname=rs.getString(COLhospitalName);
				int srNo = rs.getInt(COLsrNo);

			OperationDetails operationDetail=new OperationDetails(operationname,hospitalname,srNo);
			allOperationDeatilsList.add(operationDetail);
			}
			return allOperationDeatilsList;
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return null;
	}

	
	//display all records
	@Override
	public List<OperationDetails> getAllOpeartionDetails() {
		try {
			
			
			

			allOperationDeatilsList=new ArrayList<OperationDetails>();

			//connecting to database
			Connection connection=DBConnection.getConnection();
			//generating SqlQuery
			String sqlQuery="select * from "+TABLEoperationDetails;

			//creating PreparedStatment
			PreparedStatement pst=connection.prepareStatement(sqlQuery);
			//executing PreparedStatment
			pst.executeQuery();
			ResultSet rs=pst.getResultSet();
			//creating resultset
			while(rs.next()==true)
			{
				String operationname=rs.getString(COLoperationName);
				String hospitalname=rs.getString(COLhospitalName);
				int srNo = rs.getInt(COLsrNo);

			OperationDetails operationDetail=new OperationDetails(operationname,hospitalname,srNo);
			allOperationDeatilsList.add(operationDetail);
			}
			return allOperationDeatilsList;
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	//add record
	@Override
	public void addOperationDetails(OperationDetails operationDetails) {
		try {
			//connecting to database
			Connection connection=DBConnection.getConnection();
			//generating SqlQuery
			String sqlQuery="insert into "+TABLEoperationDetails+" values(?,?,?)";
			//creating PreparedStatment
			PreparedStatement pst = connection.prepareStatement(sqlQuery);
			
			pst.setString(1,operationDetails.getOpeartionName());
			pst.setString(2,operationDetails.getHospitalName());
			pst.setInt(3, operationDetails.getSrNo());
			//executing PreparedStatment
			pst.executeUpdate();
			allOperationDeatilsList.add(operationDetails);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	//@Override
//	public void updateOpeartionDetails(OperationDetails operationDetails) {
//		// TODO Auto-generated method stub
//		try {
//			Connection connection=DBConnection.getConnection();
//			String sqlQuery="update "+TABLEoperationDetails+" set "+COLhospitalName+"=?"+","+COLoperationName+"=?"+" where "+COLoperationName+"=?"+" and "+COLsrNo+"=?";
//			PreparedStatement pst = connection.prepareStatement(sqlQuery);
//			
//			pst.setInt(3,operationDetails.getSrNo());
//			pst.setString(2,operationDetails.getOpeartionName());
//			pst.setString(1,operationDetails.getHospitalName());
//			
//			 
//			pst.executeUpdate();
//			
//			
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}

	@Override
	public void deleteOpeartionDetails(OperationDetails opeartionDetails) 
	{
		// TODO Auto-generated method stub
		try {
			//connecting to database
			
			
			

			Connection connection=DBConnection.getConnection();
			//generating SqlQuery
			String sqlQuery="delete from "+TABLEoperationDetails+" where "+COLsrNo+"=?";
			//creating PreparedStatment
			PreparedStatement pst = connection.prepareStatement(sqlQuery);
			
			pst.setInt(1,opeartionDetails.getSrNo());

			//executing PreparedStatment
			pst.executeUpdate();
			
			allOperationDeatilsList.remove(opeartionDetails);
			
//			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}


	@Override
	public void updateOpeartionDetails(OperationDetails operationDetails) {
		// TODO Auto-generated method stub
		
	}

}
