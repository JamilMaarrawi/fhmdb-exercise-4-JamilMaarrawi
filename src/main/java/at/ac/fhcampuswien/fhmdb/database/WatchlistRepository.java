package at.ac.fhcampuswien.fhmdb.database;

import at.ac.fhcampuswien.fhmdb.controllers.MovieListController;
import at.ac.fhcampuswien.fhmdb.factorys.MovieListControllerFactory;
import at.ac.fhcampuswien.fhmdb.interfaces.Observable;
import at.ac.fhcampuswien.fhmdb.interfaces.Observer;
import com.j256.ormlite.dao.Dao;

import java.util.ArrayList;
import java.util.List;

public class WatchlistRepository implements Observable {
    private static volatile WatchlistRepository instance;
    Dao<WatchlistMovieEntity, Long> dao;
    private final List<Observer> observers = new ArrayList<>();

    private WatchlistRepository() throws DataBaseException {
        try {
            this.dao = DatabaseManager.getInstance().getWatchlistDao();
            addObserver((Observer) new MovieListControllerFactory().call(MovieListController.class));
        } catch (Exception e) {
            throw new DataBaseException(e.getMessage());
        }
    }

    public static WatchlistRepository getInstance() throws DataBaseException {
        WatchlistRepository watchlistRepository = instance;
        if (watchlistRepository == null) {
            synchronized (WatchlistRepository.class) {
                watchlistRepository = instance;
                if (watchlistRepository == null) {
                    instance = watchlistRepository = new WatchlistRepository();
                }
            }
        }
        return watchlistRepository;
    }

    public List<WatchlistMovieEntity> getWatchlist() throws DataBaseException {
        try {
            return dao.queryForAll();
        } catch (Exception e) {
            e.printStackTrace();
            throw new DataBaseException("Error while reading watchlist");
        }
    }
    public int addToWatchlist(WatchlistMovieEntity movie) throws DataBaseException {
        try {
            // only add movie if it does not exist yet
            long count = dao.queryBuilder().where().eq("apiId", movie.getApiId()).countOf();
            if (count == 0) {
                notifyObservers(true);
                return dao.create(movie);
            } else {
                notifyObservers(false);
                return 0;
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new DataBaseException("Error while adding to watchlist");
        }
    }

    public int removeFromWatchlist(String apiId) throws DataBaseException {
        try {
            return dao.delete(dao.queryBuilder().where().eq("apiId", apiId).query());
        } catch (Exception e) {
            throw new DataBaseException("Error while removing from watchlist");
        }
    }

    @Override
    public void addObserver(Observer observer) {
        if(!observers.contains(observer)) observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(boolean success) {
        observers.forEach(observer -> observer.update(success));
    }
}
