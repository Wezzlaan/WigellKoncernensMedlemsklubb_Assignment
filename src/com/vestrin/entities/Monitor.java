package com.vestrin.entities;

public class Monitor extends Item{

    /**
     * @param model model name
     * @param brand brand/manufacturer name
     * @param price price of rental
     */
    public Monitor(String model, String brand, double price)
    {
        super(ItemType.PERIPHERALS, brand, model, price);
    }
}
