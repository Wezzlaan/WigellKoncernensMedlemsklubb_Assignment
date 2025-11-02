package com.vestrin.controllers;

import com.vestrin.entities.*;
import com.vestrin.storage.Inventory;

import java.security.Key;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

public class InventoryController {

    private final Inventory inventory;

    public InventoryController(){
        this.inventory = new Inventory();
        simulatedStock();
    }

    public void addNewItem(Item item){
        inventory.addItem(item);
    }


    public PC createPC(String brand, String model, PC.ComputerType computerType, double price) {
        return new PC(model, brand, computerType, price);
    }

    public Keyboard createKeyboard(String brand, String model, Keyboard.SwitchType switchType, double price){
        return new Keyboard(brand, model, switchType, price);
    }

    public Console createNewConsole(String brand, String model, Console.ConsoleType consoleType, double price){
        return new Console(brand, model, consoleType, price);
    }

    public Monitor createNewMonitor(String brand, String model, String size, Monitor.ScreenTech screenTech, double price){
        return new Monitor(model, brand, size, screenTech, price);
    }

    public Mouse createNewMouse(String brand, String model, double price){
        return new Mouse(brand, model, price);
    }

    public void printAll() {
        Map<String, List<Item>> allItems = inventory.getItems();

        if (!allItems.isEmpty()){
            for (Map.Entry<String, List<Item>> entry : allItems.entrySet()) {
                String articleId = entry.getKey();
                List<Item> itemList = entry.getValue();
                System.out.println("ID: " + articleId);
                for (Item item : itemList){
                    System.out.println(item);
                    System.out.println("----------------------");
                }
            }
        }
    }

    public void removeItem(Item item){
        inventory.remove(item);
    }

    public Inventory getAllItems(){
        return this.inventory;
    }

    public List<Item> getSingleItem(String identifier){
        String identifierToUpper = identifier.toUpperCase().trim();
        String idIdentifier = identifier.trim();
        if (inventory.containsItem(idIdentifier)){
            return inventory.getSingleItemList(idIdentifier);
        }
        if (!inventory.containsItem(identifierToUpper)){
            List <Item> itemsByName = inventory.containsItemName(identifierToUpper);
            if(itemsByName != null){
                return itemsByName;
            }
        }
        throw new NoSuchElementException("kunde inte hitta objekt med ID eller namn: " + identifier);
    }


    private void simulatedStock(){
        addNewItem(new Console("Playstation 5", "Sony", Console.ConsoleType.MODERN,199.99));
        addNewItem(new Console("Super Nintendo", "Nintendo", Console.ConsoleType.RETRO, 99.99));
        addNewItem(new Console("Dreamcast", "SEGA", Console.ConsoleType.RETRO, 99.99));
        addNewItem(new PC("Old School Runescape", "Starforge", PC.ComputerType.DESKTOP, 699.99));
        addNewItem(new PC("Aurora", "Alienware", PC.ComputerType.DESKTOP,549.99));
        addNewItem(new Keyboard("ROG Scope II", "Asus", Keyboard.SwitchType.MECHANICAL, 149.99));
        addNewItem(new Keyboard("G915", "Logitech", Keyboard.SwitchType.MECHANICAL, 149.99));
        addNewItem(new Mouse("G502X", "Logitech", 99.99));
        addNewItem(new Mouse("Rival 3", "Steelseries", 99.99));
    }
}
