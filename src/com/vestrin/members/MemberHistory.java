package com.vestrin.members;

import com.vestrin.entities.Item;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class MemberHistory {
    private final List<Double> rentalRevenues = new ArrayList<>();
    private final LinkedList<String> allHistory;
    private final List<Item> itemRentalHistory = new LinkedList<>();

    public MemberHistory(Member member)
    {
       this.allHistory = new LinkedList<>();
       allHistory.add(dateOfCreation());
    }

    /**Adds rank change to members history.
     * @param oldRank Rank before change, as String.
     * @param newRank Rank after change, as String.
     */
    public void addRankChange(String oldRank, String newRank){
        String rankChange = getCurrentTime() + ": [ÄNDRING AV MEDLEMSNIVÅ] " + oldRank + " -> " + newRank;
        if (oldRank != null && newRank != null) {
            this.allHistory.add(rankChange);
        } else {
            throw new NullPointerException("FEL: Inmatning kan inte vara 'null.");
        }
    }

    public void addRentalHistory(Item item, double rentedPrice, int duration, double totalCost){
        if (item != null){
            String rentalRecord = getCurrentTime() + ": [ARTIKEL HYRD] " +
                                    item.formattedName() + " (ID: " + item.getItemID() + ")" +
                                    " Pris (per dag): " + String.format("%.2f;-", rentedPrice) +
                                    ". Pris (totalt): " + String.format("%.2f;-", totalCost) +
                                    ". Dagar: " + duration;
            this.allHistory.add(rentalRecord);
            this.rentalRevenues.add(totalCost);
            this.itemRentalHistory.add(item);

        } else {
            throw new NullPointerException("FEL: Kan inte lägga in en 'null' artikel.");
        }
    }

    private String dateOfCreation(){
        return getCurrentTime() + ": [MEDLEM TILLAGD I REGISTER]";
    }

    public List<String> getAllHistory(){
        return allHistory;
    }

    public List<Item> getItemRentalHistory(){
        return itemRentalHistory;
    }

    private String getCurrentTime(){
        LocalDateTime currentTime = LocalDateTime.now();
        DateTimeFormatter formattedTime = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        return currentTime.format(formattedTime);
    }

    public void returnItem(Item item){
        if (item != null){
            String rentalRecord = getCurrentTime() + ": [ARTIKEL ÅTERLÄMNAD] " +
                    item.formattedName() + " (ID: " + item.getItemID() + ")";
            this.allHistory.add(rentalRecord);
        } else {
            throw new NullPointerException("FEL: Kan inte lägga in en 'null' artikel.");
        }
    }

    public List<Double> getRentalRevenues(){
        return rentalRevenues;
    }
}
