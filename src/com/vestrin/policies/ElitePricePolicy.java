package com.vestrin.policies;

public class ElitePricePolicy implements PricePolicy {

    @Override
    public double applyDiscount(double price) {
        double discountDecimal = 0.15;
        double changeFactor = 1.00 - discountDecimal;
        return price * changeFactor;
    }

    @Override
    public String discountLevel() {
        return "Medlemsnivå [ELITE] har rabatt på 10%.";
    }
}
