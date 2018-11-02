package com.dao;

import java.util.List;

import com.model.CardDetails;
//creating inteface for storing AppoinmentDetails

public interface CardDetailsDao {
	
	String TABLEcardDetails="CardDetails",COLcardId="CardId",COLissueDate="IssueDate",COLdueDate="DueDate";
	//declaration of methods
	CardDetails getCardDetails(int cardId);
	
	List<CardDetails> getAllCardDetails();
	void addCardDetail(CardDetails cardDetails)throws CardDetailsExistsException;
	void updateCardDetails(CardDetails cardDetails);
	void deleteCardDetails(CardDetails cardDetails);


}
