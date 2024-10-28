import java.util.Scanner;

public class CheckOut {
    public static void main(String[] args) {

        double itemPrice = 0.0;
        double totalPrice = 0.0;
        int itemCounter = 0;
        boolean shopping = true;

        Scanner in = new Scanner(System.in);

        do {
            itemCounter++;
            itemPrice = SafeInput.getRangedDouble(in, "Enter the price of item " + itemCounter, .50, 10.00);
            totalPrice = totalPrice + itemPrice;
            shopping = SafeInput.getYNConfirm(in, "Enter another item? [Y/N]");
        } while(shopping);

        System.out.printf("%nYou bought %d items for a total of $%.2f", itemCounter, totalPrice);

    }
}
