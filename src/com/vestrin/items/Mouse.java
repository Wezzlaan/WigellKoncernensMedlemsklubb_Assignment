package com.vestrin.items;

public class Mouse extends Item{

    /**
     * @param model model name
     * @param brand brand/manufacturer name
     * @param price price of rental
     * @param itemID Article ID of Item, in String.
     */
    public Mouse(String model, String brand, double price, String itemID)
    {
        super(ItemType.PERIPHERALS, brand, model, price, itemID);
    }
}
