package com.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Repository.EmployeeRepository;
import com.Repository.LeaveApplicationRepository;
import com.entity.Employee;
import com.entity.LeaveApplication;

@Service
public class LeaveApplicationService {

    @Autowired
    LeaveApplicationRepository lresp;
    @Autowired
    EmployeeRepository emprep;

    // Apply Leave
    public String employeelive(int empid,LeaveApplication l) {
    	
    	 // fetch employee from database
        Employee emp = emprep.findById(empid).orElse(null);

        if(emp == null) {
            return "Employee not found";
        }

        // set employee inside leave
        l.setEmployee(emp);

        // save leave
        
        lresp.save(l);
        return "Leave applied successfully";
    }

    // Get all leaves
    public List<LeaveApplication> findallleave() {
        return lresp.findAll();
    }

    // Get leave by employee id
    public List<LeaveApplication> findByEmpid(int empid) {
        return lresp.findByEmployeeEmpid(empid);
    }


    // UPDATE FULL LEAVE DETAILS
    public String updateLeave(int leaveid, LeaveApplication updatedLeave) {

        Optional<LeaveApplication> optionalLeave = lresp.findById(leaveid);

        if (optionalLeave.isPresent()) {

            LeaveApplication existingLeave = optionalLeave.get();

            existingLeave.setFromdate(updatedLeave.getFromdate());;
            existingLeave.setTodate(updatedLeave.getTodate());
            existingLeave.setReason(updatedLeave.getReason());
            existingLeave.setStatus(updatedLeave.getStatus());

            lresp.save(existingLeave);

            return "Leave updated successfully";
        } else {
            return "Leave ID not found";
        }
    }

    // UPDATE ONLY STATUS (Approve / Reject)
    public String updateLeaveStatus(int leaveid, String status) {

        Optional<LeaveApplication> optionalLeave = lresp.findById(leaveid);

        if (optionalLeave.isPresent()) {

            LeaveApplication leave = optionalLeave.get();

            leave.setStatus(status);

            lresp.save(leave);

            return "Leave status updated successfully";
        } else {
            return "Leave ID not found";
        }
    }

    // CANCEL LEAVE
    public String cancelLeave(int leaveid) {

        Optional<LeaveApplication> optionalLeave = lresp.findById(leaveid);

        if (optionalLeave.isPresent()) {

            LeaveApplication leave = optionalLeave.get();

            leave.setStatus("Cancelled");

            lresp.save(leave);

            return "Leave cancelled successfully";
        } else {
            return "Leave ID not found";
        }
    }

}
