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
        value = rounding.round(value * k, scale);
        return this;
    }

    public Byn round(Rounding rounding, int scale) {
        value = rounding.round(value, scale);
        return  this;
    }

    public Byn mul(double k, Rounding rounding) {
        return mul(k, rounding, 0);
    }

    public Byn mul(double k) {
        return mul(k, Rounding.ROUND, 0);
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

    public enum Rounding {
        CEIL {
            double roundFun(double d) {
                return Math.ceil(d);
            }
        },
        FLOOR {
            double roundFun(double d) {
                return Math.floor(d);
            }
        },
        ROUND {
            double roundFun(double d) {
                return Math.round(d);
            }
        };

        abstract double roundFun(double value);

        int round(double roundedValue, int scale) {
            int[] tenPowD = {1, 10, 100, 1000, 10000, 100000, 1000000, 10000000, 100000000};
            int tenPow = tenPowD[scale];
            int result = (int) roundFun(roundedValue / tenPow) * tenPow;
            return result;
        }
    }
}
