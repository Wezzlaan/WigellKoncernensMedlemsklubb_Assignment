package com.vestrin.application;

import com.vestrin.entities.Item;
import com.vestrin.members.Member;
import com.vestrin.members.Ranks;

import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

public class ConsoleView {
    private Scanner scanner;
    protected ConsoleView(){
        scanner = new Scanner(System.in);
    }

    protected void printMainMenu() {
        System.out.println("\nNavigera med [1], [2], [3], [4] och [ENTER]:");
        System.out.println("\n[1] Lägg till medlem " +
                "\n[2] Sök medlem " +
                "\n[3] Hantera medlem" +
                "\n[4] Se lagerstatus" +
                "\n[5] Boka/Avsluta uthyrning" +
                "\n[6] Kontrollera/summera intäkter");
    }

    protected char getMenuChoice(){
        try {
            char input = scanner.nextLine().charAt(0);
            if (input >= '1' && input <= '9') {
                return input;
            } else {
                throw new InputMismatchException("FEL: " + input + " är inte en godkänd inmatning.");
            }
        } catch (InputMismatchException e){
            System.err.println(e.getMessage());
        }
        return 0;
    }

    /**
     * Prompts for user input.
     * @return New name as String.
     */
    protected String newMemberNamePrompt(){
        StringBuilder memberName = new StringBuilder();
        System.out.print("Ange förnamn: ");
        String firstName = scanner.nextLine().trim().toUpperCase();
        System.out.print("Ange efternamn: ");
        String lastName = scanner.nextLine().trim().toUpperCase();
        memberName.append(firstName).append(" ").append(lastName);

        return memberName.toString();
    }

    /**
     * Prompts for userInput. 1 = NOOB, 2 = CASUAL, 3 = VETERAN, 4 = ELITE.
     * @return Rank choice as char.
     */
    protected char memberRankPrompt(){
        System.out.println("Medlemsnivå: ");
        System.out.println("\n[1]" + Ranks.NOOB +
                " [2]" + Ranks.CASUAL +
                " [3]" + Ranks.VETERAN +
                " [4]" + Ranks.ELITE);
        return scanner.nextLine().charAt(0);
    }

    protected void creationConfirmation(Member member){
        String name = member.getName();
        String ID = member.getID();
        Ranks rank = member.getRank();

        System.out.println("\nMedlem tillagd: " + "\n" + name + "\nMedlems ID: " + ID + "\nMedlems-rank: " + rank);
    }

    protected void printRentedItems(Member member){
        for (Map.Entry<String, Item> entry : member.getRentedItems().entrySet()){
            String itemId = entry.getKey();
            Item item = entry.getValue();
            System.out.println("ID: " + itemId + ", Föremål: " + item.formattedName());
        }
    }

    protected String idInputPrompt(){
        System.out.print("\nMedlems-ID: ");
        return scanner.nextLine().trim();
    }

    protected void printFoundMembers(Member member){
        String name = member.getName();
        String ID = member.getID();
        Ranks rank = member.getRank();

        System.out.println("\nMedlem hittad: " + "\n" + name + "\nMedlems ID: " + ID + "\nMedlems-rank: " + rank);
    }



}
