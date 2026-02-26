/**
 * 
 */
package com.capgemini.advancejava_usecase;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
/**
 * 
 */
import java.util.Scanner;
public class EmployeeManagement {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		List<Employee> employees=new ArrayList<>();
		employees.add(new Employee(1,"RAJ","CSE","DEVELOPER",55000,5));
		employees.add(new Employee(2,"MADAN","IT","ENGINEER",82000,6));
		employees.add(new Employee(3,"ADITYA","CSE","BACKEND DEVELOPER",50000,4));
		employees.add(new Employee(4,"AYUSH","HR","EXECUTIVE",45000,3));
		employees.add(new Employee(5,"MADHU","FINANCE","ANALYST",95000,6));
		
		//1Calculate average salary..
		double averageSalary = employees.stream()
		        .mapToDouble(Employee::getSalary)
		        .average()
		        .orElse(0.0);

		System.out.println("Average Salary: " + averageSalary);
		
		
		
	
		//2..calculating highest salary
		Employee highestPaidEmployee = employees.stream()
		        .max(Comparator.comparingDouble(Employee::getSalary))
		        .orElse(null);

		System.out.println("Highest Paid Employee: " + highestPaidEmployee);
			

	}

}
