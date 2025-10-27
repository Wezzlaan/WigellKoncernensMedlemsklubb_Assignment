package com.vestrin.storage;

import com.vestrin.entities.Item;

import java.io.*;
import java.util.*;

public class Inventory implements Serializable {

    private final HashMap<String, Item> items;

    public Inventory(){
        this.items = new HashMap<>();
    }
    /**
     * @param item Specify new item to be stored in Inventory.
     */
    public void addItem(Item item)
    {
        if (item == null) {
            throw new IllegalArgumentException("FEL: Kunde inte lägga till objekt. Orsak: Objekt var 'Null'.");
        }
        items.put(item.getItemID(), item);
    }
    /**
     * @return Unmodifiable version of Inventory List.
     */
    public List<Item> getItems()
    {
        return List.copyOf(this.items.values());
    }

    /**RETURNS A SINGLE ITEM.
     * @param itemID ID of item to find.
     * @return Found item.
     */
    public Item getSingleItem(String itemID){
        return this.items.get(itemID);
    }

    public void remove(Item item)
    {
        if (item == null){
            System.out.println("FEL: Medlem kan inte vara 'null'.");
            return;
        }
        if (items.isEmpty()) {
            throw new NoSuchElementException("FEL! Kunde inte ta bort objektet i listan. Orsak: 'Inventory' är tomt.");
        }
        this.items.remove(item.getItemID());
    }

    public boolean containsItem(String ItemID){
        if (ItemID == null){
            return false;
        }
        return this.items.containsKey(ItemID);
    }
}
