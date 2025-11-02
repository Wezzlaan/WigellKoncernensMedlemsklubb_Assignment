package com.vestrin.policies;

public class NoobPricePolicy implements PricePolicy{

    @Override
    public double applyDiscount(double price) {
        double discount = 1.00;
        return price * discount;
    }
    @Override
    public String discountLevel(){
        return "Medlemsnivå [NOOB] har ingen rabatt.";
    }
}
