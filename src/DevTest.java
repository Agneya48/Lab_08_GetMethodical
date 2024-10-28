import java.util.Scanner;

public class DevTest {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        String strInput = getNonZeroLenString(in, "Please enter a string for testing");
        System.out.println("You entered " + strInput);

        int intBasicInput = getInt(in, "Please enter an int for testing");
        System.out.println("You entered '" + intBasicInput + "'");

        double doubleInput = getDouble(in, "Please enter a double for testing");
        System.out.println("You entered '" + doubleInput + "'");

        int rangedInput = getRangedInt(in, "Enter an int within range", -3, 10);
        System.out.println("You entered '" + rangedInput + "'");

        double doubleRangedInput = getRangedDouble(in, "Enter a double within range", -5.5, 13.22);
        System.out.println("you entered '" + doubleRangedInput + "'");

        boolean cont = getYNConfirm(in, "Continue? [Y/N]");
        System.out.println("Y/N continue returned " + cont);

        String SSN = "";
        String regExValue = getRegExString(in, "Enter your SSN", "\\d{3}-\\d{2}-\\d{4}");
        System.out.print("You entered " + regExValue);

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

    private static double getDouble(Scanner pipe, String prompt) {
        boolean okInput = false;
        double retDouble = 0.0;
        String buffer = ""; //Again, just decided using wrappers to parse is less headache.

        do {
            System.out.print("\n" + prompt + ": ");
            buffer = pipe.nextLine();

            try {
                retDouble = Double.parseDouble(buffer);
                okInput = true;
            } catch (NumberFormatException error) {
                System.out.print("Invalid double parsing " + error.getMessage());
                okInput = false;
            }

        } while(!okInput); //should only exit when an int is input

        return retDouble;
    }

    private static int getRangedInt(Scanner pipe, String prompt, int low, int high) {
        boolean okInput = false;
        int inputInt = 0;
        int retRangedInt = 0;
        String buffer = ""; /*Again, well aware of how to the nextLine and hasNext methods of
        bullet proofing, but I think this is more reliable and I didn't want to have to deal with
        blank input causing bugs in the future. Try/catch is a good thing to learn, too*/

        do{
            System.out.print("\n" + prompt + " [" + low + ", " + high + "]: ");
            buffer = pipe.nextLine();
            try {
                inputInt = Integer.parseInt(buffer);
                if (inputInt >= low && inputInt <= high) {
                    retRangedInt = inputInt;
                    okInput = true;
                }
                else {
                    System.out.print("Int outside valid range.");
                }
            } catch (NumberFormatException error) {
                System.out.print("Invalid int parsing " + error.getMessage());
            }
        } while(!okInput);

        return retRangedInt;
    }

    private static double getRangedDouble(Scanner pipe, String prompt, double low, double high) {
        boolean okInput = false;
        double inputDouble = 0.0;
        double retRangedDouble = 0.0;
        String buffer = "";

        do{
            System.out.print("\n" + prompt + " [" + low + ", " + high + "]: ");
            buffer = pipe.nextLine();
            try {
                inputDouble = Double.parseDouble(buffer);
                if (inputDouble >= low && inputDouble <= high) {
                    retRangedDouble = inputDouble;
                    okInput = true;
                }
                else {
                    System.out.print("Input double outside valid range.");
                }
            } catch (NumberFormatException error) {
                System.out.print("Invalid double parsing " + error.getMessage());
            }
        } while(!okInput);

        return retRangedDouble;
    }

    private static boolean getYNConfirm(Scanner pipe, String prompt) {
        boolean retYN = false;
        boolean done = false;
        String continueInput = "";
        do {
            System.out.print("\n" + prompt +": ");
            continueInput = pipe.nextLine();
            if(continueInput.equalsIgnoreCase("Y")) {
                retYN = true;
                done = true;
            }
            else if (continueInput.equalsIgnoreCase("N")) {
                retYN = false;
                done = true;
            }
            else {
                System.out.print("Invalid input. Please pick either 'y' or 'n'");
            }
        } while(!done);

        return retYN;
    }

    private static String getRegExString (Scanner pipe, String prompt, String regEx) {
        //show the prompt
        //input the data
        //test to see if the value matches valid regex format
        boolean okRegInput = false;
        String value = "";
        do {
            System.out.print("\n" + prompt + ": ");
            value = pipe.nextLine();
            if(value.matches(regEx)) {
                okRegInput = true;
            }
            else {
                System.out.print("Invalid input: " + value);
            }

        }while(!okRegInput);

        return value;
    }
}
