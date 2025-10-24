package com.vestrin.storage;

import com.vestrin.items.Item;

import java.util.*;

public class Inventory {

    private List<Item> items;

    public Inventory()
    {
        this.items = new ArrayList<>();
    }

    /**
     * @param item Specify new item to be stored in Inventory.
     */
    public void addItem(Item item)
    {
        if (item != null) {
            items.add(item);
        }
        else {
            throw new IllegalArgumentException("FEL: Kunde inte lägga till objekt. Orsak: Objekt var 'Null'.");
        }
    }

    /**
     * @return Unmodifiable version of Inventory List.
     */
    public List<Item> getItems()
    {
        return Collections.unmodifiableList(this.items);
    }

    public void removeFirst()
    {
        if (items.isEmpty())
        {
            throw new NoSuchElementException("Kunde inte ta bort första objektet i listan: 'Inventory' är tomt.");
        }
        items.removeFirst();
    }
}
