

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
        System.err.println("state zero start ======================== ");
        System.err.println("c is : " + c);
        System.err.println("n is : " + calculator.getN());
        System.err.println("t is : " + calculator.getT());
        System.err.println("l is : " + calculator.getL());

        if(Character.isDigit(c) && c != '0' ){
            calculator.setT(0);
            calculator.setN(Integer.parseInt(String.valueOf(c)));
            calculator.setL('+');

            calculator.setCurrentState(StateOne.getInstance());

        }

        System.err.println("c is : " + c);
        System.err.println("n is : " + calculator.getN());
        System.err.println("t is : " + calculator.getT());
        System.err.println("l is : " + calculator.getL());
        System.err.println("state zero finish ======================== ");

    }
}
