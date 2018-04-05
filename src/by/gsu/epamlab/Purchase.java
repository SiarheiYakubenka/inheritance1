package by.gsu.epamlab;

import java.util.Scanner;

public class Purchase {
    private String name;
    private Byn price;
    private int numOfUnits;

    public Purchase() {
    }

    public Purchase(String name, int price, int numOfUnits) {
        this.name = name;
        this.price = new Byn(price);
        this.numOfUnits = numOfUnits;
    }

    public Purchase(Scanner sc) {
        this(sc.next(), (sc.nextInt()), sc.nextInt());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Byn getPrice() {
        return price;
    }

    public void setPrice(Byn price) {
        this.price = price;
    }

    public int getNumOfUnits() {
        return numOfUnits;
    }

    public void setNumOfUnits(int numOfUnits) {
        this.numOfUnits = numOfUnits;
    }

    public Byn getCost() {
        return new Byn(price).mul(numOfUnits);
    }

    protected String fieldsToString() {
        return name + ";" + price + ";" + numOfUnits;
    }

    @Override
    public String toString() {
        return  fieldsToString() + ";" + getCost();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Purchase)) return false;

        Purchase purchase = (Purchase) o;

        if (!price.equals(purchase.price)) return false;
        return name != null ? name.equals(purchase.name) : purchase.name == null;
    }

}
