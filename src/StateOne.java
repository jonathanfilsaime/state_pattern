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
        }
        else if (c == '+' || c == '-' && c != '\n')
        {

            calculator.setT(calculator.getN());
            calculator.setN(0);
            calculator.setL(c);
            calculator.setCurrentState(StateThree.getInstance());

        }
        else if ( c == '\n')
        {
            if (calculator.getL() == '+' || calculator.getL() == '-') {

                calculator.computeTotal(calculator);

                calculator.setCurrentState(StateFinal.getInstance());
            }
        } else {
            calculator.setCurrentState(Error.getInstance());
        }
    }
}
