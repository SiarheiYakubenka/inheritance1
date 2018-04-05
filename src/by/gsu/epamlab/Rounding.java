package by.gsu.epamlab;

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
}
