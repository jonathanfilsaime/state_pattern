public class StateOne implements State {


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
        else if (c == '+' || c == '-' && calculator.getT() != 0 && c != '$')
        {
            if (calculator.getL() == '+') {
                calculator.setT(calculator.getT() + calculator.getN());
            } else {
                calculator.setT(calculator.getT() - calculator.getN());

            }

            calculator.setN(0);
            calculator.setL(c);
            calculator.setCurrentState(StateTwo.getInstance());

        }
        else if (c == '+' || c == '-' && calculator.getT() == 0 && c != '$')
        {

            calculator.setT(calculator.getN());
            calculator.setN(0);
            calculator.setL(c);
            calculator.setCurrentState(StateTwo.getInstance());

        }
        else if ( c == '$')
        {

            System.err.println("state one $");

            if (calculator.getL() == '+' || calculator.getL() == '-') {

                if (calculator.getL() == '+') {
                    calculator.setT(calculator.getT() + calculator.getN());
                } else {
                    calculator.setT(calculator.getT() - calculator.getN());

                }

                calculator.setCurrentState(StateFinal.getInstance());
            } else {
                System.err.println("ERROR");
            }
        }
    }
}
