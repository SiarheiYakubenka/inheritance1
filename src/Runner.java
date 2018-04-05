import by.gsu.epamlab.Purchase;
import by.gsu.epamlab.PurchaseFactory;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Locale;
import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        Scanner sc = null;

        try {
            sc = new Scanner(new FileReader("src/in2.txt"));
            sc.useLocale(Locale.ENGLISH);
            final int PURCHASE_NUMBER = 6;
            Purchase[] purchases = new Purchase[PURCHASE_NUMBER];
            Purchase maxCostPurchase = new Purchase("", 0, 0);
            boolean areEqual = true;

            for (int i = 0; i < purchases.length; i++) {
                purchases[i] = PurchaseFactory.getPurchaseFromFactory(sc);
                System.out.println(purchases[i]);
                if (purchases[i].getCost().compareTo(maxCostPurchase.getCost()) > 0) {
                    maxCostPurchase = purchases[i];
                }
                if (areEqual){
                    areEqual = purchases[i].equals(purchases[0]);
                }
            }

            System.out.println("The purchase with maximum cost: " + maxCostPurchase);
            if (areEqual) {
                System.out.println("All purchases are equal.");
            }

        } catch (FileNotFoundException e) {
            System.err.println("Input file is not found");
        } finally {
            if(sc != null) {
                sc.close();
            }
        }
    }

}
