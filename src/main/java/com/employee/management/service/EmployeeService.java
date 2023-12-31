package com.employee.management.service;

import com.employee.management.request.EmployeeCreationRequest;
import com.employee.management.request.UpdateEmployeeRequest;
import com.employee.management.repository.EmployeeRepository;
import com.employee.management.dao.rdbms.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Optional;
import java.util.Random;
import java.util.concurrent.CompletableFuture;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public CompletableFuture<HashMap<String, Object>> createEmployee(EmployeeCreationRequest request) {
        return CompletableFuture.supplyAsync(() -> {
            String employeeId = generateUniqueId("EMP");
            Employee employee = Employee.builder()
                    .employeeId(employeeId)
                    .designation(request.getDesignation())
                    .firstName(request.getFirstName())
                    .lastName(request.getLastName())
                    .email(request.getEmail())
                    .mobile(request.getMobile())
                    .build();

            employeeRepository.save(employee);

            HashMap<String, Object> response = new HashMap<>();
            response.put("employeeId", employeeId);
            response.put("message", "Employee is created successfully!");
            return response;
        });
    }

    public CompletableFuture<HashMap<String, Object>> getEmployeeDetails(String employeeId) {
        return CompletableFuture.supplyAsync(() -> {
            Optional<Employee> employeeOpt = employeeRepository.findByEmployeeId(employeeId);
            HashMap<String, Object> response = new HashMap<>();

            if (employeeOpt.isEmpty()) {
                response.put("message", "Employee Does not exist!");
                return response;
            }

            Employee employee = employeeOpt.get();
            response.put("employeeId", employeeId);
            response.put("firstName", employee.getFirstName());
            response.put("lastName", employee.getLastName());
            response.put("email", employee.getEmail());
            response.put("mobile", employee.getMobile());
            response.put("designation", employee.getDesignation());

            return response;
        });
    }

    public CompletableFuture<HashMap<String, Object>> updateEmployeeDetails(String employeeId, UpdateEmployeeRequest request) {
        return CompletableFuture.supplyAsync(() -> {
            Optional<Employee> employeeOpt = employeeRepository.findByEmployeeId(employeeId);
            HashMap<String, Object> response = new HashMap<>();

            if (employeeOpt.isEmpty()) {
                response.put("message", "Employee Does not exist!");
                return response;
            }

            Employee employee = employeeOpt.get();
            employee.setDesignation(request.getDesignation());
            employee.setMobile(request.getMobile());
            employeeRepository.save(employee);

            response.put("message", "Employee details updated successfully!");
            return response;
        });
    }

    public CompletableFuture<HashMap<String, Object>> deleteEmployee(String employeeId) {
        return CompletableFuture.supplyAsync(() -> {
            Optional<Employee> employeeOpt = employeeRepository.findByEmployeeId(employeeId);
            HashMap<String, Object> response = new HashMap<>();

            if (employeeOpt.isEmpty()) {
                response.put("message", "Employee Does not exist!");
                return response;
            }

            Employee employee = employeeOpt.get();
            employeeRepository.deleteById(employee.getId());

            response.put("message", "Employee details are deleted successfully!");
            return response;
        });
    }

    public String generateUniqueId(String attr) {
        Random random = new Random();
        long randomNumber = 1000 + random.nextInt(9000);
        return attr + randomNumber;
    }
}
