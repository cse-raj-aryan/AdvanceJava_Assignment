/**
 * 
 */
package com.capgemini.advancejava_usecase;

/**
 * 
 */
public class Employee {
	
	int employeeId;
	String name;
	String department;
	String designation;
	double salary;
	int yearOfExperience;

	/**
	 * @param employeeId
	 * @param name
	 * @param department
	 * @param designation
	 * @param salary
	 * @param yearOfExperience
	 */
	public Employee(int employeeId, String name, String department, String designation, double salary,
			int yearOfExperience) {
		super();
		this.employeeId = employeeId;
		this.name = name;
		this.department = department;
		this.designation = designation;
		this.salary = salary;
		this.yearOfExperience = yearOfExperience;
	}
	/**
	 * @return the employeeId
	 */
	public int getEmployeeId() {
		return employeeId;
	}
	/**
	 * @param employeeId the employeeId to set
	 */
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the department
	 */
	public String getDepartment() {
		return department;
	}
	/**
	 * @param department the department to set
	 */
	public void setDepartment(String department) {
		this.department = department;
	}
	/**
	 * @return the designation
	 */
	public String getDesignation() {
		return designation;
	}
	/**
	 * @param designation the designation to set
	 */
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	/**
	 * @return the salary
	 */
	public double getSalary() {
		return salary;
	}
	/**
	 * @param salary the salary to set
	 */
	public void setSalary(double salary) {
		this.salary = salary;
	}
	/**
	 * @return the yearOfExperience
	 */
	public int getYearOfExperience() {
		return yearOfExperience;
	}
	/**
	 * @param yearOfExperience the yearOfExperience to set
	 */
	public void setYearOfExperience(int yearOfExperience) {
		this.yearOfExperience = yearOfExperience;
	}
	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", name=" + name + ", department=" + department + ", designation="
				+ designation + ", salary=" + salary + ", yearOfExperience=" + yearOfExperience + "]";
	}
	
	
}
