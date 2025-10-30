package com.vestrin.application;

import com.vestrin.controllers.InventoryController;
import com.vestrin.controllers.MembersController;
import com.vestrin.members.Member;


import java.util.InputMismatchException;
import java.util.NoSuchElementException;

public class Program {
    MembersController membersController;
    InventoryController inventoryController;
    ConsoleView view = new ConsoleView();

    public Program(){
        membersController = new MembersController();
        inventoryController = new InventoryController();
    }

    public void mainMenu(){
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
                        break;
                    case '2': //Sök efter medlem och hantera
                        try {
                            Member memberToFind = membersController.getSingleMember(view.idInputPrompt());
                            view.printFoundMembers(memberToFind);
                            handleMemberMenu(memberToFind);

                            break;
                        } catch (NoSuchElementException e){
                            System.err.println(e.getMessage());
                        }
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
                        String currentRank = member.getRank().toString();
                        char rankChoice = view.memberRankPrompt();
                        member.setRank(membersController.chooseRank(rankChoice));
                        String newRank = member.getRank().toString();
                        System.out.println("\nMedlemsnivå ändrad: " + currentRank + " -> " + newRank);
                        break;
                }
            } catch (InputMismatchException e){
                System.err.println("Ett fel inträffade. Orsak: " + e.getMessage());
            }
        }
    }


}
