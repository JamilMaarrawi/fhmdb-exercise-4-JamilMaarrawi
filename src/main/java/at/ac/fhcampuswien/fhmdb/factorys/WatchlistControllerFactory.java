package at.ac.fhcampuswien.fhmdb.factorys;

import at.ac.fhcampuswien.fhmdb.controllers.MainController;
import at.ac.fhcampuswien.fhmdb.controllers.WatchlistController;
import javafx.util.Callback;

public class WatchlistControllerFactory implements Callback<Class<?>, Object> {
    // TODO: create MyCtrl as singleton instance
    private static WatchlistController watchlistController;

    @Override
    public Object call(Class<?> aClass) {
        // TODO: check if MyCtrl is already instantiated
        if (watchlistController == null) {
            try {
                watchlistController = (WatchlistController) aClass.getDeclaredConstructor().newInstance();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return watchlistController;
    }
}
