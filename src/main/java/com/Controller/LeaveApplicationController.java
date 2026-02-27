package com.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.Service.LeaveApplicationService;
import com.entity.LeaveApplication;

@RestController
@CrossOrigin
public class LeaveApplicationController {

    @Autowired
    LeaveApplicationService service;

    // Apply leave
    @PostMapping("/applyleave/{empid}")
    public String applyLeave(@PathVariable int empid,
                             @RequestBody LeaveApplication leave) {

        return service.employeelive(empid, leave);
    }

    // Get all leave
    @GetMapping("/getallleave")
    public List<LeaveApplication> getAllLeave() {
        return service.findallleave();
    }

    // Get leave by empid
    @GetMapping("/getleave/{empid}")
    public List<LeaveApplication> getLeaveByEmpid(@PathVariable int empid) {
        return service.findByEmpid(empid);
    }


    // Update full leave
    @PutMapping("/updateleave/{leaveid}")
    public String updateLeave(
            @PathVariable int leaveid,
            @RequestBody LeaveApplication leave) {

        return service.updateLeave(leaveid, leave);
    }

    // Update leave status (Approve / Reject)
    @PutMapping("/updateleavestatus/{leaveid}/{status}")
    public String updateLeaveStatus(
            @PathVariable int leaveid,
            @PathVariable String status) {

        return service.updateLeaveStatus(leaveid, status);
    }

    // Cancel leave
    @PutMapping("/cancelleave/{leaveid}")
    public String cancelLeave(@PathVariable int leaveid) {

        return service.cancelLeave(leaveid);
    }

}
