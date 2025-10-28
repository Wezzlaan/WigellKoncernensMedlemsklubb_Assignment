package com.vestrin.entities;

public class Mouse extends Item{

    /**
     * @param model model name
     * @param brand brand/manufacturer name
     * @param price price of rental
     */
    public Mouse(String model, String brand, double price)
    {
        super(ItemType.PERIPHERALS, brand, model, price);
    }
}
