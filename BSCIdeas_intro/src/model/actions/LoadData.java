package model.actions;

import java.io.File;
import model.Payments;

public class LoadData implements Action {

    private final File loadFile;

    public LoadData(File loadFile) {
        this.loadFile = loadFile;
    }
    
    @Override
    public void run() {
        Payments.loadData(loadFile);
    }

}
