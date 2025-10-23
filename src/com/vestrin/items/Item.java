package com.vestrin.items;

public abstract class Item {

    private String model;
    private String brand;
    private double price;
    private ItemType type;
    private String itemID;

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
        HARDWARE,
        BOARD_GAMES
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
}
