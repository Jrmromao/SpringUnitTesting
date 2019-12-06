package com.oracle.unittesting.unittesting.business;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

class ListTestClass {
	
	List mock = mock(List.class);
	
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
		when(mock.get(0)).thenReturn("oracle interview");
		 assertEquals("oracle interview", mock.get(0));
		 
	}
}










