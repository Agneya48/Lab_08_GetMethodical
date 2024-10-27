import java.util.Scanner;

public class DevTest {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        String strInput = getNonZeroLenString(in, "Please enter a string for testing");
        System.out.println("You entered " + strInput);

        int intBasicInput = getInt(in, "Please enter an int for testing");
        System.out.println("You entered '" + intBasicInput + "'");

        /*double doubleInput = getDouble(in, "Please enter a double for testing");
        System.out.println("You entered '" + doubleInput + "'");*/

        in.close();

    }

    /**
     *
     * @param pipe a Scanner opened to read from System.in
     * @param prompt prompt for the user
     * @return a String response that is not zero length
     */
    private static String getNonZeroLenString(Scanner pipe, String prompt) {

        String retString = ""; // Loop runs until string isn't blank
        do {
            System.out.print(prompt + ": ");
            retString = pipe.nextLine();
        } while(retString.length() == 0);

        return retString;
    }

    private static int getInt(Scanner pipe, String prompt) {

        boolean okInput = false;
        int retInt = 0;
        String buffer = ""; //decided just to parse int from string, to avoid blank returns/spaces weird behavior
        do {
            System.out.print("\n" + prompt + ": ");
            buffer = pipe.nextLine();

            try {
                retInt = Integer.parseInt(buffer);
                okInput = true;
            } catch (NumberFormatException error) {
                System.out.print("Invalid int parsing " + error.getMessage());
                okInput = false;
            }

        } while(!okInput); //should only exit when an int is input

        return retInt;
    }

    /*private static double getDouble(Scanner pipe, String prompt) {
        boolean okInput = false;
        double retDouble = 0.0;
        String buffer = ""; /*meant to test if a blank enter character was inputted, which can cause multiple
        values to get processed all at once */

       /* do {//input loop until double received
            System.out.print("\n" + prompt + ": ");
            buffer = pipe.nextLine();
            if(buffer.isEmpty()) { //user didn't enter anything, or just spacebar and return
                System.out.println("Nothing was entered. Please try again.");
            }
            else {
                if(pipe.hasNextDouble()) {//safe to read
                    retDouble =
                    pipe.nextLine();
                    okInput = true;
                }
                else {//invalid non-double input
                    System.out.print("Invalid non-double input.");
                    pipe.nextLine();
                }
            }

        } while(!okInput); //will continue until double is received

        return retDouble;
    }*/
}
