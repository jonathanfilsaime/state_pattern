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

    }
}
