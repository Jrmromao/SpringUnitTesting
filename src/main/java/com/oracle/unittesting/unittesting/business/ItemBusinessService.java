package com.oracle.unittesting.unittesting.business;

import com.oracle.unittesting.unittesting.data.ItemRepository;
import com.oracle.unittesting.unittesting.model.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ItemBusinessService {


    @Autowired
    private ItemRepository itemRepository;


    public List<Item> retrieveAllItems(){
        return itemRepository.findAll();
    }

    public Item retrieveHardcodedItem() {
    return new Item();
    }

}
