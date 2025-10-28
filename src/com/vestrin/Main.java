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

        inventoryController.printAll();
        membersController.printAll();
    }
}