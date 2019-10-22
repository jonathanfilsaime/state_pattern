public class Error implements State {
    private static Error instance;

    private Error() {}

    public static synchronized Error getInstance() {
        if(instance == null) {
            instance = new Error();
        }

        return instance;
    }

    @Override
    public void process(char c, Calculator calculator) {
        if(c != ' ') {
            if(calculator.getOperator() == '*' || calculator.getOperator() == '/' || calculator.getOperator() == '=' || calculator.getOperator() == '%' || calculator.getOperator() == '^' ) {
                System.out.println("you entered operator [" + calculator.getOperator() + "] this operation is not supported");
                System.out.println("please enter a valid operation ");
                calculator.setOperator('E');
                calculator.setCurrentState(StateFinal.getInstance());
            } else {
                System.out.println("you entered a letter - " + calculator.getOperator() + " - ");
                System.out.println("please enter a valid operation ");
                calculator.setOperator('E');
                calculator.setCurrentState(StateFinal.getInstance());
            }

        }
    }
}
