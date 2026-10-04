package ru.edu.pr01;

import java.util.Locale;
import java.util.Scanner;

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
        if (!isValid(quantity, unitPrice, discountPercent)) {
            throw new IllegalArgumentException("Некорректные входные данные");
        }
        double base = calculateBase(quantity, unitPrice);
        double discounted = applyDiscount(base, discountPercent);
        double vatAmount = calculateVat(discounted, vatPercent);
        return discounted + vatAmount;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);

        System.out.print("Введите количество единиц: ");
        if (!scanner.hasNextInt()) {
            System.err.println("Ошибка: количество должно быть целым числом");
            return;
        }
        int quantity = scanner.nextInt();

        System.out.print("Введите цену за единицу: ");
        if (!scanner.hasNextDouble()) {
            System.err.println("Ошибка: цена должна быть числом");
            return;
        }
        double unitPrice = scanner.nextDouble();

        System.out.print("Введите процент скидки (0-30): ");
        if (!scanner.hasNextDouble()) {
            System.err.println("Ошибка: скидка должна быть числом");
            return;
        }
        double discountPercent = scanner.nextDouble();

        if (!isValid(quantity, unitPrice, discountPercent)) {
            System.err.println("Ошибка: входные данные выходят за допустимые границы");
            return;
        }

        double base = calculateBase(quantity, unitPrice);
        double discounted = applyDiscount(base, discountPercent);
        double vat = calculateVat(discounted, DEFAULT_VAT_RATE);
        double total = calculateTotal(quantity, unitPrice, discountPercent, DEFAULT_VAT_RATE);

        System.out.printf(Locale.US, "Базовая стоимость: %.2f руб.%n", base);
        System.out.printf(Locale.US, "Сумма со скидкой: %.2f руб.%n", discounted);
        System.out.printf(Locale.US, "НДС (%.1f%%): %.2f руб.%n", DEFAULT_VAT_RATE, vat);
        System.out.printf(Locale.US, "Итого к оплате: %.2f руб.%n", total);
    }
}
