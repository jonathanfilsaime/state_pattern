import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        while (true) {

            System.out.print("Enter an operation: ");

            //collect user input
            Scanner scanner = new Scanner(System.in);
            String readThisString = scanner.nextLine();
            readThisString = readThisString.concat("\n");
            char[] a = readThisString.toCharArray();

            Calculator calculator = Calculator.getInstance();

            //The state machine starts from state zero
            for (char c : a) {
                calculator.getCurrentState().process(c, calculator);
            }

            //If there are no errors print the total
            if(calculator.getOperator() != 'E'){
                System.out.println("Total = " + calculator.getTotal());
            }

            //reset state and start over
            calculator.setCurrentState(StateRestart.getInstance());
            calculator.getCurrentState().process(' ', calculator);
        }
    }
}
