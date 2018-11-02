package com.model;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class PatientDetails {
	private int cardId,age;
	private String patientName,address,mobileNo;
	
	public PatientDetails() {
		super();
	}

	public PatientDetails(int cardId, String patientName, int age,String mobileNo,String address) {
		super();
		this.cardId = cardId;
		this.age = age;
		this.patientName = patientName;
		this.address = address;
		this.mobileNo = mobileNo;
		
	}

	

	public PatientDetails( String patientName,int age, String mobileNo,String address) {
		super();
		this.age = age;
		this.patientName = patientName;
		this.address = address;
		this.mobileNo = mobileNo;
	}

	public int getCardId() {
		return cardId;
	}
	public void setCardId(int cardId) {
		this.cardId = cardId;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getPatientName() {
		return patientName;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	@Override
	public String toString() {
		return "PatientDetails [cardId=" + cardId + ", age=" + age + ", patientName=" + patientName + ", address="
				+ address + ", mobileNo=" + mobileNo + "]";
	}
	
	
	
	}

