public class StateThree implements State {


    private static StateThree instance = null;

    private StateThree() {
    }

    public static synchronized StateThree getInstance(){
        if(instance == null){
            instance = new StateThree();
        }
        return instance;

    }

    @Override
    public void process(char c, Calculator calculator) {
        if (Character.isDigit(c)) {
            calculator.setCurrentOperand(calculator.getCurrentOperand() * 10 + Integer.parseInt(String.valueOf(c)));
        }else if (c == ' '){

        } else if (c == '+' || c == '-' && c != '\n') {

            if (calculator.getOperator() == '+' || calculator.getOperator()  == '-') {
                calculator.computeTotal(calculator);
                calculator.setCurrentOperand(0);
                calculator.setOperator(c);
                calculator.setCurrentState(StateTwo.getInstance());
            }

        } else if ( c == '\n') {
            calculator.computeFinalTotal(calculator);
        } else {
            calculator.setOperator(c);
            calculator.setCurrentState(Error.getInstance());
        }

    }

}
