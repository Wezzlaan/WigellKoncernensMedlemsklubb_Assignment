package com.vestrin.policies;

public class CasualPricePolicy implements PricePolicy{


    @Override
    public double applyDiscount(double price) {
        double discountDecimal = 0.05;
        double changeFactor = 1.00 - discountDecimal;
        return price * changeFactor;
    }

    @Override
    public String discountLevel() {
        return "Medlemsnivå [CASUAL] har rabatt på 5%.";
    }
}
