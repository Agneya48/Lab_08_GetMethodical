import java.util.Scanner;

public class FavNumbers {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int favInt = 0;
        double favDouble = 0.0;
        favInt = SafeInput.getInt(in, "Enter your favorite integer");
        favDouble = SafeInput.getDouble(in, "Enter your favorite double");
        System.out.print("\nYou said your favorite int was " + favInt);
        System.out.print("\nand that your favorite double was " + favDouble);
        in.close();

    }
}
