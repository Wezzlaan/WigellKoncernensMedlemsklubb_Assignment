package com.vestrin.services;

import com.vestrin.entities.Item;
import com.vestrin.members.Member;
import com.vestrin.storage.Inventory;

public class Rental {
    private final Inventory inventory;


    public Rental(Inventory inventory){
        this.inventory = inventory;
    }

    protected void toMember(Item item, Member member, int duration){
        member.setRentedItems(item);
        item.setIsRented(true);
        item.setRentedDuration(duration);
    }

    public void returnItem(Item item, Member member){
        member.getRentedItems().remove(item.getItemID().toString(), item);
        item.setIsRented(false);
        member.getMemberHistory().returnItem(item);
    }

    protected Inventory getInventory(){
        return inventory;
    }
}
