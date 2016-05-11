package model.actions;

import java.util.logging.Level;
import java.util.logging.Logger;
import model.Payments;

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
        if (action != null) {
            action.run();
        } else {
            Logger.getLogger(Executor.class.getName()).log(Level.WARNING, "Atempt to run null action");
        }

    }
}
