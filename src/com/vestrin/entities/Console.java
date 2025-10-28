package com.vestrin.entities;

public class Console extends Item{

    /**
     * @param model model name
     * @param brand brand/manufacturer name
     * @param price price of rental
     */
    public Console(String model, String brand, double price)
    {
        super(Item.ItemType.HARDWARE, brand, model, price);
    }
}
