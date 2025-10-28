package com.vestrin.rental;

import com.vestrin.controllers.InventoryController;
import com.vestrin.entities.Item;
import com.vestrin.members.Member;
import com.vestrin.storage.Inventory;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Rental implements Serializable {
    private final Inventory inventory;

    public Rental(Inventory inventory){
        this.inventory = inventory;
    }

    public void toMember(Item item, Member member){
        String itemKey = String.valueOf(item.getItemID());
        if (inventory.getItems().containsKey(itemKey)){
            member.setRentedItems(item);
            item.setIsRented(true);
        }
    }

    public void returnItem(Item item, Member member){

    }
}
