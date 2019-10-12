public class StateFinal implements State {


    private static StateFinal instance = null;

    private StateFinal() {
    }

    public static synchronized StateFinal getInstance(){
        if(instance == null){
            instance = new StateFinal();
        }
        return instance;

    }

    @Override
    public void process(char c, Calculator calculator) {
        System.err.println(calculator.getN());
        System.err.println(calculator.getT());
        System.err.println(calculator.getL());
    }
}
