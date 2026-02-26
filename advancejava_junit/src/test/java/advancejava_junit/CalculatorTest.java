/**
 * 
 */
package advancejava_junit;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import com.capgemini.advancejava_junit.Calculator;

/**
 * 
 */
public class CalculatorTest {
	private Calculator cal;
	
	@BeforeEach
	void setUp() {
		cal=new Calculator();
	}
	
	@Test
	public void testTwoAndTwoGivesFour() {
		assertEquals(4,cal.sum(2, 2));
	}
	
	@Test
	public void minus() {
		assertEquals(2,cal.subtract(5, 3));
	}
	
	@Test
	public void multi() {
		assertEquals(6,cal.mul(2, 3));
	}
	
	@Test
	public void divi() {
		assertEquals(4,cal.div(8, 2));
	}
	
	@RepeatedTest(56)
	@DisplayName("Test sum with repeated execution")
	void testSumRepeated() {
		assertEquals(10,cal.sum(5, 5));
	}
	
	
	
	@Nested
	@DisplayName("Subtraction Tests")
	class SubtractionTests{
		@Test
		@DisplayName("Test subtraction of two numbers")
		void testSubtraction() {
			assertEquals(1,cal.subtract(5, 4));
		}
	}
	
	
	@ParameterizedTest
	@ValueSource(ints= {1,2,3,4,5})
	@DisplayName("Test multiplication of numbers by 2")
	void testMultiplyByTwo(int number) {
		assertEquals(number*2,cal.mul(number,2));
	}
	
	
	@ParameterizedTest
	@CsvSource({"2,2,4","2,3,6","4,4,16"})
	void testMultiply(int x,int y,int expected) {
		assertEquals(expected,cal.mul(x, y));
	}

	
	
}
