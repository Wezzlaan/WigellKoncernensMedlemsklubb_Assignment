package com.vestrin.services;

import com.vestrin.application.ConsoleView;
import com.vestrin.controllers.InventoryController;
import com.vestrin.controllers.MembersController;
import com.vestrin.entities.Item;
import com.vestrin.members.Member;
import com.vestrin.members.MemberHistory;
import com.vestrin.storage.MemberRegistry;

import java.util.LinkedList;
import java.util.List;

public class MembershipService {
    private final MemberRegistry memberRegistry;

    public MembershipService(MembersController membersController) {
        this.memberRegistry = membersController.getRegistry();
    }

    /**Creates a history list.
     * Loops through the member registry to get the items and their price associated with each member and adds them to two lists.
     * Loops through the items associated with each member to get the specific item, their price, formats it to 2 decimals and adds it to the history list.
     * @return History LinkedList<String>
     */
    public List<String> getRentalHistory(){
        LinkedList<String> history = new LinkedList<>();

        for (Member member : memberRegistry.getMembers().values()) {
            List<Item> items = member.getMemberHistory().getItemRentalHistory();
            List<Double> revenue = member.getMemberHistory().getRentalRevenues();

            for (int i = 0; i < items.size(); i++) {

                Item item = items.get(i);
                double totalRevenue = revenue.get(i);

                String formattedRevenue = String.format("%.2f", totalRevenue);

                String rentalRecord = "Medlem: " + member.getName() + " [" + member.getID() + "]" +
                        " -> [" + item.itemIDToString() + "]" +
                        " '" + item.formattedName() + "'." + " Total kostnad: " + formattedRevenue + ";-";
                history.add(rentalRecord);
            }
        }
        return history;
    }

    /**
     * CALCULATES TOTAL REVENUE OF ALL MEMBERS.
     * @return Total revenue as double.
     */
    public double calculateTotalRevenue(){
        double total = 0.0;

        for (Member member : memberRegistry.getMembers().values()) {
            List<Double> x = member.getMemberHistory().getRentalRevenues();

            for (Double revenue : x) {
                total += revenue;
            }
        }
        return total;
    }

    /**Applies a new rank to Member and adds it to MemberHistory.
     * @param member To get new rank.
     * @param membersController To handle the logic of choosing a rank and adding it to history.
     * @param view To prompt rank choice.
     */
    public void changeRank(Member member, MembersController membersController, ConsoleView view){
        String currentRank;
        String newRank;

        currentRank = member.getRank().toString();
        char rankChoice = view.memberRankPrompt();
        member.setRank(membersController.chooseRank(rankChoice));
        newRank = member.getRank().toString();
        view.newRankConfirmation(currentRank, newRank);
        membersController.addRankChangeToHistory(member, currentRank, newRank);
    }
}
