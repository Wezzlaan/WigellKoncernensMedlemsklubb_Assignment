package com.vestrin.controllers;

import com.vestrin.entities.Item;
import com.vestrin.storage.FileWriter;
import com.vestrin.storage.Inventory;
import com.vestrin.storage.MemberRegistry;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class InventoryController {

    private final FileWriter fileWriter;
    private Inventory inventory;
    private String filePath = "inventory.dat";

    public InventoryController(){
        this.fileWriter = new FileWriter();
        try {
            this.inventory = fileWriter.loadInventory(filePath);
            System.out.println("Befintlig lagerlista laddad.");
        } catch (FileNotFoundException e) {
            this.inventory = new Inventory();
            System.out.println("Ingen lagerlista hittades. Skapar en ny...");
        } catch (IOException e){
            e.printStackTrace();
            this.inventory = new Inventory();
        }
    }

    public void addNewItem(Item item){
        try {
            inventory.addItem(item);
            fileWriter.writeToFile("inventory.dat", inventory);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void printAll() {
        Map<String, List<Item>> allItems = inventory.getItems();

        if (!allItems.isEmpty()){
            for (Map.Entry<String, List<Item>> entry : allItems.entrySet()) {
                String articleId = entry.getKey();
                List<Item> itemList = entry.getValue();
                System.out.println("\nID: " + articleId);
                for (Item item : itemList){
                    System.out.println(item);
                }
            }
        }
    }
}
