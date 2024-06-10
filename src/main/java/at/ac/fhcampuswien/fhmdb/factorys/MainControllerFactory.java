package at.ac.fhcampuswien.fhmdb.factorys;

import at.ac.fhcampuswien.fhmdb.controllers.MainController;
import javafx.util.Callback;

public class MainControllerFactory implements Callback<Class<?>, Object> {
    // TODO: create MyCtrl as singleton instance
    private static MainController mainController;

    @Override
    public Object call(Class<?> aClass) {
        // TODO: check if MyCtrl is already instantiated
        if (mainController == null) {
            try {
                mainController = (MainController) aClass.getDeclaredConstructor().newInstance();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return mainController;
    }
}
