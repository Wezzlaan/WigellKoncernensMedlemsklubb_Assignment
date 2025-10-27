package com.vestrin;

import com.vestrin.items.Item;
import com.vestrin.items.Keyboard;
import com.vestrin.items.Monitor;
import com.vestrin.items.PC;
import com.vestrin.members.Member;
import com.vestrin.storage.FileWriter;
import com.vestrin.storage.Inventory;
import com.vestrin.storage.MemberRegistry;

import java.io.File;
import java.io.IOException;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws Exception {

        String inventoryPath = "inventory.dat";
        String memberPath = "members.dat";

        FileWriter fileWriter = new FileWriter();

        MemberRegistry memberRegistry = fileWriter.loadMemberRegistry(memberPath);
        Inventory inventoryDB = fileWriter.loadInventory(inventoryPath);

        memberRegistry.getMembers().forEach(System.out::println);
        inventoryDB.getItems().forEach(System.out::println);

    }
}