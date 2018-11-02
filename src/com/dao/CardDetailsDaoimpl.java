package com.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.main.DBConnection;
import com.model.CardDetails;

public class CardDetailsDaoimpl implements CardDetailsDao {

	private static List<CardDetails> allCardList = new ArrayList<CardDetails>();

	@Override
	public CardDetails getCardDetails(int cardId) {
		// TODO Auto-generated method stub
		try {

			CardDetails dummyCard = new CardDetails();
			dummyCard.setPatient(new PatientDetailsDaoimpl()
					.getPatientDetails(cardId));

			if (allCardList.contains(dummyCard)) {

				int index = allCardList.indexOf(dummyCard);
				return allCardList.get(index);
			}
			// connecting to database
			Connection connection = DBConnection.getConnection();
			// generating SqlQuery
			String sqlQuery = "select * from " + TABLEcardDetails + " where "
					+ COLcardId + "=" + "?";
			// creating PreparedStatment
			PreparedStatement pst = connection.prepareStatement(sqlQuery);
			pst.setInt(1, cardId);
			// executing PreparedStatment
			pst.executeQuery();
			// creating resultset
			ResultSet rs = pst.getResultSet();

			if (rs.next() == false) {
				return null;
			}

			int cardid = rs.getInt(COLcardId);
			Date issuedate = rs.getDate(COLissueDate);
			Date duedate = rs.getDate(COLdueDate);

			CardDetails cardDetails = new CardDetails(
					new PatientDetailsDaoimpl().getPatientDetails(cardid),
					issuedate, duedate);
			allCardList.add(cardDetails);
			return cardDetails;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public List<CardDetails> getAllCardDetails() {
		// TODO Auto-generated method stub
		allCardList = new ArrayList<CardDetails>();
		try {
			// connecting to database

			Connection connection = DBConnection.getConnection();
			// generating SqlQuery
			String sqlQuery = "select * from " + TABLEcardDetails;
			// creating PreparedStatment
			PreparedStatement pst = connection.prepareStatement(sqlQuery);
			// executing PreparedStatment
			pst.executeQuery();
			// creating resultset
			ResultSet rs = pst.getResultSet();

			while (rs.next()) {
				int cardid = rs.getInt(COLcardId);
				Date issuedate = rs.getDate(COLissueDate);
				Date duedate = rs.getDate(COLdueDate);

				CardDetails cardDetails = new CardDetails(
						new PatientDetailsDaoimpl().getPatientDetails(cardid),
						issuedate, duedate);
				allCardList.add(cardDetails);

			}

			return allCardList;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public void addCardDetail(CardDetails cardDetails)
			throws CardDetailsExistsException {
		// TODO Auto-generated method stub
		// creating PreparedStatment
		PreparedStatement pst;
		try {
			// connecting to database

			Connection connection = DBConnection.getConnection();
			// generating SqlQuery
			String sqlQuery = "insert into " + TABLEcardDetails
					+ " values(?,?,?)";
			pst = connection.prepareStatement(sqlQuery);
			pst.setInt(1, cardDetails.getPatient().getCardId());
			pst.setDate(2, cardDetails.getIssueDate());
			pst.setDate(3, cardDetails.getDueDate());
			// executing PreparedStatment
			pst.executeUpdate();
			allCardList.add(cardDetails);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void updateCardDetails(CardDetails cardDetails) {
		// TODO Auto-generated method stub
		// creating PreparedStatment
		PreparedStatement pst;
		try {
			// connecting to database

			Connection connection = DBConnection.getConnection();
			// generating SqlQuery
			String sqlQuery = "update " + TABLEcardDetails + " set "
					+ COLissueDate + "=?" + "," + COLdueDate + "=?" + " where "
					+ COLcardId + "=?";
			pst = connection.prepareStatement(sqlQuery);

			pst.setDate(1, cardDetails.getIssueDate());
			pst.setDate(2, cardDetails.getDueDate());
			pst.setInt(3, cardDetails.getPatient().getCardId());
			// executing PreparedStatment
			pst.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void deleteCardDetails(CardDetails cardDetails) {
		// TODO Auto-generated method stub
		// creating PreparedStatment
		PreparedStatement pst;
		try {
			// connecting to database

			Connection connection = DBConnection.getConnection();
			// generating SqlQuery
			String sqlQuery = "delete from " + TABLEcardDetails + " where "
					+ COLcardId + "=?";
			pst = connection.prepareStatement(sqlQuery);

			pst.setInt(1, cardDetails.getPatient().getCardId());
			// executing PreparedStatment
			pst.executeUpdate();

			allCardList.remove(cardDetails);

			//
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
