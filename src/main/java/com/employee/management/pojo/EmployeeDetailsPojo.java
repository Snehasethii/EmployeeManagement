package com.employee.management.pojo;


import com.employee.management.dao.rdbms.Employee;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmployeeDetailsPojo {

    private String firstName;

    private String lastName;

    private String mobile;

    private String email;

    private String designation;

    private String employeeId;


    public static EmployeeDetailsPojo from(Employee employee){

        EmployeeDetailsPojo employeeDetailsPojo = EmployeeDetailsPojo.builder()
                .employeeId(employee.getEmployeeId())
                .firstName(employee.getFirstName())
                .lastName(employee.getLastName())
                .email(employee.getEmail())
                .designation(employee.getDesignation())
                .mobile(employee.getMobile())
                .build();
        return employeeDetailsPojo;
    }

}
