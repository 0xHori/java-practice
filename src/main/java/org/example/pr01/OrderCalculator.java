package org.example.pr01;

public class OrderCalculator {
    public static final double DEFAULT_VAT_RATE = 10.0;
    public static final int MIN_QUANTITY = 1;
    public static final int MAX_QUANTITY = 10_000;
    public static final double MIN_PRICE = 0.01;
    public static final double MAX_PRICE = 5_000_000.0;
    public static final double MIN_DISCOUNT = 0.0;
    public static final double MAX_DISCOUNT = 30.0;

    public static boolean isValid(int quantity, double unitPrice, double discountPercent) {
        if (quantity < MIN_QUANTITY || quantity > MAX_QUANTITY) {
            return false;
        }

        if (unitPrice < MIN_PRICE || unitPrice > MAX_PRICE) {
            return false;
        }

        if (discountPercent < MIN_DISCOUNT || discountPercent > MAX_DISCOUNT) {
            return false;
        }

        return true;
    }


    public static double calculateBase(int quantity, double unitPrice) {
        return quantity * unitPrice;
    }

    public static double applyDiscount(double base, double discountPercent) {
        return base * (1.0 - (discountPercent / 100.0));
    }

    public static double calculateVat(double discounted, double vatPercent) {
        return discounted * (vatPercent / 100.0);
    }
    
    public static double calculateTotal(int quantity, double unitPrice, double discountPercent, double vatPercent) {
        double base = calculateBase(quantity, unitPrice);
        double discounted = applyDiscount(base, discountPercent);
        double vatAmount = calculateVat(discounted, vatPercent);
        return discounted + vatAmount;
    }
}
