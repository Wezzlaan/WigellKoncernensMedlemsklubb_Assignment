package com.vestrin.storage;

import com.vestrin.items.Item;
import com.vestrin.items.Monitor;
import com.vestrin.items.Mouse;
import com.vestrin.items.PC;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class InventoryFileWriter {

   /* private BufferedWriter writer;
    private Inventory inventory = new Inventory();
    private List<Item> items = inventory.getItems();

    public InventoryFileWriter()
    {
    }

    public void toFile()
    {
        inventory.addItem(new Monitor("Q27G3XMN", "AOC", 149.0, "453153"));

        inventory.addItem(new Mouse("G502", "Logitech", 99, "345243"));

        inventory.addItem(new PC("R16 Gaming", "Alienware", 99, "534123"));
        try {
            writer = new BufferedWriter(new FileWriter("Inventory.txt"));
            for (Item item : items)
            {
                writer.write(item.toString());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }*/

}
