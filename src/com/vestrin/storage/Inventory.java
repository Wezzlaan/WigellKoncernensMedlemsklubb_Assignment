package com.vestrin.storage;

import com.vestrin.items.Item;

import java.io.*;
import java.util.*;

public class Inventory implements Serializable {

    private List<Item> items;

    public Inventory()
    {
        this.items = new ArrayList<>();
    }

    /**
     * @param path local "Database" path file.
     * @throws IOException ...
     */
    /*public void writeToFile(String path) throws IOException
    {
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path)))
        {
            oos.writeObject(this);
        }
    }

    *//**
     * @param path local "Database" path file.
     * @return Inventory "database".
     * @throws IOException ...
     *//*
    public static Inventory loadFromFile(String path) throws IOException
    {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path))){
            return (Inventory) ois.readObject();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }*/

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
            throw new NoSuchElementException("FEL! Kunde inte ta bort första objektet i listan. Orsak: 'Inventory' är tomt.");
        }
        items.removeFirst();
    }

    public void remove(Item item)
    {
        if (items.isEmpty())
        {
            throw new NoSuchElementException("FEL! Kunde inte ta bort objektet i listan. Orsak: 'Inventory' är tomt.");
        }
        this.items.remove(item);
    }
}
