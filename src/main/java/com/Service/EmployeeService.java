package com.Service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Repository.EmployeeRepository;
import com.entity.Employee;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class EmployeeService {

    @Autowired
    private EmployeeRepository eresp;

    // ✅ ADD Employee
    public String addEmployee(Employee e) {
        eresp.save(e);
        return "Employee added successfully";
    }

    // ✅ GET ALL EmployeeS
    public List<Employee> getAllEmployees() {
        return eresp.findAll();
    }

    // ✅ GET Employee BY ID
    public Employee getEmployeeById(int empid) {
        return eresp.findById(empid).orElse(null);
    }

    // ✅ UPDATE Employee BY ID
    public String updateEmployeeById(int empid, Employee newemp) {

        Employee existingemp = eresp.findById(empid).orElse(null);

        if (existingemp == null) {
            return "No matching record found";
        }

        if (
            newemp.getFirstname() == null &&
            newemp.getMiddelname() == null &&
            newemp.getLastname() == null &&
            newemp.getAddress() == null &&
            newemp.getAdharno() == 0 &&
            newemp.getContactno() == 0 &&
            newemp.getDepartment() == null &&
            newemp.getDesignation() == null &&
            newemp.getDob() == null &&
            newemp.getEmail() == null &&
            newemp.getReportingmaneger() == null &&
            newemp.getExp() == 0 &&
            newemp.getGender() == null &&
            newemp.getJoiningdate() == null &&
            newemp.getPanno() == null &&
            newemp.getProfile() == null &&
            newemp.getSalary() == 0.0 &&
            newemp.getStatus() == null &&
            newemp.getWorklocatin() == null
        ) {
            return "No fields provided to update";
        }

        if (newemp.getFirstname() != null)
            existingemp.setFirstname(newemp.getFirstname());

        if (newemp.getMiddelname() != null)
            existingemp.setMiddelname(newemp.getMiddelname());

        if (newemp.getLastname() != null)
            existingemp.setLastname(newemp.getLastname());

        if (newemp.getAddress() != null)
            existingemp.setAddress(newemp.getAddress());

        if (newemp.getAdharno() != 0)
            existingemp.setAdharno(newemp.getAdharno());

        if (newemp.getContactno() != 0)
            existingemp.setContactno(newemp.getContactno());

        if (newemp.getDesignation() != null)
            existingemp.setDesignation(newemp.getDesignation());
        
        if (newemp.getDepartment() != null)
            existingemp.setDepartment(newemp.getDepartment());

        if (newemp.getDob() != null)
            existingemp.setDob(newemp.getDob());

        if (newemp.getEmail() != null)
            existingemp.setEmail(newemp.getEmail());

        if (newemp.getReportingmaneger() != null)
            existingemp.setReportingmaneger(newemp.getReportingmaneger());

        if (newemp.getExp() != 0)
            existingemp.setExp(newemp.getExp());

        if (newemp.getGender() != null)
            existingemp.setGender(newemp.getGender());

        if (newemp.getJoiningdate() != null)
            existingemp.setJoiningdate(newemp.getJoiningdate());

        if (newemp.getPanno() != null)
            existingemp.setPanno(newemp.getPanno());

        if (newemp.getProfile() != null)
            existingemp.setProfile(newemp.getProfile());

        if (newemp.getSalary() != 0.0)
            existingemp.setSalary(newemp.getSalary());

        if (newemp.getStatus() != null)
            existingemp.setStatus(newemp.getStatus());
        
        if (newemp.getWorklocatin() != null)
            existingemp.setWorklocatin(newemp.getWorklocatin());


        eresp.save(existingemp);

        return "Employee updated successfully";
    }


    // ✅ DELETE Employee BY ID
    public String deleteEmployeeById(int empid) {
        if (!eresp.existsById(empid)) {
            return "Employee not found";
        }
        eresp.deleteById(empid);
        return "Employee deleted successfully";
    }
    
    public List<Employee>findbyfirstname(String firstname)
    {
    	return eresp.findByFirstname(firstname);
    	
    }
    
    public List<Employee>findbylastname(String lastname)
    {
    	return eresp.findByLastname(lastname);
    }
    
    public List<Employee>findbydepartment(String department)
    {
    	return eresp.findByDepartment(department);
    }
    public List<Employee>findbydesignation(String designation)
    {
    	return eresp.findByDesignation(designation);
    }
}
