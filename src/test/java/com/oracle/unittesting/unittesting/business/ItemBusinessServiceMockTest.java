package com.oracle.unittesting.unittesting.business;

import com.oracle.unittesting.unittesting.business.ItemBusinessService;
import com.oracle.unittesting.unittesting.data.ItemRepository;
import com.oracle.unittesting.unittesting.model.Item;
import org.aspectj.bridge.ILifecycleAware;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.awt.print.Pageable;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
@RunWith(MockitoJUnitRunner.class)
public class ItemBusinessServiceMockTest {

	 
	@InjectMocks
	private ItemBusinessService business;
	@Mock
	private ItemRepository repository;
	

	// test the web layer - controller
	@Test
	public void retrieveAllItems_fromController() {

	    when(repository.findAll()).thenReturn( Arrays.asList(new Item(1, "Item1", 10,10),
                new Item(2, "Item2", 20,20)));


        List<Item> items = business.retrieveAllItems();
        assertEquals(100, items.get(0).getValue());
        assertEquals(400, items.get(1).getValue());


	}

 


}
