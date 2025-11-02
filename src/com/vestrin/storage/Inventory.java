package com.vestrin.storage;

import com.vestrin.entities.Item;

import java.util.*;

public class Inventory {

    private final HashMap<String, List<Item>> items;

    public Inventory(){
        this.items = new HashMap<>();
    }
    /**
     * @param item Specify new item to be stored in Inventory.
     */
    public void addItem(Item item)
    {
        String articleID = item.getItemID().toString();
        if (!items.containsKey(articleID)) {
            items.put(articleID, new ArrayList<>());
        }
        items.get(articleID).add(item);
    }
    /**
     * @return Unmodifiable version of Inventory List.
     */
    public Map<String, List<Item>> getItems()
    {
        return this.items;
    }

    /**RETURNS ITEMS LIST OF SPECIFIC ITEM.
     * @param itemID ID of item to find.
     * @return Found item.
     */
    public List<Item> getSingleItemList(String itemID){
        return this.items.get(itemID);
    }

    /**
     * REMOVES ITEM FROM INVENTORY
     * @param item Item to remove
     */
    public void remove(Item item)
    {
        if (item == null){
            System.err.println("FEL: Objekt kan inte vara 'null'.");
            return;
        }
        if (items.isEmpty()) {
            throw new NoSuchElementException("FEL! Kunde inte ta bort objektet i listan. Orsak: 'Inventory' är tomt.");
        }
        this.items.remove(item.getItemID().toString());
    }

    public boolean containsItem(String ItemID){
        if (ItemID == null){
            return false;
        }
        return this.items.containsKey(ItemID);
    }

    public List<Item> containsItemName(String name){
        if (name == null){
            return new ArrayList<>();
        }
        List <Item> foundItems = new ArrayList<>();
        for (List<Item> items : items.values()){
            for (Item item : items){
                if (Objects.equals(item.getModel(), name)){
                    foundItems.add(item);
                }
            }
        }
        return foundItems;
    }
}
