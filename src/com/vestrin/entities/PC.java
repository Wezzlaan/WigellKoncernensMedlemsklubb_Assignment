package com.vestrin.entities;

public class PC extends Item{

    /**
     * @param model model name
     * @param brand brand/manufacturer name
     * @param price price of rental
     * @param itemID Article ID of Item, in String.
     */
    public PC(String model, String brand, double price, String itemID)
    {
        super(ItemType.HARDWARE, brand, model, price, itemID);
    }
}
