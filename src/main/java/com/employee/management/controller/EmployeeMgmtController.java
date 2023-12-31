package com.employee.management.controller;

import com.employee.management.request.UpdateEmployeeRequest;
import com.employee.management.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employee.management.request.EmployeeCreationRequest;

import java.util.HashMap;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/employee")
public class EmployeeMgmtController {
	
	
	@Autowired
    EmployeeService employeeService;
	
    @PostMapping(value = "/create-employee")
    public CompletableFuture<HashMap<String, Object>> addEmployee(
        @RequestBody EmployeeCreationRequest employeeCreationRequest) {
        return employeeService.createEmployee(employeeCreationRequest);
    }
	
    
    @GetMapping(value = "/get-employee/{employeeId}")
    public CompletableFuture<HashMap<String, Object>> getEmployeeDetails(
        @PathVariable String employeeId) {
        return employeeService.getEmployeeDetails(employeeId);
    }


    @PutMapping(value = "/update-employee/{employeeId}")
    public CompletableFuture<HashMap<String, Object>> updateEmployeeDetails(
            @PathVariable String employeeId, @RequestBody UpdateEmployeeRequest request ) {
        return employeeService.updateEmployeeDetails(employeeId,request);
    }


    @DeleteMapping(value = "/delete-employee/{employeeId}")
    public CompletableFuture<HashMap<String, Object>> deleteEmployeeDetails(
            @PathVariable String employeeId) {
        return employeeService.deleteEmployee(employeeId);
    }
}
