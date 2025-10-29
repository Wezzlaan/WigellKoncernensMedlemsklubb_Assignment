package com.vestrin.members;

import com.vestrin.entities.Item;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Member implements Serializable {

    private String ID;
    private String name;
    private Ranks rank;
    private MemberHistory memberHistory;
    private Map<String, Item> rentedItems;

    public Member() {}

    /**
     * @param name of Member
     */
    public Member(String name, Ranks rank)
    {
        this.name = name;
        ID_Randomizer randomizer = new ID_Randomizer();
        this.ID = randomizer.generate();
        this.rentedItems = new HashMap<>();
        this.rank = rank;
    }

    public Map<String, Item> getRentedItems(){
        return rentedItems;
    }

    /**ADDS ITEMS TO MAP RENTED ITEMS.
     * @param item item to add to rental.
     */
    public void setRentedItems(Item item){
        rentedItems.put(item.itemIDToString(), item);
    }
    /**
     * @return Member ID
     */
    public String getID()
    {
        return ID;
    }

    /**
     * @return Member name
     */
    public String getName()
    {
        return name;
    }

    /**
     *
     * @param newName Sets new name to member object
     */
    public void setName(String newName)
    {
        this.name = newName;
    }

    /**
     * @return Member rank
     */
    public Ranks getRank()
    {
        return rank;
    }

    /**
     * @param newRank Sets new rank to member
     */
    public void setRank(Ranks newRank)
    {
        this.rank = newRank;
    }

    public MemberHistory getMemberHistory()
    {
        return memberHistory;
    }
    @Override
    public String toString()
    {
        return this.name + "\n" + this.ID + "\n" + this.rank;
    }


}
