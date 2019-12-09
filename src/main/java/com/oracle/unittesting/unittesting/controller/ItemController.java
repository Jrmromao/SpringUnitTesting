package com.oracle.unittesting.unittesting.controller;

import com.oracle.unittesting.unittesting.business.ItemBusinessService;
import com.oracle.unittesting.unittesting.model.Item;
import org.aspectj.bridge.ILifecycleAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.awt.print.Pageable;
import java.util.List;

@RestController
public class ItemController {

	@Autowired
	private ItemBusinessService businessService;


	
//	@GetMapping("/dummy-item")
//	//public Item dummyItem() {
//		return new Item();
//	}
	@GetMapping("/item-from-biz-service")
	public Item itemFromBusinessService() {
		return businessService.retrieveHardcodedItem();
	}
	@GetMapping("/all-items-from-database")
	public List<Item> retrieveAllItems(){

		List<Item> iList = businessService.retrieveAllItems();

//		for(Item item : iList){
//			item.setPrice(item.getPrice() * item.getQuantity());
//		}


		return iList;

	}
}
