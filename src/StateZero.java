

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
            calculator.setT(0);
            calculator.setN(Integer.parseInt(String.valueOf(c)));
            calculator.setL('+');
            calculator.setCurrentState(StateOne.getInstance());
        } else if (c == ' '){

        } else {
            calculator.setL(c);
            calculator.setCurrentState(Error.getInstance());
        }
    }
}
