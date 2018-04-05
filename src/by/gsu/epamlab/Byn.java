package by.gsu.epamlab;

public class Byn implements Comparable<Byn> {
    private int value;

    public Byn(int value) {
        this.value = value;
    }

    public Byn(int rubs, int coins) {
        this(rubs * 100 + coins);
    }

    public Byn(Byn byn) {
        this(byn.value);
    }

    public int getRubs() {
        return this.value / 100;
    }

    public int getCoins() {
        return this.value % 100;
    }

    public Byn add(Byn byn) {
        value += byn.value;
        return this;
    }

    public Byn sub(Byn byn) {
        value -= byn.value;
        return this;
    }

    public Byn mul(int k) {
        value *= k;
        return this;
    }

    public Byn mul(double k, Rounding rounding, int scale) {
        value = round(value * k, rounding, scale);
        return this;
    }

    public Byn round(Rounding rounding, int scale) {
        value = round(value, rounding, scale);
        return  this;
    }

    private static int round(double roundedValue, Rounding rounding, int d) {
        int[] tenPowD = {1, 10, 100, 1000, 10000, 100000, 1000000, 10000000, 100000000};
        int tenPow = tenPowD[d];
        int result = (int) rounding.roundFun(roundedValue / tenPow) * tenPow;
        return result;
    }

    public Byn mul(double k, Rounding rounding) {
        return mul(k, rounding, 0);
    }

    public Byn mul(double k) {
        return mul(k, Rounding.ROUND);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Byn byn = (Byn) o;
        return value == byn.value;
    }

    @Override
    public int compareTo(Byn byn) {
        return value - byn.value;
    }

    @Override
    public String toString() {
        return value / 100 + "." + value / 10 % 10 + value % 10;
    }
}
