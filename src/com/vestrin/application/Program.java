package com.vestrin.application;

import com.vestrin.controllers.InventoryController;
import com.vestrin.controllers.MembersController;
import com.vestrin.members.Member;
import com.vestrin.searchEngine.SearchEngine;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;

public class Program {
    MembersController membersController;
    InventoryController inventoryController;
    ConsoleView view = new ConsoleView();
    SearchEngine search = new SearchEngine();

    public Program(){
        membersController = new MembersController();
        inventoryController = new InventoryController();
    }

    public void mainMenu(){
        System.out.println("------TV-SPELS KLUBBEN------");
        while (true) {
            view.printMainMenu();
            try {
                switch (view.getMenuChoice()) {
                    case '1': //Lägg till ny medlem
                        try{
                            Member newMember = membersController.createNewMember(view.newMemberNamePrompt(), view.memberRankPrompt());
                            view.creationConfirmation(newMember);
                        } catch (InputMismatchException e){
                            System.err.println("Kunde inte lägga till ny medlem. Orsak: " + e.getMessage());
                        }
                    case '2': //Sök efter medlem
                        try {
                            Member memberToFind = membersController.getSingleMember(view.idInputPrompt());
                            view.printFoundMembers(memberToFind);
                        } catch (NoSuchElementException e){
                            System.err.println(e.getMessage());
                        }
                }
            } catch (InputMismatchException e) {
                System.err.println(e.getMessage());
            }
        }
    }
}
