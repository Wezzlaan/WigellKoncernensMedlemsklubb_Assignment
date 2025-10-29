package com.vestrin;

import com.vestrin.application.Program;
import com.vestrin.controllers.InventoryController;
import com.vestrin.controllers.MembersController;
import com.vestrin.entities.Item;
import com.vestrin.entities.Keyboard;
import com.vestrin.entities.PC;
import com.vestrin.members.Member;
import com.vestrin.rental.Rental;
import com.vestrin.storage.Inventory;
import com.vestrin.storage.MemberRegistry;

public class Main {
    public static void main(String[] args) throws Exception {

      /*  MembersController membersController = new MembersController();
        InventoryController inventoryController = new InventoryController();
        inventoryController.load();

        *//*PC pc = new PC("G7", "ASUS", 349.99);
        inventoryController.addNewItem(pc);*//*

        *//*Member member = new Member("Kalle Qvist");
        membersController.addNewMember(member);*//*

        //String memberID = member.getID();
        //System.out.println("Medlem skapades med ID: " + memberID);

        Member currentMember = membersController.getRegistry().getSingleMember("92745");

        Rental rental = new Rental(inventoryController.getAllItems());

        if (currentMember != null){
            System.out.println("Hittade medlem: " + currentMember.getName());

            *//*rental.toMember(pc, currentMember);
            System.out.println(pc.formattedName() + " har lånats ut till: " + currentMember.getName());*//*
            membersController.printRentedItems(currentMember);
        }

        inventoryController.printAll();*/

        Program program = new Program();

        program.mainMenu();
    }
}