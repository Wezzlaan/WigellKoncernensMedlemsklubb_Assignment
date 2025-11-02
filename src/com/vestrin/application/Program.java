package com.vestrin.application;

import com.vestrin.controllers.InventoryController;
import com.vestrin.controllers.MembersController;
import com.vestrin.entities.*;
import com.vestrin.members.Member;
import com.vestrin.services.MembershipService;
import com.vestrin.services.Rental;
import com.vestrin.services.RentalService;


import java.util.InputMismatchException;
import java.util.List;
import java.util.NoSuchElementException;

public class Program {
    MembersController membersController;
    InventoryController inventoryController;
    RentalService rentalService;
    ConsoleView view = new ConsoleView();
    MembershipService membershipService;

    public Program(){
        this.membersController = new MembersController();
        this.inventoryController = new InventoryController();
        Rental rentalDB = new Rental(inventoryController.getAllItems());
        this.rentalService = new RentalService(rentalDB);
        this.membershipService = new MembershipService(membersController);
    }

    public void run(){
        view.printMenuLogo();
        while (true) {
            view.menuChoices();
            try {
                switch (view.getMenuChoice()) {
                    case '1': //Lägg till ny medlem
                        try{
                            Member newMember = membersController.createNewMember(view.newMemberNamePrompt(), view.memberRankPrompt());
                            view.creationConfirmation(newMember);
                        } catch (InputMismatchException e){
                            System.err.println("Kunde inte lägga till ny medlem. Orsak: " + e.getMessage());
                        }
                        break;

                    case '2': //Sök efter medlem och hantera
                        try {
                            memberSearchHelper();
                            break;
                        } catch (NoSuchElementException e){
                            System.err.println(e.getMessage());
                            break;
                        }

                    case '3': //Visa lager
                        inventoryController.printAll();
                        break;

                    case '4': //Uthyrning

                        while (true) {
                            try {
                                handleBookingOrReturningMenu();
                                break;
                            } catch (NoSuchElementException e) {
                                System.err.println(e.getMessage() + "\n");
                            }
                        }
                        break;

                    case '5': //Summera intäkter
                        view.allRentalHistory(membershipService.getRentalHistory());
                        view.totalRevenue(membershipService.calculateTotalRevenue());
                        break;

                    case '6': //Lägg till item i inventory.
                        try {
                            handleItemCreationMenu(view.newItemPrompt());
                        } catch (InputMismatchException e){
                            System.err.println(e.getMessage());
                        }
                        break;

                    case '0':
                        view.printShutdownMessage();
                        System.exit(0);
                    default:
                        System.err.println("FEL: Välj mellan godkända menyval. [1], [2], [3], [4], [5], [6] ELLER [0].\n");
                }
            } catch (InputMismatchException e) {
                System.err.println(e.getMessage());
            }
        }
    }

    private void handleMemberMenu(Member member){
        boolean isInMenu = true;

        while (isInMenu){
            try {
                switch (view.memberConfigPrompt()) {
                    case '1':
                        membershipService.changeRank(member, membersController, view);
                        break;
                    case '2':
                        view.printHistory(member);
                        break;
                    case '3':
                        view.printRentedItems(member);
                        break;
                    case '0':
                        isInMenu = false;
                        break;
                }
            } catch (InputMismatchException e){
                System.err.println("Ett fel inträffade. Orsak: " + e.getMessage());
            }
        }
    }

    private void handleItemCreationMenu(char itemChoice){
        AddingItems addingItems = new AddingItems();
        String brand = addingItems.brand();
        String model = addingItems.model();
        double price = Double.parseDouble(addingItems.price());
        Item newItem;

        switch (itemChoice) {
            case '1':
                PC.ComputerType computerType = addingItems.setComputerType();
                newItem = inventoryController.createPC(brand, model, computerType, price);
                break;
            case '2':
                Console.ConsoleType consoleType = addingItems.setConsoleType();
                newItem = inventoryController.createNewConsole(brand, model, consoleType, price);
                break;
            case '3':
                Keyboard.SwitchType switchType = addingItems.setSwitchType();
                newItem = inventoryController.createKeyboard(brand, model, switchType, price);
                break;
            case '4':
                newItem = inventoryController.createNewMouse(brand, model, price);
                break;
            case '5':
                String screenSize = addingItems.setScreenSize();
                Monitor.ScreenTech screenTech = addingItems.setScreenTech();
                newItem = inventoryController.createNewMonitor(brand, model, screenSize, screenTech, price);
                break;
            default:
                throw new InputMismatchException("FEL: inmatning måste vara 1-5.");
        }
        if (newItem != null) {
            inventoryController.addNewItem(newItem);
            view.addedItemConfirmation(newItem);
        }



    }

    private void handleBookingOrReturningMenu() {
        char choice = view.bookOrReturnPrompt();
        if (choice >= '1' && choice <= '2') {
            if (choice == '1') {
                try {
                    rentItem();
                } catch (NoSuchElementException e) {
                    System.err.println(e.getMessage());
                }
            }
            if (choice == '2') {
                returnItem();
            }
            else {
                throw new InputMismatchException("FEL: Inmatning måste vara 1 eller 2.");
            }
        }
    }

    private void memberSearchHelper(){
        Member memberToFind = membersController.getSingleMember(view.idInputPrompt());
        view.printFoundMembers(memberToFind);
        handleMemberMenu(memberToFind);
    }

    private void rentItem(){
        String memID = view.idInputPrompt();
        Member member = membersController.getSingleMember(memID);
        String itemID = view.itemIdInputPrompt();
        List<Item> items = inventoryController.getSingleItem(itemID);
        int rentalTime = view.rentalTimePrompt();
        rentalService.rent(member, items, rentalTime);
    }

    private void returnItem(){
        String memID = view.idInputPrompt();
        Member member = membersController.getSingleMember(memID);
        view.printRentedItems(member);

        String itemID = view.uuidItemToReturn();

        Item itemToReturn = member.getRentedItems().get(itemID);

        if (itemToReturn != null){
            rentalService.returnItem(member, itemToReturn);
        } else {
            System.err.println("Kunde inte hitta ett hyrt föremål med UUID: " + itemID);
        }
    }
}
