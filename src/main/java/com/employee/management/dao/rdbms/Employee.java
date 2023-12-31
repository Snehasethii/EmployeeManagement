package com.employee.management.dao.rdbms;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "employee")
public class Employee {
		
		@Id
		@GeneratedValue(strategy =  GenerationType.IDENTITY)
		private long id;
		
		private String employeeId;

		private String firstName;
		
		private String lastName;
		
		private String email;

		private String designation;

		private String mobile;


}
