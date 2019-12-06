package com.oracle.unittesting.unittesting.business;

import static org.junit.jupiter.api.Assertions.*;
 

import org.junit.jupiter.api.Test;

 

public class SomeBusinessTest {

	@Test
	public void calculateSum_baic() {
		SomeBusinessImpl biz = new SomeBusinessImpl();
		int actualResult = biz.calculateSum(new int[] {1,2,3});
		int expectedResult = 6;
		assertEquals(expectedResult, actualResult);
		
	}
	@Test
	public void calculateSum_empty() {
		SomeBusinessImpl biz = new SomeBusinessImpl();
		int actualResult = biz.calculateSum(new int[] {});
		int expectedResult = 0;
		assertEquals(expectedResult, actualResult);
		
	}

}
