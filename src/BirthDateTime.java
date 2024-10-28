import java.util.Scanner;

public class BirthDateTime {
    public static void main(String[] args) {

        int yearVal = 0;
        int monthVal = 0;
        int dayVal = 0;
        int hourVal = 0;
        int minVal = 0;

        Scanner in = new Scanner(System.in);
        yearVal = SafeInput.getRangedInt(in, "Enter your year of birth within range", 1950, 2015);
        monthVal = SafeInput.getRangedInt(in, "Enter the month you were born", 1, 12);

        switch(monthVal) {
            case 1, 3, 5, 7, 8, 10, 12:
                dayVal = SafeInput.getRangedInt(in, "Enter your day of birth", 1, 31);
                break;
            case 2:
                dayVal = SafeInput.getRangedInt(in, "Enter your day of birth", 1, 29);
                break;
            case 4, 6, 9, 11:
                dayVal = SafeInput.getRangedInt(in, "Enter your day of birth", 1, 30);
                break;
        }
        hourVal = SafeInput.getRangedInt(in, "Enter the hour of your birth", 1, 24);
        minVal = SafeInput.getRangedInt(in, "Enter the minute of your birth:", 1, 59);

        System.out.println("\n Year: " + yearVal + " | Month: " + monthVal + " | Day: " + dayVal + " | " + hourVal + ":" + minVal);

    }
}
