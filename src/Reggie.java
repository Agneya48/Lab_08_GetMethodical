import java.util.Scanner;

public class Reggie {
    public static void main(String[] args) {
        String socialSecurity = "";
        String studentNumber = "";
        String menuChoice = "";

        Scanner in = new Scanner(System.in);

        socialSecurity = SafeInput.getRegExString(in, "Enter your SSN", "^\\d{3}-\\d{2}-\\d{4}$");
        System.out.println("\nThe SSN you entered is: " + socialSecurity);

        studentNumber = SafeInput.getRegExString(in, "Enter you UC Student M number", "^(M|m)\\d{5}$");
        System.out.println("\nThe student id you entered is: " + studentNumber);

        menuChoice = SafeInput.getRegExString(in, "O to Open, S to Save, V to view, or Q to Quit", "^[OoSsVvQq]$");
        System.out.println("\nYou selected " + menuChoice);

        in.close();
    }
}
