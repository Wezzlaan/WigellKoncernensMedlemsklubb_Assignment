package com.vestrin;

import com.vestrin.items.Item;
import com.vestrin.items.Monitor;
import com.vestrin.items.Mouse;
import com.vestrin.members.Member;
import com.vestrin.members.Ranks;
import com.vestrin.storage.Inventory;

import java.util.LinkedList;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        /*Member member = new Member("Test Tester", "144325");

        member.setRank(Ranks.NOOB);*/

        /*System.out.println("Namn: " + member.getName() + "\nID: " + member.getID() + "\nRank: " + member.getRank());

        Monitor monitor = new Monitor ("Q27G3XMN", "AOC", 149.0, "453153");

        System.out.println(monitor.formattedName() + " " + monitor.getItemID() + " " + monitor.getPrice() + " " + monitor.getItemType());*/

        Inventory inventory = new Inventory();

        inventory.addItem(new Monitor ("Q27G3XMN", "AOC", 149.0, "453153"));

        inventory.addItem(new Mouse("G502", "Logitech", 99, "345243"));

        List<Item> items = inventory.getItems();
    }


    /*TO DO:
    * LÄGG TILL FLER SORTERS ITEMS
    * NY BRANCH FÖR BYGGA FUNKTIONALITET FÖR INVENTORY AV ITEMS*/
}