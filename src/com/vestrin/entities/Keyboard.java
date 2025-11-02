package com.vestrin.entities;

public class Keyboard extends Item{

    private SwitchType switchType;
    /**
     * @param model model name
     * @param brand brand/manufacturer name
     * @param price price of rental
     *
     */
    public Keyboard(String model, String brand, SwitchType switchType, double price)
    {
        super(ItemType.PERIPHERALS, brand, model, price);
        this.switchType = switchType;
    }

    public enum SwitchType {
        MECHANICAL,
        MEMBRANE
    }

    public SwitchType getSwitchType() {
        return this.switchType;
    }

    @Override
    public String toString() {
        String itemInfo = super.toString();

        return itemInfo + "\nTyp av Switch: " + this.switchType;
    }
}
