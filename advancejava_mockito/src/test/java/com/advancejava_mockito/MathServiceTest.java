/**
 * 
 */
package com.advancejava_mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.capgemini.advancejava_mockito.Calculator;
import com.capgemini.advancejava_mockito.MathService;

/**
 * 
 */
@ExtendWith(MockitoExtension.class)
public class MathServiceTest {
	
	@Mock
	MathService mathService;
	
	@InjectMocks
	Calculator calculator;
	
	@Test
	void testAdd() {
		when(mathService.add(10,20)).thenReturn(30);
		assertEquals(30,calculator.add(10, 20));
		verify(mathService).add(10,20);
	}

}
