package com.vestrin;

import com.vestrin.items.Monitor;
import com.vestrin.items.PC;
import com.vestrin.storage.Inventory;

import java.io.IOException;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws Exception {

        /*Member member = new Member("Test Tester", "144325");

        member.setRank(Ranks.NOOB);*/

        //System.out.println("Namn: " + member.getName() + "\nID: " + member.getID() + "\nRank: " + member.getRank());

       /* Monitor monitor = new Monitor ("Q27G3XMN", "AOC", 149.0, "453153");

        PC gamingPC = new PC ("Max Bite Extreme", "SharkGaming", 399, "532432");*/

        //System.out.println(monitor.formattedName() + " " + monitor.getItemID() + " " + monitor.getPrice() + " " + monitor.getItemType());

        /*Inventory inventory = new Inventory();

        inventory.addItem(gamingPC);
        inventory.addItem(monitor);

        try {
            inventory.writeToFile("inventory.dat");
        }
        catch(IOException e)
        {
            System.out.println("Något gick fel.");
        }*/

        Inventory inventoryDb = Inventory.loadFromFile("inventory.dat");
        inventoryDb.getItems().forEach(System.out::println);





    }
}