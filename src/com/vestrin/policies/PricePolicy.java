package com.vestrin.policies;

public interface PricePolicy {

    double applyDiscount(double price);
    String discountLevel();

}
