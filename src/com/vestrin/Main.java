package com.vestrin;

import com.vestrin.controllers.InventoryController;
import com.vestrin.controllers.MembersController;
import com.vestrin.entities.Item;
import com.vestrin.entities.Keyboard;
import com.vestrin.members.Member;

public class Main {
    public static void main(String[] args) throws Exception {

        MembersController membersController = new MembersController();
        InventoryController inventoryController = new InventoryController();

        inventoryController.addNewItem(new Keyboard("Scope II", "Asus", 99.0, "534232"));
        //KOLLA OM DET GÅR ATT LÄGGA TILL ANTAL AV ETT VISST OBJEKT I INVENTORY!!
        inventoryController.addNewItem(new Keyboard("ROG Azoth", "Asus", 99.0, "514232"));

        inventoryController.printAll();
        membersController.printAll();

    }
}