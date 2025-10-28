package com.vestrin.entities;

public class PC extends Item{

    /**
     * @param model model name
     * @param brand brand/manufacturer name
     * @param price price of rental
     */
    public PC(String model, String brand, double price)
    {
        super(ItemType.HARDWARE, brand, model, price);
    }
}
