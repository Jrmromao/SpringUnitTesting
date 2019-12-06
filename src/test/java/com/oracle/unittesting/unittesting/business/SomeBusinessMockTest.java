package com.oracle.unittesting.unittesting.business;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.oracle.unittesting.unittesting.data.ISomeDataservice;

import org.mockito.junit.jupiter.MockitoExtension;


@ExtendWith(MockitoExtension.class)
@RunWith(MockitoJUnitRunner.class)
public class SomeBusinessMockTest {

	 
	@InjectMocks
	SomeBusinessImpl biz = new SomeBusinessImpl();
	
	@Mock
	ISomeDataservice dataserviceMock;
	
	
	@BeforeEach
	public void before() {
		biz.setSomeDataService(dataserviceMock);
	}	
	
	@Test 
	public void calculateSumUsindDataService_baic() {
		when(dataserviceMock.retriveAllData()).thenReturn(new int[] {1,2,3});
		assertEquals(6, biz.calculateSum_dataService());
	}
	
	@Test
	public void calculateSum_empty() {
		when(dataserviceMock.retriveAllData()).thenReturn(new int[] {});
		assertEquals(0, biz.calculateSum_dataService());
	}
	
	@Test
	public void calculateSum_returnOne() {
		when(dataserviceMock.retriveAllData()).thenReturn(new int[] {1});
		assertEquals(1, biz.calculateSum_dataService());
		
	}
	
 


}
