package com.vestrin.entities;

public class Console extends Item{
    private ConsoleType consoleType;
    /**
     * @param model model name
     * @param brand brand/manufacturer name
     * @param price price of rental
     */
    public Console(String model, String brand, ConsoleType consoleType, double price)
    {
        super(Item.ItemType.HARDWARE, brand, model, price);
        this.consoleType = consoleType;
    }

    public enum ConsoleType{
        RETRO,
        MODERN
    }

    @Override
    public String toString() {
        String itemInfo = super.toString();

        return itemInfo + "\nTyp av konsoll: " + this.consoleType;
    }
}
