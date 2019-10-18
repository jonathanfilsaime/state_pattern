public class StateTwo implements State {


    private static StateTwo instance = null;

    private StateTwo() {
    }

    public static synchronized StateTwo getInstance(){
        if(instance == null){
            instance = new StateTwo();
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
            calculator.computeTotal(calculator);

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
