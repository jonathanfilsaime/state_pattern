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
        System.err.println("state two start ======================== ");
        System.err.println("c is : " + c);
        System.err.println("n is : " + calculator.getN());
        System.err.println("t is : " + calculator.getT());
        System.err.println("l is : " + calculator.getL());



        if (Character.isDigit(c)) {
            calculator.setN(calculator.getN() * 10 + Integer.parseInt(String.valueOf(c)));

        } else if (c == '+' || c == '-' && c != '$') {

            if (calculator.getL() == '+' || calculator.getL()  == '-') {

                if (calculator.getL() == '+') {
                    calculator.setT(calculator.getT() + calculator.getN());
                } else {
                    calculator.setT(calculator.getT() - calculator.getN());

                }

                calculator.setN(0);
                calculator.setL(c);
                calculator.setCurrentState(StateOne.getInstance());
            }


        } else if ( c == '$') {

            System.err.println("state two $");

            if (calculator.getL() == '+' || calculator.getL() == '-') {

                if (calculator.getL() == '+') {
                    calculator.setT(calculator.getT() + calculator.getN());
                } else {
                    calculator.setT(calculator.getT() - calculator.getN());

                }

                calculator.setCurrentState(StateFinal.getInstance());
            }
        }

    }

}
