package com.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Service.EmployeeService;
import com.entity.Employee;



@RestController
@CrossOrigin
@RequestMapping("/Employee")
public class EmployeeController{
@Autowired
EmployeeService empservice;

@PostMapping("/addemp")
public String addemployee(@RequestBody Employee e) {
    return empservice.addEmployee(e);
}


@GetMapping("/getemp")
public List<Employee> getallEmployee()
{
    return empservice.getAllEmployees();	
}


@GetMapping("/empid/{id}")
public Employee getEmployeeById(@PathVariable int id)
{
    return empservice.getEmployeeById(id);
}

// 🔎 Find by First Name
@GetMapping("/firstname/{firstname}")
public List<Employee> findByFirstname(@PathVariable String firstname) {
    return empservice.findbyfirstname(firstname);
}

// 🔎 Find by Last Name
@GetMapping("/lastname/{lastname}")
public List<Employee> findByLastname(@PathVariable String lastname) {
    return empservice.findbylastname(lastname);
}

// 🔎 Find by Department
@GetMapping("/department/{department}")
public List<Employee> findByDepartment(@PathVariable String department) {
    return empservice.findbydepartment(department);
}

// 🔎 Find by Designation
@GetMapping("/designation/{designation}")
public List<Employee> findByDesignation(@PathVariable String designation) {
    return empservice.findbydesignation(designation);
}

// ✅ UPDATE Employee BY ID
@PutMapping("/update/{empid}")
public String updateEmployee(
        @PathVariable int empid,
        @RequestBody Employee newemp) {

    return empservice.updateEmployeeById(empid, newemp);
}

// ✅ DELETE Employee BY ID
@DeleteMapping("/delete/{empid}")
public String deleteEmployee(@PathVariable int empid) {

    return empservice.deleteEmployeeById(empid);
}


}
