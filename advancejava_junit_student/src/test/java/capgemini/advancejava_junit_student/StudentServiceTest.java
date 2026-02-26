/**
 * 
 */
package capgemini.advancejava_junit_student;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.capgemnini.advancejava_junit_student.Student;
import com.capgemnini.advancejava_junit_student.StudentService;

/**
 * 
 */
public class StudentServiceTest {
	
	private StudentService service;
    private Student student;

    @BeforeEach
    void setUp() {
        service = new StudentService();
        student = new Student(101, "Raj", 80, 80, 80);
    }


    @Test
    void testCalculateTotalMarks() {
        int total = service.calculateTotal(student);
        assertEquals(240, total);
    }

   
    @Test
    void testCalculateAverageMarks() {
        double average = service.calculateAverage(student);
        assertEquals(80.0, average);
    }

   
    @Test
    void testStudentPass() {
        boolean result = service.isPassed(student);
        assertTrue(result);
    }

 
    @Test
    void testStudentFail() {
        Student failStudent = new Student(102, "Aman", 30, 35, 40);
        boolean result = service.isPassed(failStudent);
        assertFalse(result);
    }
    
   

}
