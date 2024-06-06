package at.ac.fhcampuswien.fhmdb.sorting;

import at.ac.fhcampuswien.fhmdb.controllers.MovieListController;

public abstract class SortState {
    protected MovieListController movieListController;

    public SortState(MovieListController movieListController) {
        this.movieListController = movieListController;
    }

    public abstract void sort();
    public abstract void keepSorted();
}
