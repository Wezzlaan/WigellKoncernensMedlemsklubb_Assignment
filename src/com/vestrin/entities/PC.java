package com.vestrin.entities;

public class PC extends Item{
    private ComputerType computerType;
    /**
     * @param model model name
     * @param brand brand/manufacturer name
     * @param price price of rental
     */
    public PC(String model, String brand, ComputerType computerType, double price)
    {
        super(ItemType.HARDWARE, brand, model, price);
        this.computerType = computerType;
    }

    public enum ComputerType {
        LAPTOP,
        DESKTOP
    }

    public ComputerType getComputerType(){
        return computerType;
    }

    @Override
    public String toString(){
        String itemInfo = super.toString();

        return itemInfo + "\nTyp av dator: " + this.computerType;
    }
}
