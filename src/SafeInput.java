import java.util.Scanner;

public class SafeInput {

    /** @param pipe a Scanner opened to read from System.in
     * @param prompt prompt for the user
     * @return a String response that is not zero length
     */
    public static String getNonZeroLenString(Scanner pipe, String prompt) {

        String retString = ""; // Loop runs until string isn't blank
        do {
            System.out.print("\n" + prompt + ": ");
            retString = pipe.nextLine();
        } while(retString.length() == 0);

        return retString;
    }

    public static int getInt(Scanner pipe, String prompt) {

        boolean okInput = false;
        int retInt = 0;
        do {
            System.out.print("\n" + prompt + ": ");
            if(pipe.hasNextInt()) { //safe to read
                retInt = pipe.nextInt();
                pipe.nextLine();
                okInput = true;
            }
            else {//invalid non-int input
                System.out.print("Invalid non-integer input.");
                pipe.nextLine();
            }

        } while(!okInput); //should only exit when an int is input

        return retInt;
    }
}