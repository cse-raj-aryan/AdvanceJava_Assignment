/**
 * 
 */
package com.capgemnini.advancejava_junit_student;

/**
 * 
 */
public class Student {

	int studentId;
	String name;
	int subject1;
	int subject2;
	int subject3;
	/**
	 * @param studentId
	 * @param name
	 * @param subject1
	 * @param subject2
	 * @param subject3
	 */
	public Student(int studentId, String name, int subject1, int subject2, int subject3) {
		super();
		this.studentId = studentId;
		this.name = name;
		this.subject1 = subject1;
		this.subject2 = subject2;
		this.subject3 = subject3;
	}
	/**
	 * @return the studentId
	 */
	public final int getStudentId() {
		return studentId;
	}
	/**
	 * @return the name
	 */
	public final String getName() {
		return name;
	}
	/**
	 * @return the subject1
	 */
	public final int getSubject1() {
		return subject1;
	}
	/**
	 * @return the subject2
	 */
	public final int getSubject2() {
		return subject2;
	}
	/**
	 * @return the subject3
	 */
	public final int getSubject3() {
		return subject3;
	}
	
}
