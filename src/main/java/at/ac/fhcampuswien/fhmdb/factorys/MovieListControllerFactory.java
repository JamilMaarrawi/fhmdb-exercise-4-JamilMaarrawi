package at.ac.fhcampuswien.fhmdb.factorys;

import at.ac.fhcampuswien.fhmdb.controllers.MainController;
import at.ac.fhcampuswien.fhmdb.controllers.MovieListController;
import javafx.util.Callback;

public class MovieListControllerFactory implements Callback<Class<?>, Object> {
    // TODO: create MyCtrl as singleton instance
    private static MovieListController movieListController;

    @Override
    public Object call(Class<?> aClass) {
        // TODO: check if MyCtrl is already instantiated
        if (movieListController == null) {
            try {
                movieListController = (MovieListController) aClass.getDeclaredConstructor().newInstance();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return movieListController;
    }
}