public class StateOne implements State{
    private static StateOne instance = null;

    private StateOne() {
    }

    public static synchronized StateOne getInstance(){
        if(instance == null){
            instance = new StateOne();
        }
        return instance;
    }

    @Override
    public void process(char c, Calculator calculator) {
        if(Character.isDigit(c)){
            calculator.setCurrentOperand(calculator.getCurrentOperand() * 10 + Integer.parseInt(String.valueOf(c)));
        }else if (c == ' '){

        }
        else if (c == '+' || c == '-' && c != '\n')
        {
            calculator.setTotal(calculator.getCurrentOperand());
            calculator.setCurrentOperand(0);
            calculator.setOperator(c);
            calculator.setCurrentState(StateTwo.getInstance());
        }
        else if ( c == '\n')
        {
            calculator.computeFinalTotal(calculator);

        } else {
            calculator.setOperator(c);
            calculator.setCurrentState(Error.getInstance());
        }
    }
}
