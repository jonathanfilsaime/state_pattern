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

    private State currentState = StateZero.getInstance();

    public State getCurrentState() { return currentState; }

    public void setCurrentState(State currentState) {
        this.currentState = currentState;
    }

    public int getTotal() {
        return t;
    }

    public void setTotal(int t) {
        this.t = t;
    }

    public int getCurrentOperand() {
        return n;
    }

    public void setCurrentOperand(int n) {
        this.n = n;
    }

    public char getOperator() {
        return l;
    }

    public void setOperator(char l) {
        this.l = l;
    }

    public void computeTotal(Calculator calculator) {
        if (calculator.getOperator() == '+') {
            calculator.setTotal(calculator.getTotal() + calculator.getCurrentOperand());
        } else {
            calculator.setTotal(calculator.getTotal() - calculator.getCurrentOperand());
        }
    }

    public void computeFinalTotal(Calculator calculator){
        if (calculator.getOperator() == '+' || calculator.getOperator() == '-') {
            calculator.computeTotal(calculator);
            calculator.setCurrentState(StateFinal.getInstance());
        }
    }
}
