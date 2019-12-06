package com.oracle.unittesting.unittesting.business;


import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

import static org.mockito.Mockito.*;

class ListTestClass {
	
	List<String> mock = mock(List.class);
	
	@Test
	void size_return_multipleValues() {
		 when(mock.size()).thenReturn(5).thenReturn(10);
		 assertEquals(5, mock.size());
		 assertEquals(10, mock.size());
	}
	
	@Test
	void size_basic() {
		 
		 when(mock.size()).thenReturn(5);
		 assertEquals(5, mock.size());
	}

	@Test
	void return_withParameters() {
		when(mock.get(0)).thenReturn("test string");
		 assertEquals("test string", mock.get(0));
	}
	
	@Test
	void return_withGenericParameters() { // anyInt() argument matcher
		when(mock.get(anyInt())).thenReturn("test string");
		 assertEquals("test string", mock.get(0));
		 assertEquals("test string", mock.get(1));
	}

	
	@Test
	void method_call_verification() {  
		
		//SUT
		String value1 = mock.get(0);
		String value2 = mock.get(1);
		
		
		// verify a specific  method call
		verify(mock).get(0);
		verify(mock, times(2)).get(anyInt());
		verify(mock, atLeast(1)).get(anyInt()); //check that this was called at least 1 time
		verify(mock, atMost(2)).get(anyInt());
		verify(mock, never()).get(2);
		verify(mock, atLeastOnce()).get(anyInt()); 
 
	}
	
//	
//	@Test
//	void argument_capture() {  
//		 //SUT
//		 mock.add("Something");
//		 //verification
//		 ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
//		 // now, capture the argument passed to the method
//		 verify(mock).add(captor.capture());
//		 assertEquals("Something", captor.getAllValues());
//	}
//	
	@Test
	void multiple_argument_capture() {  
		 //SUT
		 mock.add("Something1");
		 mock.add("Something2");
		 
		 //verification
		 ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
		 // now, capture the argument passed to the method
		 verify(mock, times(2)).add(captor.capture());
		 List<String> allValues = captor.getAllValues();
		 
		 
		 assertEquals("Something1", allValues.get(0));
		 assertEquals("Something2", allValues.get(1));
	}
	
	
	@Test
	public void with_mock() {
		ArrayList arrayListMock = mock(ArrayList.class);
		System.out.println(arrayListMock.get(0)); //null
		System.out.println(arrayListMock.size()); //0
		arrayListMock.add("test");
		arrayListMock.add("test 2");
		System.out.println(arrayListMock.size());//0
		when(arrayListMock.size()).thenReturn(5); 
		System.out.println(arrayListMock.size());//4
		
		 
	}
	
	
	@Test
	public void with_spying() {
		// spy used the real class 
		//
		//you use a sky when you want to use the real dependency. 
		// ie: let the real world action happen, but keep an watch in it
		
		ArrayList arrayListMock = spy(ArrayList.class);
		System.out.println(arrayListMock.get(0)); //null
		System.out.println(arrayListMock.size()); //0
		arrayListMock.add("test");
		arrayListMock.add("test 2");
		System.out.println(arrayListMock.size());//0
		when(arrayListMock.size()).thenReturn(5); 
		System.out.println(arrayListMock.size());//4
		
		
		
	}
}








