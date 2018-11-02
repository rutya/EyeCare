package com.model;

public class OperationDetails {
String opeartionName;
String hospitalName;
int srNo;
public OperationDetails(String opeartionName, String hospitalName, int srNo) {
	super();
	this.opeartionName = opeartionName;
	this.hospitalName = hospitalName;
	this.srNo = srNo;
}
public OperationDetails() {
	super();
}
public String getOpeartionName() {
	return opeartionName;
}
public void setOpeartionName(String opeartionName) {
	this.opeartionName = opeartionName;
}
public String getHospitalName() {
	return hospitalName;
}
public void setHospitalName(String hospitalName) {
	this.hospitalName = hospitalName;
}
public int getSrNo() {
	return srNo;
}
public void setSrNo(int srNo) {
	this.srNo = srNo;
}
@Override
public String toString() {
	return "OperationDetails [opeartionName=" + opeartionName + ", hospitalName=" + hospitalName + ", srNo=" + srNo
			+ "]";
}


}
