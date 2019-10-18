import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Calculator calculator = Calculator.getInstance();

        Scanner scanner = new Scanner(System.in);

        //  prompt for the user's name
        System.out.print("Enter an equation: ");

        // get their input as a String
        String readThisString = scanner.nextLine();
        System.err.println(readThisString);

        readThisString = readThisString.concat("\n");
        char[] a = readThisString.toCharArray();

        for (char c : a) {
            calculator.getCurrentState().process(c, calculator);
        }

        System.err.println("final n value " + calculator.getN());
        System.err.println("final t value " + calculator.getT());
    }
}
