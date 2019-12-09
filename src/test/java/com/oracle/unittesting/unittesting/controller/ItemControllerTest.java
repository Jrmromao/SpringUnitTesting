package com.oracle.unittesting.unittesting.controller;

import com.oracle.unittesting.unittesting.business.ItemBusinessService;
import com.oracle.unittesting.unittesting.model.Item;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.lang.reflect.Array;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@WebMvcTest(value=ItemController.class)
class ItemControllerTest {

	// the spring bean
	@Autowired
	private MockMvc mockMvc;
	@MockBean
	private ItemBusinessService businessService;
	
	
	@Test
	public void dummyItem_baic() throws Exception{
	    // call uri GET application/jeson
        // in response, i want the hello-world string
		RequestBuilder request = MockMvcRequestBuilders
				.get("/dummy-item")
				.accept(MediaType.APPLICATION_JSON);
		
		MvcResult result = mockMvc.perform(request)
				.andExpect(status().isOk()).andExpect(content().json("{\"id\":1,\"name\":\"Ball\",\"price\":10,\"quantity\":100}")).andReturn();

	}


	@Test
	public void itemFromBusinessService_basic() throws Exception{
	    // use mockito
        when(businessService.retrieveHardcodedItem()).thenReturn(
                new Item(2, "Item2", 10,10)
        );
		// call uri GET application/json
		// in response, i want the hello-world string
		RequestBuilder request = MockMvcRequestBuilders
				.get("/item-from-biz-service")
				.accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(request)
				.andExpect(status().isOk()).andExpect(content().json("{id:2,name:Item2,price:10}")).andReturn();

        // JSONAssert.assertEquals(expected, actual, strict);
		//assertEquals("Hello, boss!", result.getResponse().getContentAsString());
	}


	// test item controller from database
    @Test
    public void retrieveAllItem_basic() throws Exception{

        // stub the business logic
        when(businessService.retrieveAllItems()).thenReturn(
                Arrays.asList(new Item(1, "Item1", 10,10),
                        new Item(2, "Item2", 10,10)));

        RequestBuilder request = MockMvcRequestBuilders
                .get("/all-items-from-database")
                .accept(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(request)
                .andExpect(status()
                        .isOk())
                .andExpect(content().json("[{id:1,name:Item1,price:10, quantity:10}," +
                        "{id:2,name:Item2,price:10, quantity: 10}]"))
                .andReturn();

    }

// for the web layer - controller
@Test
public void retrieveAllItems_basic() throws Exception{

    // stub the business logic
    when(businessService.retrieveAllItems()).thenReturn(
            Arrays.asList(new Item(1, "Item1", 10,10),
                          new Item(2, "Item2", 10,10)));

    RequestBuilder request = MockMvcRequestBuilders
            .get("/all-items-from-database")
            .accept(MediaType.APPLICATION_JSON);

    MvcResult result = mockMvc.perform(request)
            .andExpect(status()
                    .isOk())
            .andExpect(content().json("[{id:1,name:Item1,price:10, quantity:10}," +
                    "{id:2,name:Item2,price:10, quantity: 10}]"))
            .andReturn();

}



}
