public class StateRestart implements State {

    private static StateRestart instance = null;

    private StateRestart() {
    }

    public static synchronized StateRestart getInstance(){
        if(instance == null){
            instance = new StateRestart();
        }
        return instance;
    }

    @Override
    public void process(char c, Calculator calculator) {

            calculator.setOperator(c);
            calculator.setCurrentOperand(0);
            calculator.setTotal(0);
            calculator.setCurrentState(StateZero.getInstance());

    }
}
