package com.vestrin.entities;

public class Monitor extends Item{

    private String size;
    private ScreenTech screenTech;
    /**
     * @param model model name
     * @param brand brand/manufacturer name
     * @param price price of rental
     */
    public Monitor(String model, String brand, String size, ScreenTech screenTech, double price)
    {
        super(ItemType.PERIPHERALS, brand, model, price);
        this.size = size;
        this.screenTech = screenTech;
    }

    public enum ScreenTech {
        TN,
        VA,
        IPS,
        OLED,
        MINI_LED;
    }

    public String getSize(){
        return this.size;
    }

    public ScreenTech getScreenTech(){
        return this.screenTech;
    }

    @Override
    public String toString() {
        String itemInfo = super.toString();

        return itemInfo + "\nSkärmteknologi: " + this.screenTech + "\nStorlek (i tum): " + this.size;
    }

}
