package com.vestrin.policies;

public class VeteranPricePolicy implements PricePolicy{


    @Override
    public double applyDiscount(double price) {
        double discountDecimal = 0.10;
        double changeFactor = 1.00 - discountDecimal;
        return price * changeFactor;
    }

    @Override
    public String discountLevel() {
        return "Medlemsnivå [VETERAN] har rabatt på 10%.";
    }
}
