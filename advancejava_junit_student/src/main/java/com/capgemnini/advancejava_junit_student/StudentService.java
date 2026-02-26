package com.capgemnini.advancejava_junit_student;

public class StudentService {
	
	 public int calculateTotal(Student student) {
	        return student.getSubject1()
	             + student.getSubject2()
	             + student.getSubject3();        

}
	 
	  public double calculateAverage(Student student) {
	        int total = calculateTotal(student);
	        return total / 3.0;
	    }
	  
	  public boolean isPassed(Student student) {
	        return calculateAverage(student) >= 40;
	    }
}
