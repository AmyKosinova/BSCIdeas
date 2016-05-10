package model.actions;

public class Executor {

    private static Executor instance;

    public static Executor getInstance() {
        if (instance == null) {
            instance = new Executor();
        }
        return instance;
    }

    private Executor() {
    }

    public void execute(Action action) {
        action.run();
    }
}
