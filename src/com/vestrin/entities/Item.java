package com.vestrin.entities;

import java.io.Serializable;

public abstract class Item implements Serializable {

    protected String model;
    protected String brand;
    protected double price;
    protected ItemType type;
    protected String itemID;
    protected int quantity;

    public Item() {}

    /**
     * @param itemType type of item
     * @param name name of Item
     * @param brand brand of item
     * @param price price of item
     * @param itemID ID number of item
     */
    public Item(ItemType itemType, String brand, String name, double price, String itemID)
    {
        this.type = itemType;
        this.brand = brand;
        this.model = name;
        this.price = price;
        this.itemID = itemID;
    }

    public enum ItemType
    {
        PERIPHERALS,
        HARDWARE
    }

    public ItemType getItemType()
    {
        return this.type;
    }

    public void setItemType(ItemType itemType)
    {
        this.type = itemType;
    }

    public String getModel()
    {
        return model;
    }

    public void setModel(String model)
    {
        this.model = model;
    }

    public String getBrand()
    {
        return brand;
    }

    public void setBrand(String brand)
    {
        this.brand = brand;
    }

    public double getPrice()
    {
        return this.price;
    }

    public void setPrice(double price)
    {
        this.price = price;
    }

    public String getItemID()
    {
        return this.itemID;
    }

    /**
     * @param itemID set new item ID as String.
     */
    public void setItemID(String itemID)
    {
        this.itemID = itemID;
    }

    /**
     * @return formatted name of product.
     */
    public String formattedName()
    {
        return this.brand + " " + this.model;
    }

    /**
     * @return Object to readable String. Format: Brand + Model + ItemID + Price.
     */
    @Override
    public String toString()
    {
        return this.formattedName() + "\n" + "Artikelnummer: " + this.itemID + "\n" + this.price + ";-";
    }

    public void addQuantity(int amount) {
        if (amount > 0) {
            this.quantity += amount;
            System.out.println("La till " + amount + "enheter. Nytt lagersaldo för " +
                                this.formattedName() + ": " + this.quantity);
        }
    }
}
