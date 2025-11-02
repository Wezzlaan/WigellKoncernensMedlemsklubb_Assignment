package com.vestrin.application;

import com.vestrin.entities.Item;
import com.vestrin.members.Member;
import com.vestrin.members.Ranks;

import java.text.DecimalFormat;
import java.util.*;

public class ConsoleView {
    private final Scanner scanner;
    private final ConsoleColors color = new ConsoleColors();
    private DecimalFormat df;
    protected ConsoleView(){
        scanner = new Scanner(System.in);
    }

    protected void menuChoices() {
        System.out.println(color.applyCyan("\nNavigera med [1], [2], [3], [4], [5], [6], [0] och [ENTER]:"));
        System.out.println("\n[1] Lägg till medlem " +
                "\n[2] Sök/hantera medlem " +
                "\n[3] Se lagerstatus" +
                "\n[4] Boka/Avsluta uthyrning" +
                "\n[5] Kontrollera/summera intäkter" +
                "\n[6] Lägg till vara i lager" +
                "\n[0] Avsluta");
        System.out.print(color.applyCyan("\nVal sedan [ENTER]: "));
    }

    public void printMenuLogo(){
        System.out.println(color.applyPurple("░▀█▀░█░█░░░░░█▀▀░█▀█░█▀▀░█░░░█▀▀░░░█░█░█░░░█░█░█▀▄░█▀▄░█▀▀░█▀█\n" +
                                            "░░█░░▀▄▀░▄▄▄░▀▀█░█▀▀░█▀▀░█░░░▀▀█░░░█▀▄░█░░░█░█░█▀▄░█▀▄░█▀▀░█░█\n" +
                                            "░░▀░░░▀░░░░░░▀▀▀░▀░░░▀▀▀░▀▀▀░▀▀▀░░░▀░▀░▀▀▀░▀▀▀░▀▀░░▀▀░░▀▀▀░▀░▀"));
    }

    protected char getMenuChoice(){
        try {
            char input = scanner.nextLine().charAt(0);
            if (input >= '0' && input <= '9') {
                return input;
            } else {
                throw new InputMismatchException("FEL: " + input + " är inte en godkänd inmatning.\n");
            }
        } catch (InputMismatchException e){
            System.err.println(e.getMessage());
        }
        return 0;
    }

    /**Prompts for user input.
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
    public char memberRankPrompt(){
        System.out.println(color.applyCyan("\nMedlemsnivå:"));
        System.out.println(color.applyCyan("\n[1]" + Ranks.NOOB +
                                            " [2]" + Ranks.CASUAL +
                                            " [3]" + Ranks.VETERAN +
                                            " [4]" + Ranks.ELITE));
        System.out.print("\nVal: ");
        return scanner.nextLine().charAt(0);
    }

    protected void creationConfirmation(Member member){
        String name = member.getName();
        String ID = member.getID();
        Ranks rank = member.getRank();

        System.out.println(color.applyGreen("\nMedlem tillagd: " + "\n" + name + "\nMedlems ID: " + ID + "\nMedlems-rank: " + rank));
    }

    protected void addedItemConfirmation(Item item){
        System.out.println(color.applyGreen("\nProdukt: \n" + item.toString() + "\n\nLades in i systemet."));
    }

    public void newRankConfirmation(String currentRank, String newRank){
        System.out.println(color.applyGreen("\nMedlemsnivå ändrad: " + currentRank + " -> " + newRank));
    }

    protected void printRentedItems(Member member){
        df = new DecimalFormat("#.00");
        if (!member.getRentedItems().isEmpty()) {
            for (Map.Entry<String, Item> entry : member.getRentedItems().entrySet()) {
                String itemId = entry.getKey();
                Item item = entry.getValue();
                int duration = item.getRentedDuration();
                double rentalPrice = item.getCurrentRentalPrice();

                System.out.println("\nID: " + itemId +
                        "\nFöremål: " + item.formattedName() +
                        "\nKostnad (per dag): " + df.format(rentalPrice) + ";-" +
                        "\nUthyrningstid: " + duration + " dagar.");
            }
        } else {
            System.err.println("Medlemmen har inga hyrda föremål.");
        }
    }

    /**@return Identifier of member to find as String.
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
     * Prompts for type of item to add to the inventory.
     * @return user input as char.
     */
    protected char newItemPrompt(){
        System.out.println(color.applyCyan("\n-----LÄGG TILL VARA------"));
        System.out.println("Välj en typ: \n[1] PC" +
                                        "\n[2] Spelkonsoll" +
                                        "\n[3] Tangentbord" +
                                        "\n[4] Mus" +
                                        "\n[5] Skärm");
        return scanner.nextLine().charAt(0);
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

    protected void printHistory(Member member){
        member.getMemberHistory().getAllHistory().forEach(System.out::println);
    }

    protected String itemIdInputPrompt(){
        System.out.print(color.applyCyan("\nAnge namn eller ID: "));
        return scanner.nextLine();
    }

    protected int rentalTimePrompt(){
        System.out.print(color.applyCyan("\nHur länge ska den hyras ut? Ange antal dygn i siffror: "));
        while (true) {
            String input = scanner.nextLine().trim();
            try {
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.err.println("Felaktig inmatning. Ange endast siffror.");
            }
        }
    }

    protected char bookOrReturnPrompt(){
        System.out.println(color.applyCyan("\nVill du boka eller avbryta hyrning? \n[1] Boka \n[2] Lämna tillbaka vara"));
        System.out.print(color.applyCyan("\nVal sedan [ENTER]: "));
        return scanner.nextLine().charAt(0);
    }

    protected String uuidItemToReturn(){
        System.out.print(color.applyCyan("\nAnge UUID: "));
        return scanner.nextLine().trim();
    }

    protected void totalRevenue(Double revenue){
        System.out.print(color.applyCyan("\nTotala intäkter: "));
        df = new DecimalFormat("0.##");
        String formattedRevenue = df.format(revenue);
        System.out.print(color.applyGreen(formattedRevenue + ";-\n"));
    }

    protected void allRentalHistory(List<String> rentalHistory){
        for (String x : rentalHistory) {
            System.out.println("\n" + x);
        }
    }
}
