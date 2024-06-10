package at.ac.fhcampuswien.fhmdb;

import at.ac.fhcampuswien.fhmdb.enums.UIComponent;
import at.ac.fhcampuswien.fhmdb.factorys.MainControllerFactory;
import at.ac.fhcampuswien.fhmdb.factorys.MovieListControllerFactory;
import at.ac.fhcampuswien.fhmdb.factorys.WatchlistControllerFactory;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class FhmdbApplication extends Application {
    @Override
    public void start(Stage stage) {
        FXMLLoader fxmlLoaderHome = new FXMLLoader(FhmdbApplication.class.getResource(UIComponent.HOME.path));
        fxmlLoaderHome.setControllerFactory(new MainControllerFactory());

        FXMLLoader fxmlLoaderMovieList = new FXMLLoader(FhmdbApplication.class.getResource(UIComponent.MOVIELIST.path));
        fxmlLoaderMovieList.setControllerFactory(new MovieListControllerFactory());

        FXMLLoader fxmlLoaderWatchlist = new FXMLLoader(FhmdbApplication.class.getResource(UIComponent.WATCHLIST.path));
        fxmlLoaderWatchlist.setControllerFactory(new WatchlistControllerFactory());

        try{
            Scene scene = new Scene(fxmlLoaderHome.load(), 890, 620);
            scene.getStylesheets().add(Objects.requireNonNull(FhmdbApplication.class.getResource("/styles/styles.css")).toExternalForm());
            stage.setTitle("FHMDb!");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            System.err.println("Cannot load scene from " + UIComponent.HOME.path);
        } catch (NullPointerException e) {
            System.err.println("Path to stylesheet may be corrupt.");
        }

    }

    public static void main(String[] args) {
        launch();
    }
}