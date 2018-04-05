package by.gsu.epamlab;

import java.util.Scanner;

public class PriceDiscountPurchase extends Purchase {
    private Byn discount;

    public PriceDiscountPurchase(){
        super();
    }

    public PriceDiscountPurchase(String name, int price, int numOfUnits, int discount) {
        super(name, price, numOfUnits);
        this.discount = new Byn(discount);
    }

    public PriceDiscountPurchase(Scanner sc) {
        super(sc);
        this.discount = new Byn(sc.nextInt());
    }

    public Byn getDiscount() {
        return new Byn(discount);
    }

    public void setDiscount(Byn discount) {
        this.discount = new Byn(discount);
    }

    @Override
    public Byn getCost(){
        return new Byn(getPrice()).sub(discount).mul(getNumOfUnits());
    }

    @Override
    protected String fieldsToString() {
        return super.fieldsToString() + ";" + discount;
    }
}
