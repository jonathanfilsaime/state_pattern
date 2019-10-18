public class Calculator {

    int t = 0;
    int n;
    char l;

    private static Calculator instance = null;



    private Calculator() {

    }

    public static synchronized  Calculator getInstance(){
        if(instance == null){
            instance = new Calculator();
        }
        return instance;
    }

    public void computeTotal(Calculator calculator) {
        if (calculator.getL() == '+') {
            calculator.setT(calculator.getT() + calculator.getN());
        } else {
            calculator.setT(calculator.getT() - calculator.getN());
        }
    }

    public void computeFinalTotal(Calculator calculator){
        if (calculator.getL() == '+' || calculator.getL() == '-') {

            calculator.computeTotal(calculator);

            calculator.setCurrentState(StateFinal.getInstance());
        }
    }



    private State currentState = StateZero.getInstance();

    public State getCurrentState() {
        return currentState;
    }

    public void setCurrentState(State currentState) {
        this.currentState = currentState;
    }

    public int getT() {
        return t;
    }

    public void setT(int t) {
        this.t = t;
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    public char getL() {
        return l;
    }

    public void setL(char l) {
        this.l = l;
    }
}
