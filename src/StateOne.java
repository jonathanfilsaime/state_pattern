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
            calculator.setN(calculator.getN() * 10 + Integer.parseInt(String.valueOf(c)));
        }else if (c == ' '){

        }
        else if (c == '+' || c == '-' && c != '\n')
        {
            calculator.setT(calculator.getN());
            calculator.setN(0);
            calculator.setL(c);
            calculator.setCurrentState(StateTwo.getInstance());
        }
        else if ( c == '\n')
        {
            calculator.computeFinalTotal(calculator);

        } else {
            calculator.setL(c);
            calculator.setCurrentState(Error.getInstance());
        }
    }
}
