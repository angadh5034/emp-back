package com.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Employee {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)

int empid;
String firstname;
String middelname;
String lastname;
String gender;
String email;
LocalDate dob;
long contactno;
long adharno;
String panno;
String address;
String profile;
int exp;
double salary;
LocalDate joiningdate;
String designation;
String worklocatin;
String status;
String reportingmaneger;
String department;

@OneToMany(mappedBy = "employee", cascade = CascadeType.ALL, orphanRemoval = true)
@JsonIgnoreProperties("employee")

List<LeaveApplication> leavelist = new ArrayList<>();
//public List<LeaveApplication> leaveapplication;

public Employee() {
	super();
}
public int getEmpid() {
	return empid;
}
public void setEmpid(int empid) {
	this.empid = empid;
}
public String getFirstname() {
	return firstname;
}
public void setFirstname(String firstname) {
	this.firstname = firstname;
}
public String getMiddelname() {
	return middelname;
}
public void setMiddelname(String middelname) {
	this.middelname = middelname;
}
public String getLastname() {
	return lastname;
}
public void setLastname(String lastname) {
	this.lastname = lastname;
}
public String getGender() {
	return gender;
}
public void setGender(String gender) {
	this.gender = gender;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public LocalDate getDob() {
	return dob;
}
public void setDob(LocalDate dob) {
	this.dob = dob;
}
public long getContactno() {
	return contactno;
}
public void setContactno(long contactno) {
	this.contactno = contactno;
}
public long getAdharno() {
	return adharno;
}
public void setAdharno(long adharno) {
	this.adharno = adharno;
}
public String getPanno() {
	return panno;
}
public void setPanno(String panno) {
	this.panno = panno;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public String getProfile() {
	return profile;
}
public void setProfile(String profile) {
	this.profile = profile;
}
public int getExp() {
	return exp;
}
public void setExp(int exp) {
	this.exp = exp;
}
public double getSalary() {
	return salary;
}
public void setSalary(double salary) {
	this.salary = salary;
}
public LocalDate getJoiningdate() {
	return joiningdate;
}
public void setJoiningdate(LocalDate joiningdate) {
	this.joiningdate = joiningdate;
}
public String getDesignation() {
	return designation;
}
public void setDesignation(String designation) {
	this.designation = designation;
}
public String getWorklocatin() {
	return worklocatin;
}
public void setWorklocatin(String worklocatin) {
	this.worklocatin = worklocatin;
}
public String getStatus() {
	return status;
}
public void setStatus(String status) {
	this.status = status;
}
public String getReportingmaneger() {
	return reportingmaneger;
}
public void setReportingmaneger(String reportingmaneger) {
	this.reportingmaneger = reportingmaneger;
}
public String getDepartment() {
	return department;
}
public void setDepartment(String department) {
	this.department = department;
}

}
