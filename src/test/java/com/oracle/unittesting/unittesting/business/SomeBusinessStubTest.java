package com.oracle.unittesting.unittesting.business;

import static org.junit.jupiter.api.Assertions.*;
 

import org.junit.jupiter.api.Test;

import com.oracle.unittesting.unittesting.data.ISomeDataservice;

 class SomeDataServiceStub implements ISomeDataservice{
	@Override
	public int[] retriveAllData() {
		// TODO Auto-generated method stub
		return new int[] {1,2,3};
	}
 }

public class SomeBusinessStubTest {

	 
	private ISomeDataservice someDataservice;
	private SomeBusinessImpl biz = new SomeBusinessImpl();
	
	@Test 
	public void calculateSumUsindDataService_baic() {

		biz.setSomeDataService(new SomeDataServiceStub());
		int actualResult =  biz.calculateSum_dataService();
		int expectedResult = 6;
		assertEquals(expectedResult, actualResult);
		
	}
	
	@Test
	public void calculateSum_empty() {
	 
		biz.setSomeDataService(new SomeDataServiceStub());
		int actualResult =  biz.calculateSum_dataService();
		int expectedResult = 0;
		assertEquals(expectedResult, actualResult);
		
	}
 


}
