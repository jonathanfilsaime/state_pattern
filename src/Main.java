import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        while (true) {

            System.out.print("Enter an operation: ");

            //collecting user input
            //user must input a valid operation
            //operand operator operand (i.e 1 + 3)
            //user must press enter to compute the total
            Scanner scanner = new Scanner(System.in);
            String readThisString = scanner.nextLine();
            readThisString = readThisString.concat("\n");
            char[] a = readThisString.toCharArray();

            Calculator calculator = Calculator.getInstance();

            //The state machine starts from state zero
            //loop all the input characters
            //and change the state
            for (char c : a) {
                calculator.getCurrentState().process(c, calculator);
            }

            //If there are no errors print the total
            if(calculator.getOperator() != 'E'){
                System.out.println("Total = " + calculator.getTotal());
            }

            //after computing the total
            //the state is reset and the
            //program starts over
            calculator.setCurrentState(StateRestart.getInstance());
            calculator.getCurrentState().process(' ', calculator);
        }
    }
}
