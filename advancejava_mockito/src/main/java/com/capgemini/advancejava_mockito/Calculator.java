package com.capgemini.advancejava_mockito;

public class Calculator {
	
	private MathService mathService;

	/**
	 * @param mathService
	 */
	public Calculator(MathService mathService) {
		this.mathService = mathService;
	}
	
	public int add(int a,int b) {
		return mathService.add(a, b);
	}
	

}
