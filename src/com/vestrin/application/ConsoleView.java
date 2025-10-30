package com.vestrin.application;

import com.vestrin.entities.Item;
import com.vestrin.members.Member;
import com.vestrin.members.Ranks;

import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

public class ConsoleView {
    private final Scanner scanner;
    private final ConsoleColors color = new ConsoleColors();
    protected ConsoleView(){
        scanner = new Scanner(System.in);
    }

    protected void printMainMenu() {
        System.out.println(color.applyCyan("\n------TV-SPELS KLUBBEN------"));
        System.out.println(color.applyCyan("\nNavigera med [1], [2], [3], [4], [5], [0] och [ENTER]:"));
        System.out.println("\n[1] Lägg till medlem " +
                "\n[2] Sök/hantera medlem " +
                "\n[3] Se lagerstatus" +
                "\n[4] Boka/Avsluta uthyrning" +
                "\n[5] Kontrollera/summera intäkter" +
                "\n[0] Avsluta");
        System.out.print(color.applyCyan("\nVal sedan [ENTER]: "));
    }

    protected char getMenuChoice(){
        try {
            char input = scanner.nextLine().charAt(0);
            if (input >= '0' && input <= '9') {
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
        System.out.print(color.applyCyan("Ange förnamn: "));
        String firstName = scanner.nextLine().trim().toUpperCase();
        System.out.print(color.applyCyan("Ange efternamn: "));
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

        System.out.println(color.applyGreen("\nMedlem tillagd: " + "\n" + name + "\nMedlems ID: " + ID + "\nMedlems-rank: " + rank));
    }

    protected void printRentedItems(Member member){
        for (Map.Entry<String, Item> entry : member.getRentedItems().entrySet()){
            String itemId = entry.getKey();
            Item item = entry.getValue();
            System.out.println("ID: " + itemId + ", Föremål: " + item.formattedName());
        }
    }

    /**
     * @return Identifier of member to find as String.
     */
    protected String idInputPrompt(){
        System.out.println(color.applyCyan("\n------SÖK ANVÄNDARE------"));
        System.out.println("Du kan välja mellan att ange medlemmens ID eller namn.");
        System.out.print(color.applyCyan("\nSkriv medlemmens ID ELLER namn, sedan [ENTER]: "));
        return scanner.nextLine().trim();
    }

    /**
     * Prints details about member.
     * @param member Found member.
     */
    protected void printFoundMembers(Member member){
        String name = member.getName();
        String ID = member.getID();
        Ranks rank = member.getRank();

        System.out.println(color.applyGreen("\nMedlem hittad: " + "\n" + name + "\nMedlems ID: " + ID + "\nMedlems-rank: " + rank));
    }

    /**
     * Prompts options for configuring member
     * @return Choice as char.
     */
    protected char memberConfigPrompt(){
        System.out.println(color.applyCyan("\nNavigera med [1], [2], [3], [0] och [ENTER]:"));
        System.out.println("\n[1] Ändra rank" +
                "\n[2] Se historik" +
                "\n[3] Se nuvarande uthyrningar" +
                "\n[0] Tillbaka");
        System.out.print(color.applyCyan("\nVal sedan [ENTER]: "));
        return scanner.nextLine().charAt(0);
    }



}
