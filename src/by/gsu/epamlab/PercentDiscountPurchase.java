package by.gsu.epamlab;

import java.util.Scanner;

public class PercentDiscountPurchase extends Purchase {
    private static final int UNITS_NUMBER = 5;
    private double discountPercent;

    public PercentDiscountPurchase() {
        super();
    }
    public PercentDiscountPurchase(String name, int price, int numOfUnits, double discountPercent) {
        super(name, price, numOfUnits);
        this.discountPercent = discountPercent;
    }

    public  PercentDiscountPurchase(Scanner sc) {
        this(sc.next(), (sc.nextInt()), sc.nextInt(), sc.nextDouble());
    }

    public double getDiscountPercent() {
        return discountPercent;
    }

    public void setDiscountPercent(double discountPercent) {
        this.discountPercent = discountPercent;
    }

    @Override
    public Byn getCost() {
        Byn cost = super.getCost();
        if (getNumOfUnits() > UNITS_NUMBER) {
         cost.mul ((100 - discountPercent) / 100);
        }
        return cost;
    }

    @Override
    protected String fieldsToString() {
        return super.fieldsToString() + ";" + discountPercent;
    }
}
