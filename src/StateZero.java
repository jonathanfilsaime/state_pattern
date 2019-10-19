

public class StateZero implements State {

    private static StateZero instance = null;

    private StateZero() {
    }

    public static synchronized StateZero getInstance(){
        if(instance == null){
            instance = new StateZero();
        }
        return instance;
    }

    @Override
    public void process(char c, Calculator calculator) {
        if(Character.isDigit(c) && c != '0' ){
            calculator.setTotal(0);
            calculator.setCurrentOperand(Integer.parseInt(String.valueOf(c)));
            calculator.setOperator('+');
            calculator.setCurrentState(StateOne.getInstance());
        } else if (c == ' '){

        } else {
            calculator.setOperator(c);
            calculator.setCurrentState(Error.getInstance());
        }
    }
}
