import java.util.Scanner;

public class Main {

    public static void main(String[] args) {


        while (true) {
            System.out.print("Enter an operation: ");

            Calculator calculator = Calculator.getInstance();

            Scanner scanner = new Scanner(System.in);

            String readThisString = scanner.nextLine();
            System.out.println(readThisString);

            readThisString = readThisString.concat("\n");
            char[] a = readThisString.toCharArray();


            for (char c : a) {
                calculator.getCurrentState().process(c, calculator);
            }

            if(calculator.getL() != 'E'){
                System.out.println("Total = " + calculator.getT());
            }


            calculator.setCurrentState(StateRestart.getInstance());
            calculator.getCurrentState().process(' ', calculator);
        }
    }
}
