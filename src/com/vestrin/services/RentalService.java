package com.vestrin.services;

import com.vestrin.entities.*;
import com.vestrin.members.Member;
import com.vestrin.members.MemberHistory;
import com.vestrin.policies.*;

import java.util.List;
import java.util.NoSuchElementException;

public class RentalService {
    private final Rental rental;

    public RentalService(Rental rental){
        this.rental = rental;
        }

    public void rent(Member member, List<Item> foundItems, int duration){

            Item itemToRent = null;
            double priceForRental = 0.0;
            for (Item item : foundItems){
                if (!item.getIsRented()){
                    double currentPrice = item.getPrice();
                    priceForRental = applyMemberDiscount(member).applyDiscount(currentPrice);
                    itemToRent = item;
                    itemToRent.setCurrentRentalPrice(priceForRental);
                    break;
                }
            }
            if (itemToRent != null){
                rental.toMember(itemToRent, member, duration);
                double total = priceForRental * duration;
                member.getMemberHistory().addRentalHistory(itemToRent, priceForRental, duration, total);

                String formattedPriceForRental = String.format("%.2f", priceForRental);
                String formattedTotal = String.format("%.2f", total);
                System.out.println("\n" + itemToRent.formattedName() + " har hyrts ut till: " + member.getName() + " i " + duration + " dagar." +
                                    "\nPris (Per dag, med eventuella rabatter): " + formattedPriceForRental +
                                    ";-. Total kostnad: " + formattedTotal + ";-.");
            } else {
                throw new NoSuchElementException("Artikeln är uthyrd.");
            }
    }

    public void returnItem(Member member, Item item){
        rental.returnItem(item, member);
        item.setCurrentRentalPrice(0);
        System.out.println("\n" + member.getName() + " har lämnat tillbaka: " + "\n" + item.formattedName() +
                            "\nUUID: " + item.itemIDToString());
    }

    private PricePolicy applyMemberDiscount(Member member){
        switch (member.getRank()){
            case NOOB:
                return new NoobPricePolicy();
            case CASUAL:
                return new CasualPricePolicy();
            case VETERAN:
                return new VeteranPricePolicy();
            case ELITE:
                return new ElitePricePolicy();
        }
        return new NoobPricePolicy(); //NoobPricePolicy = ingen rabatt.
    }
}
