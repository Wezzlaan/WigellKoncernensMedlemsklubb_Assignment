package com.vestrin.controllers;

import com.vestrin.entities.Item;
import com.vestrin.storage.FileWriter;
import com.vestrin.storage.Inventory;
import com.vestrin.storage.MemberRegistry;

import java.io.FileNotFoundException;
import java.io.IOException;

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
        if (!inventory.getItems().isEmpty()){
            inventory.getItems().forEach(System.out::println);
        }
    }

}
