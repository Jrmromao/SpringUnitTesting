package com.oracle.unittesting.unittesting.business;

import com.oracle.unittesting.unittesting.data.ISomeDataservice;

public class SomeBusinessImpl {

	
	private ISomeDataservice someDataService;
	
	
	public void setSomeDataService(ISomeDataservice someDataService) {
		this.someDataService = someDataService;
	}

	public int calculateSum(int[] data) {
		int sum = 0;
		for(int val : data) {
			
			sum+=val;
		}
		return sum;
	}
	
	public int calculateSum_dataService() {
		int sum = 0;
		int[] data = someDataService.retriveAllData();
		for(int val : data) {
			
			sum+=val;
		}
		return sum;
	}
}
