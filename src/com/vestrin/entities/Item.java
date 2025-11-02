package com.vestrin.entities;
import java.util.UUID;

public abstract class Item{

    protected String model;
    protected String brand;
    protected double price;
    protected ItemType type;
    protected UUID itemID;
    protected boolean isRented;
    protected int rentedDuration;
    protected double currentRentalPrice;

    public Item() {}

    /**
     * @param itemType type of item
     * @param name name of Item
     * @param brand brand of item
     * @param price price of item
     */
    public Item(ItemType itemType, String brand, String name, double price){
        this.type = itemType;
        this.brand = brand.toUpperCase();
        this.model = name.toUpperCase();
        this.itemID = UUID.randomUUID();
        this.price = price;
    }

    public enum ItemType {
        PERIPHERALS,
        HARDWARE
    }

    public void setRentedDuration(int duration){
        this.rentedDuration = duration;
    }

    public int getRentedDuration(){
        return rentedDuration;
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

    /**
     * @return GUID of Item
     */
    public UUID getItemID()
    {
        return this.itemID;
    }

    public String itemIDToString(){
        return itemID.toString();
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
    public String toString() {
        return this.formattedName() + "\n" + "Kategori: " + this.type +
                                    "\n" + "Kostnad (utan medlemsavdrag): " + this.price +
                                    ";-" + "\nUtlånad: " + this.isRented;
    }

    public boolean getIsRented(){
        return isRented;
    }

    /**
     * @param rentedStatus true/false
     */
    public void setIsRented(Boolean rentedStatus){
        this.isRented = rentedStatus;
    }

    public void setCurrentRentalPrice(double price) {
        this.currentRentalPrice = price;
    }

    public double getCurrentRentalPrice() {
        return this.currentRentalPrice;
    }
}
