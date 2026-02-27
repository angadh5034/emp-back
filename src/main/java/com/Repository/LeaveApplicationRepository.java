package com.Repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.entity.LeaveApplication;

public interface LeaveApplicationRepository extends JpaRepository <LeaveApplication,Integer>{
	
	
//@Query(value="select * from LeaveApplication where employee_id=:empid",nativeQuery=true)
//List<LeaveApplication> findByEmployeeEmpid (int empid);
	@Query(value = "select * from leave_application where employee_id = :empid", nativeQuery = true)
	List<LeaveApplication> findByEmployeeEmpid(@Param("empid") int empid);



}
