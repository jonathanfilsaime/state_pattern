

public class Main {

    public static void main(String[] args) {

        Calculator calculator = Calculator.getInstance();

        String readThisString = "100 + 1 - 30 + 1 + 8 + 20 - 100 - 100  $";

        char[] a = readThisString.toCharArray();

        for (char c : a) {

            calculator.getCurrentState().process(c, calculator);


        }

        System.err.println("final n value " + calculator.getN());
        System.err.println("final t value " + calculator.getT());
    }
}
